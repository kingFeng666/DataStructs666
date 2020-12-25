package Test;

/**
 * @ClassName: Main
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 10月 31 16:54
 * @Version 1.0
 */
public class Main {
   /* public static void main(String[] args){
        for(int i=0;i<6;i++){
            for(int j=0;j<12;j++){
                if(i==0||i==1){
                    if(j==5||j==6){
                        System.out.print("*");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
                if(i==2||i==3){
                    System.out.print("*");
                }
                if(i==4||i==5){
                    if(j==4||j==7){
                        System.out.print("*");}
                    else {
                        System.out.print(" ");
                    }
                }

            }
            System.out.println("");

        }
    }*/
   public static void main(String[] args)
   {
       int i = 1234;
       System.out.print('0'+Integer.toOctalString(i));  //返回i的八进制的字符串表示
       System.out.print(' ');
       String daxie=Integer.toHexString(i);
       System.out.print("0X"+daxie.toUpperCase());  //返回i的十六进制的字符串表示
   }
}

