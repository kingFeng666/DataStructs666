package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName: shellSort2
 * @Description: 希尔排序位移式
 * @Author: 李峰
 * @Date: 2020 年 10月 29 20:33
 * @Version 1.0
 */
public class shellSort2 {
    public static void main(String[] args) {
        /*//这里测试一下冒泡排序的时间 对80000个数据进行排序
        int arr[]=new int[80000];
        bubblesort2 bubble = new bubblesort2();
        for (int k =0;k<80000;k++){
            //产生了80000个随机数
            arr[k]=(int)(Math.random()*80000);
        }
        //System.out.println("排序前");
        //System.out.println(Arrays.toString(arr));
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("排序前的时间是:"+format);
        shellSort(arr);
        Date date2 = new Date();
        String format2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是:"+format2);*/
        int[] arr={8,9,1,7,2,3,5,4,6,0};
        shellSort(arr);
        System.out.println("希尔排序的结果"+ Arrays.toString(arr));
    }
    public static void shellSort(int [] arr){
        //移动式就是插入式
        for (int gap=arr.length/2;gap>0;gap/=2){
           for (int i=gap;i<arr.length;i++){
                int j=i;
                int temp=arr[j];
                if (arr[j]<arr[j-gap]){
                    //移动
                    while (j-gap>=0&&temp<arr[j-gap]){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    arr[j]=temp;
                }
            }
           // System.out.println(Arrays.toString(arr));
        }


    }
}
