package test1;

import java.util.*;

public class ListIteratorTest {

	
	public void Str(){
		String[] st3={"疯狂讲义1","疯狂讲义2","疯狂讲义3","疯狂讲义4"};
		int [] a={1,5,48,54,332,121,121};
		System.out.println(a);//输出也是乱码
		System.out.println("st3的值为：");
		System.out.println(st3);//输出乱码
		System.out.println(Arrays.toString(st3));//可以输出
	}
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		
		new ListIteratorTest().Str();
   List<String> list=new ArrayList<>();
   String [] st={"疯狂讲义1","疯狂讲义2","疯狂讲义3"};//将数组转化为集合
   for(int i=0;i<st.length;i++){
	   list.add(st[i]);
   }
   
   String[] st1=new String[st.length];//将集合转化为数组
   for(int j=0;j<st.length;j++){
	   st1[j]=list.get(j);
	   System.out.println(st1[j]);
   }
  
   ListIterator<String> itera=list.listIterator();
   //这种迭代专门为List准备，比一般的迭代增加了add和向前迭代功能
   while(itera.hasNext()){
	   System.out.println(itera.next());
	   itera.add("*******22222222*********");//只是增加了并没有打印出来
   }
   System.out.println("============下面开始反向迭代==========");
   while(itera.hasPrevious()){
	   System.out.println(itera.previous());
   }
		
   
		
	}

}
