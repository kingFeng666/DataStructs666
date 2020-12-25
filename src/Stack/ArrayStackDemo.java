package Stack;
/**
 * @ClassName: ArrayStackDemo
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 10月 16 17:53
 * @Version 1.0
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.add(1);
        arrayStack.add(5);
        arrayStack.add(9);
        arrayStack.add(12);
        arrayStack.list();
        arrayStack.pop();
        System.out.println("===========");
        arrayStack.list();
    }
}
//数组模拟栈的入栈 出栈 遍历
class ArrayStack{
    private int maxSize;//表示栈的大小
    private int top=-1;//栈顶
    private int[] stack;//数组模拟栈,元素存储在栈中
    public ArrayStack(int maxSize) {
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
