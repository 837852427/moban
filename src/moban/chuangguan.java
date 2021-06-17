package moban;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import moban.Main;
import moban.menu;
public class chuangguan extends JMenu 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int cmod=0;
	static int cnt=1;
	static JLabel jishu;
	chuangguan()
	{
		this.setText("��������ģʽ");
		this.addMenuListener(new MenuListener()
				{
					public void menuSelected(MenuEvent e)
					{
						if(cmod==1)
						{
							JOptionPane.showMessageDialog(Main.mainJF,"���Ѿ������˴���ģʽ","��ʾ",1);
							return;
						}
						int re=JOptionPane.showConfirmDialog(Main.mainJF, "ȷ�����봳��ģʽ????","ȷ��",JOptionPane.YES_NO_OPTION);
						if(re==0)
						{
							JOptionPane.showMessageDialog(Main.mainJF, "���Ѿ������˴���ģʽ,�����ѡ������ģʽ������ս,�����ս�ɹ��Ļ�,ϵͳ���¼���ʱ���Ѷ���Ϊ�ɼ����Ҽ���Ӣ�۰�","��ʾ˵��",1);
							menu.chongwan.setText("�˳�����ģʽ");
							jishu=new JLabel("�����ڴ��������ǵ�"+cnt+"��,������ս��!!!!");
							menu.jpa1.add(jishu);
							Main.ctt.add(menu.jpa1);
							cmod=1;
						}
						else if(re==1)
						{
							JOptionPane.showMessageDialog(Main.mainJF, "����Ȼ���Լ���ѡ��ģʽ��ս!!!!������ÿ��Ե�ʱ�򻹿��Ի���ѡ�񴳹�","��ʾ",1);
						}
					}

					public void menuCanceled(MenuEvent e) {
						return;
						// TODO Auto-generated method stub
						
					}

					public void menuDeselected(MenuEvent e) {
						return;
						// TODO Auto-generated method stub
						
					}
				}
				);
	}
}
