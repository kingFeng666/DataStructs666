package sort.Sort1;
import java.util.Arrays;
/**
 * @ClassName: selectSort
 * @Description:选择排序
 * @Author: 李峰
 * @Date: 2020 年 10月 26 21:01
 * @Version 1.0
 */
public class selectSort {
    public static void main(String[] args) {
        int[] arr={9,5,6,1,4,8,7,2};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static  void selectSort(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            //n个数字一共要排序n-1趟
            //假设第的最小的元素
            //每一堂都是从上一趟找出的最小的后面开始  所以  minIndex=i
            int minIndex=i;//假设最小元素的小标
            int min=arr[i];//假设的最小元素
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


    /*
    //单步运行,查看运行原理
    public static void main(String[] args) {
        int arr[]={45,56,2,98,75,16,72};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static  void selectSort(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            int minIndex=i;
            int min=arr[i];
            for (int j=i+1;j<arr.length;j++){
                if (min>arr[j]){
                    //交换
                    min=arr[j];
                    minIndex=j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }*/
}
