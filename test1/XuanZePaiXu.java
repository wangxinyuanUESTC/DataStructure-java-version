package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @author wang
 * 实现选择排序：从第一个开始分别与其他相比较，若第一个不是最小则把最小的那个放到第一个位置，以此类推
 * 复杂度为O(n*n)但是比冒泡好点
 *
 */
public class XuanZePaiXu {
	int []arr;
	public void scan()  {
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   String s;
	try {
		s = br.readLine();
		String str[]=s.split(" ");
		arr=new int[str.length];
		   for(int i=0;i<s.length();i++){
				  arr[i]=Integer.parseInt(str[i]);
		   }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
	public void  test(){
		int minindex;
		for(int i=0;i<arr.length-1;i++){
			//外循环
			for(int j=i+1;j<arr.length;j++){
				//内循环
				minindex=i;
				if(arr[minindex]>arr[j]){
					minindex=j;
				}
				if(i!=minindex){
					int temp=arr[i];
					arr[i]=arr[minindex];
					arr[minindex]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XuanZePaiXu paixu=new XuanZePaiXu();
		System.out.println("请输入一组数");
		paixu.scan();
		paixu.test();
		
	}

}
