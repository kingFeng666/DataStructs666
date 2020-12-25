package Recursion;

/**
 * @ClassName: migong
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 10月 23 20:11
 * @Version 1.0
 */
public class migong {
    public static void main(String[] args) {
        //先二维数组创建一个地图
        /*
          1  1  1  1  1  1  1
          1  0  0  0  0  0  1
          1  0  0  0  0  0  1
          1  1  1  0  0  0  1
          1  0  0  0  0  0  1
          1  0  0  0  0  0  1
          1  0  0  0  0  终  1
          1  1  1  1  1  1  1
        * */
        int map[][]= new int [8][7];
        //然后给他设置墙体  用1表示墙体无法通过
        //先把第一行和最后一行置为1
        for (int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        //然后把第一列和最后一列也都置为1
        for (int j=1;j<8;j++){
            map[j][0]=1;
            map[j][6]=1;
        }
        //然后设置挡板(也相当于墙体)
        map[3][1]=1;
        map[3][2]=1;
        //输出地图
        for (int i=0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(map[i][j] +"  ");
            }
            System.out.println();
        }
        setWay(map, 1, 1);
        //输出走过后地图
        System.out.println();
        System.out.println();
        System.out.println("输出走过后的地图--------");
        for (int i=0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(map[i][j] +"  ");
            }
            System.out.println();
        }

    }

    //使用递归回溯算法来给迷宫找路
    /*定义规则
    * 1. 使用数字来标识
    *    (1)当map[i][j]=0 表示没有走过
    *    (2)当map[i][j]=1表示为墙
    *    (3)当map[i][j]=2;表示走过
    *    (4)当map[i][j]=3 表示走过无法通过
    * 2.map 表示地图  i j 表示起点的位置
    * 3.终点的位置设置为 6 5
    * 4.定义小球探路的规则是下 右  上  左
    */

    public static  boolean setWay(int[][] map,int i,int j){
       if (map[6][5]==2){
           //说明找到终点
           return true;
       }else {
           if (map[i][j] == 0) {// 65  64 63  53 43  33  23  22  21  11
               map[i][j] = 2;
               if (setWay(map, i + 1, j)) {
                   return true;
               } else if (setWay(map, i, j + 1)) {
                   return true;
               } else if (setWay(map, i - 1, j)) {
                   return true;
               } else if (setWay(map, i, j - 1)) {
                   return true;
               } else {
                   map[i][j] = 3;
                   return false;
               }
           }else {
               return false;
           }
       }
    }
}
