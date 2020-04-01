package service;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Dao.get_hangshu;
import unity.information;
public class checkAnswer {
	public boolean checkAnswer() {
		get_hangshu gHangshu = new get_hangshu();
		int i = 0,j = 0,k = 0;
		StringBuilder wrong = new StringBuilder();	//错题记录写入txt
		StringBuilder correct = new StringBuilder();//对题记录写入txt
		int Qnumber = gHangshu.hang(information.getProblem());
		int W = 0,C = 0;						    //错题数，对题数		
		File replys = new File(information.getReply());
		File answers = new File(information.getAnswer());
		File grade = new File(information.getFile_s());
		try {
			if(!replys.exists())	
				replys.createNewFile();
			if(!grade.exists())	
				grade.createNewFile();
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		BufferedReader R1 = null,R2 = null;


		int [] a = new int[Qnumber];
		try {
			R1 = new BufferedReader(new FileReader(replys));
			R2 = new BufferedReader(new FileReader(answers));
			String str1,str2;
			while((str2 = R2.readLine())!=null) {
				str1 = R1.readLine();
				i++;		
					//System.out.print("正确答案是"+str2.substring(str2.indexOf('.')+1, str2.length())+"\n");
					if(str1.equals(str2))	a[i-1]=1;
			}
			R1.close();
			R2.close();
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}finally {
			if(R1!=null&R2!=null) {
				try {
					R1.close();
					R2.close();
				}catch (IOException ee){
					ee.printStackTrace();
					return false;
				}
			}
		}
		for(i=0;i<Qnumber;i++) {
			if(a[i]==1)	{correct.append(i+1+",");C++;}
			else	{wrong.append(i+1+",");W++;}
		}
		correct.replace(correct.length()-1, correct.length(), ")");
		wrong.replace(wrong.length()-1, wrong.length(), ")");
		correct.insert(0,"correct:"+" "+C+" "+"(");
		wrong.insert(0,"wrong:"+" "+W+" "+"(");
		try{
			FileWriter writer = new FileWriter(grade);
			writer.write(correct.toString()+"\n");
			writer.write(wrong.toString());
			writer.close();
		}catch(IOException e) {
			e.printStackTrace(); 
			return false;
}		
	return true;
	}
}
