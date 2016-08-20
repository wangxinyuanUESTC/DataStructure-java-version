package Chapter7_PrimSuanFa;

/*
 * ��С������prim�㷨��������С�ڽӱ�������С��������
 * ���ȹ���һ����ͼ��ѡ��һ����ʼ����뵽�����У�
 * Ȼ��ֱ��ԭ������ļ����г�ȡһ�����㣬
 * ѡ��ı�׼�ǹ���ɵ�����Ȩֵ��С��
 * ѭ�򽥽���������һ����С������
 */
public class PrimYuanLi {
 /**
  * @author �����
  * @date 2015-02-13 20:23
  */
 
 /*
  * m:����Ϊ�޷�����ľ���
  * weight:�ڽӾ����,weight��ʾȨֵ
  * verNum:����ĸ���
  * lowerW:���¼��ϵ���СȨֵ
  * edge:�洢���¼��ϵı�
  * checked:�ж������Ƿ񱻳�ȡ�ļ���
  */
 
 static int m=Integer.MAX_VALUE;
 static int[][] weight={
   {0, 0, 0, 0, 0, 0},  
   {0, m, 6, 9, 5, 13},  
   {0, 6, m, 6,7,8},  
   {0, 9,6,m,9,3},  
   {0, 5,7,9,m,3},  
   {0,13,8,3,3,m}  
 };
 static int verNum=weight.length;
 static int []lowerW=new int[verNum];
 static int []edge=new int[verNum];
 static boolean []checked=new boolean[verNum];
 
 public void prim(int n,int [][]w){
  checked[1]=true;            //��ȡ��һ������
  
  for(int i=1;i<=n;i++){          //��ʼ�����㼯��
   lowerW[i]=w[1][i];
   edge[i]=1;
   checked[i]=false;
  }
  
  for(int i=1;i<=n;i++){
   int min=Integer.MAX_VALUE;
   int j=1;
   for(int k=2;k<=n;k++){        //�ж��Ƿ��ȡ�ö���
    if(lowerW[k]<min&&(!checked[k])){
     min=lowerW[k];
     j=k;
    }
   }
   if(i<n)                //���������һ�����㵽��һ����������
   System.out.println(j+"-->"+edge[j]);
   
   checked[j]=true;           //��������뵽�¼�����
   
   for(int k=2;k<=n;k++){        //�����¼���Ķ��㣬�����С��Ȩֵ
    if((w[j][k]<lowerW[k])&&(!checked[k])){
     lowerW[k]=weight[j][k];
     edge[k]=j;
    }
   }
  }
 }
 
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  PrimYuanLi p=new PrimYuanLi();
  p.prim(verNum-1,weight);
 }
}
