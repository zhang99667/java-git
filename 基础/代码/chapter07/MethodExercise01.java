package chapter07;

public class MethodExercise01 {
    public static void main(String[] args) {
        BB b = new BB();
        if (b.isOdd(2) == true)
            System.out.println(true);
        else
            System.out.println(false);

        b.print(4, 4, '*');
    }
}

class BB {
    // 编写类BB,有一个方法：判断一个数是奇数odd还是偶数，返回boolean
    public boolean isOdd(int number) {
        return number % 2 == 0 ? true : false;
    }

    // 根据行、列、字符打印对应行数和列数的字符
    // 比如：行：4，列：4，字符 #,则打印相应的效果
    public void print(int row, int col, char c) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
