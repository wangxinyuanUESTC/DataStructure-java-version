package test1;

import java.util.Arrays;

//测试一下object类型的数组功能
public class TestObjectArrays {
	Object[] array=new Object[4];
	int count=0;
	public void add(Object obj) {
		if(isEmpty()){
			System.out.println("数组为空，输入第一个元素为："+obj);}
		   
		array[count]=obj;
		count++;
		
		if(!isFull()){//如果数组不满，则继续
		System.out.print("还没有满,count为："+count+" ");	
		System.out.println(Arrays.toString(array));
		    }
		
		else{
			
			System.out.print("数组已满！！！！ count为："+count+" ");
			System.out.println(Arrays.toString(array));
			
			return;
          
		    }
		
	}
	
	//用一个判断数组是否为空的方法
	public boolean isEmpty(){
		return count==0;//如果是空则输出
	
	}
	public boolean isFull(){
		if(count>=4)
		return true;
		return false;
	}
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		TestObjectArrays te=new TestObjectArrays();
		te.add("wangxinyuan");
		te.add('f');
		te.add(1565);
		te.add(45);
		te.add(6);//此时超过数组长度 报错
//		System.out.println(Arrays.toString(te.array));//暴力输出全部

	}

}
