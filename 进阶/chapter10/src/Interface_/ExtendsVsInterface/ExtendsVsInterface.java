package Interface_.ExtendsVsInterface;

public class ExtendsVsInterface {
    public static void main(String[] args) {
        LittleMonkey littleMonkey = new LittleMonkey("wuKong");
        littleMonkey.climbing();
        littleMonkey.swimming();
    }
}

// 猴子
class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public void climbing() {
        System.out.println(this.name + "猴子会爬树");
    }

    public String getName() {
        return name;
    }
}

// 接口
interface Fishable {
    void swimming();
}

interface Birdable {
    void flying();
}

// 继承
class LittleMonkey extends Monkey implements Fishable, Birdable {
    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(this.getName() + "通过学习可以像鱼儿一样游泳！");
    }


    @Override
    public void flying() {
        System.out.println(this.getName()+"通过学习可以向像鸟儿一样飞翔");
    }
}