package s5;

import java.util.Arrays;

/**
 * @author AbbYbz
 * @create 2020-08-31-23:14
 */
public class ShellSort {

    public static void main(String[] args) {

        int[] arr = {8,9,1,7,2,3,5,4,6,0};

        shellSort(arr);
    }

    // 交换法
    public static void shellSort(int[] arr){

        int temp = 0;
        int count = 0;

        for(int gap=arr.length/2; gap>0; gap/=2){
            for (int i = gap; i < arr.length; i++){
                for(int j=i-gap; j>=0; j-=gap){
                    if(arr[j]>arr[j+gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println((++count)+"-sort: ");
            System.out.println(Arrays.toString(arr));
        }
    }


    // 对交换式的希尔排序进行优化 -> 移位法
    public static void shellSort2(int[] arr){
        for(int gap = arr.length/2; gap>0; gap/=2){

            // 插入排序
            for(int i=gap; i<arr.length; i++){

                int j=i;
                int temp = arr[j];

                if(arr[j]<arr[j-gap]){
                    while (j-gap>=0 && temp<arr[j-gap]){
                        arr[j] = arr[j-gap];
                        j-=gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
}
