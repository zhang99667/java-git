package Exception_;

class NumberFormatException {
    public static void main(String[] args) {
        String name = "1234";
        String name1 = "韩顺平教育";
        // 将 String 转换为 int
        int num = Integer.parseInt(name);
        int num2 = Integer.parseInt(name1); // 抛出 NumberFormatException 异常
        System.out.println("num"); // 1234
    }
}