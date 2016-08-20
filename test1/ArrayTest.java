package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 词程序是把字符串中的大写字符按原顺序放到最后
 */


public class ArrayTest {
	int m=0;//m的作用为当遇到一个大写字母时把大写字母放到最后，m增加一，
	//然后循环的时候不在循环到数组后面的大写，防止把后面的大写字母又重新排列
public void test( char cha[]){
	for(int j=0;j<cha.length-m;j++){
		
		if(cha[j]>='A'&&cha[j]<='Z'){
			m++;
			
			char temp=cha[j];//把大写先提取出来
			for(int k=j;k<cha.length-1;k++)//从提取出来的位置开始往前移位
			{
			cha[k]=cha[k+1];
			
			}
			cha[cha.length-1]= temp;//永远都是最后一个位置放大写的字母，以为以前放的大写字母前移了已经
			j--;//如果有大写的，当前移一位之后还要从前一位算起，防止两个大写字母相邻的情况
		}
	}
	for(int m = 0;m<cha.length;m++){
		System.out.print(cha[m]+"  ");//输出排序后的数组
	}
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] chr=null;
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    System.out.println("please inset words:");
    try {
		String s=br.readLine();//把输入的信息先赋值给一个字符串
	 chr=s.toCharArray();//把字符串转化为数组
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    new ArrayTest().test(chr);
    
    
    
	}

}
