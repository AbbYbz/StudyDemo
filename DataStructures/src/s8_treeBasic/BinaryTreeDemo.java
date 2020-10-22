package s8_treeBasic;

import javax.naming.BinaryRefAddr;

/**
 * @author AbbYbz
 * @create 2020-09-05-18:19
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        HeroNode root = new HeroNode(1,"a");
        HeroNode node2 = new HeroNode(2,"b");
        HeroNode node3 = new HeroNode(3,"c");
        HeroNode node4 = new HeroNode(4,"d");
        HeroNode node5 = new HeroNode(5,"e");

        // 手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        System.out.println("########遍历########");
        System.out.println("pre:");
        binaryTree.preOrder();

        System.out.println("infix");
        binaryTree.infixOrder();

        System.out.println("post");
        binaryTree.postOrder();
        System.out.println();

        System.out.println("########查找########");
        HeroNode resNode = binaryTree.preOrderSearch(2);
        System.out.println();

    }
}


class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root){
        this.root = root;
    }

    // 前序遍历
    public void preOrder(){
        if(this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("binary tree is empty");
        }
    }

    // 中序遍历
    public void infixOrder(){
        if(this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("binary tree is empty");
        }
    }

    // 后序遍历
    public void postOrder(){
        if(this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("binary tree is empty");
        }
    }


    // 查找
    public HeroNode preOrderSearch(int no){
        if(root!=null){
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode infixOrderSearch(int no){
        if(root!=null){
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode postOrderSearch(int no){
        if(root!=null){
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }


    public void delNode(int no){
        if(root != null){
            if(root.getNo() == no){
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("empty tree~");
        }
    }
}


class HeroNode{

    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name){
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
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
    public HeroNode preOrderSearch(int no){
        System.out.println("preSearch");
        if(this.no == no){
            return this;
        }
        HeroNode resNode = null;
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


    public HeroNode infixOrderSearch(int no){
        HeroNode resNode = null;
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


    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null;
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


    // 删除
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

}