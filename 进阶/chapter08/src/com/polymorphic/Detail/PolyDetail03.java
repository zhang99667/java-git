package com.polymorphic.Detail;

public class PolyDetail03 {
    public static void main(String[] args) {
        BB bb = new BB();
        System.out.println(bb instanceof BB);
        System.out.println(bb instanceof AA);

        AA aa = new BB(); //运行类型是BB
        System.out.println(aa instanceof AA);

        AA aa1 = new AA();
        System.out.println(aa1 instanceof BB);//false
    }


}

class AA {
}// 父类

class BB extends AA {
} // 子类
