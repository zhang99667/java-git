package Exception_;

class ArrIndexOutBoundsException {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4};
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}