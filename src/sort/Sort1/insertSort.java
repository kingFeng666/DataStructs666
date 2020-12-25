package sort.Sort1;

import java.util.Arrays;

/**
 * @ClassName: 直接插入排序
 * @Description: 直接插入排序
 * @Author: 李峰
 * @Date: 2020 年 12月 05 11:29
 * @Version 1.0
 */
public class insertSort {
    public static void main(String[] args) {
        int[] array={5,6,8,1,65,12,41,25,36};
        System.out.println("排序前"+Arrays.toString(array));
        insertto(array);
        System.out.println("排序后"+Arrays.toString(array));
    }
    public  static  void  insertto(int[] array){
        //下标是从1开始,第一个元素下标为0的位置默认是已经有序的
        for (int i = 1; i <array.length ; i++) {
            int temp=array[i]; //相当于中间变量,用来交换数据
            int j=i-1;
            for (;j>=0&&temp>array[j] ;j-- ) {
                array [j+1]=array[j];
            }
            array[j+1]=temp;
        }
    }
}
