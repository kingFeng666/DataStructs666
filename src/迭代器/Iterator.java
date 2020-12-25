package 迭代器;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Iterator
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 11月 04 23:34
 * @Version 1.0
 */
public class Iterator {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        //迭代器遍历
        java.util.Iterator<String> it = list.iterator();
        //这里就相当于执行了foreach
        while (it.hasNext()){
            String next = it.next();
            System.out.println(next);
        }
    }
}
