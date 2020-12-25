package ArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ArrayListCapacity
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 11月 05 23:23
 * @Version 1.0
 */
public class ArrayListCapacity {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>(100);
        /*
        * list的初始容量是100  包含的元素个数是0
        * list的下标和容量无关 只和元素个数有关
        *get/set/add/remove/ 和list.size()有关
        * */
        //这句代码是错误的 java.lang.IndexOutOfBoundsException: Index: 98, Size: 0
        //list.set(98,"a");
        //System.out.println(list);
    }
}
