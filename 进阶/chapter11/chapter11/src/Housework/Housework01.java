package Housework;

/*
 *
 * 枚举类
 * 1. 创建一个 Color 枚举类
 * 2. 有 RED, BLUE, BLACK, YELLOW, GREEN 这个五个枚举值/对象；
 * 3. Color 有三个属性 redValue, greenValue, blueValue
 * 4. 创建构造方法，参数包括这三个属性，
 * 5. 每个枚举值都要给这三个属性赋值，三个属性对应的值分别是
 * 6. red: 255,0,0
 *    blue: 0,0,255
 *    black: 0,0,0
 *    yellow: 255,255,0
 *    green: 0,255,0
 * 7. 定义接口，里面有方法 show, 要求 Color 实现该接口
 * 8. show 方法中显示三属性的值
 * 9. 将枚举对象在 switch 语句中匹配使用
 * */
public class Housework01 {
    public static void main(String[] args) {
        Color color = Color.BLUE;

        switch (color) {
            case YELLOW:
                System.out.println("yellow");
                break;
            case BLUE:
                System.out.println("blue");
                break;
            case BLACK:
                System.out.println("black");
                break;
            case GREEN:
                System.out.println("green");
                break;
            default:
                System.out.println("什么也没匹配到...");
                break;
        }
    }
}

enum Color implements showColor {
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    BLACK(0, 0, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0);

    private final int redValue;
    private final int greenValue;
    private final int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("属性值：(" + redValue + "," + greenValue + "," + blueValue + ")");
    }
}

interface showColor {
    void show();
}
