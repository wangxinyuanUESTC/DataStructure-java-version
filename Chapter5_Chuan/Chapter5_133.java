package Chapter5_Chuan;
/*
 * 此序用于比较两个字符串
    没有用到KMP模式匹配算法 
*/
public class Chapter5_133 {
 public String arr1="goodfhfhgoogledgdSSS";
 public String arr2="google";//直接定义两个字符串
 char ch1[]=null;
 char ch2[]=null;
 public void test(){
	 ch1=arr1.toCharArray();
	 ch2=arr2.toCharArray();//先转化为数组的形式
//System.out.print(Arrays.toString(ch1));
	 for( int i=0;i<ch1.length;i++){//外循环，第一个数组
		 int m=0;//m用于内循环中充当数组一的增量，为了回到外循环时还是从整个外部开始
		 for(int j=0;j<ch2.length;j++){
			
			int n=m+i;
			
			 if(ch1[n]==ch2[j]){
				 m++;
				 if(m==ch2.length){
					 System.out.println("有匹配的字符串：");
					 for(int k=i;k<i+ch2.length;k++){
						 System.out.print(ch1[k]);
					 } 
		        
				 }
			 } 
		 }
		 }
	 
	 }
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    new Chapter5_133().test();
	}

}
