package Exception_.Try;

class TryCatchDetail01 {
    public static void main(String[] args) {
        // ctrl + alt + t
        try {
            String str = "韩顺平";
            int a = Integer.parseInt(str); // 这里出错
            System.out.println("数字：" + a); // 所以这条语句不执行
        } catch (NumberFormatException e) {
            System.out.println("异常信息：" + e.getMessage());
        } finally {
            System.out.println("finally 代码块被执行...");
        }

        // 继续执行
        System.out.println("程序继续...");
    }
}