package Chapter7_Tu;
import java.util.*;
/*
 * 用简单方法实现无向图的深度遍历和广度遍历 无权值
 * 图在http://www.cnblogs.com/skywang12345/p/3711483.html
 */
public class MyTu {
	char[]ch={'A','B','C','D','E','F','G'};
   public void deepTravel(int[][]a,int color[],int k){
	    System.out.print(ch[k]+" ");//0 2 1 3 5 6 4 
	                            //A C B D F G E
	    color[k]=1;
	  for(int i=0;i<a[k].length;i++){
		  if(a[k][i]==1&&color[i]==0){
			  deepTravel(a,color,i);
		  }
	  }
   }
   public void broadFirstSearch(int[][]a){
	 ArrayList<Integer>list=new ArrayList<Integer>();//待遍历元素
	 Set<Integer>set=new HashSet<Integer>();//已遍历过的元素
	 list.add(0);//从0元素开始
	 while(true){
		 if(list.isEmpty())//当list表为空时遍历结束
			 break;
		 int node=list.get(0);
		 System.out.print(ch[node]+" ");
		 set.add(node);
		 list.remove(0);
		 for(int i=0;i<a[node].length;i++){
			 if(a[node][i]==1&&set.contains(i)!=true&&list.indexOf(i)<0){
		 //list.indexOf(i)<0的意思是不让重复的孩子加入到list中  当在list中找不到i元素的时候才加入list
				 list.add(i);
			 }
		 }
	 }
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int array[][]={{0,0,1,1,0,1,0},
    		       {0,0,1,0,0,0,0},
                   {1,1,0,1,0,0,0},
    		       {1,0,1,0,0,0,0}, 
    		       {0,0,0,0,0,0,1}, 
    		       {1,0,0,0,0,0,1},
    		       {0,0,0,0,1,1,0} 
                   };
    
    MyTu mt=new MyTu();
    int color[]=new int[array.length];
    System.out.println("深度优先遍历：");
    mt.deepTravel(array, color, 0);
    System.out.println("\n广度优先遍历：");
    mt.broadFirstSearch(array);
  
	}

}
