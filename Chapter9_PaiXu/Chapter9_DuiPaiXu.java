package Chapter9_PaiXu;
import java.util.Arrays;
/*
 * 堆排序时间复杂度为O[NlgN]  具有原址性  不稳定  最大堆排出的是从小到大排序自己写的
 */
public class Chapter9_DuiPaiXu {
	public static int  n;
    public void heapsort(int []a){
    	n=a.length-1;
    	for(int i=(n/2);i>=0;i--){
    		changeNode(a,i,n);// 这个是建立最大堆
    	}
    	System.out.println(Arrays.toString(a));//[16, 14, 10, 8, 7, 9, 3, 2, 4, 1]
    	for(int j=n;j>=0;j--){//始终把第一个根节点的最大元素放到最后，然后重新递归得到根节点的最大值
    		int temp=a[0];
			a[0]=a[j];
            a[j]=temp;
            changeNode(a,0,j-1); //这个才是真正的把最大堆变为排好的顺序数组
    	}
    	System.out.println(Arrays.toString(a));//[1, 2, 3, 4, 7, 8, 9, 10, 14, 16]
    }
    public void changeNode(int[]a,int i,int n){
		int l=2*i+1;
		int r=2*i+2;
		int maxIndex=0;
		if(l<=n&&a[l]>a[i]){
			maxIndex=l;
		}else{maxIndex=i;}
		if(r<=n&&a[r]>a[maxIndex]){
			maxIndex=r;
		}
		if(maxIndex!=i){
			int temp=a[i];
			a[i]=a[maxIndex];
            a[maxIndex]=temp;	
            changeNode(a,maxIndex,n);
		}
	}
	public static void main(String[] args) {
    int[]a={4,1,3,2,16,9,10,14,8,7};
    Chapter9_DuiPaiXu dp=new Chapter9_DuiPaiXu();
    dp.heapsort(a);
    
	}
}
