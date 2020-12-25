package 面试题;
/**
 * @ClassName: Test2
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 11月 29 19:20
 * @Version 1.0
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Test2 {
        public static int judge(List<Integer> list,int m){
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                for (int j = i+1; j < list.size(); j++) {
                    if(list.get(i) + list.get(j) == m){
                        count++;
                    }
                }
            }
            return count;
        }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            //输入m n
            int n = scanner.nextInt();
            int m  = scanner.nextInt();

            int index = n;
            List<Integer> list = new ArrayList<>();
            while(index-- != 0){
                list.add(scanner.nextInt());
            }
            System.out.println(judge(list, m));


        }
}

