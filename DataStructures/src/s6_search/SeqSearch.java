package s6_search;

/**
 * @author AbbYbz
 * @create 2020-09-01-23:20
 */
public class SeqSearch {

    public static void main(String[] args) {

        int arr[] = {1,9,11,-1,34,89};
        int index = seqSearch(arr, 11);

        System.out.println(index);

    }

    public static int seqSearch(int[] arr, int value){

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
