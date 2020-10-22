package s1_multithreading.p1;

/**
 * @author AbbYbz
 * @create 2020-09-07-20:31
 */
public class test {
    public static void main(String[] args) {
        testThread myThread = new testThread();
        Thread t1 = new Thread(myThread);
    }

}


class testThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
