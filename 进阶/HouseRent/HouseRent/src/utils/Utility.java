package utils;
import java.util.Scanner;

public class Utility {
    private static final Scanner myScanner = new Scanner(System.in);


    public static String readString(int limit, String defaultValue) {
        String str; // 接收字符串的变量

        while (true) {
            str = myScanner.next();
            if (str.length() > limit)
                System.out.printf("输入长度（不能大于%d）错误，请重新输入：", limit);
            else break;
        }
        return str.equals("") ? defaultValue : str; // 如果字符串为空 返回默认值，否则返回 输入字符串
    }

    // 只判断输入长度
    public static String readChar(int limit) {
        String str; // 接收字符串的变量

        while (true) {
            str = myScanner.next();
            if (str.length() > limit)
                System.out.printf("输入长度（不能大于%d）错误，请重新输入：", limit);
            else break;
        }
        return str;
    }

    // 无参传递，直接返回输入字符串
    public static char readChar() {
        return myScanner.next().charAt(0);
    }

    // 无参传递，直接返回输入浮点型
    public static double readDouble() {
        return myScanner.nextDouble();
    }

    // 无参传递，直接返回输入整数型
    public static int readInt() {
        return myScanner.nextInt();
    }

    /* 确认选择 Y/N
     * 返回类型：boolean
     * y 返回 true
     * n 返回 false
     *  */
    public static boolean readConfirmSelection() {
        char key;
        while (true) {
            System.out.print("确认是否删除（Y/N）：）");

            key = Utility.readChar(); // 获取输入信息
            if (key == 'y' || key == 'Y' || key == 'n' || key == 'N') {
                break;
            } else
                System.out.println("输入有误！请重新输入！");
        }
        // 如果 key == y或Y 返回 true 否则返回 false
        return key == 'y' || key == 'Y';
    }

    /*
     * 读取用户输入房屋ID
     * -1 表示退出 返回 -1
     * 输入其他字符 返回 输入的ID
     * */
    public static int readHouseID() {
        int readID;
        while (true) {
            System.out.print("请输入房屋ID（'-1'退出）：");
            readID = Utility.readInt(); // 读取输入 ID
            if (readID < -1)
                System.out.println("输入有误！请重新输入！");
            else
                break;
        }
        return readID;
    }


    public static void closeScanner() {
        myScanner.close();
    }
}
