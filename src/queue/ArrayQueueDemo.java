package queue;
/**
 * @ClassName: ArrayQueue
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 10月 11 10:10
 * @Version 1.0
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addQueue(3);
        arrayQueue.addQueue(5);
        arrayQueue.addQueue(6);
        arrayQueue.getQueue();
        arrayQueue.show();

    }
}
//用数组模拟队列
class ArrayQueue{
    //1.定义队列的属性
    private int maxSize;//队列的最大容量
    private int front;//队列头
    private int rear;//队列尾部
    private int[] arr;//数组用来存放队列的元素
    //2.创建队列的构造器
    public  ArrayQueue(int arrMaxSize ){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        //讲队列的头指针和尾指针初始化为-1
        front=-1;//指向队列头的前一个位置
        rear=-1;//指向最后一个元素
    }
    //3.判断队列是否满
    public boolean isFull(){
        return rear==maxSize-1;
    }
    //4.判断队列是否为空
    public boolean isEmpty(){
        return front==rear;
    }
    //5.队列添加数据
    public void addQueue(int n){
        //先判断队列是否满
        if (isFull()){
            System.out.println("队里满了,无法添加数据");
            return;
        }
        rear++;
        arr[rear]=n;
    }
    //6.出队列
    public int getQueue(){
        //先判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空....");
        }
        front++;
        System.out.println(arr[front]);
        return arr[front];
    }
    //7.显示队列的所有数据
    public void show(){
        for (int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }

    }

}

