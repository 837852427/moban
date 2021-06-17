package moban;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
public class picture 
{
	public static BufferedImage change(Image image) {
	    if (image instanceof BufferedImage) {
	        return (BufferedImage)image;
	     }
	     image = new ImageIcon(image).getImage();
	     BufferedImage bimage = null;
	     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    try {
	        int transparency = Transparency.OPAQUE;
	         GraphicsDevice gs = ge.getDefaultScreenDevice();
	         GraphicsConfiguration gc = gs.getDefaultConfiguration();
	         bimage = gc.createCompatibleImage(
	         image.getWidth(null), image.getHeight(null), transparency);
	     } catch (HeadlessException e) {
	     }
	 
	    if (bimage == null) {
	        int type = BufferedImage.TYPE_INT_RGB;
	        bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
	     }
	     Graphics g = bimage.createGraphics();
	 
	     g.drawImage(image, 0, 0, null);
	     g.dispose();
	 
	    return bimage;
	}
}
