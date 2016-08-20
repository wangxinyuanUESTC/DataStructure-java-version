package Chapter9_PaiXu;

import java.util.Arrays;

public class Chapter9_XiErPaiXU {
		/*
		 * @them 希尔排序
		 * 是对插入排序的改进，先将整个分成若干个，再在若干个里分别进行插入排序，然后再整体进行一次插入排序。
		 * 时间复杂度：O（NlogN）~O（N*N）
		 */
	 
    public void test(int arr[]){
    
    	for(int gap=arr.length/2;gap>0;gap/=2)//每次分组数
    	{
    		for(int i=0;i<gap;i++){
    			//每个分组中用插入排序
    			for(int j=gap+i;j<arr.length;j+=gap){
    			if(arr[j]<arr[j-gap])//如果每个分组中的后一个小雨前一个则前一个后移，如果还是比更前一个小还后移
    			{
    				//后面代码可以更简化  用直接交换相邻元素就可以 插入排序思想
    				int temp1=arr[j];//如果后一个大 则把后一个先存起来
    				int k=j-gap;
    				
    				while(k>=0&&arr[k]>temp1)
    				{
    					arr[k+gap]=arr[k];//依次后移
    					k-=gap;
    				}
    				arr[k+gap]=temp1;//把后面的放到前面的空位置
    				
    			}
    			
    		}
    		
    		}
    		
    	}
    	System.out.println(Arrays.toString(arr));		
    }
	public static void main(String []args){
		int array[]={1,4,2,7,3,12,44,21,55,32,11};	
	   
		new Chapter9_XiErPaiXU().test(array);
	}
	
	
	
	
	
	
	
	
	
	
	
	
		/*
		public int[] shellSort(int[] theArray)   
	    {   
	        int inner=0,outer=0;
	        int nElems=theArray.length;
	        long temp=0;   
	        int h=1;                    //find initial value of h   
	        while(h<=nElems/3)          //1,4,13,40,121,...   
	            h=h*3+1;   				
	        
	        while(h>0)   
	        {   
	        	//当间隔h>1时，进行小部分插入排序；当间隔h=1时，进行整体插入排序
	        for(outer=h;outer<nElems;outer++)   
	            {   
	                temp=theArray[outer];   
	                inner=outer;       
	              while(inner>h-1&&theArray[inner-h]>=temp)   
	                {   
	                theArray[inner]=theArray[inner-h];   
	                inner-=h;   
	                }   
	            theArray[inner]=(int) temp;   
	             }   
	            h=(h-1)/3;  // 间隔从大减小，一直减小到1，此时因为间隔为1，就相当于是做整体的插入排序
	         }
	        
			return theArray;   
	     }   
	       
	  

		public static void main(String[] args) {
			int[] a={1,4,2,7,3,12,44,21,55,32,11};
			Chapter9_XiErPaiXU g=new Chapter9_XiErPaiXU();
			a=g.shellSort(a);
			System.out.println(Arrays.toString(a));
			
		}
*/
	}

