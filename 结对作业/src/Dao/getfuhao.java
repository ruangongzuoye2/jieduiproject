package Dao;

import java.security.SecureRandom;
/*
 * ���ɷ���
 */
public class getfuhao {
	public  char fuhao(int n) {	//n=1ʱ������ɲ����� ��/��/��/��
		//n=0ʱ�����������ж��Ƿ��������ţ��Ƿ�����������ȣ�����0��1
		SecureRandom r = new SecureRandom();	
		int t = r.nextInt();
		if(n==1) {
			t%=4;
			if(t==0)	return '+';
			else if(t==1)	return '-';
			else if(t==2)	return '��';
			else	return '��';
		}else {
			if(t%2==0)	return 1;
			else	return 0;
		}
	}	

}
