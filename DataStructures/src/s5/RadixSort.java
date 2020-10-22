package s5;

import java.util.Arrays;

/**
 * @author AbbYbz
 * @create 2020-09-01-21:31
 */
public class RadixSort {

    public static void main(String[] args) {

        int[] arr = {53,3,542,748,14,214};

        radixSort(arr);

        System.out.println(Arrays.toString(arr));

    }


    public static void radixSort(int[] arr){

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max+"").length();

        // 桶
        int[][] bucket = new int[10][arr.length];

        int[] bucketElementCounts = new int[10];


        for(int i=0, n=1; i<maxLength; i++, n*=10){

            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j]/n%10;   // 个位，十位，百位...
                bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            // 桶标签
            int index = 0;
            // 遍历每个桶
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if(bucketElementCounts[k]!=0){  // 该桶中有数据
                    for (int j = 0; j < bucketElementCounts[k]; j++) {
                        arr[index++] = bucket[k][j];
                    }
                }
                bucketElementCounts[k] = 0;
            }
        }


    }
}
