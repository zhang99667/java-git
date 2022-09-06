package Annotation_;

public class Deprecated_ {

    public static void main(String[] args) {
        A a = new A();
        a.hi();
    }
}

@Deprecated
// 1. @Deprecated 修饰某个元素，表示钙元素已过时
// 2. 即不在推荐使用，但仍可以使用

class A {
    public int n1 = 10;

    public void hi() {

    }
}