package Chapter7_Tu;
import java.util.*;
public class MyTutest {
	char []ch={'A','B','C','D','E','F','G'};
	int color[]=new int[ch.length];
	int k;
public void dps(int[][]a,int k){
	System.out.print(ch[k]+" ");
	color[k]=1;
	for(int i=0;i<ch.length;i++){
		if(a[k][i]==1&&color[i]!=1){
			dps(a,i);
		}
	}
}
public void bps(int a[][],char c){
	ArrayList<Integer>list=new ArrayList<Integer>();
	Set<Integer>set=new HashSet<Integer>();
    for(int i=0;i<ch.length;i++){
    	if(ch[i]==c){
    		k=i;
    	}
    }
	list.add(k);
	while(true){
		if(list.isEmpty())
			break;
		int node=list.get(0);
		System.out.print(ch[node]+" ");
		set.add(node);
		list.remove(0);
		for(int i=0;i<ch.length;i++){
			if(a[node][i]==1&&set.contains(i)==false&&list.indexOf(i)<0){
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
  MyTutest mt=new MyTutest();
  System.out.println("深度遍历：");
  mt.dps(array, 0);
  System.out.println("\n广度遍历：");
  mt.bps(array, 'F');//从'F'开始遍历
	}

}
