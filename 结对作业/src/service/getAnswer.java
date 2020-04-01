package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Dao.get_hangshu;
import unity.information;

public class getAnswer {
	public boolean  getAnswer(){
		Scanner sc = new Scanner(System.in);
		get_hangshu gHangshu = new get_hangshu();
		int i = 0,j = 0,k = 0;
		int Qnumber = gHangshu.hang(information.getProblem());
		StringBuilder wrong = new StringBuilder();	//错题记录写入txt
		StringBuilder correct = new StringBuilder();//对题记录写入txt
		int W = 0,C = 0;						    //错题数，对题数								
		File fex = new File(information.getProblem());
		File fan = new File(information.getAnswer());
		File grade = new File(information.getFile_s());
		try {
			if(!grade.exists())	
				grade.createNewFile();
		}catch(IOException e) {
			e.printStackTrace();
			sc.close();
			return false;
		}
		
		BufferedReader R1 = null,R2 = null;
		StringBuffer sb = new StringBuffer();
		String [] answer = new String[Qnumber];	//使用者的回答
		int [] a = new int[Qnumber];
		try {
			R1 = new BufferedReader(new FileReader(fex));
			R2 = new BufferedReader(new FileReader(fan));
			String str1,str2;
			while((str1 = R1.readLine())!=null&(str2 = R2.readLine())!=null) {
				i++;
				sb.append(str1);
				System.out.print(sb+" ");
				answer[i-1] = sc.next();			
					System.out.print("正确答案是"+str2.substring(str2.indexOf('.')+1, str2.length())+"\n");
					if(answer[i-1].equals(str2.substring(str2.indexOf('.')+1, str2.length())))	a[i-1]=1;
				sb.delete(0, sb.length());
			}
			R1.close();
			R2.close();
		}catch(IOException e) {
			e.printStackTrace();
			sc.close();
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
		sc.close();
		//
		//writer.close();
		for(i=0;i<Qnumber;i++) {
			if(a[i]==1)	{correct.append(i+1+",");C++;}
			else	{wrong.append(i+1+",");W++;}
		}
		correct.replace(correct.length()-1, correct.length(), ")");
		wrong.replace(wrong.length()-1, wrong.length(), ")");
		correct.insert(0,"wrong:"+" "+C+" "+"(");
		wrong.insert(0,"correct:"+" "+W+" "+"(");
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
