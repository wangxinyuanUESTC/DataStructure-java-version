package Chapter7_Kruskal;

/**
 * sample Kruskal.java Description:
 * kruskal�㷨��˼��������С�ߣ���ÿ���ҵ��ı߲�������ҳ����ı��γɻ�·������һ��һά����group��ŵ�ǰ����������ͨͼ��ʾ��ÿ����С�ߣ�����һ����ͨͼ����ֱ�����㶼���� 
 * 1.0 YESUN Jul 18,
 * 2013 8:48:28 AM Create. ChangeLog:
 */
public class Kruskal1 {
    


    /**
     * Description:
     * 
     * @param args
     *            1.0 YESUN Jul 18, 2013 8:47:10 AM Create. ChangeLog:
     */
    public static void main(String[] args) {
        int[][] map = new int[][]{
                {0,10,MAX,MAX,MAX,11,MAX,MAX,MAX},
                {10,0,18,MAX,MAX,MAX,16,MAX,12},
                {MAX,MAX,0,22,MAX,MAX,MAX,MAX,8},
                {MAX,MAX,22,0,20,MAX,MAX,16,21},
                {MAX,MAX,MAX,20,0,26,MAX,7,MAX},
                {11,MAX,MAX,MAX,26,0,17,MAX,MAX},
                {MAX,16,MAX,MAX,MAX,17,0,19,MAX},
                {MAX,MAX,MAX,16,7,MAX,19,0,MAX},
                {MAX,12,8,21,MAX,MAX,MAX,MAX,0}
        };
        kruskal(map);
    }
    
    static int MAX = Integer.MAX_VALUE;
    
    /**
     * Description: by yesun
     * @param arcs
     * 1.0 YESUN Jul 18, 2013 1:42:42 PM Create.
     * ChangeLog:
     */
    public static void kruskal(int[][] arcs) {
        //�������
        int num = arcs.length;
        //��Ŷ�Ӧ����������ͨͼ��ʶ
        int[] group = new int[num];
        
        int sum = 0, n1 = 0, n2 = 0;
        boolean finished = false;
        int groupNum = 1;
        
        while(!finished) {
            int min = Integer.MAX_VALUE;
            //�ҳ����б�����Сֵ
            for(int i = 0; i < num; i++) {
                for(int j = i+1; j < num; j++) {
                    if(arcs[i][j] > 0 && arcs[i][j] < min){
                        //���group��ͬ�����ʾ�����������ͬ��Ϊ0����ʾû�����
                        if (group[i] != group[j] || (group[i] == 0 && group[j] == 0)) {
                            min = arcs[i][j];
                            n1 = i;
                            n2 = j;    
                        }                                            
                    }
                }
            }
            
            if(min == Integer.MAX_VALUE){
                continue;
            }
            
            System.out.println(n1 + " ---> " + n2 + " " + min);
            sum += min;
            
            //�ҵ�����Сֵ��������ͨ���
            if(group[n1] == 0 && group[n2] == 0){
                group[n1] = groupNum;
                group[n2] = groupNum;
                groupNum++;
            }
            else if(group[n1] > 0 && group[n2] > 0) {
                int tmp = group[n2];
                for(int m = 0; m < group.length; m++){
                    if(group[m] == tmp){
                        group[m] = group[n1];
                    }
                }
            }
            else{
                if(group[n1] == 0){
                    group[n1] = group[n2];
                }
                else{
                    group[n2] = group[n1];
                }
            }
            
            for(int i = 0; i < group.length; i++) {
                if(group[i] != group[0]){
                    finished = false;
                    break;
                }
                else{
                    finished = true;
                }
            }
            
            if(finished) {
                break;
            }
        }
        
        System.out.println(" sum:"+sum);
        
    }

}