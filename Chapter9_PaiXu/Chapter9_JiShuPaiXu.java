package Chapter9_PaiXu;

import java.util.Arrays;

public class Chapter9_JiShuPaiXu {
    public static int [] JiShusort(int []a){
        int []b=new int[a.length];
        int []c=new int[6];
        for(int i=0;i<a.length;i++){
        	c[a[i]]=c[a[i]]+1;
        }
        System.out.println(Arrays.toString(c));
        for(int j=1;j<c.length;j++){  
        	c[j]=c[j]+c[j-1];
        }
        System.out.println(Arrays.toString(c));
        for(int k=0;k<a.length;k++){
        	b[c[a[k]]-1]=a[k];//b也从0开始    注意c[a[k]]表示的是个数 跟数组的坐标不对应
        	c[a[k]]--;
        }
		return b;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int a[]={2,5,3,0,2,3,0,3,0,5};
    int []b=JiShusort(a);
    System.out.println(Arrays.toString(b));
	}

}
