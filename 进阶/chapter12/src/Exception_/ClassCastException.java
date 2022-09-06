package Exception_;

class ClassCastException {
    public static void main(String[] args) {
        A b = new B(); // 向上转型
        B bw = (B) b; // 向下转型
        C c2 = (C) b; // 不可以，因为 B 和 C 之间没有任何关系，所以会抛出 ClassCastException 异常
    }
}

class A {
}

class B extends A {
}

class C extends A {
}