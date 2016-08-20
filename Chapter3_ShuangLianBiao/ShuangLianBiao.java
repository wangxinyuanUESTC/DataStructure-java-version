package Chapter3_ShuangLianBiao;
/*
 * 自己写的链式双向循环链表，其中add和delete都是在头结点的后面操作 也就是在第一个位置操作 相当于栈删除的是最后加入的
 * 注意 在LinkedList中add,addlast,offer offerlast相同相当于队列方法
 *                    addfirst, offerfirst ,push相同 相当于栈方法
 */
public class ShuangLianBiao {
	int  size=0;
	Node3 nil=new Node3(null);//表示空的头两边的指针分别指向第一个元素和最后一个元素
	Node3 current;
    public ShuangLianBiao(){  //如果没有这个初始化的话 会抛出异常
    	nil.next=nil.pre=nil;//初始化 自己指向自己
    }
    public int size(){
    	return size;
    }
	public void  addfirst(Object a){//此方法相当于源码中的addFirst以及栈中的push()在头后面加元素  也可以在头的前面插入 这样时间复杂度是O[1]
      Node3 NodeNumber=new Node3(a);
      if(nil.next==null){//如果只有头结点
    	    NodeNumber.pre=nil.pre;//定义两个相同的引用 他们指向同一个对象
    	    NodeNumber.next=nil.next;//和上面的含义相同
    	    nil.pre=NodeNumber;//把头结点的前指针指向要加入的元素
			nil.next=NodeNumber;//把头结点的后指针指向要插入的元素 
			size++;
      }
		else{
			NodeNumber.next=nil.next; //定义两个引用相同 指向同一对象 算法导论中的1,2步
			nil.next.pre=NodeNumber;  //定义两个引用相同 指向同一对象
			nil.next=NodeNumber;
			NodeNumber.pre=nil;
		    size++;
		}
    }
    public void removefirst(){ //相当于栈方法中的pop和removefirst把头结点后面的删除掉
    	if(size==0){
    	    System.out.println("没有结点，无法删除！");
    		return;
    	}else{
    		nil.next.next.pre=nil;//先把第三个结点（包括头结点）的前指针指向头结点
    		nil.next=nil.next.next;//然后把头结点的后指针指向第三个结点  两行代码互换也可以
    	    size--;
    	}
    }
    public void insert(int index,Object data){//插入到index的后面
    	Node3 insertNode=new Node3(data);
    	if(index==0)
    		addfirst(data);
    	else{
    		Node3 preNode=serach(index);
    		insertNode.next=preNode.next;//先把插入元素和后面的元素连接
    		preNode.next.pre=insertNode;
    		preNode.next=insertNode;
    		insertNode.pre=preNode;
    		//用下面的也可以先把插入元素分别连一边
//        	insertNode.next=preNode.next;
//        	insertNode.pre=preNode.next.pre;
//        	preNode.next=insertNode;
//        	preNode.next.pre=insertNode;
    	}
    }
    public Node3 serach(int index){  //根据索引查找元素  从第一个有效值开始
    	if(size==0||index==0||index>size)
    	    System.out.println("错误！没有要找的元素！");
    	else{ 
    		current=nil;
    		if(index>size/2){
    		    for(int i=size;i>=index;i--)
    			   current=current.pre;
    		}
    		if(index<=size/2){
    			for(int j=0;j<index;j++)
    				current=current.next;
    		}
    	}
			return current;
    }
    public void print(){
    	current=nil.next;
    	while(current.data!=null){//注意千万不能用current！=null因为双链表会循环输出
    		System.out.println(current.data);
    		current=current.next;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShuangLianBiao slb=new ShuangLianBiao();
		slb.addfirst(1);
		slb.addfirst(2);
		slb.addfirst("wang");
		slb.addfirst(3);
		slb.addfirst('a');
		slb.insert(2, "xin");
//		slb.removefirst();
		slb.print();
		System.out.println("size:"+slb.size());
		System.out.println("要找的元素为："+slb.serach(4).data);
		
	}
}
class Node3{
	Node3 next;
	Node3 pre;
	Object data;
	public Node3(Object data){
		this.data=data;

	}
}