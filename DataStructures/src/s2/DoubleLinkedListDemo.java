package s2;

import java.time.temporal.Temporal;

/**
 * @author AbbYbz
 * @create 2020-08-26-20:18
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {

    }

}


class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0,"","");


    public HeroNode2 getHead(){
        return head;
    }


    public void list(){
        if (head.next == null){
            System.out.println("空链表");
        }
        HeroNode2 temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }


    public void add(HeroNode2 heroNode){

        HeroNode2 temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }


    public void update(HeroNode2 newHeroNode){
        if(head.next == null){
            System.out.println("空链表");
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.println("没有编号:"+newHeroNode.no);
        }
    }


    public void del(int no){
        if(head.next == null){
            System.out.println("空链表");
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.pre.next = temp.next;
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("没有编号:"+no);
        }
    }


}


class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}