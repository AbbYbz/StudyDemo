package s8_treeBasic;

/**
 *
 * 第n个元素的左子节点 2n+1
 * 第n个元素的右子节点 2n+2
 * 第n个元素的父节点 (n-1)/2
 *
 * @author AbbYbz
 * @create 2020-09-06-17:40
 */
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};

    }
}


class ArrBinaryTree {

    private int[] arr;

    public ArrBinaryTree(int[] arr){
        this.arr = arr;
    }

    public void preOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("empty arrTree");
        }
        System.out.println(arr[index]);
        if((index*2+1)<arr.length){
            preOrder(2*index+1);
        }
        if((index*2+2)< arr.length){
            preOrder(2*index+2);
        }
    }

}
