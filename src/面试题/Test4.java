package 面试题;
/**
 * @ClassName: Test4
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 11月 29 19:23
 * @Version 1.0
 */
import java.util.Scanner;
public class Test4 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int a = 0;
            int b = 0;
            a = (x-y)/10;
            b = (y-5*a)/10;
            if((int)((x-y)/10f) != ((x-y)/10)){
                System.out.println(-1);
            }else{
                System.out.println(a + " " + b);
            }
        }
}

