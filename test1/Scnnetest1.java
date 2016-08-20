package test1;

import java.util.Scanner;

/**
 * Created by wang on 2016/5/8.
 * 此程序是用来自己练习用，和Scnnertest功能一样
 */
public class Scnnetest1 {
    public void test(){
        int a[]=new int[10];
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一组数组");
        String s=sc.nextLine();
        String [] ss=s.split("\\s+");
        for(int i=0;i<a.length;i++){
            a[i]=Integer.parseInt(ss[i]);
        }
        for(int j=0;j<a.length;j++){
            System.out.print(a[j]+" ");
        }
    }
    public static void main(String[]args){
        new Scnnetest1().test();
    }
}
