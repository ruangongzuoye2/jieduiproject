package Dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class get_hangshu {
	public  int hang(String file) { //返回文件 file.c 的行数
		    int linenum = 0;
		     BufferedReader br = null;
		     try {
		     br = new BufferedReader(new FileReader(file));
		     String temp = null;
		     while (((temp = br.readLine()) != null)) {
		          linenum++;
		      }
		     } catch (FileNotFoundException e) {
		         e.printStackTrace();
		     } catch (IOException e) {
		         e.printStackTrace();
		     } finally {
		         try {
		             br.close();
		         } catch (IOException e) {
		             e.printStackTrace();
		         }
		     }
		     return linenum;
		 }

}
