package Chapter9_PaiXu;

import java.util.Arrays;

/*
 * »ùÊýÅÅÐò
 */
public class Chapter9_JiiShuPaiXu {
    public void radixsort(int a[]){
    	int b[]=new int[a.length];
    	for(int j=0;j<a.length;j++){
    		b[j]%=10;
    	}
    	
    	for(int i=1;i<3;i++){
    		
    		int []c=Chapter9_JiShuPaiXu.JiShusort(a);
    	}
    	
    }
    public static int[] RadixSort(int[] a, int d)
    {
        //low to high digit
        for (int k = 1; k <= d; k++)
        {
            //temp array to store the sort result inside digit
            int[] tmpArray = new int[a.length];
     
            //temp array for countingsort
            int[] tmpCountingSortArray = {0,0,0,0,0,0,0,0,0,0};
     
            //CountingSort
            for (int i = 0; i < a.length; i++)
            {
                //split the specified digit from the element
                int tmpSplitDigit = a[i]/(int)Math.pow(10,k-1) - (a[i]/(int)Math.pow(10,k))*10;
                tmpCountingSortArray[tmpSplitDigit] += 1; 
            }
     
            for (int m = 1; m < 10; m++)
            {
                tmpCountingSortArray[m] += tmpCountingSortArray[m - 1];
            }
     
            //output the value to result
            for (int n = a.length - 1; n >= 0; n--)
            {
                int tmpSplitDigit = a[n] / (int)Math.pow(10,k - 1) - (a[n]/(int)Math.pow(10,k)) * 10;
                tmpArray[tmpCountingSortArray[tmpSplitDigit]-1] = a[n];
                tmpCountingSortArray[tmpSplitDigit] -= 1;
            }
     
            //copy the digit-inside sort result to source array
            for (int p = 0; p < a.length; p++)
            {
                a[p] = tmpArray[p];
            }
        }
     
        return a;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[]a={231,54,646,456,231,31,6,456,3,77,100};
     int []b=RadixSort(a, 3);
     System.out.println(Arrays.toString(b));
	}
    
}
