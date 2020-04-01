package Dao;

public class issame {
	public static boolean same(int c,int[] T,char[] Fuhao1,char[] Fuhao2,char[] Fuhao3,int[] n1,int[] n11,int[] n111,int[] n2,int[] n22,int[] n222,int[] n3,int[] n33,int[] n333,int[] n4,int[] n44,int[] n444) {
		int d;
		if(T[c]>0)	//第一类
			for(d=0;d<c;d++) 	
				if((Fuhao1[c]==Fuhao1[d])&(Fuhao2[c]==Fuhao2[d])&(Fuhao3[c]==Fuhao3[d])&(T[c]==T[d]))
					if((n1[c]==n1[d])&(n11[c]==n11[d])&(n111[c]==n111[d])&(n2[c]==n2[d])&(n22[c]==n22[d])&(n222[c]==n222[d])&(n3[c]==n3[d])&(n33[c]==n33[d])&(n333[c]==n333[d])&(n4[c]==n4[d])&(n44[c]==n44[d])&(n444[c]==n444[d]))
						return true;else;
				else if(Fuhao1[c]=='+'|Fuhao1[c]=='×')
					if((n1[c]==n2[d])&(n11[c]==n22[d])&(n111[c]==n222[d])&(n2[c]==n1[d])&(n22[c]==n11[d])&(n222[c]==n111[d])&(n3[c]==n3[d])&(n33[c]==n33[d])&(n333[c]==n333[d])&(n4[c]==n4[d])&(n44[c]==n44[d])&(n444[c]==n444[d]))
						return true;else;else;
		else if(T[c]==0)	//第二类
			for(d=0;d<c;d++) {
				if((Fuhao1[c]==Fuhao1[d])&(Fuhao2[c]==Fuhao2[d])&(Fuhao3[c]==Fuhao3[d])) 
					if((n1[c]==n1[d])&(n11[c]==n11[d])&(n111[c]==n111[d])&(n2[c]==n2[d])&(n22[c]==n22[d])&(n222[c]==n222[d])&(n3[c]==n3[d])&(n33[c]==n33[d])&(n333[c]==n333[d])&(n4[c]==n4[d])&(n44[c]==n44[d])&(n444[c]==n444[d]))
						return true;	
					else if(Fuhao2[c]=='×'&(n1[c]==n2[d])&(n11[c]==n22[d])&(n111[c]==n222[d])&(n2[c]==n1[d])&(n22[c]==n11[d])&(n222[c]==n111[d])&(n3[c]==n3[d])&(n33[c]==n33[d])&(n333[c]==n333[d])&(n4[c]==n4[d])&(n44[c]==n44[d])&(n444[c]==n444[d]))
						return true;
					else if(Fuhao3[c]=='×'&(n1[c]==n1[d])&(n11[c]==n11[d])&(n111[c]==n111[d])&(n2[c]==n2[d])&(n22[c]==n22[d])&(n222[c]==n222[d])&(n3[c]==n4[d])&(n33[c]==n44[d])&(n333[c]==n444[d])&(n4[c]==n3[d])&(n44[c]==n33[d])&(n444[c]==n333[d]))
						return true;
					else if(Fuhao2[c]=='×'&Fuhao3[c]=='×'&(n1[c]==n2[d])&(n11[c]==n22[d])&(n111[c]==n222[d])&(n2[c]==n1[d])&(n22[c]==n11[d])&(n222[c]==n111[d])&(n3[c]==n4[d])&(n33[c]==n44[d])&(n333[c]==n444[d])&(n4[c]==n3[d])&(n44[c]==n33[d])&(n444[c]==n333[d]))
						return true;		
		}
		return false;
	}

}
