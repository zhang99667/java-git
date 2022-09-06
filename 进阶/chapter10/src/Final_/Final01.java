package Final_;

public class Final01 {
    public static void main(String[] args) {

    }
}

// 如果我们要求 A 类 不能被其他类继承
// 可以使用 final 修饰 A 类
final class A {
}

// class B extends A{}

class C {
    // 如果我们 不希望 hi 方法不能被子类重写
    // 可以使用 final 修饰 hi 方法
    public final void hi(){}
}

class D extends C {
    // @Override
    // public void hi() {
    //     System.out.println("重写了C类的hi方法");
    // }
}

class E {
    // 如果不希望类的某个属性的值被修改，可以使用 final 修饰
    public final double TAX_RATE = 0.08;
    // TAX_RATE=0.3;
}

// 不希望某个局部变量被修改，可以使用 final 修饰
class F{
    public void cry(){
        final double num=0.01;
        // num=0.9; // 不能对 num 进行修改
        System.out.println(num);
    }
}