package class03;

import java.util.Arrays;

/**
 * 二分法：每次从数组的中间开始找，如果中间位置刚好是Num就结束，否则
 * - 中间值 < num, 继续往右找, left = middle + 1
 * - 中间值 > num, 继续往左找, right = middle - 1
 */
public class BinarySearchWithSort {
    public static void main(String[] args) {
        int maxLength = 5;
        int maxValue = 10;
        int testTimes = 1; // 测试次数
        boolean succedFlag = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxLength, maxValue);
            Arrays.sort(arr);
            int num = (int) (Math.random() * (maxValue + 1));
            if (findNumIndex(arr, num) != test(arr, num)) {
                System.out.println("出错了......num=" + num);
                for (int a : arr) {
                    System.out.print(a + " ");
                }
                System.out.println();
                succedFlag = false;
            }
        }
        System.out.println(succedFlag ? "验证通过" : "二分查找算法有问题需要修改。");
    }



    public static int findNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if (arr[mid] == num){
                return mid;
            } else if (arr[mid] < num) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 生成随机数组 - 用于测试算法正确性
     *
     * @param maxLenth
     *            随机数组的最大长度，范围在 1 ~ maxLength
     * @param maxValue
     *            随机数组每个元素最大值, 范围在 1 ~ maxValue
     * @return 生成的随机数组
     */
    public static int[] generateRandomArray(int maxLenth, int maxValue) {
        int arrLength = (int) (Math.random() * (maxLenth + 1));
        int[] randomArray = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            randomArray[i] = (int) (Math.random() * (maxValue + 1));
        }
        return randomArray;
    }

    public static int test(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                result = i;
                break;
            }
        }
        return result;
    }
}
