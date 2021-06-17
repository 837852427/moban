package moban;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import moban.startmenu;
import moban.yingxiongbang;
public class Main
{
	static Container ctt;
	static JFrame mainJF;
	public static void main(String args[]) 
	{
		mainJF=new JFrame("ħ����Ϸ");
		startmenu st=new startmenu();
		Container ct=mainJF.getContentPane();
		ctt=mainJF.getLayeredPane();
		mainJF.setLayout(null);
		ctt.add(st.start_menu);
		ctt.add(st.hero_stat);
		ct.add(st.bck);
		st.title.setOpaque(false);
		ctt.add(st.title,new Integer(10));
		ctt.add(st.hr,new Integer(15));
		ctt.add(st.st,new Integer(20));
		mainJF.setBounds(100, 100, 900, 900);
		mainJF.setResizable(false);
		mainJF.setVisible(true);
		mainJF.setDefaultCloseOperation(1);
	}
}
