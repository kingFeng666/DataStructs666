package ArrayList.扑克牌;

/**
 * @ClassName: 扑克牌
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 11月 05 23:57
 * @Version 1.0
 */
public class 扑克牌 {
    public String suit;//花色
    public int  rangk; //牌面
    //构造方法
    public 扑克牌(String suit,int rangk){
        this.suit=suit;
        this.rangk=rangk;
    }

    @Override
    public String toString() {
        return  String.format("[%s %d]",suit,rangk);
    }
}
