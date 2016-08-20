package Chapter6;
/*
 * 自己写的二叉树 并用中序遍历
 */
public class MyBinaryTree {
	public Node1 root;
  public void add(int data){   //递归方法实现添加功能
	  Node1 node=new Node1(data);
	  if(root==null){
		  root=node;
	  }else{
		  add1(root,node);
	  }
  }
  public void add1(Node1 current,Node1 addNode){   //此方法使用递归思想，第一个形参思想和打印递归思想相同
	  if(addNode.data<=current.data){
		  if(current.lift==null){
			  current.lift=addNode;
		  }else{
//			  current=current.lift;  //不能用这种方式
//			  add1(current,addNode)   //用这种方法会出现异，根据添加元素的顺序不同而定 
			  add1(current.lift,addNode);
		  }
	  }
	  if(addNode.data>current.data){
		  if(current.right==null){
			  current.right=addNode;
		  }else{
//			  current=current.right;
//			  add1(current,addNode)
			  add1(current.right,addNode);
		  }
	  }
  }
/*
  //    public void add(int data2){
//    	Node1 newNode=new Node1(data2);
//    	if(root==null){
//    		root=newNode;
//    	}else{
//    	Node1 current=root;
//    	while(current!=null){//只要当前结点不为空就执行，它的孩子结点可能为空（也就是下面的if语句）
//    		if(newNode.data<=current.data){
//    	         if(current.lift!=null){
//    			            current=current.lift;
//    			            continue;//不执行以下代码重新从while开始循环，目的是为了寻找可能的左孩子的右孩子
//    		                           }
//    	         else{
//    	     		        current.lift=newNode;
//    	     		        return;//如果到为空的时候把值赋给目标左孩子，然后直接跳出add方法
//    	     	      }
//    	                                  } 
//    		if(newNode.data>current.data)    {
//    		     if(current.right!=null){
//        			         current=current.right;
//        			         continue;
//    			                         }
//    		     else{
//    	    			   current.right=newNode;
//    	    			   return;
//    	    		 }
//        		                             }
//        	                 }
//    	      }
//    	                        }
 */
    public void print(Node1 current1){  //用递归方法中序遍历二叉树
    	if(current1!=null){
    		print(current1.lift);
    		System.out.print(current1.data+" ");
    	    print(current1.right);
    	}
    }
	public static void main(String[] args) {
		MyBinaryTree myby=new MyBinaryTree();
		myby.add(3);
		myby.add(4);
		myby.add(0);//用current=current.lift形式的话，添加0和1都会出现异常
		myby.add(1);
		myby.add(5);
		myby.add(7);
		myby.add(2);
		myby.add(6);
		myby.add(1);// 用current=current.lift形式的话，最后面两个互换位置就异常
		myby.add(0);
	    System.out.print("中序遍历结果：");
		myby.print(myby.root);
	}
}
class Node1{
	public Node1 lift;
	public Node1 right;
	int data;
	public Node1(int data1){
		this.data=data1;
	}
}
