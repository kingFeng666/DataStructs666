package 迭代器;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: arrayToList
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 11月 05 0:46
 * @Version 1.0
 */
public class arrayToList {
    public static void main(String[] args) {
        String [] arr ={"a","b","c"};
        //返回的是一个list  不是一个Arraylist
        List<String> list = Arrays.asList(arr);
        System.out.println(list.getClass());//class java.util.Arrays$ArrayList

    }
}
