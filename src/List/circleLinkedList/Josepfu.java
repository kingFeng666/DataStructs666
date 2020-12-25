package List.circleLinkedList;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @ClassName: Josepfu
 * @Description:环形链表的使用 约瑟夫问题
 * @Author: 李峰
 * @Date: 2020 年 10月 15 14:54
 * @Version 1.0
 */
/*
 *单向环形链表
 *Josephu 问题为：设编号为 1，2，… n 的 n 个人围坐一圈，约定编号为 k（1<=k<=n）的人从 1 开始报数，数到
 * m 的那个人出列，它的下一位又从 1 开始报数，数到 m 的那个人又出列，依次类推，直到所有人出列为止，由此
 *产生一个出队编号的序列。
 * n=5
 * k=1
 * m=2
*/
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        circleSingleLinkedList.list();
        circleSingleLinkedList.getBoy(2,2,5);
    }
}
//2.创建单向环形链表
class CircleSingleLinkedList {
    //创建一个first头结点
    private BoyNode first = null;
    //创建添加方法
    public void add(int nums) {
        //nums 表示链表的元素个数
        //1)先对nums进行正确性检验
        if (nums < 1) {
            System.out.println("数值输入有误,请输入大于1的数");
            return;
        }
        //添加条件分为两种情况
        //1.第一个小孩   创建first 让first指向该节点形成环
        //建立辅助节点,用来添加数据   因为头结点不能移动
        BoyNode curBoy = null;
        //使用for循环来
        for (int i = 1; i <= nums; i++) {
            BoyNode boyNode = new BoyNode(i);
            if (i == 1) {
                //第一个小孩做特殊处理
                first = boyNode;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boyNode);
                boyNode.setNext(first);
                curBoy = boyNode;
            }
        }
    }
    //遍历单向循环链表
    public void list() {
        if (first == null) {
            System.out.println("单链表为空");
            return;
        }
        //头结点不能移动  创建辅助节点来辅助遍历
        BoyNode curBoy = first;
        while (true) {
            System.out.printf("小孩的编号为 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                System.out.println("说明遍历完毕");
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
    /*
     * startNo 表示从那个小孩开始报数
     * countNum  表示数几下后出圈
     * nums表示最初有多少个小孩
     *
     */
    public void getBoy(int startNo, int countNum, int nums) {
        //先对数据进行正确性校验
        if (first == null || startNo < 0 || startNo > nums) {
            System.out.println("输入的数字不合法...");
            return;
        }
        //创建辅助节点来辅助出圈
        BoyNode helper = first;
        //出圈思路
        //1.first节点和helper节点同时一定startNo-1次,找到要出圈的元素
        //helper指向first的前一个位置 所以先要让helper节点指向最后
        while (true) {
            if (helper.getNext() == first) {
                //找到了最后
                break;
            }
            helper = helper.getNext();
        }
        //然后让first和helper移动 移动到开始报数的位置
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //然后开始报数 让first节点和helper节点同时一定countNums-1
        while (true) {
            if (helper == first) {
                break;
            }
            //指针开始移动  first指向的节点就是要出圈的节点
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("要出圈的小孩 %d\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后剩余的小孩是%d\n",first.getNo());
    }
}
//1.先创建环形链表 先创建一个节点类
class BoyNode{
    private int no;//小孩的标号
    private BoyNode next;//指向下一个小孩

    public BoyNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public BoyNode getNext() {
        return next;
    }

    public void setNext(BoyNode next) {
        this.next = next;
    }
    @Override
    public String toString() {
        return "BoyNode{" +
                "no=" + no +
                ", next=" + next +
                '}';
    }
}


