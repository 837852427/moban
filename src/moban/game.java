package moban;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.html.HTMLDocument.Iterator;
import moban.picture;
import moban.menu;
import moban.chuangguan;
import moban.jishiqi;
public class game 
{
	int dif=0;
	static int n;
	static block blk[];
	static JLabel yuantu;
	int x1,y1,x2,y2;
	game(int d)
	{
		blk=new block[100];
		this.dif=d;
		map.bk=new int[100][100];
	}
	public void setgame()
	{
		Image img=null;
		try {
			img = Toolkit.getDefaultToolkit().getImage(new URL(menu.url));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
		}
		if(dif==1)
		img=img.getScaledInstance(240, 240, 1);
		else 
		img=img.getScaledInstance(320, 320, 1);
		BufferedImage bf=picture.change(img);
		int mkx1[]={0,0,80,160,0,80,160,0,80,160};
		int mky1[]={0,0,0,0,80,80,80,160,160,160};
		int mkx2[]={0,0,80,160,240,0,80,160,240,0,80,160,240,0,80,160,240};
		int mky2[]={0,0,0,0,0,80,80,80,80,160,160,160,160,240,240,240,240};
		if(dif==1&&menu.mod==1)
		{
			int a[]=new int[100];
			int p=0;
			for(int i=0;i<8;i++)
			a[i]=i+1;
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<8;i++)
			list.add(a[i]);
			Collections.shuffle(list);
			for(int i=0;i<8;i++)
			a[i]=list.get(i);
			for(int i=0;i<8;i++)
			{
				map.mk[a[i]]=i;
				blk[i]=new block(a[i],1,1);
			}
			for(int i=1;i<=3;i++)
			for(int j=1;j<=3;j++)
			{
				if(i==3&&j==3)
				continue;
				map.bk[i][j]=blk[p].id;
				blk[p++].setpos(i,j);
			}
		}
		else if(dif==2&&menu.mod==1)
		{
			int a[]=new int[100];
			int p=0;
			for(int i=0;i<15;i++)
			a[i]=i+1;
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<15;i++)
			list.add(a[i]);
			Collections.shuffle(list);
			for(int i=0;i<15;i++)
			a[i]=list.get(i);
			for(int i=0;i<15;i++)
			{
				map.mk[a[i]]=i;
				blk[i]=new block(a[i],1,2);
			}
			for(int i=1;i<=4;i++)
			for(int j=1;j<=4;j++)
			{
				if(i==4&&j==4)
				continue;
				map.bk[i][j]=blk[p].id;
				blk[p++].setpos(i,j);
			}
		}
		else if(dif==1&&menu.mod==2)
		{
			yuantu=new JLabel(new ImageIcon(bf));
			yuantu.setBounds(400,400,400,400);
			Main.ctt.add(yuantu);
			int a[]=new int[100];
			int p=0;
			for(int i=0;i<8;i++)
			a[i]=i+1;
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<8;i++)
			list.add(a[i]);
			Collections.shuffle(list);
			for(int i=0;i<8;i++)
			a[i]=list.get(i);
			for(int i=0;i<8;i++)
			{
				map.mk[a[i]]=i;
				blk[i]=new block(a[i],1,1);
				blk[i].setBorder(null);
				blk[i].removeAll();
				ImageIcon now=new ImageIcon(bf.getSubimage(mkx1[a[i]], mky1[a[i]], 80, 80));
				JLabel jl=new JLabel(now);
				jl.setSize(80, 80);
				blk[i].add(jl);
			}
			for(int i=1;i<=3;i++)
			for(int j=1;j<=3;j++)
			{
				if(i==3&&j==3)
				continue;
				map.bk[i][j]=blk[p].id;
				blk[p++].setpos(i,j);
			}
		}
		else
		{
			yuantu=new JLabel(new ImageIcon(bf));
			yuantu.setBounds(400,400,500,500);
			Main.ctt.add(yuantu);
			int a[]=new int[100];
			int p=0;
			for(int i=0;i<15;i++)
			a[i]=i+1;
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<15;i++)
			list.add(a[i]);
			Collections.shuffle(list);
			for(int i=0;i<15;i++)
			a[i]=list.get(i);
			for(int i=0;i<15;i++)
			{
				map.mk[a[i]]=i;
				blk[i]=new block(a[i],1,2);
				blk[i].setBorder(null);
				blk[i].removeAll();
				ImageIcon now=new ImageIcon(bf.getSubimage(mkx2[a[i]], mky2[a[i]], 80, 80));
				JLabel jl=new JLabel(now);
				jl.setSize(80, 80);
				blk[i].add(jl);
			}
			for(int i=1;i<=4;i++)
			for(int j=1;j<=4;j++)
			{
				if(i==4&&j==4)
				continue;
				map.bk[i][j]=blk[p].id;
				blk[p++].setpos(i,j);
			}
		}
	}
}
class map
{
	static int bk[][];
	static int mkx[]=new int[100];
	static int mky[]=new int[100];
	static int mk[]=new int[100];
	map()
	{
		for(int i=1;i<=4;i++)
		for(int j=1;j<=4;j++)
		{
			mky[i]=200+80*(i-1);
			mkx[j]=100+80*(j-1);
		}
	}
}
class block extends JPanel implements MouseListener
{
	int id,sz,x,y,dif,n,x1,y1,x2,y2;
	map mp;
	block(int id,int sz,int dif)
	{
		mp=new map();
		this.id=id;
		this.sz=sz;
		this.dif=dif;
		this.add(new JLabel(""+id));
		this.setSize(this.sz*80,this.sz*80);
		this.setBorder(BorderFactory.createLineBorder(Color.red, 2));
		this.setBackground(Color.pink);
		this.addMouseListener(this);
		if(this.dif==1)
		{
			game.n=3;
			n=3;
		}
		else
		{
			game.n=4;
			n=4;
		}
	}
	public void setpos(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public void mouseClicked(MouseEvent e) 
	{
		System.out.println("fmod="+menu.fmod);
		if(menu.fmod==1)
		{
			menu.x1=this.x;
			menu.y1=this.y;
			menu.k1=this.id;
			System.out.println(menu.x1+" "+menu.y1);
			menu.fmod=2;
			return;
		}
		if(menu.fmod==2)
		{
			menu.x2=this.x;
			menu.y2=this.y;
			menu.k2=this.id;
			System.out.println(map.mk[menu.k1]+" "+map.mk[menu.k2]);
			int re=JOptionPane.showConfirmDialog(Main.mainJF, "��ȷ��������"+menu.x1+"�е�"+menu.y1+"�����"+menu.x2+"�����"+menu.y2+"����","ȷ��",JOptionPane.YES_NO_OPTION);
			if(re==0)
			{
				if(menu.k1==menu.k2)
				{
					JOptionPane.showMessageDialog(Main.mainJF, "�޷��Լ������Լ�!!!!");
					return;
				}
				game.blk[map.mk[menu.k1]].hide();
				game.blk[map.mk[menu.k2]].hide();
				Main.ctt.remove(game.blk[map.mk[menu.k1]]);
				Main.ctt.remove(game.blk[map.mk[menu.k2]]);
				game.blk[map.mk[menu.k1]].setLocation(mp.mkx[menu.y2],mp.mky[menu.x2]);
				game.blk[map.mk[menu.k2]].setLocation(mp.mkx[menu.y1],mp.mky[menu.x1]);
				map.bk[menu.x1][menu.y1]=game.blk[map.mk[menu.k2]].id;
				map.bk[menu.x2][menu.y2]=game.blk[map.mk[menu.k1]].id;
				Main.ctt.add(game.blk[map.mk[menu.k1]]);
				Main.ctt.add(game.blk[map.mk[menu.k2]]);
				game.blk[map.mk[menu.k2]].x=menu.x1;
				game.blk[map.mk[menu.k2]].y=menu.y1;
				game.blk[map.mk[menu.k1]].x=menu.x2;
				game.blk[map.mk[menu.k1]].y=menu.y2;
				game.blk[map.mk[menu.k1]].show();
				game.blk[map.mk[menu.k2]].show();
				menu.fmod=0;
				for(int ii=1;ii<=n;ii++)
				{
					for(int jj=1;jj<=n;jj++)
					System.out.print(map.bk[ii][jj]+" ");
					System.out.print("\n");
				}
				if(check()==1)
				JOptionPane.showMessageDialog(Main.mainJF, "��ϲ����Ӯ��!!!!","��ϲ",JOptionPane.INFORMATION_MESSAGE);
			}
			else
			menu.fmod=1;
			return;
		}
		if(menu.fmod!=0)
		return;
		int dx[]={-1,1,0,0};
		int dy[]={0,0,-1,1};
		for(int i=0;i<4;i++)
		{
			int xx=this.x+dx[i];
			int yy=this.y+dy[i];
			//System.out.println(xx+" "+yy);
			if(xx>=1&&yy>=1&&xx<=n&&yy<=n&&map.bk[xx][yy]==0)
			{
				File mf=new File("src/img/yx.mp3");
				URI uri=mf.toURI();
				URL url = null;
				try {
					url=uri.toURL();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				AudioClip clip=Applet.newAudioClip(url);
				clip.play();
				map.bk[x][y]=0;
				System.out.println(xx+" "+yy);
				map.bk[xx][yy]=this.id;
				System.out.println(mp.mkx[yy]+" "+mp.mky[xx]);
				this.hide();
				Main.ctt.remove(this);
				this.setLocation(mp.mkx[yy],mp.mky[xx]);
				Main.ctt.add(this);
				this.show();
				for(int ii=1;ii<=n;ii++)
				{
					for(int jj=1;jj<=n;jj++)
					System.out.print(map.bk[ii][jj]+" ");
					System.out.print("\n");
				}
				this.x=xx;
				this.y=yy;
				//System.out.println(check());
				if(check()==1)
				{
					JOptionPane.showMessageDialog(Main.mainJF, "��ϲ����Ӯ��!!!!","��ϲ",JOptionPane.INFORMATION_MESSAGE);
					if(menu.cg.cmod==1)
					{
						chuangguan.cnt+=1;
						menu.f=0;
						menu.tm.tm.cancel();
						menu.jpa2.remove(menu.tm.show);
						menu.tm.show.hide();
						if(menu.mod==2)
						{
							game.yuantu.hide();
							Main.ctt.remove(game.yuantu);
						}
						if(dif==1)
						{
							for(int ii=0;ii<8;ii++)
							{
								menu.gm.blk[ii].hide();
								Main.ctt.remove(menu.gm.blk[i]);
							}
						}
						else if(dif==2)
						{
							for(int ii=0;ii<15;ii++)
							{
								menu.gm.blk[ii].hide();
								Main.ctt.remove(menu.gm.blk[ii]);
							}
						}
					}
					else
					menu.tm.tm.cancel();
				}
				return;
			}
		}
	}
	public int check()
	{
		//System.out.println("���Ѿ�check!!!!");
		int p=1;
		for(int i=1;i<=n;i++)
		for(int j=1;j<=n;j++)
		{
			if(i==n&&j==n)
			break;
			if(map.bk[i][j]!=p++)
			return 0;
		}
		return 1;
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent e) 
	{
		System.out.println("fmod="+menu.fmod);
		if(menu.fmod==1)
		{
			menu.x1=this.x;
			menu.y1=this.y;
			menu.k1=this.id;
			System.out.println(menu.x1+" "+menu.y1);
			menu.fmod=3;
			return;
		}
		if(menu.fmod==3)
		{
			menu.x2=this.x;
			menu.y2=this.y;
			menu.k2=this.id;
			System.out.println(map.mk[menu.k1]+" "+map.mk[menu.k2]);
			int re=JOptionPane.showConfirmDialog(Main.mainJF, "��ȷ��������"+menu.x1+"�е�"+menu.y1+"�����"+menu.x2+"�����"+menu.y2+"����","ȷ��",JOptionPane.YES_NO_OPTION);
			if(re==0)
			{
				if(menu.k1==menu.k2)
				{
					JOptionPane.showMessageDialog(Main.mainJF, "�޷��Լ������Լ�!!!!");
					return;
				}
				game.blk[map.mk[menu.k1]].hide();
				game.blk[map.mk[menu.k2]].hide();
				Main.ctt.remove(game.blk[map.mk[menu.k1]]);
				Main.ctt.remove(game.blk[map.mk[menu.k2]]);
				game.blk[map.mk[menu.k1]].setLocation(mp.mkx[menu.y2],mp.mky[menu.x2]);
				game.blk[map.mk[menu.k2]].setLocation(mp.mkx[menu.y1],mp.mky[menu.x1]);
				map.bk[menu.x1][menu.y1]=game.blk[map.mk[menu.k2]].id;
				map.bk[menu.x2][menu.y2]=game.blk[map.mk[menu.k1]].id;
				game.blk[map.mk[menu.k2]].x=menu.x1;
				game.blk[map.mk[menu.k2]].y=menu.y1;
				game.blk[map.mk[menu.k1]].x=menu.x2;
				game.blk[map.mk[menu.k1]].y=menu.y2;
				Main.ctt.add(game.blk[map.mk[menu.k1]]);
				Main.ctt.add(game.blk[map.mk[menu.k2]]);
				game.blk[map.mk[menu.k1]].show();
				game.blk[map.mk[menu.k2]].show();
				menu.fmod=0;
				for(int ii=1;ii<=n;ii++)
				{
					for(int jj=1;jj<=n;jj++)
					System.out.print(map.bk[ii][jj]+" ");
					System.out.print("\n");
				}
				if(check()==1)
				JOptionPane.showMessageDialog(Main.mainJF, "��ϲ����Ӯ��!!!!","��ϲ",JOptionPane.INFORMATION_MESSAGE);
			}
			else
			menu.fmod=1;
			return;
		}
		if(menu.fmod!=0)
		return;
		int dx[]={-1,1,0,0};
		int dy[]={0,0,-1,1};
		for(int i=0;i<4;i++)
		{
			int xx=this.x+dx[i];
			int yy=this.y+dy[i];
			//System.out.println(xx+" "+yy);
			if(xx>=1&&yy>=1&&xx<=n&&yy<=n&&map.bk[xx][yy]==0)
			{
				map.bk[x][y]=0;
				System.out.println(xx+" "+yy);
				map.bk[xx][yy]=this.id;
				System.out.println(mp.mkx[yy]+" "+mp.mky[xx]);
				this.hide();
				Main.ctt.remove(this);
				this.setLocation(mp.mkx[yy],mp.mky[xx]);
				Main.ctt.add(this);
				this.show();
				for(int ii=1;ii<=n;ii++)
				{
					for(int jj=1;jj<=n;jj++)
					System.out.print(map.bk[ii][jj]+" ");
					System.out.print("\n");
				}
				this.x=xx;
				this.y=yy;
				//System.out.println(check());
				if(check()==1)
				{
					JOptionPane.showMessageDialog(Main.mainJF, "��ϲ����Ӯ��!!!!","��ϲ",JOptionPane.INFORMATION_MESSAGE);
					if(menu.cg.cmod==1)
					{
						chuangguan.cnt+=1;
						JOptionPane.showMessageDialog(Main.mainJF, "��ϲ����˵�"+(chuangguan.cnt-1)+"��");
						menu.f=0;
						menu.tm.tm.cancel();
						menu.jpa2.remove(menu.tm.show);
						menu.tm.show.hide();
						if(menu.mod==2)
						{
							game.yuantu.hide();
							Main.ctt.remove(game.yuantu);
						}
						if(dif==1)
						{
							for(int ii=0;ii<8;ii++)
							{
								menu.gm.blk[ii].hide();
								Main.ctt.remove(menu.gm.blk[i]);
							}
						}
						else if(dif==2)
						{
							for(int ii=0;ii<15;ii++)
							{
								menu.gm.blk[ii].hide();
								Main.ctt.remove(menu.gm.blk[ii]);
							}
						}
					}
					else
					menu.tm.tm.cancel();
				}
				return;
			}
		}
		
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}