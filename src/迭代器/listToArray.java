package 迭代器;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: listToArray
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 11月 05 0:36
 * @Version 1.0
 */
public class listToArray {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        //第一种方法返回的是一个object
        Object[] objects = list.toArray();
        for (Object o : objects) {
            String s= (String)o;
            System.out.println(o);
        }
        //第二种方法
        //这里的new String [0] 就是给他传进去一个数组 如果数组的长度足够就存进去
        //如果数组的长度不够 就会为你创建一个新的数组用来保存
        System.out.println(Arrays.toString(list.toArray(new String[0])));
        }
}

