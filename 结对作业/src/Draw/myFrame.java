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
	JLabel label = new JLabel("生成题目数"); 
	JTextField textField = new JTextField(16);
	JLabel label3 = new JLabel("分母范围"); 
	JTextField textField3 = new JTextField(16);
	JLabel label4 = new JLabel("题目中自然数最大值");
	JTextField textField4 = new JTextField(16);
	//创建JTextField，16表示16列，用于JTextField的宽度显示而不是限制字符个数
	
	JButton button2 = new JButton("题目文件"); 
	JTextField textField6 = new JTextField(30);
	JButton button3 = new JButton("答案文件");
	JTextField textField5 = new JTextField(30);
	JButton button5 = new JButton("确定生成");
	
	JButton button = new JButton("导入正确答案");
	JButton button6 = new JButton("检验结果路径");
	JButton button7 = new JButton("答案地址");
	JButton button8 = new JButton("题目地址");
	JButton button4 = new JButton("确定检验");
	//构造函数
	public myFrame(String title)
	{
		//继承父类，
		super(title);
		
		//内容面板
		Container contentPane = getContentPane();
		contentPane.setLayout(null);//线性布局
		
		//添加控件
		contentPane.add(label);
		label.setBounds(30, 10, 80, 25);
		contentPane.add(textField);//题目数目
		textField.setBounds(120, 10,150, 25);
		contentPane.add(label3);
		label3.setBounds(290, 10,150, 25);
		contentPane.add(textField3);//分母范围
		textField3.setBounds(380, 10,150, 25);
		contentPane.add(label4);
		label4.setBounds(30, 40, 130, 25);
		contentPane.add(textField4);//自然数最大值
		textField4.setBounds(180, 40, 150, 25);
		contentPane.add(button3);
		button3.setBounds(30, 70, 120, 25);
		contentPane.add(textField5);//生成答案路径
		textField5.setBounds(180, 70,350, 25);
		contentPane.add(button2);
		button2.setBounds(30, 100, 120, 25);
		contentPane.add(textField6);//题目文件路径
		textField6.setBounds(180, 100,350, 25);
		contentPane.add(button5);//确认生成
		button5.setBounds(200, 130, 120, 25);
		
		
		contentPane.add( button8) ;//new JButton("校验题目")
		JTextField textField8 = new JTextField(30);
		contentPane.add(textField8);
		button8.setBounds(30, 170, 120, 25);
		textField8.setBounds(180, 170,350, 25);
		
		contentPane.add(button7);//("选择检验答案");
		button7.setBounds(30,200, 120,25);
		JTextField textField7 = new JTextField(30);
		contentPane.add(textField7);
		textField7.setBounds(180, 200,350, 25);
		
		contentPane.add(button);
		button.setBounds(30, 230, 120, 25);
		JTextField textField2 = new JTextField(30);
		contentPane.add(textField2);//正确答案
		textField2.setBounds(180, 230, 350, 25);
		
		contentPane.add(button6);
		button6.setBounds(30, 260, 120, 25);
		JTextField textField9 = new JTextField(30);
		contentPane.add(textField9);//检验结果保存路径
		textField9.setBounds(180, 260, 350,25);
		
		contentPane.add(button4);
		button4.setBounds(200,290,120, 25);
		
		
		
		
		//导入题目文件
		button2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			int i = fileChooser.showOpenDialog(getContentPane());// 显示文件选择对话框

			if (i == JFileChooser.APPROVE_OPTION) {

			selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// 获得选中的文件对象
			textField6.setText(selectedFile);// 显示选中文件的名称
			
			}

			}

			});
		
		
		//导入正确答案文件
				button.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

					int i = fileChooser.showOpenDialog(getContentPane());// 显示文件选择对话框

					if (i == JFileChooser.APPROVE_OPTION) {

					selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// 获得选中的文件对象
					textField2.setText(selectedFile);// 显示选中文件的名称
					
					}

					}

					});
				
		
		
		
		//生成答案文件
		button3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			int i = fileChooser.showOpenDialog(getContentPane());// 显示文件选择对话框

			if (i == JFileChooser.APPROVE_OPTION) {

			selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// 获得选中的文件对象
			textField5.setText(selectedFile);// 显示选中文件的名称
			
			}

			}

			});
		
		//导入答案文件
				button7.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

					int i = fileChooser.showOpenDialog(getContentPane());// 显示文件选择对话框

					if (i == JFileChooser.APPROVE_OPTION) {

					selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// 获得选中的文件对象
					textField7.setText(selectedFile);// 显示选中文件的名称
					
					}

					}

					});
				
				//导入题目文件
				button8.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

					int i = fileChooser.showOpenDialog(getContentPane());// 显示文件选择对话框

					if (i == JFileChooser.APPROVE_OPTION) {

					selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// 获得选中的文件对象
					textField8.setText(selectedFile);// 显示选中文件的名称
					
					}

					}

					});
		
				//检验结果
				button6.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

					int i = fileChooser.showOpenDialog(getContentPane());// 显示文件选择对话框

					if (i == JFileChooser.APPROVE_OPTION) {

					selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// 获得选中的文件对象
					textField9.setText(selectedFile);// 显示选中文件的名称
					
					}

					}

					});
		
		//确认检验
		button4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				file_a = textField7.getText();
				file_q = textField8.getText();
				file_s = textField9.getText();
				file_correct = textField2.getText();
				if(file_a.equals("")||file_q.equals("")||file_s.equals("")||file_correct.equals(""))
				{
					Object[] options = { "OK ", "CANCEL " }; 
					JOptionPane.showOptionDialog(null, "您还没有输入 ", "提示", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.WARNING_MESSAGE,null, options, options[0]);
				}
				else {
				information.setAnswer(file_a); 
				information.setProblem(file_q);
				information.setFile_s(file_s);
				information.setReply(file_correct);
				checkAnswer gA = new checkAnswer();
				if(gA.checkAnswer()) {
					JOptionPane.showMessageDialog(null,"检验结果已生成在"+file_s );
				}
					
				}
				}
			

			});
		
		//确认生成
		button5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				file_q = textField6.getText();
				file_a = textField5.getText();
				String fenmu_max = textField3.getText();//自
				String nature = textField4.getText();//答案
				String num_timu = textField.getText();//题目
				//判断是否输入了
				if(file_a.equals("")||file_q.equals("")||nature.equals("")||fenmu_max.equals("")||num_timu.equals(""))
				{
					Object[] options = { "OK ", "CANCEL " }; 
					JOptionPane.showOptionDialog(null, "您还没有输入 ", "提示", JOptionPane.DEFAULT_OPTION, 
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
				 JOptionPane.showMessageDialog(null,"题目已生成在"+file_q+"答案已生成在"+file_a );
				}

			}

			});
		
		
		//检验结果保存路径
		button6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			int i = fileChooser.showOpenDialog(getContentPane());// 显示文件选择对话框

			if (i == JFileChooser.APPROVE_OPTION) {

			selectedFile = fileChooser.getSelectedFile().getAbsolutePath();// 获得选中的文件对象
			textField7.setText(selectedFile);// 显示选中文件的名称
			file_s = textField7.getText();

			}

			}

			});
		
	}
}
	