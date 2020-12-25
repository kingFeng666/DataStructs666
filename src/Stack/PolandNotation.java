package Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * @ClassName: PolandNotation
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 10月 22 0:33
 * @Version 1.0
 */
public class PolandNotation {
    public static void main(String[] args) {
        //逆波兰表达式计算机求值
        ////(30+4)×5-6 => 30 4 + 5 × 6 - => 164
        //定义一个String类型的逆波兰表达式 数字与数字与符号之间用空格隔开
        String suffixException="30 4 + 5 * 6 -";
        List<String> list= getList(suffixException);
        System.out.println(list);
        int calculate = calculate(list);
        System.out.println(calculate);
    }
    //将一个逆波兰表达式， 依次将数据和运算符 放入到 ArrayList 中
    public static List<String> getList(String suffixException ){
        //然后将 suffixException 逐个放入到链表中
        String[] split = suffixException.split(" ");//将表达式按空格切分
        ArrayList<String> list = new ArrayList<>();
        //将切分后的加入到链表中
        for (String ele : split ){
            list.add(ele);
        }
        return list;
    }
    //定义计算方法
        /*完成对逆波兰表达式的运算
        1)从左至右扫描，将 3 和 4 压入堆栈；
        2)遇到+运算符，因此弹出 4 和 3（4 为栈顶元素，3 为次顶元素），计算出 3+4 的值，得 7，再将 7 入栈；
        3)将 5 入栈；
        4)接下来是×运算符，因此弹出 5 和 7，计算出 7×5=35，将 35 入栈；
        5)将 6 入栈；
        6)最后是-运算符，计算出 35-6 的值，即 29，由此得出最终结果
        */
    public static int calculate(List<String> list) {
        //拿到list 之后把 list 中的字符串取出来  然后转换为int 类型计算
        Stack<String> stack = new Stack<>();
        for (String ls : list) {
            //如果是数字 就入栈  使用正则表达式来匹配多位数
            if (ls.matches("\\d+")) {
                //入栈
                stack.push(ls);
            } else {
                //是符号就从栈里出两个数字计算后入栈
                int num2 = Integer.parseInt(stack.pop());//将字符串转换为整数
                int num1 = Integer.parseInt(stack.pop());
                //定义一个变量用来保存计算结果
                int res = 0;
                if (ls.equals("+")){ return res=num1+num2;
                }else if (ls.equals("-")){
                     res= num1-num2;
                }else if (ls.equals("*")){
                     res=num1*num2;
                }else if (ls.equals("/")){
                     res=num1 /num2;
                }else {
                    throw  new  RuntimeException("");
                }
               //把计算结果入栈
                stack.push(""+res);
            }
        }
        //最后留在栈中的数字就是表达式的运算结果
        return Integer.parseInt(stack.pop());
    }
}
