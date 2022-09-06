package Exception_.Housework;

/*
 *
 * a) 编写应用程序 EcmDef.java ,接收命令行的两个参数（整数），计算两数相除。
 * b) 计算两个数相除，要求使用方法 cal(int n1,int n2)
 * c) 对数据格式不正确(NumberFormatException)、缺少命令行参数(ArrayIndexOutOfBoundsException)、除 0 进行异常处理(ArithmeticException)。
 *
 *   */
public class Housework02 {
    public static void main(String[] args) {

        try {
            // 先验证输入的参数个数是否正确，两个参数
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("参数个数不正确");
            }
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            System.out.println("计算结果：" + cal(n1, n2));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("参数格式不正确，需要输出整数");
        } catch (ArithmeticException e) {
            System.out.println("出现了除 0 异常");
        }

    }

    public static double cal(int n1, int n2) throws ArrayIndexOutOfBoundsException, DefExcepton, ArithmeticException, NumberFormatException {
        return n1 / n2;
    }
}

class DefExcepton extends RuntimeException {

    public DefExcepton(String message) {
        super(message);
    }
}