package moban;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import moban.Main;
import moban.menu;
public class jishiqi 
{
	int cnt=0;
	Timer tm;
	TimerTask tk;
	JLabel show=new JLabel();
	jishiqi()
	{
		tm=new Timer(true);
		tk=new TimerTask()
		{
			public void run()
			{
				cnt+=1;
				menu.jpa2.remove(show);
				show.hide();
				show.setText("  您已经用时"+cnt+"秒");
				//show.setBounds(600, 600, 200, 200);
				//show.setFont(new java.awt.Font("宋体",1,55));
				show.show();
				menu.jpa2.add(show);
				Main.ctt.add(menu.jpa2);
			}
		};
	}
}
