package sort.Sort1;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
/**
 * @ClassName: shellSort
 * @Description: 希尔排序交换式
 * @Author: 李峰
 * @Date: 2020 年 10月 28 20:24
 * @Version 1.0
 */
/*
 希尔排序第一趟[3, 5, 1, 6, 0, 8, 9, 4, 7, 2]
希尔排序第二趟[0, 2, 1, 4, 3, 5, 7, 6, 9, 8]
希尔排序第一趟[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
希尔排序的结果[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
* */
public class shellSort {
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
        System.out.println("希尔排序的结果"+Arrays.toString(arr));
    }
    public static void  shellSort(int [] arr){
        int temp=0;
        //分组
        for (int gep=arr.length/2;gep>0;gep/=2){
            for (int i=gep;i<arr.length;i++){
                for (int j=i-gep;j>=0;j-=gep){
                    //进行直接插入排序
                    if (arr[j]>arr[j+gep]){
                        temp=arr[j];
                        arr[j]=arr[j+gep];
                        arr[j+gep]=temp;
                    }
                }
            }
            //System.out.println("希尔排序的结果"+Arrays.toString(arr));
        }
    }

    /*//逐步分析
    public static void shellSort(int[] arr){
        //定义辅助变量用来协助交换
        int temp=0;
        //第一趟希尔排序   10/2=5
        for (int i=5;i<arr.length;i++ ){
            for (int j=i-5;j>=0;j-=5){
                if (arr[j]>arr[j+5]){
                    //交换
                    temp=arr[j];
                    arr[j]=arr[j+5];
                    arr[j+5]=temp;
                }
            }
        }
        System.out.println("希尔排序第一趟"+ Arrays.toString(arr));
        //第一趟希尔排序   10/2=5
        for (int i=2;i<arr.length;i++ ){
            for (int j=i-2;j>=0;j-=2){
                if (arr[j]>arr[j+2]){
                    //交换
                    temp=arr[j];
                    arr[j]=arr[j+2];
                    arr[j+2]=temp;
                }
            }
        }
        System.out.println("希尔排序第二趟"+ Arrays.toString(arr));
        //第一趟希尔排序   10/2=5
        for (int i=1;i<arr.length;i++ ){
            for (int j=i-1;j>=0;j-=1){
                if (arr[j]>arr[j+1]){
                    //交换
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println("希尔排序第一趟"+ Arrays.toString(arr));
    }
*/
}
