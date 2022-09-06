package Enum_;

public class EnumDetail {
    public static void main(String[] args) {
        Music.CLASSMUISC.playing();
    }
}

// enum 默认 继承 Enum 类，java 是单继承机制
// No extends clause allowed for enum
// enum Season04 extends A {}

class A {

}

interface IPlaying {
    public void playing();
}

enum Music implements IPlaying {
    CLASSMUISC;

    @Override
    public void playing() {
        System.out.println("play the music");
    }
}

