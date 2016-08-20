package Chapter4_Stack;

/* 自己写的
 * 功能：实现栈的链式存储
 * 方法：在链表的基础上改变插入和删除的方法，栈顶插入即把链表的头指针指向插入的元素
 * 栈的顺序表实现方法是在数组的最后进行插入和删除操作
 */
public class Stack {
	//把头指针当做栈顶！
			Node top;//栈顶
			Node current;//top后面的结点，当删除top时把current赋值为top
		 int count;//计数
			public void addNode (Object object){
				    if(top==null){
				    	top=new Node(object);//注意一定不要直接用object赋值
				    	current=top;
				    	count++;
				    }
				    else{
				    Node  node	=new Node(object);
				    node.next=top;
				    current=node.next;
				    top=node;
				    count++;
				    }
				}
			public void delete(){
				
				if(top==null){
					System.out.println("栈为空，无法删除！");
					return;
				}
				if(count==1){
					top=null;
					System.out.println("删除成功，已没有元素");
					count--;
					return;
				}
				if(count==2){
					top=current;
					count--;
					return;
				}
				//总是从头部删除
				if(count>2){
				top=current;//先把top后面的current设置为top
				current=current.next;//然后再把current设置为top的下一个结点
				count--;
				return;
				}
				
			
				
			}
			 public void print1(Node node) {
		//如果不设置形参，直接用top和current则会直接把他们都改了，会出现错误，用形参不会改变原始的数据
			        if (node== null) {
                  System.out.println("栈为空不能打印");
			            return;
			        }
			       Node current1 = node;//重新定义一个当前结点 防止和current冲突
			        while (current1 != null) {
			            System.out.print(current1.data+"  ");
			            current1 = current1.next;
			        }
			    }
				
			public static void main(String[] args) {
		// TODO Auto-generated method stub
          Stack st=new Stack();
          st.addNode("第一个入栈元素");
          st.addNode("第二个入栈元素");
          st.addNode("第三个入栈元素");
          st.addNode("第四个入栈元素");
          st.print1(st.top);//从top开始遍历
          System.out.println("第一次删除：");
          st.delete();
          st.print1(st.top);
          
          System.out.println("第二次删除:");
          st.delete();
          st.print1(st.top);
          
          System.out.println("第三次删除:");
          st.delete();
          st.print1(st.top);
          
          System.out.println("第四次删除:");
          st.delete();
          st.print1(st.top);
        
          
		}

}
class Node{
	Object data;
	Node next;
	public Node(Object data){
		this.data=data;
	}
}