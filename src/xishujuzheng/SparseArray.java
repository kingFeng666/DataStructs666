package xishujuzheng;
/**
 * @ClassName: SparseArray
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 10月 10 21:48
 * @Version 1.0
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个二维数据11*11
        //模拟棋盘 0 代表无子 1 代表黑子 2代表蓝色
        int[][] array1 = new int[11][11];
        array1[1][2] = 1;
        array1[2][3] = 2;
        //循环遍历 输出二维数组
        for (int[] ints : array1) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        //将二维数组转换为稀疏数组 先循环遍历找出有几个非0元素
        int sum = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                if (array1[i][j] != 0) {
                    sum++;
                }
            }
        }
        //创建新的二维数组用来保存稀疏数组
        int[][] spareArr = new int[sum + 1][3];
        //给稀疏数组赋值
        spareArr[0][0] = 11;
        spareArr[0][1] = 11;
        spareArr[0][2] = sum;
        //将原数组的非0数保存在稀疏数组中
        int count=0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                if (array1[i][j] != 0) {
                    count++;
                    spareArr[count][0] = i;
                    spareArr[count][1] = j;
                    spareArr[count][2] = array1[i][j];
                }
            }

        }
        //遍历 输出稀疏数组
        System.out.println("稀疏矩阵---");
        for (int i=0;i<spareArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",spareArr[i][0],spareArr[i][1],spareArr[i][2]);
        }
        System.out.println();
    }

}
