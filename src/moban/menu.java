package moban;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import moban.picture;
import moban.game;
import moban.Main;
import moban.jishiqi;
import moban.chuangguan;
import moban.yingxiongbang;
public class menu 
{
	JLabel diff=new JLabel();
	JMenuBar mb;
	static JPanel jpa1;
	static JPanel jpa2;
	static game gm;
	int dif=1,ca=0;
	static jishiqi tm;
	static int mod=1,f=0,ff=0;
	picture pic=new picture();
	static String url="http://g.hiphotos.baidu.com/image/pic/item/203fb80e7bec54e7f0e0839fb7389b504fc26a27.jpg";
	static JButton chongwan;
	static chuangguan cg=new chuangguan();
	static int fmod=0,x1,y1,x2,y2,k1,k2;
	menu()
	{
		JMenu nandu=new JMenu("ѡ���Ѷ�");
		JMenu tuxiang=new JMenu("ѡ��ͼ��");
		JMenu guanyu=new JMenu("����");
		JMenu yxb=new JMenu("�鿴Ӣ�۰�");
		JMenu fz=new JMenu("����");
		JMenu ds=new JMenu("��������");
		JMenuItem jiandan=new JMenuItem("��");
		JMenuItem kunnan=new JMenuItem("����");
		chongwan=new JButton("����");
		chongwan.addActionListener(new ActionListener()//���水ť
				{
					public void actionPerformed(ActionEvent e)
					{
						fmod=0;
						if(cg.cmod==1)
						{
							int re=JOptionPane.showConfirmDialog(Main.mainJF, "��ȷ���˳�����ģʽ?","ȷ��",JOptionPane.YES_NO_OPTION);
							if(re==0)
							{
								cg.cmod=0;
								jpa1.remove(cg.jishu);
								chongwan.setText("����");
								JOptionPane.showMessageDialog(Main.mainJF, "��ͨ����"+(chuangguan.cnt-1)+"��","��ʾ",1);
								String gnm=JOptionPane.showInputDialog(Main.mainJF,"�������������","���ؽ���",1);
								int sc=(chuangguan.cnt-1)*10;
								for(int i=1;i<=3;i++)
								if(sc>=startmenu.rk[i].gc())
								{
									startmenu.rk[i+1].nm=startmenu.rk[i].nm;
									startmenu.rk[i+1].sc=startmenu.rk[i].sc;
									startmenu.rk[i].nm=gnm;
									startmenu.rk[i].sc=sc;
									JOptionPane.showMessageDialog(Main.mainJF, "��ϲ��"+gnm+"���Ѿ���ΪӢ�۰�ĵ�"+i+"���ȥ��Ӣ�۰�鿴��!!!");
									break;
								}
								chuangguan.cnt=0;
								f=0;
								tm.tm.cancel();
								jpa2.remove(tm.show);
								tm.show.hide();
								if(mod==2)
								{
									game.yuantu.hide();
									Main.ctt.remove(game.yuantu);
								}
								if(dif==1)
								{
									for(int i=0;i<8;i++)
									{
										gm.blk[i].hide();
										Main.ctt.remove(gm.blk[i]);
									}
								}
								else if(dif==2)
								{
									for(int i=0;i<15;i++)
									{
										gm.blk[i].hide();
										Main.ctt.remove(gm.blk[i]);
									}
								}
								return;
							}
							else
							return;
						}
						if(f==0)
						{
							JOptionPane.showMessageDialog(Main.mainJF, "���Ѿ���������水ť����û�е����ʼ��Ϸ��������ʼ��Ϸ","��ʾ",1);
							return;
						}
						f=0;
						tm.tm.cancel();
						jpa2.remove(tm.show);
						tm.show.hide();
						if(mod==2)
						{
							game.yuantu.hide();
							Main.ctt.remove(game.yuantu);
						}
						if(dif==1)
						{
							for(int i=0;i<8;i++)
							{
								gm.blk[i].hide();
								Main.ctt.remove(gm.blk[i]);
							}
						}
						else if(dif==2)
						{
							for(int i=0;i<15;i++)
							{
								gm.blk[i].hide();
								Main.ctt.remove(gm.blk[i]);
							}
						}
					}
				}
				);
		
		nandu.add(jiandan);
		nandu.addSeparator();
		nandu.add(kunnan);
		mb=new JMenuBar();
		mb.add(nandu);
		mb.add(tuxiang);
		mb.add(cg);
		mb.add(yxb);
		mb.add(fz);
		mb.add(guanyu);
		mb.add(ds);
		jpa1=new JPanel();
		jpa2=new JPanel();
		jpa1.setLayout(new FlowLayout(FlowLayout.LEFT));
		final JRadioButton shuzi=new JRadioButton("�����淨");
		JRadioButton tx=new JRadioButton("ͼ���淨");
		ButtonGroup gp=new ButtonGroup();
		gp.add(shuzi);
		gp.add(tx);
		shuzi.setSelected(true);
		jpa1.add(shuzi);
		jpa1.add(tx);
		JButton sta=new JButton("��ʼ");
		jiandan.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if(f==1)
						{
							JOptionPane.showMessageDialog(Main.mainJF, "���ȵ�������ٵ����ʼ��Ϸ!!!","��ʾ",JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						dif=1;
					}
				}
				);
		kunnan.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(f==1)
				{
					JOptionPane.showMessageDialog(Main.mainJF, "���ȵ�������ٵ����ʼ��Ϸ!!!","��ʾ",JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				dif=2;
			}
		}
		);
		sta.addActionListener(new ActionListener() //��ʼ��ť
				{
					public void actionPerformed(ActionEvent e)
					{
						if(f==1)
						{
							JOptionPane.showMessageDialog(Main.mainJF, "���ȵ�������ٵ����ʼ��Ϸ!!!","��ʾ",JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						if(ff==1)
						{
							JOptionPane.showMessageDialog(Main.mainJF, "���������Զ���ͼƬ!!!","��ʾ",JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						if(chuangguan.cmod==1)
						{
							jpa1.remove(chuangguan.jishu);
							chuangguan.jishu.hide();
							chuangguan.jishu=new JLabel("�����ڴ��������ǵ�"+chuangguan.cnt+"��,������ս��!!!!");
							menu.jpa1.add(chuangguan.jishu);
							chuangguan.jishu.show();
							Main.ctt.add(menu.jpa1);
						}
						f=1;
						if(shuzi.isSelected())
						mod=1;
						else
						mod=2;
						gm=new game(dif);
						gm.setgame();
						tm=new jishiqi();
						tm.tm.schedule(tm.tk,0,1000);
						System.out.println(mod);
						if(dif==1)
						{
							ca=1;
							diff.setText("   ��ѡ���˼��Ѷ�");
							jpa1.add(diff,BorderLayout.EAST);
							Main.ctt.add(jpa1);
							for(int i=0;i<3;i++)
							{
								gm.blk[i].setLocation(100+80*(i),200);
								Main.ctt.add(gm.blk[i]);
							}
							for(int i=3;i<6;i++)
							{
								gm.blk[i].setLocation(100+80*(i-3),280);
								Main.ctt.add(gm.blk[i]);
							}
							for(int i=6;i<8;i++)
							{
								gm.blk[i].setLocation(100+80*(i-6),360);
								Main.ctt.add(gm.blk[i]);
							}
						}
						else 
						{
							ca=2;
							diff.setText("   ��ѡ���������Ѷ�");
							jpa1.add(diff,BorderLayout.EAST);
							Main.ctt.add(jpa1);
							for(int i=0;i<4;i++)
							{
								gm.blk[i].setLocation(100+80*(i),200);
								Main.ctt.add(gm.blk[i]);
							}
							for(int i=4;i<8;i++)
							{
								gm.blk[i].setLocation(100+80*(i-4),280);
								Main.ctt.add(gm.blk[i]);
							}
							for(int i=8;i<12;i++)
							{
								gm.blk[i].setLocation(100+80*(i-8),360);
								Main.ctt.add(gm.blk[i]);
							}
							for(int i=12;i<15;i++)
							{
								gm.blk[i].setLocation(100+80*(i-12),440);
								Main.ctt.add(gm.blk[i]);
							}
						}
					}
					}
	);
		guanyu.addMenuListener(new MenuListener()
		{
			public void menuSelected(MenuEvent e)
			{
				JOptionPane.showMessageDialog(Main.mainJF, "��һ��������Swing��ҵ��ѧ����,baccano","��������",JOptionPane.INFORMATION_MESSAGE);
			}

			public void menuCanceled(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void menuDeselected(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}
		);
		yxb.addMenuListener(new MenuListener()
		{
			public void menuSelected(MenuEvent e)
			{
				yingxiongbang yxb=new yingxiongbang();
			}

			public void menuCanceled(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void menuDeselected(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}
		
		);
		ds.addMenuListener(new MenuListener()
		{
			public void menuSelected(MenuEvent e)
			{
				JOptionPane.showMessageDialog(Main.mainJF, "֧�����˺�:18678854327,һ��ǮҲ��Ǯ");
			}

			public void menuCanceled(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void menuDeselected(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}
		
		);
		fz.addMenuListener(new MenuListener()
		{
			public void menuSelected(MenuEvent e)
			{
				if(startmenu.cnt==0&&startmenu.cs==0)
				{
					String pw=JOptionPane.showInputDialog("���Ѿ��ﵽ���θ����ʹ������,�����뼤����!!!!");
					if(pw.compareTo(new String("wdnmdnba"))==0)
					{
						JOptionPane.showMessageDialog(Main.mainJF, "��������ȷţ���,�����ʹ��");
						startmenu.cs=1;
					}
					else
					{
						JOptionPane.showMessageDialog(Main.mainJF, "�������,����ϵ����");
						return;
					}
				}
				if(chuangguan.cmod==1)
				{
					JOptionPane.showMessageDialog(Main.mainJF, "����ģʽ��ֹʹ�ø���!!!!");
					return;
				}
				if(f==0)
				{
					JOptionPane.showMessageDialog(Main.mainJF, "���ȵ��������߿�ʼ��Ϸ");
					return;
				}
				if(fmod==1)
				{
					JOptionPane.showMessageDialog(Main.mainJF, "���Ѿ������˸���");
					return;
				}
				JOptionPane.showMessageDialog(Main.mainJF, "������һ�θ��������������齻�����ǵ�λ��");
				startmenu.cnt-=1;
				fmod=1;
			}

			public void menuCanceled(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void menuDeselected(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}
		
		);
		tuxiang.addMenuListener(new MenuListener()
		{
			public void menuSelected(MenuEvent e)
			{
				url=JOptionPane.showInputDialog(null,"���������Զ������ַ,ע��ѡ��ͼƬ�����ǰ����ͼƬ��Ϸ�����ȵ�����水ť","�Զ���ͼƬ",JOptionPane.PLAIN_MESSAGE);	
				System.out.println(url);
				int ck=0;
				try {
					BufferedImage imgck=ImageIO.read(new URL(url));
					ck=1;
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				if(url!=null&&ck==1)
				{
					ff=0;
					JOptionPane.showMessageDialog(Main.mainJF, "�Զ���ͼƬ���óɹ�!!!!","��ʾ",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(url==null)
				{
					ff=1;
					JOptionPane.showMessageDialog(Main.mainJF, "�Զ���ͼƬ����ʧ��,���������÷����޷�����ͼ�ε���Ϸ!!!!","��ʾ",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(ck==0)
				{
					ff=1;
					JOptionPane.showMessageDialog(Main.mainJF, "�Զ���ͼƬ����ʧ��,��������ȷ��ͼƬ��ַ!!!!","��ʾ",JOptionPane.INFORMATION_MESSAGE);
				}
			}

			public void menuCanceled(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void menuDeselected(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}
		);
		jpa1.add(sta);
		jpa1.add(chongwan);
		jpa1.add(new JLabel("ף����Ϸ���!!!"));
		jpa1.setBounds(0, 25, 900, 30);
		jpa2.add(new JLabel("����������ƶ�����!!!"));
		jpa2.setBounds(0, 820, 900, 50);
	}
}