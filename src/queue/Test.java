package queue;
import static javafx.scene.input.KeyCode.M;

/**
 * @ClassName: Test
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 10月 12 0:21
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        MyCircularQueue1 myCircularQueue1 = new MyCircularQueue1(5);
        myCircularQueue1.enQueue(1);
        myCircularQueue1.show();
    }
}
