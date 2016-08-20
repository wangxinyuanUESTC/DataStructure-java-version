package Chapter3_ShunXuBiao;

public class Test {

    public static void main(String[] args) {

        SequenceList list = new SequenceList(20);

        try {
            list.insert(0, 100);//在第一个位置插入数据
            list.insert(0, 50);//也在第一个位置插入数据
            list.insert(1, 20);
            list.insert(2, 200);
            list.insert(3, "dfsds");//可以插入不同类型的数据
            list.insert(4, "王新源");
            list.insert(3,'d' );
            for (int i = 0; i < list.size; i++) {
                System.out.println("第" + i + "个数为：" + list.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}