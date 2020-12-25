package sort;
import java.util.Arrays;
/**
 * @ClassName: insertSort
 * @Description:插入排序
 * @Author: 李峰
 * @Date: 2020 年 10月 28 19:26
 * @Version 1.0
 */
public class insertSort {
    public static void main(String[] args) {
        int [] arr={101,56,78,5};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int[] arr){
        //定义一个待排序元素的
        int insertValue = 0;
        //定义一个待排序的下标
        int insertIndex=0;

        for (int i=1;i<arr.length;i++) {
            insertValue = arr[i];
            //定义一个待排序的下标
            insertIndex=i-1;
            while(insertIndex>=0&&arr[insertIndex]>insertValue){
                //表示没有找到插入的位置 就让arr[insertIndex]后移
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            //当退出了while循环就说明找到了插入的位置
            arr[insertIndex+1]=insertValue;
        }
    }
}
