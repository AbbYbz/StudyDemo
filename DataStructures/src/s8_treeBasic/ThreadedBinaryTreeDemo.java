package s8_treeBasic;

import java.nio.channels.Pipe;

/**
 * 线索二叉树
 *
 * @author AbbYbz
 * @create 2020-09-06-17:48
 */
public class ThreadedBinaryTreeDemo {

    HeroNode root = new HeroNode(1,"a");
    HeroNode node2 = new HeroNode(2,"b");
    HeroNode node3 = new HeroNode(3,"c");
    HeroNode node4 = new HeroNode(4,"d");
    HeroNode node5 = new HeroNode(5,"e");
    HeroNode node6 = new HeroNode(6,"f");

}


class ThreadedBinaryTree {
    private HeroNode root;
    private HeroNode preNode = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedList(){
        HeroNode node = root;
        while (node != null){

        }
    }

//    public void threadedNodes(){
//        this.threadedNodes(root);
//    }
}



class HeroNode2 {
    private int no;
    private String name;
    private HeroNode2 left;
    private HeroNode2 right;

    private int leftType;
    private int rightType;

    public HeroNode2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode2 getLeft() {
        return left;
    }

    public void setLeft(HeroNode2 left) {
        this.left = left;
    }

    public HeroNode2 getRight() {
        return right;
    }

    public void setRight(HeroNode2 right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void delNode(int no){
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        if(this.left != null){
            this.left.delNode(no);
        }
        if(this.right != null){
            this.right.delNode(no);
        }
    }

    // 遍历
    // 前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    // 中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }

    // 后序遍历
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }


    // 查找
    public HeroNode2 preOrderSearch(int no){
        System.out.println("preSearch");
        if(this.no == no){
            return this;
        }
        HeroNode2 resNode = null;
        if(this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode != null){    //
            return resNode;
        }
        if(this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }


    public HeroNode2 infixOrderSearch(int no){
        HeroNode2 resNode = null;
        if(this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        System.out.println("infixSearch");
        if(this.no == no){
            return this;
        }
        if(this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }


    public HeroNode2 postOrderSearch(int no){
        HeroNode2 resNode = null;
        if(this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if(this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        System.out.println("postSearch");
        if(this.no == no){
            return this;
        }
        return resNode;
    }
}