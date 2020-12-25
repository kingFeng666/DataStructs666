package List;
/*
使用带 head 头的单向链表实现 –水浒英雄排行榜管理完成对英雄人物的增删改查操作， 注: 删除和修改,查找
可以考虑学员独立完成，也可带学员完成
1) 第一种方法在添加英雄时，直接添加到链表的尾部
2)第二种方式在添加英雄时，根据排名将英雄插入到指定位置(如果有这个排名，则添加失败，并给出提示)
*/
import java.util.Stack;
import static List.SingleLinkedList.reverse;
/**
 * @ClassName: SingleLinkedList
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 10月 12 20:52
 * @Version 1.0
 */
//通过链表实现对水浒英雄的排名
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "吴用", "智多星");
        HeroNode heroNode3 = new HeroNode(3, "林冲", "豹子头");
        HeroNode heroNode4 = new HeroNode(4, "李逵", "黑旋风");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode4);
          singleLinkedList.addByOrder(heroNode1);
          singleLinkedList.addByOrder(heroNode3);
          singleLinkedList.addByOrder(heroNode2);
          singleLinkedList.addByOrder(heroNode4);
          singleLinkedList.list();
          System.out.println("===============");
          singleLinkedList.del(1);
          singleLinkedList.list();
          System.out.println(singleLinkedList.getNode(singleLinkedList.getHead()));
          HeroNode test=singleLinkedList.sle(singleLinkedList.getHead(),2);
          System.out.println(test);
          System.out.println("反转前");
          singleLinkedList.list();
          System.out.println("反转后");
          reverse(singleLinkedList.getHead());
          singleLinkedList.list();
         System.out.println("逆序打印单链表:");
         singleLinkedList.reversePrint(singleLinkedList.getHead());

    }
}
//定义SingleLinkedList  来管理
class SingleLinkedList{
    //定义一个头节点  头结点不移动  头结点不存放数据,就是用来表示链表的头
    private HeroNode head=new HeroNode(0,"","" );
    public HeroNode getHead() {
        return head;
    }
    //添加方法
    //1.找到链表的尾结点
    //2.将尾结点的next  指向新的节点
    public void add(HeroNode heroNode){
        //因为头结点不能移动 所以需要一个临时节点
        HeroNode temp=head;
        while(true){
            //先找到尾结点   temp.next=null
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=heroNode;
    }
    //按顺序添加
    public void  addByOrder(HeroNode heroNode){
        //1.先定义一个临时变量用来辅助添加
        HeroNode temp=head;
        //2.通过while 循环来找到要添加的位置  条件是   temp.no< heroNode.no<temp.next.no
        while(true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;

            } else if (temp.next.no == heroNode.no) {
                break;
            }
            temp=temp.next;
        }
        heroNode.next=temp.next;
        temp.next=heroNode;
    }
    //删除元素
    public void del(int no){
        //因为头结点不能移动 ,所以需要申请一个辅助节点
        //删除操作需要找到的是要删除元素的上一个节点
        //然后删除  temp.next=temp.next.next;
        HeroNode temp= head;
        while(true){
            if (temp.next==null){
                break;
            }
            if (temp.next.no==no){//说明找到了要删除元素的位置
                temp.next=temp.next.next;
            }
            else{
                break;
            }
        }
    }
    //遍历链表
    public void list(){
        //判断链表是否为空
        if (head.next==null){
            System.out.println("链表为空");
        }
        HeroNode temp=head.next;
        while (temp!=null){
            //因为头节点不能移动  所以需要一个临时变量辅助遍历
            //判断是否到达尾部
            System.out.println(temp);
            //输出之后temp后移指向下一个节点
            temp=temp.next;
        }
    }
    //面试题1
    //统计链表中有效的节点的个数
    public static   int getNode(HeroNode head){
        while (true) {
            if (head.next == null) {
                return 0;
            }
            int length = 0;
            HeroNode cur=head.next;
            while (cur!=null){
                length++;
                cur=cur.next;
            }
            return length;
        }

    }
    //面试题2
    //查找链表的倒数第K个节点
    public static HeroNode sle(HeroNode head,int index ){
        //1.先统计链表中的节点数目(头节点不算)
        // 然后从第一个开始遍历  遍历到size-k个节点就是倒数第K个节点
        //如果链表为空返回null
        if (head.next==null){
            return null;
        }
        // 第一次遍历得到链表里总的节点数
            int size=getNode(head);
        //第二次遍历  遍历到size-index位置
        //对index进行合理性判断
        if (index<0||index>size){
            return null;
        }
        HeroNode cur=head.next;
        for (int i=0;i<size-index;i++){
            cur=cur.next;
            System.out.println();
        }
        return cur;
    }
    //腾讯面试题  实现单链表的反转
    public static  void reverse(HeroNode head){
        if (head.next==null||head.next.next==null){
            return;
        }
        //创建一个辅助的临时节点用来 辅助遍历原来的链表
        HeroNode cur=head.next;
        //next 节点用啦保存cur的下一个节点
        HeroNode next=null;
        //创建一个新的链表
        HeroNode reverseHead= new HeroNode(0,"","");
        //遍历原来的链表
        while (cur!=null){
            //System.out.println("...........");
            next=cur.next;//保存当前节点的下一个节点
            cur.next=reverseHead.next;
            reverseHead.next=cur;//将当前节点的下一节点指向新的头结点
            cur=next;
        }
        head.next=reverseHead.next;
    }
    //面试题    逆序打印单链表 (为了不破坏原有的数据结构  借助于栈的先进后出来实现)
    public static void reversePrint(HeroNode head){
        //创建一个辅助接点 来遍历原链表
        HeroNode cur=head.next;
        //新建一个栈用来保存链表中的元素
        Stack<HeroNode> stack = new Stack<>();
        while(cur!=null){
            stack.add(cur);
            cur=cur.next;
        }
        //出栈
        while (stack!=null){
            System.out.println(stack.pop());
        }
    }
}
//每一个HeroNode对象就是一个节点
class HeroNode{
    public int no;//水浒英雄的排名
    public String name ;//英雄名字
    public String nickname;//英雄外号
    public HeroNode next;//指向下一个节点
    //构造方法
    public HeroNode(int no,String name,String nickname){
        this.no=no;
        this.name=name;
        this.nickname=nickname;
    }
    //重写tostring方法
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
