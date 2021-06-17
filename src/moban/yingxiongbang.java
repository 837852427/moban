package moban;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moban.Main;
public class yingxiongbang 
{
	yingxiongbang()
	{
		final JDialog cx=new JDialog(Main.mainJF,"Ӣ�۰�",true);
		cx.setSize(700,700);
		cx.setResizable(false);
		cx.setLocationRelativeTo(Main.mainJF);
		Container ct=cx.getLayeredPane();
		JLabel tx=new JLabel("Ӣ�۰�");
		tx.setFont(new java.awt.Font("����",1,15));
		tx.setBounds(300,0,50,50);
		JButton qd=new JButton("ȷ��");
		qd.setBounds(300,600,70,70);
		qd.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						cx.dispose();
					}
				}
				);
		JPanel d[]=new JPanel[100];
		JLabel msg[]=new JLabel[100];
		for(int i=0;i<100;i++)
		d[i]=new JPanel();
		for(int i=0;i<100;i++)
		msg[i]=new JLabel();
		for(int i=0;i<100;i++)
		msg[i].setFont(new java.awt.Font("����",1,12));
		d[1].setBackground(new Color(255,215,0));
		d[2].setBackground(new Color(192,192,192));
		d[3].setBackground(new Color(184,115,51));
		for(int i=1;i<=3;i++)
		msg[i].setText("��"+i+"��Ϊ"+startmenu.rk[i].gn()+"�ܹ��÷�"+startmenu.rk[i].gc());
		for(int i=1;i<=3;i++)
		d[i].add(msg[i]);
		d[1].setBounds(200, 100, 300, 100);
		d[2].setBounds(200,250,300,100);
		d[3].setBounds(200,400,300,100);
		ct.add(tx);
		ct.add(qd);
		for(int i=1;i<=3;i++)
		ct.add(d[i]);
		cx.setVisible(true);
	}
}