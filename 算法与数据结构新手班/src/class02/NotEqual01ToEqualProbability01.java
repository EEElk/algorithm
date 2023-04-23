package class02;

/**
 * 题设: 给点一个函数x(), 里面的内容看不到，但是知道x方法会以固定的概率返回0和1(0和1的概率不等)。
 * 要求:返回等概率0和1的随机数。
 */
public class NotEqual01ToEqualProbability01 {
    public static void main(String[] args) {
        int times = 1000000;
        int count = 0;
        for (int i = 0; i < times; i++) {
            if (y() == 0) {
                count++;
            }
        }
        System.out.println("得到0的概率:" + ((double) count / (double) times));
    }

    /**
     * x方法里面的内容看不到，但是知道x方法会以固定的概率返回0和1(0和1的概率不等)
     * @return 不等概率的0和1随机数
     */
    private static int x() {
        return Math.random() < 0.8 ? 0 : 1;
    }

    /**
     * 根据不等概率的01方法，设计一个返回等概率01随机数的方法
     * 00的概率 p^2 ;01的概率 p(1-p) ; 10的概率 (p-1)p ;11的概率(1-p)^2
     * 所以10和01的概率是相等的,假设10返回1,01返回0
     * @return 等概率01随机数
     */
    private static int y() {
        int result = -1;
        do {
            result = x();
        } while (result == x());
        // 如果2次随机的数字一致，则重试，直到2次结果不等。 最终返回第一次结果为0或1的随机数
        return result;
    }
}
