package 面试题;

import java.util.Arrays;

/**
 * @ClassName: Test5
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 12月 05 21:07
 * @Version 1.0
 */
public class Test5 {
    public static void main(String[] args) {
        int[] array={1,2,3};
        do1(array);
        System.out.print(Arrays.toString(array));
    }
    public static void do1(int[] array){
        for (int i=0;i<array.length-1;i++){
            for (int j=i+1;j<array.length;j++){
                if (array[i]<array[j]){
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }

            }
        }

    }
}
