package Recursion;

/**
 * @ClassName: RecursionTest2
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 10月 23 12:49
 * @Version 1.0
 */
public class RecursionTest2 {
    public static void main(String[] args) {
        test(4);
    }

    public static  void test(int  n){
        if (n>2){
            test(n-1);
        }else{
            System.out.println("n="+n);
        }

    }
}
