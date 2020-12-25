package List.DoubleLinked;
/**
 * @ClassName: DoubleLinkedListDemo
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 10月 14 20:03
 * @Version 1.0
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "吴用", "智多星");
        HeroNode heroNode3 = new HeroNode(3, "林冲", "豹子头");
        HeroNode heroNode4 = new HeroNode(4, "李逵", "黑旋风");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);
        System.out.println("修改前");
        doubleLinkedList.list();
        System.out.println("修改后");
        doubleLinkedList.update(new HeroNode(2,"花荣","小李广"));
        doubleLinkedList.list();
        System.out.println("删除后");
        doubleLinkedList.del(4);
        doubleLinkedList.list();
    }
}
class DoubleLinkedList{
    //初始化将头结点置为空
    private  HeroNode head= new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }
    //添加一个节点到双向链表最后
    public void add(HeroNode heroNode){
        HeroNode temp=head;
        //先找到链表的尾部
        boolean flag=true;
        while (flag){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=heroNode;
        heroNode.pre=temp;
    }
    public void update(HeroNode newHeroNode){
        HeroNode temp=head.next;
        if (temp==null){
            System.out.println("链表为空");
            return;
        }
        while(true){
            if (temp.no==newHeroNode.no){
                //找到要修改的位置
                temp.name=newHeroNode.name;
                temp.nickname=newHeroNode.nickname;
                break;
            }
            temp=temp.next;
        }
    }
    //删除操作 根据no删除
    //因为是双向的链表  所以删除是自身删除
    public void del(int no){
        if (head.next==null){
            System.out.println("链表为空,无法删除");
        }
        //定义一个辅助变量
        HeroNode temp=head.next;
        //双链表的删除操作是要找到要删除元素的本身位置(单链表是要找到他的前一个位置)
        boolean flag =false;
        while(flag==false){
            if (temp==null){
                System.out.println("已经找到了链表的最后");
                break;
            }
            if (temp.no==no){
                //找到了要删除的位置 跳出循环去执行删除操作
                flag=true;
                break;
            }
            //如果没有找到,让temp 后移
            temp=temp.next;
        }
        if (flag){
            temp.pre.next=temp.next;
            //如果要删除的元素是最后一个元素  temp.next指向的就是空了
            if (temp.next!=null){
                temp.next.pre=temp.pre;
            }
        }else{
            System.out.println("要删除的节点不存在");
        }
    }
    //遍历双向链表
    public void  list(){
        HeroNode tmp=head.next;
        if (head.next==null){
            throw new RuntimeException("链表为空");
        }
        while(tmp!=null){
            System.out.print(tmp);
            tmp=tmp.next;
        }
    }
}
class HeroNode{
    public int no;//水浒英雄的排名
    public String name ;//英雄名字
    public String nickname;//英雄外号
    public HeroNode next;//指向下一个节点
    public HeroNode pre;//指向上一个节点
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
