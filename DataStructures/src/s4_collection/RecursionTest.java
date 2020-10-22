package s4_collection;

/**
 * @author AbbYbz
 * @create 2020-08-31-20:30
 */
public class RecursionTest {

    public static void main(String[] args) {
        int res = factorial(3);
        System.out.println("res="+res);
    }

    // 打印问题
    public static void test(int n){
        if(n>2){
            test(n-1);
        }
    }

    // 阶乘问题
    public static int factorial(int n){
        if(n==1){
            return 1;
        } else {
            return factorial(n-1)*n;
        }
    }

}