package com.yyf.sparsearray;

import java.io.*;

/**
 * @author yyf
 * @date 2023/3/27 17:49
 * @Description
 */
public class SparseArray {
    public static void main(String[] args) {
        //定义一个二维数组11*11
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[4][5] = 2;
        System.out.println("打印初始二维数组");
        //定义一个变量，用于记录稀疏数组非零总数
        int sum = 0;
        for (int[] row : chessArray) {
            for (int i : row) {
                if (i != 0) {
                    sum++;
                }
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }

        System.out.println();

        //创建一个稀疏数组
        int sparseArray[][] = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //定义一个变量，用于记录稀疏数组的行数
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }
            }
        }
        System.out.println("打印稀疏数组~\n");
        //存文件
        String filePath = "src/main/resources/sparseArray.data";
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(filePath, false);
            bufferedWriter = new BufferedWriter(fileWriter);

            //打印稀疏数组
            for (int[] row : sparseArray) {
                for (int i : row) {
                    bufferedWriter.write(i + " ");
                    System.out.printf("%d\t", i);
                }
                bufferedWriter.newLine();//换行
                System.out.println();
            }
            bufferedWriter.flush();//将缓存区的内容存入磁盘文件
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //稀疏数组转二维数组
        int chessArray2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("\n稀疏数组转二维数组");
        for (int[] row : chessArray2) {
            for (int i : row) {
                System.out.printf("%d\t",i);
            }
            System.out.println();
        }
    }

    String getResourcePath(){
        return this.getClass().getClassLoader().getResource("sparseArray.data").getPath();
    }

}
