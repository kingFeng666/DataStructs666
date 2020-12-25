package Stack;
/**
 * @ClassName: Test
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 10月 20 20:47
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
    }
    public static int sum(int n) {
        //不使用 if  循环  三目  计算n的累加
        int t = 0;
        boolean b = (n > 0) && ((t = sum(n - 1)) >0);
        return n + t;
    }
}