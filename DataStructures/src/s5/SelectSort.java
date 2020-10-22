package s5;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * @author AbbYbz
 * @create 2020-08-31-21:58
 */
public class SelectSort {

    public static void main(String[] args) {

        int[] arr = {101,34,119,1,-1,90,123};

        selectSort(arr);

        System.out.println();
        System.out.println("result: ");
        System.out.println(Arrays.toString(arr));

    }


    public static void selectSort(int[] arr){

        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            int minValue = arr[i];
            for (int j = i+1; j < arr.length-1; j++) {
                if(minValue>arr[j]){
                    minIndex = j;
                    minValue = arr[j];
                }
            }

            if(minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }

            System.out.println((i+1)+"-sort: (changeValue="+minValue+")");
            System.out.println(Arrays.toString(arr));
        }
    }
}
