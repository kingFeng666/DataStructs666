package Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * @ClassName: PolandNotation1
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 10月 22 16:20
 * @Version 1.0
 */
public class PolandNotation1{
    public static void main(String[] args) {
//先定义给逆波兰表达式
//(30+4)×5-6 => 30 4 + 5 × 6 - => 164
// 4 * 5 - 8 + 60 + 8 / 2 => 4 5 * 8 - 60 + 8 2 / +
//测试
//说明为了方便，逆波兰表达式 的数字和符号使用空格隔开
//String suffixExpression = "30 4 + 5 * 6 -";
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +"; // 76
//思路
//1. 先将 "3 4 + 5 × 6 - " => 放到 ArrayList 中
//2. 将 ArrayList 传递给一个方法，遍历 ArrayList 配合栈 完成计算
        List<String> list = getListString(suffixExpression);
        System.out.println("rpnList=" + list);
        int res = calculate(list);
        System.out.println("计算的结果是=" + res);
    }
    //将一个逆波兰表达式， 依次将数据和运算符 放入到 ArrayList 中
    public static List<String> getListString(String suffixExpression) {
//将 suffixExpression 分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for(String ele: split) {
            list.add(ele);
        }
        return list;
    }
    //完成对逆波兰表达式的运算
/*
* 1)从左至右扫描，将 3 和 4 压入堆栈；
2)遇到+运算符，因此弹出 4 和 3（4 为栈顶元素，3 为次顶元素），计算出 3+4 的值，得 7，再将 7 入栈；
3)将 5 入栈；
4)接下来是×运算符，因此弹出 5 和 7，计算出 7×5=35，将 35 入栈；
5)将 6 入栈；
6)最后是-运算符，计算出 35-6 的值，即 29，由此得出最终结果
*/
    public static int calculate(List<String> ls) {
// 创建给栈, 只需要一个栈即可
        Stack<String> stack = new Stack<String>();
// 遍历 ls
        for (String item : ls) {
// 这里使用正则表达式来取出数
            if (item.matches("\\d+")) { // 匹配的是多位数
// 入栈
                stack.push(item);
            } else {
// pop 出两个数，并运算， 再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
//把 res 入栈
                stack.push("" + res);
            }
        }
//最后留在 stack 中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }
}
