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
		public static int gong(int m,int n) {	//���ط��Ӻͷ�ĸ�Ĺ�����,m�Ƿ���,n�Ƿ�ĸ
			int gongyinshu = 1,small = m;
			for(int i=1;i<=small;i++) {if((m%i==0)&(n%i==0)) gongyinshu = i;}
			return gongyinshu;
		}

		public boolean getQuestion() {
			File fex = new File(information.getProblem());
			File fan = new File(information.getAnswer());
			int Qnumber = information.getNum_timu();
			int i,c,d;	//Qnumberָ������Ŀ����,i,c,d�Ǽ�����
			int N1,N2,N3,N4;	//�ĸ����Ĺ�����		
			int same = 0;	//��־��Ŀ�Ƿ��ظ�
			int nature = information.getNature(),fenmu = information.getFenmu_max();	//��Ȼ�����������ĸ����������
			int answerZi=0,answerMu=0,answerGong=1,temp;	//�ֲ��õ��Ĵ𰸵ķ��ӷ�ĸ,temp�Ǳ��ǰ����ӵ�,answerGong����������𰸵�
			int Zi=0,Mu=0;	//��������a*b+c*d����������
			char [] Fuhao1 =new char[Qnumber]; 	//ÿ����Ŀ�����������
			char [] Fuhao2 =new char[Qnumber]; 
			char [] Fuhao3 =new char[Qnumber]; 	
			int [] n1 = new int[Qnumber];	//n1,n11,n111���α�ʾ��һ����������,����,��ĸ
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
			int [] AnswerZi = new int[Qnumber];	//������մ𰸵ķ���
			int [] AnswerMu = new int[Qnumber];	//������մ𰸵ķ�ĸ
			int [] T = new int [Qnumber];	//ֵΪ0ʱ�ǵڶ�����Ŀ����Ϊ0ʱ��ʾ��һ����Ŀ����������
			for(c=0;c<Qnumber;c++) {	
				T[c] = 0;
				n11[c]=0;n111[c]=1;		
				n22[c]=0;n222[c]=1;
				n33[c]=0;n333[c]=1;
				n44[c]=0;n444[c]=1;}			//��ʼ�����ӷ�ĸ
			
			StringBuilder s = new StringBuilder();
			String [] str = new String[Qnumber];	//�����Ŀ���󱣴浽�ĵ�
		
			for(c=0;c<Qnumber;c++) {
				
				/*	
				 * ����ĸ�������������漴�����
				 */
				if(fh.fuhao(0)==1) {									//��������1
					n1[c] =opn.number(nature,0);n111[c] = opn.number(fenmu,1);n11[c] = opn.number(n111[c],0);
					N1 = gong(n11[c],n111[c]);
					n11[c]/=N1;n111[c]/=N1;			
				}else	n1[c] = opn.number(nature,0);
				if(fh.fuhao(0)==1) {									//��������2
					n2[c] = opn.number(nature,0);n222[c] = opn.number(fenmu,1);n22[c] = opn.number(n222[c],0);
					N2 = gong(n22[c],n222[c]);
					n22[c]/=N2;n22[c]/=N2;
				}else	n2[c] = opn.number(nature,0);	
				if(fh.fuhao(0)==1) {									//��������3
					n3[c] = opn.number(nature,0);n333[c] = opn.number(fenmu,1);n33[c] = opn.number(n333[c],0);
					N3 = gong(n33[c],n333[c]);
					n33[c]/=N3;n333[c]/=N3;
				}else	n3[c] = opn.number(nature,0);
				if(fh.fuhao(0)==1) {									//��������4
					n4[c] = opn.number(nature,0);n444[c] = opn.number(fenmu,1);n44[c] = opn.number(n444[c],0);
					N4 = gong(n44[c],n444[c]);
					n44[c]/=N4;n444[c]/=N4;
				}else	n4[c] = opn.number(nature,0);		
				
				/*
				 * 
				 * ��һ��ʽ��,���� (2*4-6)*3
				 * 
				 */
				if(fh.fuhao(0)==1) {
					Fuhao1[c] = fh.fuhao(1);Fuhao2[c] = fh.fuhao(1);Fuhao3[c] = fh.fuhao(1);
					/*
					 * �õ�����  a+b  ��ʽ�ӣ���һ�����㣩
					 */
					T[c] = 2;		
					if(Fuhao1[c]=='-'&((n1[c]+n11[c]/n111[c])<(n2[c]+n22[c]/n222[c])))	{i=n1[c];n1[c]=n2[c];n2[c]=i;i=n11[c];n11[c]=n22[c];n22[c]=i;i=n111[c];n111[c]=n222[c];n222[c]=i;}
					switch(Fuhao1[c]) {
					case '+':answerZi = n1[c]*n111[c]*n222[c]+n11[c]*n222[c]+n2[c]*n111[c]*n222[c]+n111[c]*n22[c];answerMu = n111[c]*n222[c];break;
					case '-':answerZi = n1[c]*n111[c]*n222[c]+n11[c]*n222[c]-n2[c]*n111[c]*n222[c]-n111[c]*n22[c];answerMu = n111[c]*n222[c];break;
					case '��':answerZi = n1[c]*n111[c]*n2[c]*n222[c]+n1[c]*n111[c]*n22[c]+n11[c]*n2[c]*n222[c]+n11[c]*n22[c];answerMu = n111[c]*n222[c];break;
					case '��':answerZi = n1[c]*n111[c]*n222[c]+n11[c]*n222[c];answerMu = n2[c]*n111[c]*n222[c]+n22[c]*n111[c];break;
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
					 * �õ�����  a+b+c  ��ʽ�ӣ��ڶ������㣩
					 */
					if(fh.fuhao(0)==1) {	//�������1ʱִ�д˲���,����Ŀ��ӵ�������
						T[c] = 3;
						if((Fuhao2[c]=='-')&((answerZi/answerMu-(n3[c]+n33[c]/n333[c]))>0)) {
							temp = 1;	//temp = 1ʱ�������
							if(fh.fuhao(0)==1)	s.insert(0, "(").append(") "+Fuhao2[c]+" ");
							else s.append(" "+Fuhao2[c]+" ");
							if((n33[c]==0))	s.append(n3[c]);
							else if(n333[c]==1)	s.append(n3[c]+n33[c]);
							else	s.append(n3[c]+"'"+n33[c]+"/"+n333[c]);
						}else if((Fuhao2[c]=='-')&((answerZi/answerMu-(n3[c]+n33[c]/n333[c]))<0)) {
							temp = 0;	//temp = 0ʱǰ�����
							if((Fuhao1[c]=='+')|(Fuhao1[c]=='-'))	s.insert(0, " "+Fuhao2[c]+" (").append(')');
							else if(fh.fuhao(0)==1)	s.insert(0, " "+Fuhao2[c]+" (").append(')');
							else s.insert(0, " "+Fuhao2[c]+" ");
							if((n33[c]==0))	s.insert(0, n3[c]);
							else if(n333[c]==1)	s.insert(0,n3[c]+n33[c]);
							else	s.insert(0,n3[c]+"'"+n33[c]+"/"+n333[c]);
						}else if(fh.fuhao(0)==1) {	//ǰ����ӵ��������͵ڶ������� 
							temp = 0;	//temp = 0ʱǰ�����
							if((Fuhao1[c]=='+')|(Fuhao1[c]=='-')|(Fuhao2[c]=='��')|(Fuhao2[c]=='��'))	s.insert(0, " "+Fuhao2[c]+" (").append(')');
							else if(fh.fuhao(0)==1)	s.insert(0, " "+Fuhao2[c]+" (").append(')');
							else s.insert(0, " "+Fuhao2[c]+" ");
							if((n33[c]==0))	s.insert(0, n3[c]); 
							else if(n333[c]==1)	s.insert(0,n3[c]+n33[c]);
							else	s.insert(0,n3[c]+"'"+n33[c]+"/"+n333[c]);
						}else {				//������ӵ��������͵ڶ�������
							temp = 1;	//temp = 1ʱ�������
							if(((Fuhao1[c]=='+')|(Fuhao1[c]=='-'))&((Fuhao2[c]=='��')|(Fuhao2[c]=='��')))	s.insert(0, "(").append(") "+Fuhao2[c]+" ");
							else if(fh.fuhao(0)==1)	s.insert(0, "(").append(") "+Fuhao2[c]+" ");
							else s.append(" "+Fuhao2[c]+" ");
							if((n33[c]==0))	s.append(n3[c]);
							else if(n333[c]==1)	s.append(n3[c]+n33[c]);
							else	s.append(n3[c]+"'"+n33[c]+"/"+n333[c]);
						}
						if(temp == 1)	
							switch(Fuhao2[c]) {			//answer*��һ����
								case '+':answerZi = n333[c]*n3[c]*answerMu+n33[c]*answerMu+n333[c]*answerZi;answerMu = n333[c]*answerMu;break;
								case '-':answerZi = n333[c]*answerZi-answerMu*n3[c]*n333[c]-n33[c]*answerMu;answerMu = n333[c]*answerMu;break;
								case '��':answerZi = n3[c]*n333[c]*answerZi+answerZi*n33[c];answerMu = n333[c]*answerMu;break;
								case '��':answerZi = answerZi*n333[c];answerMu = n3[c]*n333[c]*answerMu+answerMu*n33[c];break;
						}else	
							switch(Fuhao2[c]) {			//��һ����*answer
								case '+':answerZi = n333[c]*n3[c]*answerMu+n33[c]*answerMu+n333[c]*answerZi;answerMu = n333[c]*answerMu;break;
								case '-':answerZi = n33[c]*answerMu-n333[c]*answerZi+answerMu*n3[c]*n333[c];answerMu = n333[c]*answerMu;break;
								case '��':answerZi = n3[c]*n333[c]*answerZi+answerZi*n33[c];answerMu = n333[c]*answerMu;break;
								case '��':answerZi = n3[c]*n333[c]*answerMu+n33[c]*answerMu;answerMu = n333[c]*answerZi;break;
						}	
						/*
						 * �õ�����  a+b+c+d ��ʽ�ӣ����������㣩
						 */
						if(fh.fuhao(0)==1) {	//�������1ʱִ�д˲���,����Ŀ��ӵ��ĸ���
							T[c] = 4;
							if((Fuhao3[c]=='-')&((answerZi/answerMu-(n4[c]+n44[c]/n444[c]))>0)) {
								temp = 1;	//temp = 1ʱ�������
								if(fh.fuhao(0)==1)	s.insert(0, "(").append(") "+Fuhao3[c]+" ");
								else s.append(" "+Fuhao3[c]+" ");
								if((n44[c]==0))	s.append(n4[c]);
								else if(n444[c]==1)	s.append(n4[c]+n44[c]);
								else	s.append(n4[c]+"'"+n44[c]+"/"+n444[c]);
							}else if((Fuhao3[c]=='-')&((answerZi/answerMu-(n4[c]+n44[c]/n444[c]))<0)) {
								temp = 0;	//temp = 0ʱǰ�����
								if((Fuhao2[c]=='+')|(Fuhao2[c]=='-'))	s.insert(0, " "+Fuhao3[c]+" (").append(')');
								else if(fh.fuhao(0)==1)	s.insert(0, " "+Fuhao3[c]+" (").append(')');
								else s.insert(0, " "+Fuhao3[c]+" ");
								if((n44[c]==0))	s.insert(0, n4[c]);
								else if(n444[c]==1)	s.insert(0,n4[c]+n44[c]);
								else	s.insert(0,n4[c]+"'"+n44[c]+"/"+n444[c]);
							}else if(fh.fuhao(0)==1) {	//ǰ����ӵ��������͵ڶ������� 
								temp = 0;	//temp = 0ʱǰ�����
								if((Fuhao2[c]=='+')|(Fuhao2[c]=='-')|(Fuhao3[c]=='��')|(Fuhao3[c]=='��'))	s.insert(0, " "+Fuhao3[c]+" (").append(')');
								else if(fh.fuhao(0)==1)	s.insert(0, " "+Fuhao3[c]+" (").append(')');
								else s.insert(0, " "+Fuhao3[c]+" ");
								if((n44[c]==0))	s.insert(0, n4[c]); 
								else if(n444[c]==1)	s.insert(0,n4[c]+n44[c]);
								else	s.insert(0,n4[c]+"'"+n44[c]+"/"+n444[c]);
							}else {				//������ӵ��������͵ڶ�������
								temp = 1;	//temp = 1ʱ�������
								if(((Fuhao2[c]=='+')|(Fuhao2[c]=='-'))&((Fuhao3[c]=='��')|(Fuhao3[c]=='��')))	s.insert(0, "(").append(") "+Fuhao3[c]+" ");
								else if(fh.fuhao(0)==1)	s.insert(0, "(").append(") "+Fuhao3[c]+" ");
								else s.append(" "+Fuhao3[c]+" ");
								if((n44[c]==0))	s.append(n4[c]);
								else if(n444[c]==1)	s.append(n4[c]+n44[c]);
								else	s.append(n4[c]+"'"+n44[c]+"/"+n444[c]);
							}
							if(temp == 1)	
								switch(Fuhao3[c]) {				//answer*��һ����
									case '+':answerZi = n444[c]*n4[c]*answerMu+n44[c]*answerMu+n444[c]*answerZi;answerMu = n444[c]*answerMu;break;
									case '-':answerZi = n444[c]*answerZi-answerMu*n4[c]*n444[c]-n44[c]*answerMu;answerMu = n444[c]*answerMu;break;
									case '��':answerZi = n4[c]*n444[c]*answerZi+answerZi*n44[c];answerMu = n444[c]*answerMu;break;
									case '��':answerZi = answerZi*n444[c];answerMu = n4[c]*n444[c]*answerMu+answerMu*n44[c];break;
							}else	
								switch(Fuhao3[c]) {			//��һ����*answer
									case '+':answerZi = n444[c]*n4[c]*answerMu+n44[c]*answerMu+n444[c]*answerZi;answerMu = n444[c]*answerMu;break;
									case '-':answerZi = n44[c]*answerMu-n444[c]*answerZi+answerMu*n4[c]*n444[c];answerMu = n444[c]*answerMu;break;
									case '��':answerZi = n4[c]*n444[c]*answerZi+answerZi*n44[c];answerMu = n444[c]*answerMu;break;
									case '��':answerZi = n4[c]*n444[c]*answerMu+n44[c]*answerMu;answerMu = n444[c]*answerZi;break;
								}
						}
					}	
		
					answerGong = gong(answerZi,answerMu);
					answerZi/=answerGong;answerMu/=answerGong;	//�����
					s.append(" "+'=');
					//System.out.print(s.toString()+"\n");
					/*
					 * �ж������Ƿ��ظ�,�ظ�������������Ŀ
					 */
					same = 0;
					for(d=0;d<c;d++) 
						if(T[d]>0)	//��һ��
							if((Fuhao1[c]==Fuhao1[d])&(Fuhao2[c]==Fuhao2[d])&(Fuhao3[c]==Fuhao3[d])&(T[c]==T[d]))
								if((n1[c]==n1[d])&(n11[c]==n11[d])&(n111[c]==n111[d])&(n2[c]==n2[d])&(n22[c]==n22[d])&(n222[c]==n222[d])&(n3[c]==n3[d])&(n33[c]==n33[d])&(n333[c]==n333[d])&(n4[c]==n4[d])&(n44[c]==n44[d])&(n444[c]==n444[d]))
									{same = 1;break;}
							else if(Fuhao1[c]=='+'|Fuhao1[c]=='��')
								if((n1[c]==n2[d])&(n11[c]==n22[d])&(n111[c]==n222[d])&(n2[c]==n1[d])&(n22[c]==n11[d])&(n222[c]==n111[d])&(n3[c]==n3[d])&(n33[c]==n33[d])&(n333[c]==n333[d])&(n4[c]==n4[d])&(n44[c]==n44[d])&(n444[c]==n444[d]))
									{same = 1;break;}
								
							
					if(same == 1) {
						c--;s.delete(0,s.length());	//���s	//System.out.print(c+"   "+d+"   "+s.toString()+"\n");s.delete(0,s.length());//���s	
						
					}else {
						str[c] = s.toString();
						AnswerZi[c] = answerZi;AnswerMu[c] = answerMu;
						s.delete(0,s.length());	//���s	
					}
				}
				
				/*
				 * 
				 * �ڶ���ʽ�ӣ����� 4*5+6*8
				 * 
				 */
				else {
					if(fh.fuhao(0)==1)	Fuhao1[c] = '+';else	Fuhao1[c] = '-';
					if(fh.fuhao(0)==1)	Fuhao2[c] = '��';else	Fuhao2[c] = '��';
					if(fh.fuhao(0)==1)	Fuhao3[c] = '��';else	Fuhao3[c] = '��';
					switch(Fuhao2[c]) {
					case '��':answerZi = n1[c]*n111[c]*n2[c]*n222[c]+n1[c]*n111[c]*n22[c]+n11[c]*n2[c]*n222[c]+n11[c]*n22[c];answerMu = n111[c]*n222[c];break;
					case '��':if((n2[c]+n22[c]/n222[c])==1)	n222[c]*=opn.number(nature,1);	answerZi = n1[c]*n111[c]*n222[c]+n11[c]*n222[c];answerMu = n2[c]*n111[c]*n222[c]+n22[c]*n111[c];break;
					}
					switch(Fuhao3[c]) {
					case '��':Zi = n3[c]*n333[c]*n4[c]*n444[c]+n3[c]*n333[c]*n44[c]+n33[c]*n4[c]*n444[c]+n33[c]*n44[c];Mu = n333[c]*n444[c];break;
					case '��':if((n4[c]+n44[c]/n444[c])==1)	n444[c]*=opn.number(nature,1);	Zi = n3[c]*n333[c]*n444[c]+n33[c]*n444[c];Mu = n4[c]*n333[c]*n444[c]+n44[c]*n333[c];break;
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
					 * �ж������Ƿ��ظ�,�ظ�������������Ŀ
					 */
					same = 0;
					for(d=0;d<c;d++) {
						if(T[d]==1)
							if((Fuhao1[c]==Fuhao1[d])&(Fuhao2[c]==Fuhao2[d])&(Fuhao3[c]==Fuhao3[d])) 
									if((n1[c]==n1[d])&(n11[c]==n11[d])&(n111[c]==n111[d])&(n2[c]==n2[d])&(n22[c]==n22[d])&(n222[c]==n222[d])
											&(n3[c]==n3[d])&(n33[c]==n33[d])&(n333[c]==n333[d])&(n4[c]==n4[d])&(n44[c]==n44[d])&(n444[c]==n444[d]))
									{same = 1;break;}	
									else if(Fuhao2[c]=='��'&(n1[c]==n2[d])&(n11[c]==n22[d])&(n111[c]==n222[d])&(n2[c]==n1[d])&(n22[c]==n11[d])&(n222[c]==n111[d])
											&(n3[c]==n3[d])&(n33[c]==n33[d])&(n333[c]==n333[d])&(n4[c]==n4[d])&(n44[c]==n44[d])&(n444[c]==n444[d]))
									{same = 1;break;}
									else if(Fuhao3[c]=='��'&(n1[c]==n1[d])&(n11[c]==n11[d])&(n111[c]==n111[d])&(n2[c]==n2[d])&(n22[c]==n22[d])&(n222[c]==n222[d])
											&(n3[c]==n4[d])&(n33[c]==n44[d])&(n333[c]==n444[d])&(n4[c]==n3[d])&(n44[c]==n33[d])&(n444[c]==n333[d]))
									{same = 1;break;}
									else if(Fuhao2[c]=='��'&Fuhao3[c]=='��'&(n1[c]==n2[d])&(n11[c]==n22[d])&(n111[c]==n222[d])&(n2[c]==n1[d])&(n22[c]==n11[d])&(n222[c]==n111[d])
											&(n3[c]==n4[d])&(n33[c]==n44[d])&(n333[c]==n444[d])&(n4[c]==n3[d])&(n44[c]==n33[d])&(n444[c]==n333[d]))
									{same = 1;break;}				
					}
					if((same == 1)|(answerZi<0)) {
						c--;s.delete(0,s.length());	//���s	//System.out.print(c+"   "+d+"   "+s.toString()+"\n");s.delete(0,s.length());	//���s	
					}else {
						str[c] = s.toString();
						AnswerZi[c] = answerZi/gong(answerZi,answerMu);AnswerMu[c] = answerMu/gong(answerZi,answerMu);
						s.delete(0,s.length());	//���s	
					}
				}
			}
			for(c=0;c<Qnumber;c++) {
				System.out.print(str[c]+" "+AnswerZi[c]+"/"+AnswerMu[c]+"\n");
			}
			try {
				FileWriter fw = new FileWriter(fex);
				for(c=0;c<Qnumber;c++) fw.write(c+1+"."+str[c]+"\n");	//������Ŀ��txt
					fw.close();
			}catch(IOException e) {
				e.printStackTrace();
				return false;
			}
			try {
				FileWriter fw = new FileWriter(fan);
				for(c=0;c<Qnumber;c++)	//��ĸΪ1ʱ���Ƿ�����ֱ�ӷ��ط���
					if(AnswerMu[c]==1)	fw.write(c+1+"."+AnswerZi[c]+"\n");	//����𰸵�txt
					else fw.write(c+1+"."+AnswerZi[c]+"/"+AnswerMu[c]+"\n");
				fw.close();
			}catch(IOException e) {
				e.printStackTrace(); 
				return false;
			}
		
	
			return true;
}

}
