package chapter03;
public class ChangeChar {
    public static void main(String[] args) {
        // \t :一个制表位，实现对其功能
        System.out.println("Beijing \t Lanzhou \t Taiyuan");
        // \n :换行符
        System.out.println("jack\nsmith \nmary");
        // \\ :一个\
        System.out.println("E:\\Download\\Adobe\\2020\\Adobe Photoshop2020");
        // \" :一个"
        System.out.println("老韩说:\"要好好学习java,有前途\"");
        // \' :一个'
        System.out.println("老韩说：\'要好好学习java，有前途\'");

        // \r :一个回车 System.out.println("韩顺平教育\r北京");
        //解读
        // 1. 输出 韩顺平教育
        // 2. \r表示回车
        System.out.println("韩顺平教育\r北京"); // 北京平教育
        System.out.println("韩顺平教育\r\n北京"); // 北京韩顺平教育
    }
}
