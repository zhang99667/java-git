package chapter05;

public class WhileExercise {
    public static void main(String[] args) {
        // 打印1-100之间所有能被3整除的数 【使用whi1e,老师评讲】
        int startNum = 1;
        int endNum = 100;
        while (startNum <= endNum) {
            if (startNum % 3 == 0)
                System.out.println(startNum);
            startNum++;
        }

        // 打印40-200之间所有的偶数 【使用whi1e,课后练习】
        int j = 40;
        while (j <= 200) {
            if (j % 2 == 0)
                System.out.println(j);
            j++;
        }
    }
}
