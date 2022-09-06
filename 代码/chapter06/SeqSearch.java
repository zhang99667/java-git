package chapter06;

import java.util.Scanner;

public class SeqSearch {
    public static void main(String[] args) {
        String[] name = { "白眉鹰王", "金毛狮王", "紫衫龙王", "青翼蝠王" };
        Scanner myScanner = new Scanner(System.in);

        System.out.println("请输入名字");
        String findName = myScanner.next();

        int index = -1; // 下标
        for (int i = 0; i < name.length; i++) {
            if (findName.equals(name[i])) {
                System.out.println("恭喜你找到 " + findName);
                System.out.println("下标为 = " + i);
                index = i;
                break;
            }
        }
        if (index == -1)
            System.out.println("未找到 " + findName);
        myScanner.close();
    }
}
