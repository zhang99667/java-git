package Abstract_;

public class Abstract01 {
    public static void main(String[] args) {

    }
}

abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    // 思考：这里 eat，这里你实现了，但是没有什么意义
    // 即:父类方法不确定性
    // ===> 考虑将该方法设计为 抽象（abstract）方法
    // ===> 所谓抽象方法就是没有实现的方法
    // ===> 所谓没有实现就是指，没有方法体

    // ===> 当一个类中存在抽象方法时，需要将该类声明为 abstract

    // 一般来说，抽象类会被继承，尤其子类进行重写
    public abstract void eat();
}