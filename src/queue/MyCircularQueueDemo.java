package queue;
/**
 * @ClassName: MyCircularQueue
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 10月 11 20:09
 * @Version 1.0
 */
public class MyCircularQueueDemo {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(5);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(1);
        myCircularQueue.show1();
        System.out.println(".........");
        myCircularQueue.getQueue();
        myCircularQueue.show1();
        myCircularQueue.enQueue(6);
        myCircularQueue.enQueue(8);
        System.out.println(".............");
        myCircularQueue.show1();
        System.out.println("...........");
        myCircularQueue.getQueue();
        myCircularQueue.show1();
        System.out.println(".........");
        myCircularQueue.enQueue(9);
        myCircularQueue.show1();
    }
}
class MyCircularQueue{
    private int[] arr;
    private int head,tail;
    private int size=0;
    //1. 构造函数
    public MyCircularQueue(int k){
        arr= new int[k];
        tail=0;
        head=0;
    }
    //2.判断是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //3.判断队列是否满
    public boolean isFull(){
        return size==arr.length-1;
    }
    //4.进队列    判断队列是否满
    public boolean enQueue(int value){
        if (isFull()){
            return false;
        }
        arr[tail]=value;
        System.out.println(head);
        size++;
        tail=(tail+1)%arr.length;
        return true;
    }
    //5.出队列
    public boolean getQueue(){
        if (isEmpty()){
            return false;
        }
        size--;
        head=(head+1)%arr.length;
        return true;
    }
    public void show1(){
        for (int j=head;j!=tail;){
            System.out.println(arr[j]);
            j=(j+1)%arr.length;
        }
    }
}
