package beginner.sort;

/**
 * 1. 先在0～N-1中查找最小的值,然后交换放到0位置
 * 2. 在在1～N-1中查找最小的值,然后交换放到1位置
 * 3. ... ...
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{46, 5, 7, 10, 8, 6, 9, 3, 0, 2, 4, 1, 5};
        printArr(arr);
        sort(arr);
        printArr(arr);
    }

    private static void sort(int[] arr) {
        if (arr == null || arr.length == 1){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minValueIndex = arr[minValueIndex] < arr[j] ? minValueIndex : j;
            }
            swap(arr, i, minValueIndex);
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
