package service;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;

import unity.information;
import Dao.getopnum;
import Dao.getfuhao;
import Dao.gongyinshu;
public class getQuestion {
	
		getfuhao fh = new getfuhao();
		getopnum opn =new getopnum();
		public static int gong(int m,int n) {	//返回分子和分母的公因子,m是分子,n是分母
			int gongyinshu = 1,small = m;
			for(int i=1;i<=small;i++) {if((m%i==0)&(n%i==0)) gongyinshu = i;}
			return gongyinshu;
		}

		public boolean getQuestion() {
			File fex = new File(information.getProblem());
			File fan = new File(information.getAnswer());
			int Qnumber = information.getNum_timu();
			int i,c,d;	//Qnumber指生成题目数量,i,c,d是计数器
			int N1,N2,N3,N4;	//四个数的公因数		
			int same = 0;	//标志题目是否重复
			int nature = information.getNature(),fenmu = information.getFenmu_max();	//自然数，真分数分母的限制条件
			int answerZi=0,answerMu=0,answerGong=1,temp;	//分步得到的答案的分子分母,temp是标记前后添加的,answerGong是用来化简答案的
			int Zi=0,Mu=0;	//保存形如a*b+c*d的运算数据
			char [] Fuhao1 =new char[Qnumber]; 	//每个题目的三个运算符
			char [] Fuhao2 =new char[Qnumber]; 
			char [] Fuhao3 =new char[Qnumber]; 	
			int [] n1 = new int[Qnumber];	//n1,n11,n111依次表示第一个数的整数,分子,分母
			int [] n11 = new int[Qnumber];
			int [] n111 = new int[Qnumber];
			int [] n2 = new int[Qnumber];
			int [] n22 = new int[Qnumber];
			int [] n222 = new int[Qnumber];
			int [] n3 = new int[Qnumber];
			int [] n33 = new int[Qnumber];
			int [] n333 = new int[Qnumber];
			int [] n4 = new int[Qnumber];
			int [] n44 = new int[Qnumber];
			int [] n444 = new int[Qnumber];			
			int [] AnswerZi = new int[Qnumber];	//存放最终答案的分子
			int [] AnswerMu = new int[Qnumber];	//存放最终答案的分母
			int [] T = new int [Qnumber];	//值为0时是第二类题目，不为0时表示第一类题目的数字数量
			for(c=0;c<Qnumber;c++) {	
				T[c] = 0;
				n11[c]=0;n111[c]=1;		
				n22[c]=0;n222[c]=1;
				n33[c]=0;n333[c]=1;
				n44[c]=0;n444[c]=1;}			//初始化分子分母
			
			StringBuilder s = new StringBuilder();
			String [] str = new String[Qnumber];	//存放题目，后保存到文档
		
			for(c=0;c<Qnumber;c++) {
				
				/*	
				 * 算出四个随机数和三个随即运算符
				 */
				if(fh.fuhao(0)==1) {									//算出随机数1
					n1[c] =opn.number(nature,0);n111[c] = opn.number(fenmu,1);n11[c] = opn.number(n111[c],0);
					N1 = gong(n11[c],n111[c]);
					n11[c]/=N1;n111[c]/=N1;			
				}else	n1[c] = opn.number(nature,0);
				if(fh.fuhao(0)==1) {									//算出随机数2
					n2[c] = opn.number(nature,0);n222[c] = opn.number(fenmu,1);n22[c] = opn.number(n222[c],0);
					N2 = gong(n22[c],n222[c]);
					n22[c]/=N2;n22[c]/=N2;
				}else	n2[c] = opn.number(nature,0);	
				if(fh.fuhao(0)==1) {									//算出随机数3
					n3[c] = opn.number(nature,0);n333[c] = opn.number(fenmu,1);n33[c] = opn.number(n333[c],0);
					N3 = gong(n33[c],n333[c]);
					n33[c]/=N3;n333[c]/=N3;
				}else	n3[c] = opn.number(nature,0);
				if(fh.fuhao(0)==1) {									//算出随机数4
					n4[c] = opn.number(nature,0);n444[c] = opn.number(fenmu,1);n44[c] = opn.number(n444[c],0);
					N4 = gong(n44[c],n444[c]);
					n44[c]/=N4;n444[c]/=N4;
				}else	n4[c] = opn.number(nature,0);		
				
				/*
				 * 
				 * 第一类式子,例如 (2*4-6)*3
				 * 
				 */
				if(fh.fuhao(0)==1) {
					Fuhao1[c] = fh.fuhao(1);Fuhao2[c] = fh.fuhao(1);Fuhao3[c] = fh.fuhao(1);
					/*
					 * 得到形如  a+b  的式子（第一步运算）
					 */
					T[c] = 2;		
					if(Fuhao1[c]=='-'&((n1[c]+n11[c]/n111[c])<(n2[c]+n22[c]/n222[c])))	{i=n1[c];n1[c]=n2[c];n2[c]=i;i=n11[c];n11[c]=n22[c];n22[c]=i;i=n111[c];n111[c]=n222[c];n222[c]=i;}
					switch(Fuhao1[c]) {
					case '+':answerZi = n1[c]*n111[c]*n222[c]+n11[c]*n222[c]+n2[c]*n111[c]*n222[c]+n111[c]*n22[c];answerMu = n111[c]*n222[c];break;
					case '-':answerZi = n1[c]*n111[c]*n222[c]+n11[c]*n222[c]-n2[c]*n111[c]*n222[c]-n111[c]*n22[c];answerMu = n111[c]*n222[c];break;
					case '×':answerZi = n1[c]*n111[c]*n2[c]*n222[c]+n1[c]*n111[c]*n22[c]+n11[c]*n2[c]*n222[c]+n11[c]*n22[c];answerMu = n111[c]*n222[c];break;
					case '÷':answerZi = n1[c]*n111[c]*n222[c]+n11[c]*n222[c];answerMu = n2[c]*n111[c]*n222[c]+n22[c]*n111[c];break;
					default:answerZi = 0;
					}
					if((n11[c]==0))	s.append(n1[c]);
					else if(n111[c]==1)	s.append(n1[c]+n11[c]);
					else	s.append(n1[c]+"'"+n11[c]+"/"+n111[c]);	
					s.append(" "+Fuhao1[c]+" ");
					if((n22[c]==0))	s.append(n2[c]);
					else if(n222[c]==1)	s.append(n2[c]+n22[c]);
					else	s.append(n2[c]+"'"+n22[c]+"/"+n222[c]);
				
					/*
					 * 得到形如  a+b+c  的式子（第二步运算）
					 */
					if(fh.fuhao(0)==1) {	//随机生成1时执行此操作,往题目添加第三个数
						T[c] = 3;
						if((Fuhao2[c]=='-')&((answerZi/answerMu-(n3[c]+n33[c]/n333[c]))>0)) {
							temp = 1;	//temp = 1时后面添加
							if(fh.fuhao(0)==1)	s.insert(0, "(").append(") "+Fuhao2[c]+" ");
							else s.append(" "+Fuhao2[c]+" ");
							if((n33[c]==0))	s.append(n3[c]);
							else if(n333[c]==1)	s.append(n3[c]+n33[c]);
							else	s.append(n3[c]+"'"+n33[c]+"/"+n333[c]);
						}else if((Fuhao2[c]=='-')&((answerZi/answerMu-(n3[c]+n33[c]/n333[c]))<0)) {
							temp = 0;	//temp = 0时前面添加
							if((Fuhao1[c]=='+')|(Fuhao1[c]=='-'))	s.insert(0, " "+Fuhao2[c]+" (").append(')');
							else if(fh.fuhao(0)==1)	s.insert(0, " "+Fuhao2[c]+" (").append(')');
							else s.insert(0, " "+Fuhao2[c]+" ");
							if((n33[c]==0))	s.insert(0, n3[c]);
							else if(n333[c]==1)	s.insert(0,n3[c]+n33[c]);
							else	s.insert(0,n3[c]+"'"+n33[c]+"/"+n333[c]);
						}else if(fh.fuhao(0)==1) {	//前面添加第三个数和第二个符号 
							temp = 0;	//temp = 0时前面添加
							if((Fuhao1[c]=='+')|(Fuhao1[c]=='-')|(Fuhao2[c]=='×')|(Fuhao2[c]=='÷'))	s.insert(0, " "+Fuhao2[c]+" (").append(')');
							else if(fh.fuhao(0)==1)	s.insert(0, " "+Fuhao2[c]+" (").append(')');
							else s.insert(0, " "+Fuhao2[c]+" ");
							if((n33[c]==0))	s.insert(0, n3[c]); 
							else if(n333[c]==1)	s.insert(0,n3[c]+n33[c]);
							else	s.insert(0,n3[c]+"'"+n33[c]+"/"+n333[c]);
						}else {				//后面添加第三个数和第二个符号
							temp = 1;	//temp = 1时后面添加
							if(((Fuhao1[c]=='+')|(Fuhao1[c]=='-'))&((Fuhao2[c]=='×')|(Fuhao2[c]=='÷')))	s.insert(0, "(").append(") "+Fuhao2[c]+" ");
							else if(fh.fuhao(0)==1)	s.insert(0, "(").append(") "+Fuhao2[c]+" ");
							else s.append(" "+Fuhao2[c]+" ");
							if((n33[c]==0))	s.append(n3[c]);
							else if(n333[c]==1)	s.append(n3[c]+n33[c]);
							else	s.append(n3[c]+"'"+n33[c]+"/"+n333[c]);
						}
						if(temp == 1)	
							switch(Fuhao2[c]) {			//answer*下一个数
								case '+':answerZi = n333[c]*n3[c]*answerMu+n33[c]*answerMu+n333[c]*answerZi;answerMu = n333[c]*answerMu;break;
								case '-':answerZi = n333[c]*answerZi-answerMu*n3[c]*n333[c]-n33[c]*answerMu;answerMu = n333[c]*answerMu;break;
								case '×':answerZi = n3[c]*n333[c]*answerZi+answerZi*n33[c];answerMu = n333[c]*answerMu;break;
								case '÷':answerZi = answerZi*n333[c];answerMu = n3[c]*n333[c]*answerMu+answerMu*n33[c];break;
						}else	
							switch(Fuhao2[c]) {			//下一个数*answer
								case '+':answerZi = n333[c]*n3[c]*answerMu+n33[c]*answerMu+n333[c]*answerZi;answerMu = n333[c]*answerMu;break;
								case '-':answerZi = n33[c]*answerMu-n333[c]*answerZi+answerMu*n3[c]*n333[c];answerMu = n333[c]*answerMu;break;
								case '×':answerZi = n3[c]*n333[c]*answerZi+answerZi*n33[c];answerMu = n333[c]*answerMu;break;
								case '÷':answerZi = n3[c]*n333[c]*answerMu+n33[c]*answerMu;answerMu = n333[c]*answerZi;break;
						}	
						/*
						 * 得到形如  a+b+c+d 的式子（第三步运算）
						 */
						if(fh.fuhao(0)==1) {	//随机生成1时执行此操作,往题目添加第四个数
							T[c] = 4;
							if((Fuhao3[c]=='-')&((answerZi/answerMu-(n4[c]+n44[c]/n444[c]))>0)) {
								temp = 1;	//temp = 1时后面添加
								if(fh.fuhao(0)==1)	s.insert(0, "(").append(") "+Fuhao3[c]+" ");
								else s.append(" "+Fuhao3[c]+" ");
								if((n44[c]==0))	s.append(n4[c]);
								else if(n444[c]==1)	s.append(n4[c]+n44[c]);
								else	s.append(n4[c]+"'"+n44[c]+"/"+n444[c]);
							}else if((Fuhao3[c]=='-')&((answerZi/answerMu-(n4[c]+n44[c]/n444[c]))<0)) {
								temp = 0;	//temp = 0时前面添加
								if((Fuhao2[c]=='+')|(Fuhao2[c]=='-'))	s.insert(0, " "+Fuhao3[c]+" (").append(')');
								else if(fh.fuhao(0)==1)	s.insert(0, " "+Fuhao3[c]+" (").append(')');
								else s.insert(0, " "+Fuhao3[c]+" ");
								if((n44[c]==0))	s.insert(0, n4[c]);
								else if(n444[c]==1)	s.insert(0,n4[c]+n44[c]);
								else	s.insert(0,n4[c]+"'"+n44[c]+"/"+n444[c]);
							}else if(fh.fuhao(0)==1) {	//前面添加第三个数和第二个符号 
								temp = 0;	//temp = 0时前面添加
								if((Fuhao2[c]=='+')|(Fuhao2[c]=='-')|(Fuhao3[c]=='×')|(Fuhao3[c]=='÷'))	s.insert(0, " "+Fuhao3[c]+" (").append(')');
								else if(fh.fuhao(0)==1)	s.insert(0, " "+Fuhao3[c]+" (").append(')');
								else s.insert(0, " "+Fuhao3[c]+" ");
								if((n44[c]==0))	s.insert(0, n4[c]); 
								else if(n444[c]==1)	s.insert(0,n4[c]+n44[c]);
								else	s.insert(0,n4[c]+"'"+n44[c]+"/"+n444[c]);
							}else {				//后面添加第三个数和第二个符号
								temp = 1;	//temp = 1时后面添加
								if(((Fuhao2[c]=='+')|(Fuhao2[c]=='-'))&((Fuhao3[c]=='×')|(Fuhao3[c]=='÷')))	s.insert(0, "(").append(") "+Fuhao3[c]+" ");
								else if(fh.fuhao(0)==1)	s.insert(0, "(").append(") "+Fuhao3[c]+" ");
								else s.append(" "+Fuhao3[c]+" ");
								if((n44[c]==0))	s.append(n4[c]);
								else if(n444[c]==1)	s.append(n4[c]+n44[c]);
								else	s.append(n4[c]+"'"+n44[c]+"/"+n444[c]);
							}
							if(temp == 1)	
								switch(Fuhao3[c]) {				//answer*下一个数
									case '+':answerZi = n444[c]*n4[c]*answerMu+n44[c]*answerMu+n444[c]*answerZi;answerMu = n444[c]*answerMu;break;
									case '-':answerZi = n444[c]*answerZi-answerMu*n4[c]*n444[c]-n44[c]*answerMu;answerMu = n444[c]*answerMu;break;
									case '×':answerZi = n4[c]*n444[c]*answerZi+answerZi*n44[c];answerMu = n444[c]*answerMu;break;
									case '÷':answerZi = answerZi*n444[c];answerMu = n4[c]*n444[c]*answerMu+answerMu*n44[c];break;
							}else	
								switch(Fuhao3[c]) {			//下一个数*answer
									case '+':answerZi = n444[c]*n4[c]*answerMu+n44[c]*answerMu+n444[c]*answerZi;answerMu = n444[c]*answerMu;break;
									case '-':answerZi = n44[c]*answerMu-n444[c]*answerZi+answerMu*n4[c]*n444[c];answerMu = n444[c]*answerMu;break;
									case '×':answerZi = n4[c]*n444[c]*answerZi+answerZi*n44[c];answerMu = n444[c]*answerMu;break;
									case '÷':answerZi = n4[c]*n444[c]*answerMu+n44[c]*answerMu;answerMu = n444[c]*answerZi;break;
								}
						}
					}	
		
					answerGong = gong(answerZi,answerMu);
					answerZi/=answerGong;answerMu/=answerGong;	//化简答案
					s.append(" "+'=');
					//System.out.print(s.toString()+"\n");
					/*
					 * 判断运算是否重复,重复则重新生成题目
					 */
					same = 0;
					for(d=0;d<c;d++) 
						if(T[d]>0)	//第一类
							if((Fuhao1[c]==Fuhao1[d])&(Fuhao2[c]==Fuhao2[d])&(Fuhao3[c]==Fuhao3[d])&(T[c]==T[d]))
								if((n1[c]==n1[d])&(n11[c]==n11[d])&(n111[c]==n111[d])&(n2[c]==n2[d])&(n22[c]==n22[d])&(n222[c]==n222[d])&(n3[c]==n3[d])&(n33[c]==n33[d])&(n333[c]==n333[d])&(n4[c]==n4[d])&(n44[c]==n44[d])&(n444[c]==n444[d]))
									{same = 1;break;}
							else if(Fuhao1[c]=='+'|Fuhao1[c]=='×')
								if((n1[c]==n2[d])&(n11[c]==n22[d])&(n111[c]==n222[d])&(n2[c]==n1[d])&(n22[c]==n11[d])&(n222[c]==n111[d])&(n3[c]==n3[d])&(n33[c]==n33[d])&(n333[c]==n333[d])&(n4[c]==n4[d])&(n44[c]==n44[d])&(n444[c]==n444[d]))
									{same = 1;break;}
								
							
					if(same == 1) {
						c--;s.delete(0,s.length());	//清空s	//System.out.print(c+"   "+d+"   "+s.toString()+"\n");s.delete(0,s.length());//清空s	
						
					}else {
						str[c] = s.toString();
						AnswerZi[c] = answerZi;AnswerMu[c] = answerMu;
						s.delete(0,s.length());	//清空s	
					}
				}
				
				/*
				 * 
				 * 第二类式子，例如 4*5+6*8
				 * 
				 */
				else {
					if(fh.fuhao(0)==1)	Fuhao1[c] = '+';else	Fuhao1[c] = '-';
					if(fh.fuhao(0)==1)	Fuhao2[c] = '×';else	Fuhao2[c] = '÷';
					if(fh.fuhao(0)==1)	Fuhao3[c] = '×';else	Fuhao3[c] = '÷';
					switch(Fuhao2[c]) {
					case '×':answerZi = n1[c]*n111[c]*n2[c]*n222[c]+n1[c]*n111[c]*n22[c]+n11[c]*n2[c]*n222[c]+n11[c]*n22[c];answerMu = n111[c]*n222[c];break;
					case '÷':if((n2[c]+n22[c]/n222[c])==1)	n222[c]*=opn.number(nature,1);	answerZi = n1[c]*n111[c]*n222[c]+n11[c]*n222[c];answerMu = n2[c]*n111[c]*n222[c]+n22[c]*n111[c];break;
					}
					switch(Fuhao3[c]) {
					case '×':Zi = n3[c]*n333[c]*n4[c]*n444[c]+n3[c]*n333[c]*n44[c]+n33[c]*n4[c]*n444[c]+n33[c]*n44[c];Mu = n333[c]*n444[c];break;
					case '÷':if((n4[c]+n44[c]/n444[c])==1)	n444[c]*=opn.number(nature,1);	Zi = n3[c]*n333[c]*n444[c]+n33[c]*n444[c];Mu = n4[c]*n333[c]*n444[c]+n44[c]*n333[c];break;
					}
					if(Fuhao1[c]=='+')	{answerZi = answerZi*Mu+answerMu*Zi;answerMu = answerMu*Mu;}
					else	{answerZi = answerZi*Mu-answerMu*Zi;answerMu = answerMu*Mu;}
					answerGong = gong(answerZi,answerMu);
					
					if((n11[c]==0))	s.append(n1[c]+" "+Fuhao2[c]+" ");
					else if(n111[c]==1)	s.append(n1[c]+n11[c]+" "+Fuhao2[c]+" ");
					else	s.append(n1[c]+"'"+n11[c]+"/"+n111[c]+" "+Fuhao2[c]+" ");
					if((n22[c]==0))	s.append(n2[c]+" "+Fuhao1[c]+" ");
					else if(n222[c]==1)	s.append(n2[c]+n22[c]+" "+Fuhao1[c]+" ");
					else	s.append(n2[c]+"'"+n22[c]+"/"+n222[c]+" "+Fuhao1[c]+" ");
					if((n33[c]==0))	s.append(n3[c]+" "+Fuhao3[c]+" ");
					else if(n333[c]==1)	s.append(n3[c]+n33[c]+" "+Fuhao3[c]+" ");
					else	s.append(n3[c]+"'"+n33[c]+"/"+n333[c]+" "+Fuhao3[c]+" ");
					if((n44[c]==0))	s.append(n4[c]+" = ");
					else if(n444[c]==1)	s.append(n4[c]+n44[c]+" = ");
					else	s.append(n4[c]+"'"+n44[c]+"/"+n444[c]+" = ");

					/*
					 * 判断运算是否重复,重复则重新生成题目
					 */
					same = 0;
					for(d=0;d<c;d++) {
						if(T[d]==1)
							if((Fuhao1[c]==Fuhao1[d])&(Fuhao2[c]==Fuhao2[d])&(Fuhao3[c]==Fuhao3[d])) 
									if((n1[c]==n1[d])&(n11[c]==n11[d])&(n111[c]==n111[d])&(n2[c]==n2[d])&(n22[c]==n22[d])&(n222[c]==n222[d])
											&(n3[c]==n3[d])&(n33[c]==n33[d])&(n333[c]==n333[d])&(n4[c]==n4[d])&(n44[c]==n44[d])&(n444[c]==n444[d]))
									{same = 1;break;}	
									else if(Fuhao2[c]=='×'&(n1[c]==n2[d])&(n11[c]==n22[d])&(n111[c]==n222[d])&(n2[c]==n1[d])&(n22[c]==n11[d])&(n222[c]==n111[d])
											&(n3[c]==n3[d])&(n33[c]==n33[d])&(n333[c]==n333[d])&(n4[c]==n4[d])&(n44[c]==n44[d])&(n444[c]==n444[d]))
									{same = 1;break;}
									else if(Fuhao3[c]=='×'&(n1[c]==n1[d])&(n11[c]==n11[d])&(n111[c]==n111[d])&(n2[c]==n2[d])&(n22[c]==n22[d])&(n222[c]==n222[d])
											&(n3[c]==n4[d])&(n33[c]==n44[d])&(n333[c]==n444[d])&(n4[c]==n3[d])&(n44[c]==n33[d])&(n444[c]==n333[d]))
									{same = 1;break;}
									else if(Fuhao2[c]=='×'&Fuhao3[c]=='×'&(n1[c]==n2[d])&(n11[c]==n22[d])&(n111[c]==n222[d])&(n2[c]==n1[d])&(n22[c]==n11[d])&(n222[c]==n111[d])
											&(n3[c]==n4[d])&(n33[c]==n44[d])&(n333[c]==n444[d])&(n4[c]==n3[d])&(n44[c]==n33[d])&(n444[c]==n333[d]))
									{same = 1;break;}				
					}
					if((same == 1)|(answerZi<0)) {
						c--;s.delete(0,s.length());	//清空s	//System.out.print(c+"   "+d+"   "+s.toString()+"\n");s.delete(0,s.length());	//清空s	
					}else {
						str[c] = s.toString();
						AnswerZi[c] = answerZi/gong(answerZi,answerMu);AnswerMu[c] = answerMu/gong(answerZi,answerMu);
						s.delete(0,s.length());	//清空s	
					}
				}
			}
			for(c=0;c<Qnumber;c++) {
				System.out.print(str[c]+" "+AnswerZi[c]+"/"+AnswerMu[c]+"\n");
			}
			try {
				FileWriter fw = new FileWriter(fex);
				for(c=0;c<Qnumber;c++) fw.write(c+1+"."+str[c]+"\n");	//保存题目到txt
					fw.close();
			}catch(IOException e) {
				e.printStackTrace();
				return false;
			}
			try {
				FileWriter fw = new FileWriter(fan);
				for(c=0;c<Qnumber;c++)	//分母为1时不是分数，直接返回分子
					if(AnswerMu[c]==1)	fw.write(c+1+"."+AnswerZi[c]+"\n");	//保存答案到txt
					else fw.write(c+1+"."+AnswerZi[c]+"/"+AnswerMu[c]+"\n");
				fw.close();
			}catch(IOException e) {
				e.printStackTrace(); 
				return false;
			}
		
	
			return true;
}

}
