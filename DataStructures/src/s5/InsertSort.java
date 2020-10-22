package s5;

import java.util.Arrays;

/**
 * @author AbbYbz
 * @create 2020-08-31-22:09
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] arr = {101,34,119,1,-1,89};

        insertSort(arr);
    }


    public static void insertSort(int[] arr){

        int insertValue = 0;
        int insertIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            insertIndex = i-1;

            while (insertIndex>=0 && insertValue<arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }

            if(insertIndex+1!=i){
                arr[insertIndex+1] = insertValue;
            }

            System.out.println(i+"-sort: ");
            System.out.println(Arrays.toString(arr));
        }
    }

}
