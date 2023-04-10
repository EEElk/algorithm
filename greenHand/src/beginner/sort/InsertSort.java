package beginner.sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{46, 5, 7, 10, 8, 6, 9, 3, 0, 2, 4, 1, 5};
        printArr(arr);
        sort(arr);
        printArr(arr);
    }

    private static void sort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        // 0 ~ 0
        // 0 ~ 1
        // 0 ~ n-1
        int N = arr.length;
        for (int end = 1; end <= N - 1; end++) {
            int newNumIndex = end;
            while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]) {
                swap(arr, newNumIndex - 1, newNumIndex);
                newNumIndex--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
