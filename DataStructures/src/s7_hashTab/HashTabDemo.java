package s7_hashTab;

/**
 * 感觉就是简单的多个链表组成的数组
 *
 * @author AbbYbz
 * @create 2020-09-02-23:51
 */
public class HashTabDemo {

    public static void main(String[] args) {


    }
}


// 创建HashTab管理多条链表
class HashTab {

    private EmpLinkedList[] empLinkedListArray;
    private int size;


    public HashTab(int size){
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        // ***
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }


    public void add(Emp emp){
        int empLinkedListNo = hashFun(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);
    }


    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }


    public void find(int id){
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].find(id);
        if(emp!=null){
            System.out.println("id="+id+" was found");
        } else {
            System.out.println("no found");
        }
    }



    public int hashFun(int id){
        return id%size;
    }

}


// 雇员
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name){
        super();
        this.id = id;
        this.name = name;
    }
}


// 雇员链表
class EmpLinkedList {

    private Emp head;

    public void add(Emp emp){
        if(head==null){
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true){
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    public void list(int no) {
        if(head == null) {
            System.out.println(no+" LinkedList is empty");
            return;
        }
        System.out.println(no+" LinkedList message:");
        Emp curEmp = head;
        while (true){
            System.out.printf("=> id=%d,name=%s\t", curEmp.id, curEmp.name);
            if(curEmp.next==null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    public Emp find(int id){
        if(head == null) {
            System.out.println("LinkedList is empty");
            return null;
        }
        Emp curEmp = head;
        while (true){
            if(curEmp.id == id){
                break;
            }
            if(curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}