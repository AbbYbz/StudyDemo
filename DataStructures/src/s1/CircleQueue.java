package s1;

/**
 * @author AbbYbz
 * @create 2020-08-25-22:02
 */
public class CircleQueue {
}


class CircleArrayQueue {
    private int maxSize;
    private int front = 0;  // tou
    private int rear = 0;   // wei
    private int[] arr;

    public CircleArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列满");
        }
        arr[rear] = n;
        rear = (rear+1)%maxSize;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空");
        }
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    public void showQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空");
        }
        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空");
        }
        return arr[front];
    }
}
