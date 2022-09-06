package Housework.Housework07;

/*
 *
 * 有一个 Car 类，有属性 temperature(温度)，车内有 Air(空调) 类，有吹风的功能 flow,
 * Air 会监视车内的温度，如果温度超过 40 度则吹冷气。如果温度低于 O 度则吹暖气，
 * 如果在这之间则关掉空调。实例化具有不同温度的 Car 对象，调用空调的 flow 方法，
 * 测试空调吹的风是否正确·//体现类与类的包含关系的案例类（内部类【成员内部类】）
 *
 *  */
public class Car {
    private double temperature;

    // 构造器
    public Car(double temperature) {
        this.temperature = temperature;
    }

    void openAirCondition() {
        new Air().flow();
    }

    // 内部成员类
    class Air {

        public void flow() {
            monitor();
        }

        // 监视器，检测温度
        public void monitor() {
            if (temperature >= 40)
                System.out.println("吹冷气...");
            else if (temperature <= 0)
                System.out.println("吹暖气...");
            else System.out.println("关闭空调...");
        }
    }
}
