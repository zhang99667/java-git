package chapter07.Homework;

public class Homework08 {
    public static void main(String[] args) {
        Music music = new Music("笑傲江湖", 300);
        System.out.println(music.getInfo());
        music.play();
    }
}
// 定义 Music 类，里面有音乐名 name、音乐时长 times 属性
// 并有播放 play 功能和返回本身属性信息的功能方法getInfo

class Music {
    String name;
    int times;

    public Music(String name, int times) {
        this.name = name;
        this.times = times;
    }

    public void play() {
        System.out.println("playing···");
    }

    public String getInfo() {
        return "音乐名：" + this.name + "    " + "音乐时长：" + times;
    }
}