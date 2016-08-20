package Chapter5_Chuan;

import java.util.Arrays;
/*
 * 比较大话数据结构课本和网上的next数组的不同
 */
public class GetNextTest {
	

	public static int[] getNext(String pattern) {
        int j = 0, k = -1;
        int[] next = new int[pattern.length()];
        next[0] = -1;
        while (j < pattern.length() - 1) {
            if (-1 == k || pattern.charAt(j) == pattern.charAt(k)) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        System.out.println(Arrays.toString(next));
        return next;
	}
	
	public  void getNext1() {
        int j = 0, k = -1;
        String s="ababaaaba";
        char []c=s.toCharArray();
        int[] next1 = new int[c.length];
        next1[0] = -1;
        while (j < c.length - 1) {
            if (-1 == k || c[j] == c[k]) {
                j++;
                k++;
                next1[j] = k;
            } else {
                k = next1[k];
            }
        }
        System.out.println(Arrays.toString(next1));
        
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetNextTest t=new GetNextTest();
		String p="ababaaaba";
		//输出[-1, 0, 0, 1, 2, 3, 1, 1, 2]
        //和大话数据结构上的相差1
		t.getNext(p);
		t.getNext1();
	}

}
