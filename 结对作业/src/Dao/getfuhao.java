package Dao;

import java.security.SecureRandom;
/*
 * 生成符号
 */
public class getfuhao {
	public  char fuhao(int n) {	//n=1时随机生成并返回 加/减/乘/除
		//n=0时函数功能是判断是否生成括号，是否增加运算项等，返回0或1
		SecureRandom r = new SecureRandom();	
		int t = r.nextInt();
		if(n==1) {
			t%=4;
			if(t==0)	return '+';
			else if(t==1)	return '-';
			else if(t==2)	return '÷';
			else	return '×';
		}else {
			if(t%2==0)	return 1;
			else	return 0;
		}
	}	

}
