package Housework;

/*
    1. 在 Frock 类中声明私有的静态属性 currentNum [int类型]，初始值为 100000，作为衣服出厂的序列号起始值。
    2. 声明公有的静态方法 getNextNum,作为生成上衣唯一序列号的方法。每调用一次，将 currentNum 增加100，并作为返回值。
    3. 在 TestFrock 类的 main 方法中，分两次调用 getNextNum 方法，获取序列号并打印输出。
    4. 在 Frock 类中声明 serialNumber (序列号) 属性，并提供对应的 get 方法；
    5. 在 Frock 类的构造器中，通过调用 getNextNum 方法为 Frock 对象获取唯一序列号，赋给 serialNumber 属性。
    6. 在 TestFrock 类的 main 方法中，分别创建三个 Frock 对象，并打印三个对象的序列号，验证是否为按 100 递增。
*/
public class Housework02 {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());
        Frock frock = new Frock();
        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        System.out.println(frock2.getSerialNumber());
    }
}

class Frock {
    static int currentNum = 100000;

    private int serialNumber;

    // 无参构造器
    public Frock() {
        this.serialNumber = this.getNextNum();
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }
}
