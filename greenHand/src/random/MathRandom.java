package random;

/**
 * 1.Math.random 随机生成[0, 1)之间的数，且生成各个数的几率相同，呈线性增长
 * 2.假设需要出现 [0,x) 的概率为x的平方，怎么做呢？
 *      a.相当于要每次出现的数在0~x之中，并且两次随机出来的数字都要落在这个范围中 ，即double n = Math.max(Math.random(), Math.random());
 *      b.如果 n < x ， count++。 最后用count / 总次数 可以得到x出现的概率是在 x的平方附近。
 * 3.如果需要概率为x的三次方呢?
 *      a.同理可得，需要三次随机出来的数字都要落在这个范围内，取三次随机数的最大值n。double n = Math.max( Math.max(Math.random(), Math.random()) , Math.random());
 *      b.如果n< x， count++
 */
public class MathRandom {
    public static void main(String[] args) {
        MathRandom(0.6);
        System.out.println("====================");
        twoPower(0.6);
        System.out.println("====================");
        threePower(0.6);
    }

    private static void MathRandom(double x) {
        int count = 0;
        int times = 10000000;
        for (int i = 0; i < times; i++) {
            double random = Math.random();
            if (random < x) {
                count++;
            }
        }
        System.out.println("线性增长的概率:" + (double) count / (double) times);
    }

    private static void twoPower(double x) {
        int count = 0;
        int times = 10000000;
        for (int i = 0; i < times; i++) {
            // 需要[0,x)出现的概率为x², 则需要两次出现的随机数都在0~x范围内
            double random = Math.max(Math.random(), Math.random());
            if (random < x) {
                // 即两者中最大的数也比x小，则是都出现在范围内。
                count++;
            }
        }
        System.out.println("x的平方:" + Math.pow(x, 2));
        System.out.println("概率为x的平方:" + (double) count / (double) times);
    }

    private static void threePower(double x) {
        int count = 0;
        int times = 10000000;
        for (int i = 0; i < times; i++) {
            double num = Math.max(Math.max(Math.random(), Math.random()), Math.random());
            if (num < x) {
                count++;
            }
        }
        System.out.println("x的立方:" + Math.pow(x, 3));
        System.out.println("概率为x的立方:" + (double) count / (double) times);
    }
}
