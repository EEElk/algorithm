package class02;

/**
 * 从随机数1-5得到随机数1-7
 *  题设: 给定一个函数fn(), fn()会等概率得到1~5的随机数(整数)
 *  要求: 可以使用fn()但是不能更改fn(), 最终要等概率得到1~7的随机数(整数)
 * <p>
 * 1.先构造出01发生器:fn()会随机得到1~5， 那么定义如果得到1和2就返回0，得到4和5就返回1，得到3就重试，一直循环知道能得到1，2，4，5中的某一个数终止。假设01发生器函数为 f2();
 * 2.找到最终得到的最大数，用二进制形式表示出来:最终需要得到1~7， 7为最大数，用二进制表示就是 000 ~ 111。总共有3位，每一位的值都是0或1。
 * 3.使用01发生器等概率得到000~111之间的数: int result = (f2()<<2) + (f2()<<1) + f2();
 * 4.最终需要1~7，所以如果result=0则重试，直到结果为1到7终止，这样就能得到1到7的等概率随机数了。
 */
public class Random1To5 {
    public static void main(String[] args) {
        int times = 1000000;
        int[] count = new int[8];
        int num = -1;
        for (int i = 0; i < times; i++) {
            num = f4();
            count[num]++;
        }
        for (int i = 1; i < count.length; i++) {
            System.out.println("得到" + i + "的次数:" + count[i]);
        }
    }

    /**
     * 可以使用fn()但是不能更改fn(), 最终要等概率得到1~7的随机数(整数)
     * @return 1~5的随机数
     */
    private static int fn() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 01发生器
     * @return fn()得到1和2就返回0，得到4和5就返回1，得到3就重试
     */
    private static int f2() {
        int result = 0;
        do {
            result = fn();
        } while (result == 3);
        return result < 3 ? 0 : 1;
    }

    /**
     * 用二进制表示就是 000 ~ 111。总共有3位，每一位的值都是0或1
     * @return 000~111之间的数,即0~7之间的数
     */
    private static int f3() {
        // f2() << 2结果是100或000, f2() << 1结果是010或000, f2()结果是001或000
        return (f2() << 2) + (f2() << 1) + f2();
    }

    /**
     * f3()可以等概率得到0~7之间的数，遇到0重试就能等概率得到1~7之间的数
     * @return 1~7之间的数
     */
    private static int f4() {
        int result = 0;
        do {
            result = f3();
        } while (result == 0);
        return result;
    }
}
