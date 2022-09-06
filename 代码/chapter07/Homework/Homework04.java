package chapter07.Homework;

public class Homework04 {
    public static void main(String[] args) {
        int[] oldArr = { 10, 30, 50 };
        A03 a03 = new A03(oldArr);
        int[] newArr = a03.copyArr();
        for (int i = 0; i < newArr.length; i++) {
            System.out.printf("%d ", newArr[i]);
        }
    }
}

// 编写类 A03，实现数组的复制功能 copyArr，输入旧数组，返回一个新数组，元素和旧数组一样
class A03 {
    int[] oldArr = null;

    // 构造器
    public A03(int[] oldArr) {
        this.oldArr = oldArr;
    }

    public int[] copyArr() {
        // 在堆中，创建一个长度为 old.length 的数组
        int[] newArr = new int[this.oldArr.length];
        // 遍历 oldArr，将元素拷贝到 newArr
        for (int i = 0; i < this.oldArr.length; i++) {
            newArr[i] = this.oldArr[i];
        }
        return newArr;
    }
}