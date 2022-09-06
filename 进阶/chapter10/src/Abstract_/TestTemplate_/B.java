package Abstract_.TestTemplate_;

public class B extends Template {
    // 计算任务：
    // 1+...+10000

    @Override
    public void job() {
        long result = 1; // 计算结果
        for (int i = 1; i < 800000; i++) {
            result += i;
        }
        System.out.println("结果：" + result);
    }
}
