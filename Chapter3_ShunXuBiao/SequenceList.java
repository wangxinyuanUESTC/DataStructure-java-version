package Chapter3_ShunXuBiao;
/*
 * 参考 自己又写了一遍
 */
public class SequenceList implements List {

    //默认的顺序表的最大长度
    final int defaultSize = 10;
    //最大长度
    int maxSize;
    //当前长度
    int size;
    //对象数组
    Object[] listArray;
    public SequenceList() {
        init(defaultSize);
    }
 //下面的有参构造函数用于当数组大于默认的10时，人为的增加数组大小
    public SequenceList(int size1) {
        init(size1);
    }

    //顺序表的初始化方法
    private void init(int size2) {
    	//这个表的长度是size2  size是指不为空的数据个数
        maxSize = size2;
        this.size = 0;//这个size是最上面的Size初始化，不要也行，默认为0
        listArray = new Object[size2];
//        System.out.println(listArray[10]);//输出为null,说明数组总长度是不变的 只是为空
    }

    @Override
    public void delete(int index) throws Exception {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            throw new Exception("顺序表为空，无法删除！");
        }
        if (index < 0 || index > size - 1) {
            throw new Exception("参数错误！");
        }
        //移动元素
        for (int j = index; j < size - 1; j++) {
            listArray[j] = listArray[j + 1];//直接用j+1位置的元素覆盖掉要删除的元素
        }
        size--;
    }

    @Override
    public Object get(int index) throws Exception {
        // TODO Auto-generated method stub
        if (index < 0 || index >= size) {
            throw new Exception("参数错误！");
        }
        return listArray[index];
    }

    @Override
    public void insert(int index, Object obj) throws Exception {
        // TODO Auto-generated method stub
        //如果当前线性表已满，那就不允许插入数据
        if (size == maxSize) {
            throw new Exception("顺序表已满，无法插入！");
        }
        //插入位置编号是否合法
        if (index < 0 || index > size) {
            throw new Exception("参数错误！");
        }
        //移动元素
        //当size=index以及size=0时不执行下面的for循环直接在后面添加
        for (int j = size - 1; j >= index; j--) {
            listArray[j + 1] = listArray[j];
        }
        //当size为0时直接执行下面代码

        listArray[index] = obj;  //不管当前线性表的size是否为零，这句话都能正常执行，即都能正常插入
        size++;

    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size == 0;
    }
//这个方法不用也可以
    
//    @Override
//    public int size() {
//        // TODO Auto-generated method stub
//        return size;
//    }
    
}

