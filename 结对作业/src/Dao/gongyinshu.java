package Dao;

public class gongyinshu {
	public int gong(int m,int n) {	//���ط��Ӻͷ�ĸ�Ĺ�����,m�Ƿ���,n�Ƿ�ĸ
		int gongyinshu = 1,small = m;
		for(int i=1;i<=small;i++) {if((m%i==0)&(n%i==0)) gongyinshu = i;}
		return gongyinshu;
	}
}
