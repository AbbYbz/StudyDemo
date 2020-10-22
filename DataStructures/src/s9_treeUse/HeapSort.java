package s9_treeUse;

/**
 * @author AbbYbz
 * @create 2020-09-06-19:57
 */
public class HeapSort {

    public static void main(String[] args) {

        int arr[] = {4,6,8,5,9};
    }

    public static void heapSort(int arr[]){
        int temp = 0;
        System.out.println("heapSort~");

        for (int i = arr.length/2-1; i >= 0 ; i++) {

        }
    }

    public static void adjustHeap(int arr[], int i, int length){

        int temp = arr[i];

        // 遍历左子结点
        for(int k=2*i+1; k<length; k=k*2+1){
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            if(arr[k]>temp){
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
