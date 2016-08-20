package Chapter9_PaiXu;

import java.util.Arrays;

public class Chapter9_MyKuaiSuPaiXu {
	public void quicksort(int []a,int low,int high){//这个方法有问题
		if(low<high){  
		int resultIndex=pointIndex(a,low,high);
		quicksort(a,low,resultIndex-1);
		quicksort(a,resultIndex+1,high);
		}
	}
	public int pointIndex(int []a,int low,int high){
		int j=low-1;                         //标记小于中间值值的最后元素的位置的下一个 也就是大于中间值的第一个位置 用于把小于中间值的数插入到此处  而把此处的原来数交换到i处
		int i=low; 
		int k=high;
		for(i=0;i<=k-1;i++){             //因为最后一个元素是中间值 所以不需要循环到最后一个元素
			if(a[i]<=a[k]){
				j=j+1;                      //如果后面的元素有小于中间值的把第一个大于中间值的元素和这个元素交换位置
				int temp=a[j];
				a[j]=a[i];
				a[i]=temp;
			}
		}
		int temp1=a[j+1];             //大于中间值的第一个元素
		a[j+1]=a[k];
		a[k]=temp1;
		return j+1;
	}
	public static void quickSort(int[] a, int l, int r) {  //另一种方法  更高效 从两边开始查找
		//http://www.cnblogs.com/skywang12345/p/3596746.html
		if (l < r) {
			int i,j,x;
			i = l;
			j = r;
			x = a[i];                   //把第一个元素当做中间值
			while (i < j) {
				while(i < j && a[j] > x)
					j--;               // 从右向左找第一个小于x的数
				if(i < j)
					a[i++] = a[j];
				while(i < j && a[i] < x)
					i++;               // 从左向右找第一个大于x的数
				if(i < j)
					a[j--] = a[i];
			}
			a[i] = x;//最后把中间值赋给a[i] a[j]也可以
			quickSort(a, l, i-1); /* 递归调用 */
			quickSort(a, i+1, r); /* 递归调用 */
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a={2,8,7,1,3,5,6,4,0};
		Chapter9_MyKuaiSuPaiXu ks=new Chapter9_MyKuaiSuPaiXu();
//		ks.quicksort(a, 0, a.length-1);
		quickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}

}
