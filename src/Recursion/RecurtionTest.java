package Recursion;

/**
 * @ClassName: RecurtionTest
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 10月 23 12:45
 * @Version 1.0
 */
public class RecurtionTest {
    public static void main(String[] args) {
        test(4);
    }
    public static  void test(int  n){
        if (n>2){
            test(n-1);
        }
        System.out.println("n="+n);
    }
}
