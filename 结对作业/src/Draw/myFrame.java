package Draw;

import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.FileAlreadyExistsException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import service.checkAnswer;
import service.getQuestion;
import unity.information;



public class myFrame extends JFrame{
	private JFileChooser fileChooser = new JFileChooser();
	String file_a,file_q,selectedFile,file_s,file_correct;
	JLabel label = new JLabel("������Ŀ��"); 
	JTextField textField = new JTextField(16);
	JLabel label3 = new JLabel("��ĸ��Χ"); 
	JTextField textField3 = new JTextField(16);
	JLabel label4 = new JLabel("��Ŀ����Ȼ�����ֵ");
	JTextField textField4 = new JTextField(16);
	//����JTextField��16��ʾ16�У�����JTextField�Ŀ����ʾ�����������ַ�����
	
	JButton button2 = new JButton("��Ŀ�ļ�"); 
	JTextField textField6 = new JTextField(30);
	JButton button3 = new JButton("���ļ�");
	JTextField textField5 = new JTextField(30);
	JButton button5 = new JButton("ȷ������");
	
	JButton button = new JButton("������ȷ��");
	JButton button6 = new JButton("������·��");
	JButton button7 = new JButton("�𰸵�ַ");
	JButton button8 = new JButton("��Ŀ��ַ");
	JButton button4 = new JButton("ȷ������");
	//���캯��
	public myFrame(String title)
	{
		//�̳и��࣬
		super(title);
		
		//�������
		Container contentPane = getContentPane();
		contentPane.setLayout(null);//���Բ���
		
		//��ӿؼ�
		contentPane.add(label);
		label.setBounds(30, 10, 80, 25);
		contentPane.add(textField);//��Ŀ��Ŀ
		textField.setBounds(120, 10,150, 25);
		contentPane.add(label3);
		label3.setBounds(290, 10,150, 25);
		contentPane.add(textField3);//��ĸ��Χ
		textField3.setBounds(380, 10,150, 25);
		contentPane.add(label4);
		label4.setBounds(30, 40, 130, 25);
		contentPane.add(textField4);//��Ȼ�����ֵ
		textField4.setBounds(180, 40, 150, 25);
		contentPane.add(button3);
		button3.setBounds(30, 70, 120, 25);
		contentPane.add(textField5);//���ɴ�·��
		textField5.setBounds(180, 70,350, 25);
		contentPane.add(button2);
		button2.setBounds(30, 100, 120, 25);
		contentPane.add(textField6);//��Ŀ�ļ�·��
		textField6.setBounds(180, 100,350, 25);
		contentPane.add(button5);//ȷ������
		button5.setBounds(200, 130, 120, 25);
		
		
		contentPane.add( button8) ;//new JButton("У����Ŀ")
		JTextField textField8 = new JTextField(30);
		contentPane.add(textField8);
		button8.setBounds(30, 170, 120, 25);
		textField8.setBounds(180, 170,350, 25);
		
		contentPane.add(button7);//("ѡ������");
		button7.setBounds(30,200, 120,25);
		JTextField textField7 = new JTextField(30);
		contentPane.add(textField7);
		textField7.setBounds(180, 200,350, 25);
		
		contentPane.add(button);
		button.setBounds(30, 230, 120, 25);
		JTextField textField2 = new JTextField(30);
		contentPane.add(textField2);//��ȷ��
		textField2.setBounds(180, 230, 350, 25);
		
		contentPane.add(button6);
		button6.setBounds(30, 260, 120, 25);
		JTextField textField9 = new JTextField(30);
		contentPane.add(textField9);//����������·��
		textField9.setBounds(180, 260, 350,25);
		
		contentPane.add(button4);
		button4.setBounds(200,290,120, 25);
		
		
		
		
		//������Ŀ�ļ�
		button2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			int i = fileChooser.showOpenDialog(getContentPane());// ��ʾ�ļ�ѡ��Ի���

			if (i == JFileChooser.APPROVE_OPTION) {

			selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// ���ѡ�е��ļ�����
			textField6.setText(selectedFile);// ��ʾѡ���ļ�������
			
			}

			}

			});
		
		
		//������ȷ���ļ�
				button.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

					int i = fileChooser.showOpenDialog(getContentPane());// ��ʾ�ļ�ѡ��Ի���

					if (i == JFileChooser.APPROVE_OPTION) {

					selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// ���ѡ�е��ļ�����
					textField2.setText(selectedFile);// ��ʾѡ���ļ�������
					
					}

					}

					});
				
		
		
		
		//���ɴ��ļ�
		button3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			int i = fileChooser.showOpenDialog(getContentPane());// ��ʾ�ļ�ѡ��Ի���

			if (i == JFileChooser.APPROVE_OPTION) {

			selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// ���ѡ�е��ļ�����
			textField5.setText(selectedFile);// ��ʾѡ���ļ�������
			
			}

			}

			});
		
		//������ļ�
				button7.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

					int i = fileChooser.showOpenDialog(getContentPane());// ��ʾ�ļ�ѡ��Ի���

					if (i == JFileChooser.APPROVE_OPTION) {

					selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// ���ѡ�е��ļ�����
					textField7.setText(selectedFile);// ��ʾѡ���ļ�������
					
					}

					}

					});
				
				//������Ŀ�ļ�
				button8.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

					int i = fileChooser.showOpenDialog(getContentPane());// ��ʾ�ļ�ѡ��Ի���

					if (i == JFileChooser.APPROVE_OPTION) {

					selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// ���ѡ�е��ļ�����
					textField8.setText(selectedFile);// ��ʾѡ���ļ�������
					
					}

					}

					});
		
				//������
				button6.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

					int i = fileChooser.showOpenDialog(getContentPane());// ��ʾ�ļ�ѡ��Ի���

					if (i == JFileChooser.APPROVE_OPTION) {

					selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// ���ѡ�е��ļ�����
					textField9.setText(selectedFile);// ��ʾѡ���ļ�������
					
					}

					}

					});
		
		//ȷ�ϼ���
		button4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				file_a = textField7.getText();
				file_q = textField8.getText();
				file_s = textField9.getText();
				file_correct = textField2.getText();
				if(file_a.equals("")||file_q.equals("")||file_s.equals("")||file_correct.equals(""))
				{
					Object[] options = { "OK ", "CANCEL " }; 
					JOptionPane.showOptionDialog(null, "����û������ ", "��ʾ", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.WARNING_MESSAGE,null, options, options[0]);
				}
				else {
				information.setAnswer(file_a); 
				information.setProblem(file_q);
				information.setFile_s(file_s);
				information.setReply(file_correct);
				checkAnswer gA = new checkAnswer();
				if(gA.checkAnswer()) {
					JOptionPane.showMessageDialog(null,"��������������"+file_s );
				}
					
				}
				}
			

			});
		
		//ȷ������
		button5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				file_q = textField6.getText();
				file_a = textField5.getText();
				String fenmu_max = textField3.getText();//��
				String nature = textField4.getText();//��
				String num_timu = textField.getText();//��Ŀ
				//�ж��Ƿ�������
				if(file_a.equals("")||file_q.equals("")||nature.equals("")||fenmu_max.equals("")||num_timu.equals(""))
				{
					Object[] options = { "OK ", "CANCEL " }; 
					JOptionPane.showOptionDialog(null, "����û������ ", "��ʾ", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.WARNING_MESSAGE,null, options, options[0]);
				}
				else {
				information.setAnswer(file_a); 
				information.setProblem(file_q);
				information.setFenmu_max(Integer.parseInt(fenmu_max));
				information.setNature(Integer.parseInt(nature));
				information.setNum_timu(Integer.parseInt(textField.getText()));
				getQuestion gQ = new getQuestion();
				if(gQ.getQuestion())
				 JOptionPane.showMessageDialog(null,"��Ŀ��������"+file_q+"����������"+file_a );
				}

			}

			});
		
		
		//����������·��
		button6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			int i = fileChooser.showOpenDialog(getContentPane());// ��ʾ�ļ�ѡ��Ի���

			if (i == JFileChooser.APPROVE_OPTION) {

			selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// ���ѡ�е��ļ�����
			textField7.setText(selectedFile);// ��ʾѡ���ļ�������
			file_s = textField7.getText();

			}

			}

			});
		
	}
}
	