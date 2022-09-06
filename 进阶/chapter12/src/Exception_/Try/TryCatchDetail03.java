package Exception_.Try;

class TryCatchDetail03 {
    public static void main(String[] args) {

        try {
            int n1 = 10;
            int n2 = 0;
            System.out.println(n1 / n2);
        } finally {
            // 无论是否发生异常都去执行
            System.out.println("执行了 finally");
        }
        System.out.println("程序继续执行...");
    }
}
