package class01;

/**
 *   [ 2 1 3 7 6 5 8 ]
 *      0-7:第1个和第2个比较 ,小的交换在左 ; 第2个和第3个比较 ,小的交换在左; ......
 *      0-6:第1个和第2个比较 ,小的交换在左 ; 第2个和第3个比较 ,小的交换在左; ......
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{46, 5, 7, 10, 8, 6, 9, 3, 0, 2, 4, 1, 5};
        printArr(arr);
        bubbleSort(arr);
        printArr(arr);
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        // 0 ~ n-1
        // 0 ~ n-2
        // 0 ~ end
        int N = arr.length;
        for (int end = N - 1; end >= 0; end--) {
            // 0 ~ end 上做的事情
            for (int second = 1; second <= end; second++) {
                if (arr[second - 1] > arr[second]) {
                    swap(arr, second - 1, second);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void printArr(int[] arr) {
        for (int j : arr) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }
}
