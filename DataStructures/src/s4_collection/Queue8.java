package s4_collection;

/**
 * @author AbbYbz
 * @create 2020-08-31-21:00
 */
public class Queue8 {

    int max = 8;
    int[] location = new int[max];

    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("解法共计: "+count);
        System.out.println("判断冲突次数共计: "+judgeCount);
    }

    private void check(int n){

        if (n==max){
            print();
            return;
        }

        for (int i = 0; i < max; i++) {
            location[n] = i;
            if(judge(n)){ // 如果不冲突
                check(n+1);
            }
        }
    }


    /**
     *
     * @param n
     * @return
     */
    private boolean judge(int n){

        judgeCount++;
        for (int i = 0; i < n; i++) {
            if(location[i] == location[n] ||
                    Math.abs(n-i) == Math.abs(location[n]-location[i])){
                return false;
            }
        }
        return true;
    }


    private void print(){
        count++;
        for (int i = 0; i < location.length; i++) {
            System.out.print(location[i]+" ");
        }
        System.out.println();
    }

}
