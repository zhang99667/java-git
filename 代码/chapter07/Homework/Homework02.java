package chapter07.Homework;

public class Homework02 {
    public static void main(String[] args) {
        A02 a02 = new A02();
        String str = "zhangzhen";
        Integer res = a02.find(str, 'g');
        if (res != null)
            System.out.println("index = " + res);
        else
            System.out.println("输入有误！");

    }
}

// 编写类 A02，定义方法 find，实现查找某字符串是否在字符串数组中。
// 并返回索引，如果找不到，返回 -1。
class A02 {
    public Integer find(String strs, char c) {
        if (strs != null) {
            int index = -1;
            for (int i = 0; i < strs.length(); i++) {
                if (c == strs.charAt(i))
                    index = i;
            }
            return index;
        } else
            return null;
    }
}