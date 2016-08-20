package Chapter7_PrimSuanFa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Prim {

	public static List<Vertex> vertexList = new ArrayList<Vertex>();//��㼯
	public static List<Edge> EdgeQueue = new ArrayList<Edge>();//�߼�
	public static List<Vertex> newVertex = new ArrayList<Vertex>();//�Ѿ� ���ʹ��Ľ��
	
	public static void main(String[] args) {
		primTree();

	}
	public static void buildGraph() {
		Vertex v1 = new Vertex("a");
		Prim.vertexList.add(v1);
		Vertex v2 = new Vertex("b");
		Prim.vertexList.add(v2);
		Vertex v3 = new Vertex("c");
		Prim.vertexList.add(v3);
		Vertex v4 = new Vertex("d");
		Prim.vertexList.add(v4);
		Vertex v5 = new Vertex("e");
		Prim.vertexList.add(v5);
		addEdge(v1, v2, 6);//���ÿ��Ȩֵ
		addEdge(v1, v3, 7);
		addEdge(v2, v3, 8);
		addEdge(v2, v5, 4);
		addEdge(v2, v4, 5);
		addEdge(v3, v4, 3);
		addEdge(v3, v5, 9);
		addEdge(v5, v4, 7);
		addEdge(v5, v1, 2);
		addEdge(v4, v2, 2);
	}
	public static void addEdge(Vertex a, Vertex b, int w) {
		Edge e = new Edge(a, b, w);
		Prim.EdgeQueue.add(e);//Ȩֵ����
	}
	public static void primTree(){
		buildGraph();
		Vertex start = vertexList.get(0);
		newVertex.add(start);
		for(int n=0;n<vertexList.size();n++){
			Vertex temp = new Vertex(start.key);
			Edge tempedge = new Edge(start,start,1000);
			for(Vertex v : newVertex){
				for(Edge e : EdgeQueue){
					if(e.start==v && !containVertex(e.end)){
						if(e.key<tempedge.key){
							temp = e.end;
							tempedge = e;
						}
							
						
					}
				}
			}
			newVertex.add(temp);
		}
		Iterator it = newVertex.iterator();
		while(it.hasNext()){
			Vertex v =(Vertex) it.next();
			System.out.println(v.key);
		}
	}
	public static boolean containVertex(Vertex vte){
		for(Vertex v : newVertex){
			if(v.key.equals(vte.key))
				return true;
		}
		return false;
	}
}
class Vertex {
	String key;
	Vertex(String key){
		this.key = key;
	}
}

class Edge{
	Vertex start;
	Vertex end;
	int key;
	Edge(Vertex start,Vertex end,int key){
		this.start = start;
		this.end  = end;
		this.key = key;
		
	}
}