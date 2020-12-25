package 面试题;
/**
 * @ClassName: Test1
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 11月 29 19:18
 * @Version 1.0
 */
import java.util.Scanner;
public class Test1 {
        public static boolean judge(int number){
            int count = 0;
            for (int i = 2; i <number ; i++) {
                if(number%i == 0){
                    count++;
                    if(count == 2){
                        return true;
                    }
                }
            }
            return false;
        }
        public static void main(String[] args) {
            int count = 0;
            Scanner scanner  = new Scanner(System.in);
            int number = scanner.nextInt();
            for (int i = 1; i <= number ; i++) {
                if(judge(i)){
                    count++;
                }
            }
            System.out.println(count);

        }
}


