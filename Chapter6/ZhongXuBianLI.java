package Chapter6;
/*
 * 建立一个二叉树，并用中序遍历的方法打印二叉树
 */
public class ZhongXuBianLI {
	public Node2 root; 
	 public void add(int data){
	  Node2 newNode = new Node2(data);
	  if(this.root == null){     //root为空时直接把data赋值给root，否则增加新节点（左子树或右子树）
	   this.root = newNode;
	  }else{
	   this.root.addNode(newNode);//如果root不为空也从root开始添加节点
	  }
	 }
	 public void print(){
	  this.root.printNode();//从root开始
	 }
	 public static void main(String args[]){
		ZhongXuBianLI  bt = new ZhongXuBianLI();
	  bt.add(3);
	  bt.add(4);
	  bt.add(0);
	  bt.add(1);
	  bt.add(5);
	  bt.add(7);
	  bt.add(2);
	  bt.add(6);
	  bt.print();
	 }
	}
class Node2{
	  int data;  
	  Node2 left; 
	 Node2 right;
	  public Node2(int data){
	   this.data = data;
	  }
	  public void addNode(Node2 newNode){     
	   if(newNode.data<= this.data){  //this.data表示root的data
		 if(this.left == null){         
	     this.left = newNode;
	    }else{
	     this.left.addNode(newNode);//递归，从root开始
	    }
	   }
	   if(newNode.data > this.data){
	    if(this.right == null){         
	     this.right = newNode;
	    }else{
	     this.right.addNode(newNode);
	    }
	   }
	  } 
	  public void printNode(){                
	   if(this.left != null){
	    this.left.printNode();//递归打印左子树，
	   }
	   System.out.println(this.data);      //当节点没有左子树的时候打印该节点
	   if(this.right != null){
	    this.right.printNode();
	   }
	  }
	 } 