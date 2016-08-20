package Chapter8_BinaryTree;
/*
 * 完成二叉排序树的增删查功能
 */
public class SerchAndDelete {
	public Node root;
	int numNode;
    public void addfirst(int data){//增加根节点
       if(root==null){
    	   root=new Node(data);
    	   ++numNode;
       }else
    	addnext(root, data);
       }
    public void addnext(Node current,int data){
 	   if(current.data>=data){
 		   if(current.left==null)
 			   current.left=new Node(data);
 		   else{
 			   addnext(current.left,data);
 			    ++numNode;
 		   }
 	   }
 	   if(current.data<data){
 		   if(current.right==null){
 			   current.right=new Node(data);
 			  ++numNode;
 		   }else
 		    addnext(current.right,data);
 	   }
    }
    public Node serch(Node current,int data){//递归查找，找到返回true
    	
    	if(current!=null){
    		if(current.data>data)
    			 serch(current.left,data);
    		 if(current.data<data)
    			serch(current.right,data);
    		 if(current.data==data){
    			 System.out.println("找到要找的元素："+current.data);
    			 return current;}
        }
		return null;
    }
   public void delete(int data){
      Node temp=serch(root,data);
	   if(temp!=null){
    	  if(temp.left==null&&temp.right==null)
    		  temp=null;
    	      numNode--;
      }
   }
   public void deleteBST(int key){  
       deleteBST(root, key);  
   }  
   private boolean deleteBST(Node node, int key) {  
       if(node == null) return false;  
       else{  
           if(key == node.data){  
               return delete(node);  
           }  
           else if(key < node.data){  
               return deleteBST(node.left, key);  
           }  
           else{  
               return deleteBST(node.right, key);  
           }  
       }  
   }  
 
   private boolean delete(Node node) {  
       Node temp = null;  
       /* 右子树空，只需要重接它的左子树 
        * 如果是叶子结点，在这里也把叶子结点删除了 
        * */  
       if(node.right == null){  
           temp = node;  
           node = node.left;  
       }  
       /*左子树空， 重接它的右子树*/  
       else if(node.left == null){  
           temp = node;  
           node = node.right;  
       }  
       /*左右子树均不为空*/  
       else{  
           temp = node;  
           Node s = node;  
           /*转向左子树，然后向右走到“尽头”*/  
           s = s.left;  
           while(s.right != null){  
               temp = s;  
               s = s.right;  
           }  
           node.data=s.data; 
           if(temp != node){  
                
               temp.right=s.left;
           }  
           else{  
        	   temp.left=s.left;
           }  
       }  
       return true;  
   }
   public void print( Node current){//递归遍历 中序遍历
	    if(current!=null){
		    print(current.left);
		    System.out.print(current.data+" ");
		    print(current.right);
	    }
   }
	public static void main(String[] args) {
		SerchAndDelete myby=new SerchAndDelete();
		myby.addfirst(3);
		myby.addfirst(4);
		myby.addfirst(0);//用current=current.lift形式的话，添加0和1都会出现异常
		myby.addfirst(1);
		myby.addfirst(5);
		myby.addfirst(7);
		myby.addfirst(2);
		myby.addfirst(6);
		myby.addfirst(1);// 用current=current.lift形式的话，最后面两个互换位置就异常
		myby.addfirst(0);
	    System.out.print("中序遍历结果：");
	    myby.print(myby.root);
	    myby.serch(myby.root, 1);
	    myby.deleteBST(6);
	    myby.print(myby.root);
	}
}
class Node{
	public Node left;
	public Node right;
	int data ;
	public Node(int data){
		this.data=data;
	}
}