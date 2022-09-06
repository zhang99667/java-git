package Abstract_.TestTemplate_;

abstract public class Template {
    public abstract void job();

    // 抽出公用部分
    public void calculateTime() {
        long start = System.currentTimeMillis();
        job(); // 动态绑定
        long end = System.currentTimeMillis();
        System.out.println("花费" + (end - start) + "ms");
    }
}