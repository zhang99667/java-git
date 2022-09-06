package chapter07;

public class MethodExercise02 {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "tom";
        p.age = 19;
        myTools tools = new myTools();

        tools.print(5, 5, '*'); // 打印二维数组

        Person p2 = tools.copyPerson(p);// 克隆对象
        System.out.println("p2.name = " + p2.name + " p2.age = " + p2.age);

        // 可以通过对象比较看看是否为同一个对象
        p2.name = "jack";
        p2.age = 0;
        System.out.println("p.name = " + p.name + " p.age = " + p.age);
        // p 和 P2 不是同一个存储空间


    }
}

class myTools {

    // 编写类MyTools类，编写一个方法可以打印二维数组的数据。
    public void print(int row, int col, char c) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    // 编写一个方法copyPerson,可以复制一个Person对象，返回复制的对象。
    // 克隆对象， 注意要求得到新对象和原来的对象是两个独立的对象，只是他们的属性相同
    public Person copyPerson(Person p) {
        Person p2 = new Person();
        p2.name = p.name;
        p2.age = p.age;
        return p2;
    }
}
