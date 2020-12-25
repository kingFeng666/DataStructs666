package Test;
import java.util.Scanner;
/**
 * @ClassName: hexTo10
 * @Description:16进制转10进制
 * @Author: 李峰
 * @Date: 2020 年 10月 31 0:34
 * @Version 1.0
 */
public class hexTo10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个16进制的数");
        String next = scanner.next();
        System.out.println(转10进制(next));
    }
    public static long 转10进制(String s){
        //定义一个变量接收  先把String类型转换为char类型的单个字符
        long ret=0;
        //这个是把字符串转成字符
        char[] chars = s.toCharArray();
        for (char c : chars){
            //然后把字符转成数字
            int dirt=字符转数字(c);
            //这样就会多*一个16
            ret=(ret+dirt)*16;
        }
        return  ret/16;
    }
    public static int 字符转数字(char c){
        if (c>='0'&&c<='9'){
            return c-'a';
        }else{
            return c-'A'+10;//0-15的一个数字
        }
    }
}
