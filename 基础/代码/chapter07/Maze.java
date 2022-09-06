package chapter07;

public class Maze {
    public static void main(String[] args) {
        // 思路
        // 1.先创建迷宫，用二维数组表示int[][] map = new int[8][7];
        // 2.先规定map数组的元素值：0 表示可以走 1 表示障碍物

        int[][] map = new int[8][7];
        // 3.将第一行和最后一行，全部设置 1
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1; // 第一行设置为 1
            map[7][i] = 1; // 最后一行设置为 1
        }
        // 4.将第一列和最后一列，全部设置 1
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[2][1] = 1; // 测试回溯

        map m = new map();
        m.printMap(map);

        m.findWay(map, 1, 1);
        m.printMap(map);
    }

}

class map {
    // 找到返回 true ，否则返回 false
    // i,j为老叔的位置，初始化为1,1
    // 当 map[6][5]=2，说明找到通路，可以结束
    // 先确定老鼠找路策略， 下 -> 右 -> 上 -> 左
    // 0 表示未走 ；1 表示障碍物 ；2 表示可以走 ；3 表示走过，死路
    public boolean findWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {// 当前位置 0 ，表示可以走
                // 假定可以走通
                map[i][j] = 2;
                // 使用找路策略，来确定该位置是否真的可以走通
                // 下 -> 右 -> 上 -> 左
                if (findWay(map, i + 1, j)) { // 向下
                    return true;
                } else if (findWay(map, i, j + 1)) { // 向右
                    return true;
                } else if (findWay(map, i - 1, j)) { // 向上
                    return true;
                } else if (findWay(map, i, j - 1)) { // 向左
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else { // map[i][j] == 1,2,3 即 改路已经走过
                map[i][j] = 3;
                return false;
            }
        }

    }

    // 输出当前地图
    public void printMap(int[][] map) {
        System.out.println("=========== 当前地图 ===========");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }
}