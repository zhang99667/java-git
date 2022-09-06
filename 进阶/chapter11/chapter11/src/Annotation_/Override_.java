package Annotation_;

public class Override_ {
    public static void main(String[] args) {

    }
}

class Father {
    public void fly() {
        System.out.println("Father fly...");
    }
}

class Son extends Father {
    // 1. @Override 注解放在 fly 方法上，表示子类的 fly 方法重写了父类的 fly
    // 2. 这里如果没有写 @Override ，还是重写了父类方法
    // 3. 如果那你写了 @Override Annotation ，编译器就会检查该方法是不是重写了父类的方法。如果没有构成重写，则编译错误。
    @Override // 注解
    public void fly() {
        super.fly();
    }
}