package Exception_.Exercise;

class TryCatchExercise01 {
    public static void main(String[] args) {
        System.out.println(method());
    }

    public static int method() {
        try {
            String[] names = new String[3]; // String 数组
            if (names[1].equals("tom")) { // NullPointerException
                System.out.println(names[1]);
            } else {
                names[3] = "hspedu";
                return 1;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) { // 捕获
            return 3;
        } finally {
            // 必须执行
            return 4;// 返回4
        }
    }
}