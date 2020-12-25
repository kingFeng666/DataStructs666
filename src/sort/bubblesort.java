package sort;

import java.lang.reflect.Array;
import java.util.Arrays;
/**
 * @ClassName: bubblesort
 * @Description:冒泡排序
 * @Author: 李峰
 * @Date: 2020 年 10月 25 23:02
 * @Version 1.0
 */
public class bubblesort {
    public static void main(String[] args) {
        //优化  减少他运行的次数   如果他某一趟 发现一次交换都没有发生 就说明他已经是有序就不需要排序了
        int arr[]={52,39,67,95,70,8,25,52};
        int temp;
        //定义一个boolean 类型来标识
        boolean flag= false;
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                flag=true;
                //因为第一趟排序结束后,最大的就被放在了最后一个位置
                // 所以第二趟排序就不需要扫描最后一个了,所以是arr.length-1-i;
                if (arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if (!flag){//这里说明他一次都没有交换过 已经有序了
                break;
            }else{
                flag=false;  //这里是让他进行下次的判断
            }
        }
        System.out.println("排序后的结果"+ Arrays.toString(arr));
        /*int arr[]={52,39,67,95,70,8,25,52};
        int temp;
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                //因为第一趟排序结束后,最大的就被放在了最后一个位置 所以第二趟排序就不需要扫描最后一个了,所以是arr.length-1-i;
                if (arr[j]>arr[j+1]){
                    temp=arr[j];//temp=52     arr[j]=39     arr[j+1]=39
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println("排序后的结果"+ Arrays.toString(arr));*/
    }
}
