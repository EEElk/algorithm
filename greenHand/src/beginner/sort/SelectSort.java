package beginner.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{46, 5, 7, 10, 8, 6, 9, 3, 0, 2, 4, 1, 5};
        printArr(arr);
        sort(arr);
        printArr(arr);
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minValueIndex = arr[minValueIndex] < arr[j] ? minValueIndex : j;
            }
            swap(arr, i, minValueIndex);
        }
    }

    private static void swap(int[] arr, int i, int minValueIndex) {
        int tmp = arr[i];
        arr[i] = arr[minValueIndex];
        arr[minValueIndex] = tmp;
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
