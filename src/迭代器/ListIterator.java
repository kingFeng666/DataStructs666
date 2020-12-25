package 迭代器;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ListIterator
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 11月 05 0:17
 * @Version 1.0
 */
public class ListIterator {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        //java.util.ListIterator<String> it = list.listIterator(list.size());
        //看一下用法
        java.util.ListIterator<String> iterator = list.listIterator(1);
        java.util.ListIterator<String> iterator1 = list.listIterator(1);

        System.out.println(iterator.next());//B // 0 A  1 B
        System.out.println(iterator1.previous());//5 E 4 D 3 C 2 B 1 A

        //从后往前遍历
       /* while (it.hasPrevious()){
            String previous = it.previous();
            System.out.println(previous);
        }*/
    }
}
