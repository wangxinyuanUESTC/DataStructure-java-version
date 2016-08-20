package Chapter7_Tu;
	import java.awt.print.Book;
import java.util.ArrayList;
import java.util.LinkedList;
	/*
	 * @description 邻接矩阵模型类 有向图 带权值
	 * https://segmentfault.com/a/1190000002685782
	 * 
	 */
	public class LinJieJuZhenWuXiangTu {
		public  ArrayList<Object> vertexList;//存储点的链表
	    public int[][] edges;//邻接矩阵，用来存储边
	    public int numOfEdges;//边的数目
        boolean isVisited[];
        boolean isVisited1[];
	    public LinJieJuZhenWuXiangTu(int n) {
	        //初始化矩阵，一维数组，和边的数目
	        edges=new int[n][n];
	        vertexList=new ArrayList<Object>(n);//有n个点
	        numOfEdges=0;
	        isVisited=new boolean[n];//深度遍历用
	        isVisited1=new boolean[n];//广度遍历用
	    }

	    //得到结点的个数
	    public int getNumOfVertex() {
	        return vertexList.size();
	    }

	    //得到边的数目
	    public int getNumOfEdges() {
	        return numOfEdges;
	    }

	    //返回结点i的数据
	    public Object getValueByIndex(int i) {
	        return vertexList.get(i);
	    }

	    //返回v1,v2的权值
	    public int getWeight(int v1,int v2) {
	        return edges[v1][v2];
	    }

	    //插入结点
	    public void insertVertex(Object vertex) {
	        vertexList.add(vertexList.size(),vertex);
	    }

	    //插入结点
	    public void insertEdge(int v1,int v2,int weight) {
	        edges[v1][v2]=weight;
	        numOfEdges++;
	    }

	    //删除结点
	    public void deleteEdge(int v1,int v2) {
	        edges[v1][v2]=0;
	        numOfEdges--;
	    }

	    //得到第一个邻接结点的下标
	    public int getFirstNeighbor(int index) {
	        for(int j=0;j<vertexList.size();j++) {
	            if (edges[index][j]>0) {
	                return j;
	            }
	        }
	        return -1;
	    }

	    //根据前一个邻接结点的下标来取得下一个邻接结点
	    public int getNextNeighbor(int v1,int v2) {
	    	
	        for (int j=v2+1;j<vertexList.size();j++) {
	            if (edges[v1][j]>0) {
//	            	 System.out.print("Nn:("+(v1+1)+(j+1)+")  ");
	                return j;
	            }
	        }
	        return -1;
	    }
	    
	    //深度优先遍历
	   public void depthFirstSearch(boolean[] isVisited,int  i) {
	        //首先访问该结点，在控制台打印出来
	        System.out.print(getValueByIndex(i)+"  ");
	        //置该结点为已访问
//            System.out.print("Fn:("+(i+1)+")  ");//输出的都是结点
	       isVisited[i]=true;
	        this.isVisited[i]=isVisited[i];
	        int w=getFirstNeighbor(i);
	        while (w!=-1) {
	            if (!this.isVisited[w]) {
	                depthFirstSearch(this.isVisited,w);

	            }//执行一步上面的就要执行下面的
	            w=getNextNeighbor(i, w);
	           
	        }
	    }
	    
	    //深度优先遍历，与其同名私有函数属于方法重载
	    public void depthFirstSearch() {
	        for(int i=0;i<getNumOfVertex();i++) {
	            //因为对于非连通图来说，并不是通过一个结点就一定可以遍历所有结点的。
	            if (!this.isVisited[i]) {
	                depthFirstSearch(this.isVisited,i);
	            }
	        }
	    }
	    
	    //私有函数，广度优先遍历
	    public  void broadFirstSearch(boolean[] isVisited,int i) {
	        int u,w;
	        LinkedList<Object> queue=new LinkedList<Object>();
	        
	        //访问结点i
	        System.out.print(getValueByIndex(i)+"  ");
	        isVisited[i]=true;
	        
	        //结点入队列
	        queue.addLast(i);
	        while (!queue.isEmpty()) {
	            u=((Integer)queue.removeFirst()).intValue();
	            w=getFirstNeighbor(u);
	            while(w!=-1) {
	                if(!isVisited[w]) {
	                        //访问该结点
	                        System.out.print(getValueByIndex(w)+"  ");
	                        //标记已被访问
	                        isVisited[w]=true;
	                        //入队列
	                        queue.addLast(w);
	                }
	                //寻找下一个邻接结点
	                w=getNextNeighbor(u, w);
	            }
	        }
	    }
	    
	    //对外公开函数，广度优先遍历
	    public void broadFirstSearch() {
	        for(int i=0;i<getNumOfVertex();i++) {
	            if(!isVisited[i]) {
	                broadFirstSearch(isVisited, i);
	            }
	        }
	    }
	    public static void main(String args[]){
	    	int n=8,e=9;//分别代表结点个数和边的数目
	        String labels[]={"1","2","3","4","5","6","7","8"};//结点的标识
	    	LinJieJuZhenWuXiangTu li=new LinJieJuZhenWuXiangTu(n);
	    	 for(String label:labels) {
	             li.insertVertex(label);//插入结点
	         }
	    	  li.insertEdge(0, 1, 1);
	    	  li.insertEdge(0, 2, 1);
	    	  li.insertEdge(1, 3, 1);
	    	  li.insertEdge(1, 4, 1);
	    	  li.insertEdge(3, 7, 1);
	    	  li.insertEdge(4, 7, 1);
	    	  li.insertEdge(2, 5, 1);
	    	  li.insertEdge(2, 6, 1);
	    	  li.insertEdge(5, 6, 1);
	    	  
	    	  li.insertEdge(1, 0, 1);
	    	  li.insertEdge(2, 0, 1);
	    	  li.insertEdge(3, 1, 1);
	    	  li.insertEdge(4, 1, 1);
	    	  li.insertEdge(7, 3, 1);
	    	  li.insertEdge(7, 4, 1);
	    	  li.insertEdge(6, 2, 1);
	    	  li.insertEdge(5, 2, 1);
	    	  li.insertEdge(6, 5, 1);
	    	  System.out.println("深度优先搜索序列为：");
	    	  li.depthFirstSearch();
	          System.out.println();
	          System.out.println("广度优先搜索序列为：");
	          li.broadFirstSearch();
	    	
	    }
	}

