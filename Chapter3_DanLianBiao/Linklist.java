package Chapter3_DanLianBiao;

/*
 * 自己写的有头结点的链表
 */

public class Linklist {
    public Node head;//头
    public Node current;//当前结点对象
    int number;
    //方法：向链表中添加数据
    public void add(Object data) {
        //判断链表为空的时候
        if (head == null) {//如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头结点
            head = new Node(data);
            current = head;
            number++;
        } else {
            //创建新的结点，放在当前节点的后面（把新的结点和链表进行关联）
            current.next = new Node(data);
            //把链表的当前索引向后移动一位
            current = current.next;  
            //此步操作完成之后，current结点指向新添加的那个结点
        number++;
        }
    }
  public void delete(int data){
	  index(data);
	  if(data==0){
		 head=current.next;
	  }else{
		  current.next=current.next.next;
		  number--;
		  }
	  
  }
  //需要一个定位的方法 用于删除方法 当输入索引后先找到索引结点的前一个结点，把前一个结点的next指向后一个的后一个
  //也可以用双指针，时间复杂度降低
  public Node index(int index){
	  if(index==0){
		  //头一个结点下标为0
		  current=head;
		 
		  return current;
		  //删除后链表为空
	  }else{
		  current=head;
		  for(int i=0;i<index-1;i++){
			  current=current.next;
			  //因为current.next赋值给了current，所以要设置为index-1
		  }
		 
	  }
	  return current;
  }
    //方法：遍历链表（打印输出链表。方法的参数表示从节点node开始进行遍历
    public void print(Node node) {
        if (node == null) {
            return;
        }
        current = node;
        while (current != null) {
            System.out.print(current.data+"  ");
            current = current.next;
        }
    }
    //输出结点数
    public void nodeNum(){
    	
    	System.out.println("结点个数为："+number);
    }
    public static void main(String[] args) {
        Linklist list = new Linklist();
        //向LinkList中添加数据
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.add("我是最后一个");
        list.print(list.head);// 从head节点开始遍历输出
        list.nodeNum();
        list.delete(2);
        list.print(list.head);
        list.nodeNum();
        
        list.delete(2);
        list.print(list.head);
        list.nodeNum();
    }

}
class Node {
    
    Object data; //数据域
     Node next;//指针域

    public Node(Object data2) {
        this.data = data2;
    }
}


/*方法nodeNumber里面的
 * int nodeNumber=0;
 
if(head==null){
	System.out.println("结点为空!!");
	return;
}
else{
	current=head;
	while(current!=null){
	nodeNumber++;
	current=current.next;
	}
}
System.out.println("结点数为："+nodeNumber);

*/