package chapter07;

public class HanoiTower {
    public static void main(String[] args) {
        Tower tower = new Tower();
        tower.move(32, 'A', 'B', 'C');
    }
}

class Tower {
    // 方法
    // num 表示要移动的个数，a，b，c分别表示A塔，B塔，C塔
    public void move(int num, char a, char b, char c) {
        // 如果只有一个盘子 num = 1
        if (num == 1) {
            System.out.println(a + "->" + c);
        } else {

            // 如果有多个盘子，可以看成两个盘子 —— 最下面和上面的所有盘（ num - 1 ）

            move(num - 1, a, c, b); // （1）先移动上面所有盘子到B，借助C

            System.out.println(a + "->" + c); // （2）把最下面的盘子，移动到C

            move(num - 1, b, a, c); // （3）再把B塔所有的盘子，移动到C，借助A
        }
    }
}