package Recursion;
/**
 * @ClassName: Queue8
 * @Description:8皇后问题的描述
 * @Author: 李峰
 * @Date: 2020 年 10月 24 16:45
 * @Version 1.0
 */
public class Queue8 {
    int max=8;
    //定义一个数组用来保存每一个皇后的位置
    int[] array = new int[max];
    static int  count=0; //用来计算一共有多少种不同的方法
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.cheek(0);
        System.out.printf("一共有%d 解法", count);
    }
    //1.思路分析
    /*1) 第一个皇后先放第一行第一列
        2) 第二个皇后放在第二行第一列、然后判断是否 OK， 如果不 OK，继续放在第二列、第三列、依次把所有列都
        放完，找到一个合适
        3) 继续第三个皇后，还是第一列、第二列……直到第 8 个皇后也能放在一个不冲突的位置，算是找到了一个正确
        解
        4) 当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解，
        全部得到.
        5) 然后回头继续第一个皇后放第二列，后面继续循环执行 1,2,3,4 的步骤

       说明: 理论上应该创建一个二维数组来表示棋盘，但是实际上可以通过算法，用一个一维数组即可解决问题. arr[8] =
        {0 , 4, 7, 5, 2, 6, 1, 3} //对应 arr 下标 表示第几行，即第几个皇后，arr[i] = val , val 表示第 i+1 个皇后，放在第 i+1
        行的第 val+1 列
    */
    //1. 方法1 放入第n个皇后
    public   void cheek(int n ){
        if (n==max){
            print();
            return;
        }
        // 把第n个皇后先放在该行的第一个位置  然后判断该位置是否正确  如果不正确就放到i+1的位置
        //如果正确就返回放第n+1个皇后
        for (int i=0;i<max;i++){
            array[n]=i;
            //判断放入进去后冲突不冲突
            if (judge(n)){
                //如果不冲突  就往进放第n+1个皇后   如果冲突就继续调用执行 array[n]=i; 指向当前这一行的后一个位置
                cheek(n+1);
            }
        }
    }

    //2.方法2  判断放入的位置是否合理
    public boolean judge( int n ){
        //判断方法  为 任意两个皇后不能在同一列 或者 统一斜线
        //判断不在同一列的方法   每一个小标对应的值就是在所在的列 只要相同下标所对应的数字不一样就不是同一列
        //判断不在同一斜线的方法  |n-i|==|array[n]-array[i]| 就说明了不在同一个斜线上
        for (int i=0;i<n;i++){
            if (array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
                return true;
    }

    //3. 方法3  输出皇后的位置
    public   void print(){
        count++;
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+"");
        }
        System.out.println();
    }
}
