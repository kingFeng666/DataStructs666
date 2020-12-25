package Stack;
/**
 * @ClassName: Calculato
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 10月 20 20:18
 * @Version 1.0
 */
public class Calculato {
    public static void main(String[] args) {

//来书写计算表达式的逻辑
 /*
 使用找完成表达式的计算思路

1.通过一个index值(索引) ,来遍历我们的表达式

2.如果我们发现是一个数字，就直接入数栈

3.如果发现扫描到是一个符号， 就分如下情况

3.1如果发现当前的符号栈为空，就直接入栈

3.2如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于核中的操作符，就需要从数栈中pop出两个数在从符号栈中pop出一个符号，
进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈，如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈

4.当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行,

5.最后在数栈只有一一个数字，就是表达式的结果

验证: 3+2*6-2=131.*/
 //1. 先传进来一个String类型发表达式
        String expression="3+2*6-2";
 //2.创建两个栈  一个数栈  一个符号栈
        ArrayStack2 numStack2 = new ArrayStack2(6);//存放数字的栈
        ArrayStack2 operStack2 = new ArrayStack2(6);//存放符号的栈
 //3.定义需要用到的相关变量
        int index=0;//用来扫描表达式的变量
        int num1=0;
        int num2=0;
        int oper=0 ;
        int res=0 ;
        char ch=' ';
  //4.依次扫描表达式
        while(true){
            //subString方法`  返回的是一个String类型的  所以需要把它转换为字符 然后再做处理
            ch=expression.substring(index,index+1).charAt(0);
            //判断ch是什么
            if (operStack2.isOper(ch)){
                //如果是一个运算符  然后判断符号栈是否为空 如果为空就直接入栈
                if (!operStack2.isEmpty()){
                    //符号栈如果不是空 就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符，
                    if (operStack2.priority(ch)<=operStack2.priority(operStack2.peek())){
                        // 就需要从数栈中pop出两个数在从符号栈中pop出一个符号，进行运算，将得到结果
                        // 入数栈，然后将当前的操作符入符号栈
                        num1=numStack2.pop();
                        num2=numStack2.pop();
                        oper=operStack2.pop();
                        res=numStack2.cal(num1,num2,oper);
                        //将计算结果入数栈
                        numStack2.add(res);
                        //将当前符号入符号栈
                        operStack2.add(ch);
                    }else{
                        //说明当前的操作符的优先级大于栈中的操作符，就直接入符号栈
                        operStack2.add(ch);
                    }
                }else{
                    operStack2.add(ch);
                }
            }else{
                //这里需要减去48的原因是因为ch 现在是一个字符 比如 ch='1' 他表示的是一个ASCII  他与数字之间的转换相差48
                numStack2.add(ch-48);
            }
            //让index +1  并且判断是否扫描到 表达式的尾部
            index++;
            if (index>=expression.length()){
                break;
            }
        }
        //4.当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行,
        //5.最后在数栈只有一一个数字，就是表达式的结果
        while (true){
            if (operStack2.isEmpty()){
                break;
            }
            num1 = numStack2.pop();
            num2 = numStack2.pop();
            oper = operStack2.pop();
            res = numStack2.cal(num1, num2, oper);
            numStack2.add(res);
        }
        int res2 =numStack2.pop();
        System.out.printf("表达式 %s=%d",expression,res2);
    }
}
class ArrayStack2{
    private int maxSize;//表示栈的大小
    private int top=-1;//栈顶
    private int[] stack;//数组模拟栈,元素存储在栈中
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        //这里就把这个栈创建好了
        stack=new int [this.maxSize];
    }
    //栈空
    public boolean isEmpty(){
        return top==-1;
    }
    //栈满
    public boolean isFull(){

        return top==maxSize-1;
    }
    //符号的优先级,返回运算符的优先级，优先级是程序员来确定, 优先级使用数字表示
    ////数字越大，则优先级就越高.
    //int 和char类型是一致的
    public int priority(int oper){
        //如果是乘除 返回1
        if (oper=='*'||oper=='/'){
            return 1;
        }
        else if (oper=='+'||oper=='-'){
            return 0;
        }else {
            //假设当前的表达式只有+ - * /
            return -1;
        }

    }
    //判断传进来的的是一个数字还是一个运算符
    public boolean isOper(int oper){
        return oper=='+'||oper=='-'||oper=='*'||oper=='/';
    }
    //计算方法是
    public int cal(int num1,int num2,int oper){
        //定义一个变量用来接收计算结果
        int res=0;
        switch (oper){
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num2/num1;
                break;
        }
        return res;
    }
    //创建一个方法 来返回栈顶的值  但不是真正的出栈
    public int peek(){
        return stack[top];
    }
    //入栈
    public void add(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;
    }
    //出栈
    public int pop(){
        if (isEmpty()){
            System.out.println("栈空");
        }
        int value= stack[top];
        top--;
        return value;
    }
    //遍历栈
    public void list(){
        if (isEmpty()){
            System.out.println("栈为空,没有数据");
        }
        for (int i=top;i>-1;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
