package Chapter8_ChaZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 此程序的功能为输入一个组数，把数组转化为整形的数组，然后用二分法判断给定的数值在不在数组中，
 * 二分法查找的基本原理就是先把数组排序，然后把要查找的元素和数组中间的元素比较，依次循环
 * 如果在数组中则返回在数组中的位置时间复杂度为O(logn)
 */
public class Chapter8_BinarySearch {
   int arr[]=null;
   public int[] input(){//定义一个输入方法，把输入的元素转化为整形数组
	   BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		try {
			String s=br.readLine();
			
			String st[]=s.split(" ");
			arr=new int [st.length];
			for(int i=0;i<st.length;i++){
				arr[i]=Integer.parseInt(st[i]);
			}
			
			Arrays.sort(arr);//必须先把数组排序才能比较
			System.out.println(Arrays.toString(arr));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
   }
   
	public boolean test(int key){
	  
	   int low=0;
	   int high=arr.length-1;
	   int mid;
	   while(low<=high){
	    mid=(low+high)/2;
	   if(key<arr[mid]){
		   high=mid-1;
	   }
	   else if(key>arr[mid]){
		   low=mid+1;
	   }
	   else{
		   System.out.println(mid);
		   return true;//必须要有这个语句，否则会在相等的地方死循环下去
	   }
	   }
	return false;
   }
	public static void main(String[] args){
		Chapter8_BinarySearch ch=new Chapter8_BinarySearch();
		ch.input();
		System.out.println(ch.test(32));
	
	}
}
