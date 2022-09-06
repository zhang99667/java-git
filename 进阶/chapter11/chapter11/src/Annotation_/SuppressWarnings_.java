package Annotation_;

import java.util.ArrayList;
import java.util.List;

public class SuppressWarnings_ {
    // 1. 当我们不希望看到警告的时候，可以使用 SuppressWarnings 注解去抑制警告信息
    // 可以在 {""} 中，写入你不希望显示的警告信息
    // @SuppressWarnings 的范围和注解的位置有关，放在 main 前，他的作用范围就是 main 函数
    @SuppressWarnings({"rawtypes","unchecked","unused"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        int i;
        System.out.println(list.get(1));
    }
}