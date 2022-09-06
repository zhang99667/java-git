package Enum_.EnumerationExercise;

/*
 * 1)声明Week枚举类，其中包含星期一至星期日的定义；
 *      MONDAY,TUESDAY,WEDNESDAY,THURSDAY,
 *      FRIDAY,SATURDAY,SUNDAY:
 * 2)使用values返回所有的枚举数组，并遍历
 * */
public class EnumExercise02 {
    public static void main(String[] args) {
        System.out.println("===所有星期信息如下===");
        for (Week week :
                Week.values()) {
            System.out.println(week);
        }
    }
}


enum Week {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");
    private String Chinese;

    Week(String chinese) {
        this.Chinese = chinese;
    }

    @Override
    public String toString() {
        return this.Chinese;
    }
}