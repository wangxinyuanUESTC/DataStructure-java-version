package test1;

import java.util.Scanner;

/*
 * Created by wang on 2016/5/8.
 * 这种方法是输入一个存入一个 不能一次性输入 一次性输入需要用test2方法
 */
public class Scannertest {
   /* int array[]=null;
    public void test(){
        array=new int[10];
        System.out.println("请输入数字");
        for(int i=0;i<array.length;i++){
            Scanner sc=new Scanner(System.in);
            array[i]=sc.nextInt();

        }
        for(int j=0;j<array.length;j++){
            System.out.print(array[j]+" ");
        }
    }
    */
    /*
    这个功能可以实现键盘输入确定长度的一组数
     */
	public void StringInPut(){
		Scanner sc=new Scanner(System.in);//不能输入多行
		String s=sc.nextLine();
		System.out.println(s);
	}
    public  void test2(){
        int array2[]=new int[10];
        Scanner scn=new Scanner(System.in);
        System.out.println("输入一组10元素数字：");
        String s=scn.nextLine();//将输入的一组数给s
        String[] c=s.split("\\s+");//用空格将其分割成字符串数组
        for(int a=0;a<array2.length;a++){
            array2[a]=Integer.parseInt(c[a]);//将字符串数组转换成int型数组
        }
           for(int p=0;p<array2.length;p++){
            System.out.print(array2[p]+" ");//输出整个数组
        }
    }

    public static void main (String []args){
//    new Scannertest().test();
//        new Scannertest().test2();
        new Scannertest().StringInPut();
    }


}
