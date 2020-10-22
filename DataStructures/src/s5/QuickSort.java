package s5;

/**
 * @author AbbYbz
 * @create 2020-09-01-20:04
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {-9,78,0,23,-567,70,-1,900,4561};

        quickSort(arr, 0, arr.length-1);
    }


    public static void quickSort(int[] arr, int left, int right){

        int l = left;
        int r = right;
        int pivot = arr[(left+right)/2];  // 中轴值
        int temp = 0;

        while (l<r) {
            while (arr[l]<pivot){
                l+=1;
            }
            while (arr[r]>pivot){
                r-=1;
            }

            if(l>=r){
                break;
            }

            // swap
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // r处于正中间 不动
            if(arr[l] == pivot){
                r-=1;
            }

            // l处于正中间 不动
            if(arr[r] == pivot){
                l+=1;
            }
        }

        // 刚好都收缩到正中间
        if(l == r){
            l+=1;
            r-=1;
        }

        // 递归
        if(left<r){
            quickSort(arr,left,r);
        }

        // 递归
        if(right>l){
            quickSort(arr,l,right);
        }
    }
}
