package s2;

import javax.sound.midi.Soundbank;
import javax.swing.plaf.BorderUIResource;
import java.util.Stack;

/**
 * @author AbbYbz
 * @create 2020-08-25-22:32
 */
public class SingleLinkedListDemo {
}


class SingleLinkedList {
    private HeroNode head = new HeroNode(0,"","");

    public void add(HeroNode heroNode) {

        HeroNode temp = head;

        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode){

        HeroNode temp = head.next;
        boolean flag = false;

        while (true) {
            if(temp.next == null){
                break;
            }
            if (temp.next.no > heroNode.no){
                break;
            } else if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            System.out.printf("no=%d的已经有了\n", heroNode.no);
        } else {
            temp.next = heroNode;
            heroNode.next = temp.next;
        }
    }

    // 修改节点信息，根据no编号来修改
    public void update(HeroNode newHeroNode){
        if(head.next == null){
            System.out.println("空链表");
        }

        HeroNode temp = head;
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

        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.println("没有这个编号："+newHeroNode.no);
        }
    }


    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.println("没有这个编号："+no);
        }
    }


    public void list(){
        if (head.next == null){
            System.out.println("空链表");
        }
        HeroNode temp = head.next;
        while (true){
            if (temp.next == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }


    /**
     * question: 求单链表中有效节点的个数
     *
     * @param head
     * @return num
     */
    public static int getLength(HeroNode head){
        if(head.next == null){
            return 0;
        }
        HeroNode temp = head.next;
        int num = 1;
        while (true){
            if(temp.next == null){
                break;
            }
            num++;
            temp = temp.next;
        }
        return num;
    }


    /**
     * question: 查找单链表中的倒数第k个几点
     *
     * @param head
     * @param index
     * @return
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index){
        if(head.next == null){
            return null;
        }
        int size = getLength(head);

        // test index
        if(index<=0 || index>size){
            return null;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < size-index; i++) {
            temp = temp.next;
        }
        return temp;
    }


    /**
     * question: 将单链表反转（腾旭）
     *
     * @param head
     */
    public static void reverseList(HeroNode head){
        if(head.next==null||head.next.next==null){
            return;
        }

        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0,"","");
        while (cur != null) {
            next = cur.next;
            // 插到reverseHead最前端
            reverseHead.next = cur;
            cur.next = reverseHead.next;
            // 迭代
            cur = next;
        }
        head.next = reverseHead.next;
    }


    /**
     * question: 逆向打印单链表
     *
     * @param head
     */
    public static void reversePrint(HeroNode head){
        if(head.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;

        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }

        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

}


class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\''+
                '}';
    }
}

