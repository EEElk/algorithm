package random;

/**
 * 题设：根据输入的maxLen(数组最大长度)和maxValue(数组每个元素最大的值)，返回一个数组。数组长度随机，数组元素值随机。
 * 要求：生成数组n次，去验证排序算法是否正确, 排序完后数字由小到大排列。
 */
public class RandomValidateSortMethod {
    public static void main(String[] args) {
        int maxLen = 100;
        int maxValue = 1000;
        int runtimes = 10000;
        for (int i = 0; i < runtimes; i++) {
            int[] randomArr = createLenAndValueRandomArr(maxLen, maxValue);
            selectSort(randomArr);
            if (!isSorted(randomArr)) {
                System.out.println("选择排序错误");
            }
        }
    }

    /**
     * 利用随机数生成一个长度随机、值随机的数组
     * @return 数组
     */
    private static int[] createLenAndValueRandomArr(int maxLen, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxLen)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }

    /**
     * 判断是否排序
     * @param randomArr
     * @return
     */
    private static boolean isSorted(int[] randomArr) {
        if (randomArr.length < 2) {
            return true;
        }
        int maxVal = randomArr[0];
        for (int i = 1; i < randomArr.length; i++) {
            if (maxVal > randomArr[i]) {
                return false;
            }
            maxVal = randomArr[i];
        }
        return true;
    }

    /**
     * 选择排序
     */
    private static void selectSort(int[] arr) {
        // 1.处理边界
        if (arr == null || arr.length < 2) {
            return;
        }
        // 2.找规律做排序
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i; j < arr.length; j++) {
                // 找到 i ~ n-1位置最小的数，得到下标赋值给minIdx
                minIdx = arr[j] < arr[minIdx] ? j : minIdx;
            }

            if (arr[i] == arr[minIdx]) {
                continue;
            }
            // 交换i和minIdx的位置
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
}
