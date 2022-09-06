package chapter07;

public class VarParametErexercise {
    public static void main(String[] args) {
        HspMethod2 tool = new HspMethod2();
        System.out.println(tool.showScore("张二", 90, 80, 70));
        System.out.println(tool.showScore("张三", 58, 59, 61, 119));
    }
}

class HspMethod2 {

    /*
     * 有三个方法：
     * 分别实现返回姓名和两门课成绩（总分），返回姓名和三门课成绩（总分)，返回姓名和五门课成绩（总分）
     * 封装成一个可变参数的方法
     */
    public String showScore(String name, int... scores) {
        int sum = 0; // 总分
        for (int i = 0; i < scores.length; i++)
            sum += scores[i];
        return name + "有 " + scores.length + " 门课，总成绩为 " + sum;
    }
}
