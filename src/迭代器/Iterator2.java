package 迭代器;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Iterator2
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 11月 05 0:04
 * @Version 1.0
 */
public class Iterator2 {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        //迭代器遍历
        java.util.Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String next = it.next();
            if (next.equals("C")){
                it.remove();
            }
        }
     //这样的写法是错误的,在遍历的同时不允许改变list的结构  需要使用迭代器
        /*for(String next : list){
            if (next.equals("C")){
                list.remove(next);
            }

        }*/

    }

}
