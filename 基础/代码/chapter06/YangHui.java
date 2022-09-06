package chapter06;

public class YangHui {
    public static void main(String[] args) {
        int[][] yanghui = new int[10][]; // 定义数组

        for (int i = 0; i < yanghui.length; i++) {
            yanghui[i] = new int[i + 1];
            for (int j = 0; j < yanghui[i].length; j++) {
                if (j == 0 || j == yanghui[i].length - 1)
                    yanghui[i][j] = 1; // 第一个和最后一个元素为1
                else
                    yanghui[i][j] = yanghui[i - 1][j] + yanghui[i - 1][j - 1]; // 中间的元素

            }
        }

        // 输出杨辉三角
        for (int i = 0; i < yanghui.length; i++) {
            for (int j = 0; j < yanghui[i].length; j++) {
                System.out.printf("%d ", yanghui[i][j]);
            }
            System.out.println("");
        }
    }
}
