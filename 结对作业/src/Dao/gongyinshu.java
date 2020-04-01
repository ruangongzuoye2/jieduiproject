package Dao;

public class gongyinshu {
	public int gong(int m,int n) {	//返回分子和分母的公因子,m是分子,n是分母
		int gongyinshu = 1,small = m;
		for(int i=1;i<=small;i++) {if((m%i==0)&(n%i==0)) gongyinshu = i;}
		return gongyinshu;
	}
}
