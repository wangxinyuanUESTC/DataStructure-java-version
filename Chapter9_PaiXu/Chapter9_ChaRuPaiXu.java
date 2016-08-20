package Chapter9_PaiXu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 插入排序，从后面开始和前面的比较，若小于前面的就后移 把后面的放前面
 */
public class Chapter9_ChaRuPaiXu {
	int  []array;
	public void inset(){

		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("请输入一个数组，以空格隔开:");
			
		   String s=bf.readLine();
			String[]str=s.split(" ");
			array=new int [str.length];
			for(int i=0;i<array.length;i++){
				array[i]=Integer.parseInt(str[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	}
	
	public void insetpaixu(){
		
		
		int j=1;
		while(j<array.length){
			if(array[j]>array[j-1])
			{j++;}
			else{
            int temp=array[j];//把此值缓存起来
            int k=j-1;
            while(k>=0&&array[k]>temp){
            	array[k+1]=array[k];//如果前面的大于后面 的 ，前面的后移
            	k--;
            }
            array[k+1]=temp;//把缓存的值数组前面的空位置
			}
		
		
		
		}
		
		
		System.out.println(Arrays.toString(array));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chapter9_ChaRuPaiXu cr=new Chapter9_ChaRuPaiXu();
		cr.inset();
		cr.insetpaixu();
	}

}
