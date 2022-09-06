package Exception_.Try;

class TryCatchDetail02 {
    public static void main(String[] args) {
        // 1. 如果 try 代码块有多个异常
        // 2. 可以使用多个 catch 分别捕获不同的异常，相应处理
        // 3.
        try {
            Person person = new Person();
            person = null;
            System.out.println(person.getName()); // NullPointerException
            int n1 = 10;
            int n2 = 0;
            int res = n1 / n2; // ArithmeticException
        } catch (NullPointerException e) {
            System.out.println("空指针异常：" + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("算数异常：" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally被执行...");
        }
    }
}

class Person {
    private String name = "jack";

    public String getName() {
        return this.name;
    }
}