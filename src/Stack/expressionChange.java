package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: expressionChange
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 10月 22 21:37
 * @Version 1.0
 */
public class expressionChange {
    public static void main(String[] args) {
        //完成将一个中缀表达式转成后缀表达式的功能
        //说明
        //1. 1+((2+3)×4)-5 => 转成 1 2 3 + 4 × + 5 –
        String expression="1+((2+3)*4)-5";
        //测试list

        List<String> list = toInfixExpressionList(expression);
        System.out.println(list);
        List<String> list1 = parseSuffixExpreesionList(list);
    }
    //中缀表达式转换为后缀表达式的方法
    /*
 1) 初始化两个栈：运算符栈 s1 和储存中间结果的栈 s2；
 2) 从左至右扫描中缀表达式；
 3) 遇到操作数时，将其压 s2；
 4) 遇到运算符时，比较其与 s1 栈顶运算符的优先级：
     (1).如果 s1 为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
     (2).否则，若优先级比栈顶运算符的高，也将运算符压入 s1；
     (3).否 则  将 s1 栈顶的运算符弹出并压入到 s2 中，再次转到(4-1)与 s1 中新的栈顶运算符相比较；
 5) 遇到括号时：
 (1) 如果是左括号“(”，则直接压入 s1
 (2) 如果是右括号“)”，则依次弹出 s1 栈顶的运算符，并压入 s2，直到遇到左括号为止，此时将这一对括号丢弃
 6) 重复步骤 2 至 5，直到表达式的最右边
 7) 将 s1 中剩余的运算符依次弹出并压入 s2
 8) 依次弹出 s2 中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
*/
    public static List<String> parseSuffixExpreesionList(List<String> ls){
        //先初始化一个符号栈 用来存放运算符
        Stack<String> stack = new Stack<>();
        //不需要初始化数栈  因为中间结果栈实际就是一直在添加元素 不存在出栈 结果返回的是一个链表 所以就初始化一个链表
        ArrayList<String> list2 = new ArrayList<>();
        //从左至右扫描中缀表达式  实际就是扫描 ls[1, +, (, (, 2, +, 3, ), ×, 4, ), -, 5]
        for (String item : ls) {
            if(item.matches("\\d+")){
                //匹配到是一个数字
                list2.add(item);
            }else if(item.equals("(")){
                stack.push(item);
            }else if (item.equals(")")){
                //如果是右括号“)”，则依次弹出 s1 栈顶的运算符，并压入 s2，直到遇到左括号为止，此时将这一对括号丢弃
                while(!stack.peek().equals("(")){
                    list2.add(stack.pop());
                }
                stack.pop();//消除括号
            }else {
                //当 item 的优先级小于等于 s1 栈顶运算符, 将 s1 栈顶的运算符弹出并加入到 s2 中，再次转到(4.1)
                //与 s1 中新的栈顶运算符相比较
                //问题：我们缺少一个比较优先级高低的方法
                //peek()方法就是查看栈顶的元素 但是不是取出来
                while(stack.size()!=0&&Operation.getValue(stack.peek())>=Operation.getValue(item)){
                    list2.add(stack.pop());
                }
                stack.push(item);
            }
        }
        while (stack.size()!=0){
            //将符号栈中的剩余元素弹出来 然后存储到list中
            list2.add(stack.pop());
        }
        return list2;
    }
    // 方法 将s="1+((2+3)×4)-5"转换为Arraylist [1,+,(,(,2,+,3,),*,4,),-,5]
    public static List<String> toInfixExpressionList(String s ){
        //定义一个List 用来存放 中缀表达式的内容
        ArrayList<String> list = new ArrayList<String>();
        int i = 0; //这时是一个指针，用于遍历 中缀表达式字符串
        String str; // 对多位数的拼接
        char c; // 每遍历到一个字符，就放入到 c
        do {
            //如果是符号就直接加到链表中 这里对照Ascal表中的  数字是48-57
            if ((c=s.charAt(i))<48||(c=s.charAt(i))>57){
                list.add(""+c);
                i++;
            }else{
                //如果是数字就要判断数字的下一位是不是数字  如果是数字就要实现对数字的拼接 主要是用来针对多位数
                //先把str置空
                str="";
                while (i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){
                    str+=c;
                    i++;
                }
                //遍历完将数字入链表
                list.add(str);

            }

        }while (i<s.length());

        return list;
    }
}
//编写一个类 Operation 可以返回一个运算符 对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;
    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}
