package Housework.Housework07;

/*
 *
 * 有一个 Car 类，有属性 temperature(温度),车内有 Air(空调) 类，有吹风的功能 flow
 * Air会监视车内的温度，如果温度超过 40 度则吹冷气。如果温度低于 0 度则吹暖气，
 * 如果在这之间则关掉空调。实例化具有不同温度的Ca对像
 * 调用空调的 flow 方法，测试空调吹的风是否正确
 *
 *  */
public class Housework07 {
    public static void main(String[] args) {
        new Car(41.4).openAirCondition();
        new Car(28.8).openAirCondition();
        new Car(-10.3).openAirCondition();
    }
}

