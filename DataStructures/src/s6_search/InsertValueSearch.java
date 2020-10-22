package s6_search;

/**
 * @author AbbYbz
 * @create 2020-09-02-23:38
 */
public class InsertValueSearch {

    public static void main(String[] args) {

        int arr[] = {1,8,10,89,1000,1000,1234};

    }


    public static int insertValueSearch(int[] arr, int left, int right, int value){

        if(left>right || value<arr[0] || value>arr[arr.length-1]){
            return -1;
        }

        int mid = left+(right-left)*(value-arr[left])/(arr[right]-arr[left]);
        int midValue = arr[mid];
        if (value>midValue){
            return insertValueSearch(arr,mid+1,right,value);
        } else if(value<midValue){
            return insertValueSearch(arr, left,mid-1,value);
        } else {
            return mid;
        }
    }
}
