package Main;

import javax.swing.JFrame;
import Draw.myFrame;

public class main {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				createGUI();
			}
		});
	}
	private static void createGUI()
	{
		//����һ�����ڣ�����һ������
		myFrame frame = new myFrame("��������");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���ô��ڴ�С
		frame.setSize(600, 400);
		
		//��ʾ����
		frame.setVisible(true);
	}

}


