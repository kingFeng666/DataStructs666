package 面试题;
/**
 * @ClassName: Test3
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 11月 29 19:22
 * @Version 1.0
 */
import java.util.Scanner;
public class Test3 {
        public static String sub(String str){
            String strTemp = "";
            int count = 0;
            char[] chars = str.toCharArray();
            int begin = 0;
            int end = 0;
            for (int i = 0; i < chars.length; i++) {
                begin  = i;
                end = str.indexOf(chars[i], i+1);
                if(end != -1){
                    if(count == 1 && (end - begin+1) < strTemp.length()){
                        strTemp = str.substring(begin, end+1);
                    }
                    if(count == 0){
                        strTemp = str.substring(begin, end+1);
                        count++;
                    }
                }
            }
            return strTemp;
        }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            //输出一个字符串
            String str = scanner.nextLine();
            if(str == null || str == ""){
                System.out.println("");
            }else if(str.length() == 1){
                System.out.println(str);
            }else{
                System.out.println(sub(str));
            }
        }
}

