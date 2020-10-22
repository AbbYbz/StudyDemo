package s6_search;

import javax.naming.BinaryRefAddr;
import java.util.ArrayList;
import java.util.List;

/**
 * @author AbbYbz
 * @create 2020-09-01-23:23
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1,8,10,89,1000,1000,1234};

        int resIndex = binarySearch(arr,0, arr.length-1, 1000);
        System.out.println("resIndex="+resIndex);
        // resIndex仅返回5

        List<Integer> resIndexList = binarySearch2(arr,0,arr.length-1,1000);
        System.out.println("resIndexList="+resIndexList);

    }


    public static int binarySearch(int[] arr, int left, int right, int value){
        if(right<left){
            return -1;
        }
        int mid = (left+right)/2;
        int midValue = arr[mid];

        if(value > midValue){
            return binarySearch(arr, mid+1, right, value);
        } else if (value < midValue){
            return binarySearch(arr, left, mid-1,value);
        } else {
            return mid;
        }
    }


    // 升级版
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int value){

        if(right<left){
            return new ArrayList<Integer>();
        }
        int mid = (left+right)/2;
        int midValue = arr[mid];

        if(value > midValue){
            return binarySearch2(arr, mid+1, right, value);
        } else if (value < midValue){
            return binarySearch2(arr, left, mid-1,value);
        } else {
            // return mid;
            List<Integer> resIndexList = new ArrayList<Integer>();

            // search left value
            int temp = mid-1;
            while (true){
                if(temp<0 || arr[temp]!=value){
                    break;
                }
                resIndexList.add(temp);
                temp-=1;
            }

            resIndexList.add(mid);

            // search right value
            temp = mid+1;
            while (true){
                if(temp> arr.length-1 || arr[temp]!=value){
                    break;
                }
                resIndexList.add(temp);
                temp+=1;
            }

            return resIndexList;
        }
    }

}
