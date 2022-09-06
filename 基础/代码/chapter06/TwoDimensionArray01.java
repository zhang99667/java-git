package chapter06;

public class TwoDimensionArray01 {
    public static void main(String[] args) {

        int[][] arr = { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0 }, { 0, 2, 0, 3, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
        for (int i = 0; i < arr.length; i++) {
            // 得到对应的 arr[i].length 对应的 每一个一维数组的长度
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println("");
        }
    }
}
