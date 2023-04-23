package class01;

/**
 * 从第一个元素开始，该元素默认已经排好序。
 * 然后，取出下一个元素，在已经排好序的元素序列从后向前扫描；
 * 如果该元素大于新元素，将该元素移到下一个位置，直到找到已排序的元素小于或者等于新元素的位置；
 * 将新元素插入到该位置后，重复上述步骤，直到排序完成。
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{46, 5, 7, 10, 8, 6, 9, 3, 0, 2, 4, 1, 5};
        printArr(arr);
        OptimizeSort(arr);
        printArr(arr);
    }

    /**
     * 优化插入排序
     *
     * @param arr
     */
    private static void OptimizeSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        // 0 ~ 0
        // 0 ~ 1
        // 0 ~ n-1
        int N = arr.length;
        for (int end = 1; end <= N - 1; end++) {
            for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                swap(arr, pre, pre + 1);
            }
        }
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
        for (int j : arr) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }
}
