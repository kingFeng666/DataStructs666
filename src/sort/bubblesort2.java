package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.SimpleFormatter;
/**
 * @ClassName: bubblesort2
 * @Description:冒泡排序的运行时间测试
 * @Author: 李峰
 * @Date: 2020 年 10月 26 0:14
 * @Version 1.0
 */
public class bubblesort2 {
    public static void main(String[] args) {
         //这里测试一下冒泡排序的时间 对80000个数据进行排序
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
        bubbleSort(arr);
        //System.out.println("排序后");
        //System.out.println(Arrays.toString(arr));
        Date date2 = new Date();
        String format2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是:"+format2);
    }
    public static void bubbleSort(int arr[] ){
        int temp=0;//辅助变量
        boolean flag=false; //用来标识是否已经有序 需不需要进行下一趟排序
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
                }
            if (!flag){
                break;
            }else{
                flag=false;//进行下一趟的判断
            }
        }
    }
}
