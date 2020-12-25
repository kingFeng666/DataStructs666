package queue;

/**
 * @ClassName: MyCircularQueue1
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 10月 12 0:20
 * @Version 1.0
 */
class MyCircularQueue1 {
    private int[] arr;
    private int head, tail;
    private int size = 0;
    public MyCircularQueue1(int k) {
        arr = new int[k];
        tail = 0;
        head = 0;
    }
    public boolean enQueue(int value) {
        if (isFull()) return false;
        size++;
        tail = (tail + 1) % arr.length;
        arr[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        size--;
        head = (head + 1) % arr.length;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return arr[head];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return arr[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }
    public void show(){
        for (int j=head;j!=tail;){
            System.out.println(arr[j]);
            j=(j+1)%arr.length;
        }
    }
}


