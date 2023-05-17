package class08;

public class Code01_MergeSort {
    // 解法一：通过递归的方式解决，将数组分为左右两份，后归并
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 走到这，代表arr的长度至少为2
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        // 左右边界相同，代表已排好序
        if (L == R) {
            return;
        }
        // 走到这，代表左右边界不一致
        // 注意，这里右移1位一定要加括号
        int mid = L + ((R - L) >> 1);
        // 将左右区间排好序
        process(arr, L, mid);
        process(arr, mid + 1, R);
        // 排好序后，需要将左右区间归并
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = M + 1;
        int i = 0;
        //  右边界能取到，所以是<=
        while (p1 <= M && p2 <= R) {
            if (arr[p1] < arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
        }
        // 跳出循环时，肯定有个指针超过右边界，如果哪个没有超过将后续的值补上
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        // 将help数组的元素回写到arr区间[L,R]
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }
}
