package moban;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import moban.Main;
import moban.menu;
public class startmenu 
{
	JPanel start_menu;
	JPanel hero_stat;
	JPanel title;
	JLabel bck;
	JLabel name,hr,st;
	JButton b1,b2;
	Font ft;
	int f=0;
	static rank rk[]=new rank[10];
	static int cnt=5,cs=0;
	public startmenu()
	{
		rk[1]=new rank("baccano",10);
		rk[2]=new rank("��1",0);
		rk[3]=new rank("��2",0);
		start_menu=new JPanel();
		hero_stat=new JPanel();
		b1=new JButton();
		b2=new JButton();
		b1.setIcon(new ImageIcon("src/img/menu1.png"));
		b2.setIcon(new ImageIcon("src/img/menu1.png"));
		b1.setPressedIcon(new ImageIcon("src/img/menu2.png"));
		b2.setPressedIcon(new ImageIcon("src/img/menu2.png"));
		b1.setBorderPainted(true);
		b2.setBorderPainted(true);
		bck=new JLabel(new ImageIcon("src/img/back.png"));
		bck.setBounds(0,0,900,900);
		name=new JLabel(new ImageIcon("src/img/font.png"));
		hr=new JLabel(new ImageIcon("src/img/yingxiong.png"));
		st=new JLabel(new ImageIcon("src/img/kaishi.png"));
		name.setBounds(300, 300, 200, 50);
		title=new JPanel();
		title.add(name);
		start_menu.add(b1);
		hero_stat.add(b2);
		start_menu.setBounds(380,550,95,65);
		hero_stat.setBounds(380,700,95,65);
		title.setBounds(10,80,850,600);
		hr.setBounds(380, 650, 100, 50);
		st.setBounds(380,500,100,50);
		b1.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation") 
			public void actionPerformed(ActionEvent e)
			{
				start_menu.hide();
				hero_stat.hide();
				title.hide();
				hr.hide();
				st.hide();
				menu m=new menu();
				Main.mainJF.setJMenuBar(m.mb);
				Main.ctt.add(m.jpa1,new Integer(50));
				Main.ctt.add(m.jpa2,new Integer(51));
			}
		}
		);
		b2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						yingxiongbang yxb=new yingxiongbang();
					}
				});
	}
}