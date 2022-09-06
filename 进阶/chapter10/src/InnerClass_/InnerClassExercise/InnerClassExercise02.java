package InnerClass_.InnerClassExercise;

/*
 *   1.有一个铃声接口BelL,里面有个ring方法。（右图）
 *   2.有一个手机类Cellphone,具有闹钟功能alarmClock,参数是Bell类型（右图）
 *   3.测试手机类的闹钟功能，通过匿名内部类（对象）作为参数，打印：懒猪起床了
 *   4.再传入另一个匿名内部类（对象），打印：小伙伴上课了
 */
public class InnerClassExercise02 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        // 1. 传递的是实现了 Bell 接口的匿名内部类 InnerClassExercise02$1
        // 2. 重写了 ring
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });

        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
    }
}


// 手机类
class CellPhone {
    // 闹钟
    public void alarmClock(Bell bell) {
        bell.ring();
    }
}

// 铃声接口
interface Bell {
    void ring();
}