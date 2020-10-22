package s2;

import java.util.concurrent.ForkJoinPool;

/**
 * @author AbbYbz
 * @create 2020-08-26-20:49
 */
public class Josephu {

    public static void main(String[] args) {

    }
}


class CirclSingleLinkedList{

    private Boy first = null;

    public void addBoy(int nums){
        if(nums<1){
            System.out.println("numsError");
        }

        // 辅助指针
        Boy cur = null;

        for (int i = 1; i < nums; i++) {
            Boy boy = new Boy(i);
            if(i==1){
                first = boy;
                first.setNext(first); // 构成环   // 感觉没有必要
                cur = first;
            } else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }
        }
    }



    public void showBoy(){
        if (first == null){
            System.out.println("no child");
        }

        Boy cur = first;
        while (true){
            System.out.println("child's no:"+cur.getNo());
            if(cur.getNext() == first) {     // 说明已经遍历完毕
                break;
            }
            cur = cur.getNext();
        }
    }


    /**
     * question: 根据用户输入，计算出小孩出圈的顺序
     *
     * @param startNo
     * @param countNum
     * @param nums
     */
    public void countBoy(int startNo, int countNum, int nums){
        if(first==null || startNo<1 || startNo>nums){
            System.out.println("参数输入有误");
        }

        // 单向环形链表 需要同时记录头节点和尾部节点
        Boy cur = first;
        while (true){
            if(cur.getNext() == first){
                break;
            }
            cur = cur.getNext();
        }

        for (int j = 0; j < startNo-1; j++) {
            first = first.getNext();
            cur = cur.getNext();
        }

        while (true){
            if(cur == first){
                break;
            }

            for (int j = 0; j < countNum-1; j++) {
                first = first.getNext();
                cur = cur.getNext();
            }

            System.out.println("child's no="+first.getNo()+" out!");
            first = first.getNext();
            cur.setNext(first);
        }

    }
}



class Boy{
    private int no;
    private Boy next;

    public Boy(int no){
        this.no = no;
    }

    public int getNo(){
        return no;
    }

    public void setNo(int no){
        this.no = no;
    }

    public Boy getNext(){
        return next;
    }

    public void setNext(Boy next){
        this.next = next;
    }
}