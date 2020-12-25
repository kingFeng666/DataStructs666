package queue;

/**
 * @ClassName: SingleLinkedListDemo1
 * @Description:模拟队列 只能使用尾插法来进行
 * @Author: 李峰
 * @Date: 2020 年 10月 13 0:30
 * @Version 1.0
 */
public class SingleLinkedListDemo1 {
    public static void main(String[] args) {
        //测试链表中各个方法是否正确：
        // 先创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        // 创建链表
        //SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        // 加入节点不按照顺序的加入
//        singleLinkedList1.add(heroNode1);
//        singleLinkedList1.add(heroNode3);
//        singleLinkedList1.add(heroNode2);
//        singleLinkedList1.add(heroNode4);
//        System.out.println("链表1：不按照顺序加入水浒人物链表信息");
//        //将链表1的人物编号为2的人物信息进行修改
//        singleLinkedList1.update(new HeroNode(2,"小卢","小麒麟"));
//        singleLinkedList1.list();//打印
        singleLinkedList2.addByOrder(heroNode1);
        singleLinkedList2.addByOrder(heroNode3);
        singleLinkedList2.addByOrder(heroNode2);
        singleLinkedList2.addByOrder(heroNode4);
        System.out.println("链表2：按顺序加入水浒人物的链表信息");
        //将链表2的人物编号为4的人物信息进行删除
        singleLinkedList2.delete(4);
        singleLinkedList2.list();//打印

    }
}
//定义一个SingleLinkedList管理我们的英雄
class SingleLinkedList {
    // 先初始化一个头结点，头结点不要动,不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");
    // 返回头结点
    public HeroNode getHead() {
        return head;
    }

    // 添加节点到单向链表中
    // 思路，不考虑编号顺序时
    // 1.找到当前链表的最后一个节点
    // 2.将最后这个节点的next域指向新的节点
    public void add(HeroNode heroNode) {
        // 因为head节点不能动，因此我们需要一个辅助变量temp
        HeroNode temp = head;

        // 遍历链表找到最后
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {
                break;
            }
            // 如果没有找到最后，就将temp后移
            temp = temp.next;
        }
        // 但退出循环while循环时，temp就指向了链表的最后
        // 将最后这个节点的next指向新的节点
        temp.next = heroNode;
    }
    // 第二种加入英雄的方式：根据英雄排名将英雄插入到制定的位置上(如果有这个排名,则添加失败，并给出提示 )
    public void addByOrder(HeroNode heroNode) {
        // 因为头结点不能动，因此我们任然通过辅助指针(变量)temp来帮助找到添加的位置
        // 因为是单链表，因此我们找的temp，是位于添加位置的前一个节点 ，否则插入不了
        HeroNode temp = head;
        boolean flag = false;// 标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {// 说明temp已经到链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {// 位置就找到了
                break;
            } else if (temp.next.no == heroNode.no) {// 说明希望添加的heroNode的编号已然存在了
                flag = true;// 说明编号存在
                break;
            }
            temp = temp.next;// temp后移，遍历当前的链表
        }
        // 判断flag的值
        if (flag) {// 不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号%d已经存在,不能加入\n", heroNode.no);
        } else {
            // 插入到链表中
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 完成修改节点的信息，根据编号no来修改，即no不能修改
    // 说明
    // 1.根据newHeroNode的no来修改即可
    public void update(HeroNode newHeroNode) {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }

        // 找到需要修改的节点，根究no编号来找
        // 定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;// 表示是否找到该节点
        while (true) {
            if (temp == null) {//
                break;// 表示链表已经遍历结束了
            }
            if (temp.no == newHeroNode.no) {// 找到了这个节点
                flag = true;// 找到
                break;// 找到就退出
            }
            temp = temp.next;// 后移
        }
        // 根据flag来判断是否找到需要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {// 没有找到
            System.out.printf("没有找到编号为%d的节点，不能修改\n", newHeroNode.no);
        }

    }

    // 删除节点
    // 思路：
    // 1.head节点不能动，因此我们需要一个temp辅助节点来找到待删除节点的前一个节点
    // 2.说明：我们在比较时，是temp.no 和 需要删除节点的no进行比较
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;// 标识是否找到待删除节点的前一个节点
        while (true) {
            if (temp.next == null) {// 说明我们已经遍历到链表的最后了
                break;
            }
            if (temp.next.no == no) {// 找到了待删除节点的前一个节点
                flag = true;// 找到
                break;
            }
            temp = temp.next;// temp后移，实现遍历

        }
        if (flag) {// 找到
            // 可以删除
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的%d号节点不存在\n", no);
        }
    }

    // 显示链表[遍历链表]
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头结点不能动，因此我们需要一个辅助变量temp来遍历
        HeroNode temp = head.next;
        while (true) {
            // 判断是否到链表的最后
            if (temp == null) {
                break;
            }
            // 输出节点的信息
            System.out.println(temp);
            // 将辅助变量后移
            temp = temp.next;
        }
    }
}

//定义一个HeroNode，每一个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;// 指向下一个节点

    // 构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;

    }

    // 为了后面打印显示方便，我们重新写toString方法
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}

