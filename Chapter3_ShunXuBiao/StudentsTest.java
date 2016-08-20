package Chapter3_ShunXuBiao;
/*
 * 通过顺序表测试学生的信息
 */


public class StudentsTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SequenceList list1 = new SequenceList(100);

        try {
            list1.insert(list1.size, new Students("S0001", "张三", "男", 18)); 
            //第一个参数list.size代表的是：我每次都是在顺序表的最后一个位置（当前线性表的长度的位置）进行插入操作。这一行里，size是等于0
            list1.insert(list1.size, new Students("S0002", "李四", "男", 19));
            list1.insert(list1.size, new Students("S0003", "王五", "女", 21));

            for (int i = 0; i < list1.size; i++) {
                System.out.println(list1.get(i));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}


/*
 * 顺序表的应用，存储学生信息
 */
//学生类
 class Students {

  private String id;// 学号
  private String name;// 姓名
  private String gender;// 性别
  private int age;// 年龄

 

  public Students(String sid, String name, String gender, int age) {
      this.id = sid;
      this.name = name;
      this.gender = gender;
      this.age = age;
  }

public String getId() {
      return id;
  }

  public void setId(String id) {
      this.id = id;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getGender() {
      return gender;
  }

  public void setGender(String gender) {
      this.gender = gender;
  }

  public int getAge() {
      return age;
  }

  public void setAge(int age) {
      this.age = age;
  }

  public String toString() {
      return "学号：" + this.getId() + " 姓名：" + this.getName() + " 性别：" + this.getGender() + " 年龄:" + this.getAge();
  }

}


