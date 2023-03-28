package com.yyf.sparsearray;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author yyf
 * @date 2023/3/27 17:49
 * @Description
 */
public class SparseArray {
    public static void main(String[] args) {
        //定义一个二维数组11*11
        int chessArray[][] = new int [11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[4][5] = 2;
        System.out.println("打印初始二维数组");
        //定义一个变量，用于记录稀疏数组非零总数
        int sum = 0;
        for (int[] row : chessArray) {
            for (int i : row) {
                if (i != 0){
                    sum++;
                }
                System.out.printf("%d\t",i);
            }
            System.out.println();
        }

        System.out.println();

        //创建一个稀疏数组
        int sparseArray[][] = new int[sum+1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //定义一个变量，用于记录稀疏数组的行数
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }
            }
        }
        System.out.println("打印稀疏数组~\n");
        //存文件
        String filePath = "sparseArray.data";
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
             fileOutputStream = new FileOutputStream(filePath, false);
             bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            //打印稀疏数组
            for (int[] row : sparseArray) {
                for (int i : row) {
                    System.out.printf("%d\t",i);
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //稀疏数组转二维数组
    }
}
