package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
/**
 * @ClassName: selectSort2
 * @Description:选择排序的运行时间测试
 * @Author: 李峰
 * @Date: 2020 年 10月 26 21:45
 * @Version 1.0
 */
public class selectSort2 {
    public static void main(String[] args) {
        int [] arr=new int [80000];
        for (int i=0;i<80000;i++){
            arr[i]=(int)(Math.random()*80000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("排序前的时间是:"+format);
        selectSort(arr);
        Date date1 = new Date();
        String format1 = simpleDateFormat.format(date1);
        System.out.println("排序后的时间是"+format1);
    }
    public static  void selectSort(int[] arr){
        //两趟大循环
        for (int i=0;i<arr.length-1;i++){
            //n个数字一共要排序n-1趟
            //假设第的最小的元素
            //每一堂都是从上一趟找出的最小的后面开始  所以  minIndex=i
            int minIndex=i;
            int min=arr[i];
            for (int j=i+1;j<arr.length;j++){
                //第一趟排序结束后 第一个位置就是最小的  下次就从第二个位置开始扫描了 跳过第一个位置
                if (min>arr[j]){
                    //如果有一个数字比假设的最小的还小 重置min  和minIndex
                    min=arr[j];
                    minIndex=j;
                }
            }
            if (minIndex!=i){
                //交换
                arr[minIndex] = arr[i];//把假设的最小的数和实际最小的交换
                arr[i] = min;
            }
        }
    }
}
