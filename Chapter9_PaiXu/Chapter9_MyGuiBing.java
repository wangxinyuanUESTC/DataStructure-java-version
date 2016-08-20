package Chapter9_PaiXu;
import java.util.Arrays;
/*
 *参考的归并排序 
 */
public class Chapter9_MyGuiBing {
	public void mergroup(int []a,int str,int end){
		int mid=(str+end)/2;
		if(str<end){
		       mergroup(a,str,mid);
//		       System.out.println("llll:　"+Arrays.toString(a));
		       mergroup(a,mid+1,end);
//		       System.out.println("RRRR:　"+Arrays.toString(a));
		       merger(a,str,mid,end);
		       System.out.println(Arrays.toString(a));
		}
	}
	public void merger(int arr[],int str,int mid,int end){
		int i=str;
		int j=mid+1;
        int k=0;
        int temp[]=new int [arr.length];
		while(i<=mid&&j<=end)
			temp[k++]=(arr[i]<=arr[j]?arr[i++]:arr[j++]);
		while(i<= mid)
            temp[k++] = arr[i++];
        while(j<= end)
            temp[k++] = arr[j++];
//        System.out.println(Arrays.toString(temp));
        // 将排序后的元素，全部都整合到数组a中。
        for (i = 0; i < k; i++)
            arr[str+ i] = temp[i];
//        System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chapter9_MyGuiBing mer=new Chapter9_MyGuiBing();
	   int a[]={5,3,2,1,0,-2,9,4,8,6};
	   mer.mergroup(a,0,a.length-1);
//	   System.out.println(Arrays.toString(a));
	}

}
