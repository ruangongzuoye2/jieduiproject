package unity;

import java.io.File;

public class information {
	 static int num_timu;//生成题目数
	 static  int fenmu_max;//分母最大值
	 static  int nature;//式子中自然数最大值
	 
	 static String problem;//题目文件
	 static String answer;//答案文件
	 static String reply;//
	 static String file_s;//检验答案结果保存的文件
	
	public static int getNum_timu() {
		return num_timu;
	}
	public static String getProblem() {
		return problem;
	}
	public static void setProblem(String problem) {
		information.problem = problem;
	}
	public static String getAnswer() {
		return answer;
	}
	public static void setAnswer(String answer) {
		information.answer = answer;
	}
	public static void setNum_timu(int num_timu) {
		information.num_timu = num_timu;
	}
	public static int getFenmu_max() {
		return fenmu_max;
	}
	public static void setFenmu_max(int fenmu_max) {
		information.fenmu_max = fenmu_max;
	}
	public static int getNature() {
		return nature;
	}
	public static void setNature(int nature) {
		information.nature = nature;
	}
	public static String getFile_s() {
		return file_s;
	}
	public static void setFile_s(String file_s) {
		information.file_s = file_s;
	}
	public static String getReply() {
		return reply;
	}
	public static void setReply(String reply) {
		information.reply = reply;
	}
	
	
	
}
