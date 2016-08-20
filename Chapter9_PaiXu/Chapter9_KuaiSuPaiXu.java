package Chapter9_PaiXu;
/*
 *  快�?�排�?
 * 对冒泡排序的改进：首先�?�一个轴值，将待排序的数据分为两个独立的两部分，左侧小于轴�?�，右侧大于轴�??
 * 然后分别对这两部分重复上述部分，直到整个序列有序�?
 * 时间复杂度为O(n*n)期望值的时间复杂度为nlgn
 */
public class Chapter9_KuaiSuPaiXu {
	public static void main(String[] args) 
	{
		quicksort qs = new quicksort();
		int data[] = {44,22,2,32,54,22,88,77,99,11};
		qs.data = data;
		qs.sort(0, qs.data.length-1);
		qs.display();
	}
}
class quicksort
{
	public int data[];
	
	private int partition(int sortArray[],int low,int hight)//划分  优化后的算法  减少交换次数
	{
		int key = sortArray[low];
		
		while(low<hight)
		{
			while(low<hight && sortArray[hight]>=key)
				hight--;
			sortArray[low] = sortArray[hight];
			while(low<hight && sortArray[low]<=key)
				low++;
			sortArray[hight] = sortArray[low];
		}
		sortArray[low] = key;//当low=high时，把key添加到最后的正确位置�?
		return low;//这个low的意思就是key值的数组索引，用于�?�归
	}
	public void sort(int low,int hight)
	{
		if(low<hight)
		{
			int result = partition(data,low,hight);//把整体分成独立的两部分，返回轴�?�位�?
			for(int i=0;i<data.length;i++){
				System.out.print(data[i]+" ");
			}
			System.out.println();
			sort(low,result-1);//左侧重复
			sort(result+1,hight);//右侧重复
		}
	}
	public void display()//输出
	{
		for(int i=0;i<data.length;i++)
		{
			System.out.print(data[i]);
			System.out.print(" ");
		}
	}
	
}
