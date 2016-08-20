package Chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class ArrayTest {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    System.out.println("请输入数字：");
         int arr[];
		  String s;
		try {
			s = br.readLine();
			String []st=s.split(" ");
			arr=new int[st.length];
			 for(int i=0;i<st.length;i++){
				 arr[i]=Integer.parseInt(st[i]);
				 
			 }
			 Arrays.sort(arr);
			 System.out.println( Arrays.binarySearch(arr, 54));
			
			 for(int aa:arr){
			 System.out.print(aa+"  ");
			 }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    
	}

}
