package sort;
import java.util.Arrays;
/**
 * @ClassName: quickSort
 * @Description:快速排序
 * @Author: 李峰
 * @Date: 2020 年 10月 31 10:23
 * @Version 1.0
 */
public class quickSort {
    public static void main(String[] args) {
        int[] a = {46, 30, 82, 90, 56, 17, 95, 15};
        int start = 0;
        int end = a.length - 1;
        System.out.println("排序前的"+ Arrays.toString(a));
        sort(a, start, end);
        System.out.println("排序结果"+Arrays.toString(a));
    }
    public static void sort(int arr[], int low, int high) {
        int l = low;//start
        int h = high;//end
        //取第一个数为基数 46
        int baseNum = arr[low];

        while (l < h) {
            //1.从右向左查找小于指定基数的数，找到之后跳出循环执行下面if循环，交换数据
            while (l < h && arr[h] >= baseNum) {
                h--;
            }
            //交换数据
            if (l < h) {
                //从右向左找 找到一个数小于基数(46) 然后就交换位置
                //数据交换
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }
            //2.从左向右查找大于指定基数的数，找到后跳出循环执行下面if循环，交换数据
            while (l < h && arr[l] <= baseNum)
                l++;
            //交换数据
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
        }
        //低子表递归排序
        if (l > low) {
            sort(arr, low, l - 1);
        }
        //高字表递归排序
        if (h < high) {
            sort(arr, l + 1, high);
        }
    }
}
