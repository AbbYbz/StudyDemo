package s1;

import com.sun.tools.javac.Main;

import javax.swing.*;

/**
 * @author AbbYbz
 * @create 2020-08-19-19:39
 */
public class sparsearry {

    public static void main(String[] args) {
        int arr1[][] = new int[11][11];
        arr1[1][2] = 1;
        arr1[2][3] = 2;
        arr1[6][7] = 11;
        for (int[] row: arr1){
            for(int data: row){
                System.out.printf(data+"\t");
            }
            System.out.println();
        }

        // 转稀疏
        int sum = 0;
        for(int i=0; i< arr1.length; i++){
            for(int j=0; j< arr1[i].length; j++){
                if(arr1[i][j] != 0){
                    sum++;
                }
            }
        }

        // 创建稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int cnt = 0;
        for(int i=0; i< arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j] != 0) {
                    cnt++;
                    sparseArr[cnt][0] = i;
                    sparseArr[cnt][1] = j;
                    sparseArr[cnt][2] = arr1[i][j];

                }
            }
        }

        // show
        System.out.println();
        System.out.println("sparseArray:");
        for(int i=0; i< sparseArr.length; i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }

        // 恢复为二维
        int arr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 赋值
        for(int i=1;i< sparseArr.length; i++){
            arr2[sparseArr[i][0]][sparseArr[i][1]]= sparseArr[i][2];
        }
        // show
        System.out.println();
        System.out.println("2dArray:");
        for(int row[]: arr2){
            for(int data: row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
