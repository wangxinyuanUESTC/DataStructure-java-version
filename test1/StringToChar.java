package test1;


/*
 * Java中字符串和字符数组之间的相互转换
 * 
 * */

public class StringToChar {


	public static void main(String[] args){
		
		String str1 = "1234567";
		String str2="hello java";
		char c[] = str1.toCharArray();//将一个字符串变为字符数组toCharArray();
		char d[]=str2.toCharArray();
		int ii=Integer.parseInt(str1);
		System.out.println(ii);
		for (int i = 0; i<c.length;i++){
			
			System.out.print(c[i] + " ");
			System.out.print(d[i] + " ");
		}
		
		System.out.println("");
		
		String str3 = new String(c);//将全部的字符数组变为String字符串
		String str33 = new String(d);//将全部的字符数组变为String字符串
		String str4 = new String(c,0,3);//将部分的字符数组变为String ，从下表为0开始到下表为3结束；
		String str44 = new String(d,0,3);//将部分的字符数组变为String ，从下表为0开始到下表为3结束；
		
		System.out.println(str3);//输出字符串
		System.out.println(str33);//输出字符串
		System.out.println(str4);
		System.out.println(str44);
	}
}