package Chapter3_ShunXuBiao;
/*
 * 初始化数组
 */
public class ArrayChuShiHua_test {
   int maxlong;
   int size;
   int defaultlong=10;
   Object array[];
   
   //初始化默认数组长度
   public ArrayChuShiHua_test(){
	   init(defaultlong);
   }
   
   //初始化指定数组长度
   public ArrayChuShiHua_test(int size2){
	   init(size2);
   }
   public void init(int size1){
	   maxlong=size1;
	  array=new Object [size1];
   }
   public void test1(){
	   System.out.println(array.length);
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayChuShiHua_test t1=new ArrayChuShiHua_test();
		t1.test1();//输出默认数组长度
		ArrayChuShiHua_test t2=new ArrayChuShiHua_test(20);
		t2.test1();//输出指定数组长度
	}

}
