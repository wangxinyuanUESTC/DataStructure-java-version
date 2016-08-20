package Chapter9_PaiXu;
import java.io.*;
import java.util.Arrays;
/**
 * Created by wang on 2016/5/8.
 * 从键盘中输入一组可变的一序列数，从小到大排序
 */

public class Chapter9_MaoPaoPaiXu {

    int[]array2=null;
    public void test2()  {

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入数字，用空格隔开:");
            String t = br.readLine();
//            if(!t.equals("")){ //不要if语句也可以
                String[]st =t.split(" ");
                array2 =new int[st.length];
                for (int i = 0; i <st.length; i++)
                    array2[i]=Integer.parseInt(st[i]);
                Arrays.sort(array2);

//            }
        }catch(IOException e){
            e.printStackTrace();
        }
//        int array2[]={12, 42, 64, 7, 24, 37, 5, 61, 11, 55};
        for(int i=0;i<array2.length-1;i++){
            for(int j=i+1;j<array2.length;j++){
                if(array2[i]>array2[j]){
                    int temp2=array2[i];
                    array2[i]=array2[j];
                    array2[j]=temp2;
                }
            }
        }
        System.out.println("从小到大顺序：");
        for(int i=0;i<array2.length;i++){
            System.out.print(array2[i]+"  ");
        }
    }

   /*
   //。。。。。。。。。。。。以下代码用于直接定义数组后从大到小排列。。。。。。。。。。。。
    public void test() throws IOException {

//        BufferedReader bi=new BufferedReader(new InputStreamReader(System.in) );
//        System.out.println("Enter a line:");
//        System.out.println(bi.readLine());
        int[] array = {12, 42, 64, 7, 24, 37, 5, 61, 11, 55};
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            System.out.print("第"+(i+1)+"次排序结果： ");
             for(int k=0;k<array.length;k++){
                 System.out.print(array[k]+"\t");

             }
            System.out.println();//输出一次循环之后换行
        }

        System.out.println("从大到小顺序：");
        for(int i=0;i<array.length;i++){
           System.out.print(array[i]+"  ");//打印出结果排序
        }
        System.out.println();
    }
    */


    public static void main(String[] args) {
    	Chapter9_MaoPaoPaiXu m=new Chapter9_MaoPaoPaiXu();
//        m.test();
        m.test2();
    }
}