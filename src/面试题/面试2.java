package 面试题;

/**
 * @ClassName: 面试2
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 11月 10 20:23
 * @Version 1.0
 */
public class 面试2 {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
        public static int reverse ( int x){
            int ans = 0;
            while (x != 0) {
                int pop = x % 10;
                if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                    return 0;
                if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                    return 0;
                ans = ans * 10 + pop;
                x /= 10;
            }
            return ans;
        }
    }



