package Chapter5_Chuan;

import java.util.Arrays;
/*
 * 这个程序演示了课本92页上说道的堆内存和栈内训的区别
 */
public class ArrayINRam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int []a={1,3,4};
   int []b=new int[4];
   System.out.println(a.length);
   System.out.println(b.length);
   b=a;
   System.out.println(a.length);
   System.out.println(b.length);
   System.out.println(Arrays.toString(a));
   System.out.println(Arrays.toString(b));
	}

}
