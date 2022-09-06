package chapter07;

public class Method02 {
    public static void main(String[] args) {
        int[][] map = { { 0, 0, 1 }, { 1, 1, 1 }, { 1, 1, 3 } };
        MyTools tool = new MyTools();
        tool.printArr(map);
    }
}

class MyTools {
    public void printArr(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
