package com.yyf.test;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author yyf
 * @date 2023/3/28 13:52
 * @Description
 */
public class OneTest {
    @Test
    public void test1(){
        String str = "121312312312312312";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i > 3 && i < 15){
                chars[i] = '*';
            }
        }
        str = new String(chars);
        System.out.println(str);
    }

    @Test
    public void test2(){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("src/main/resources/sparseArray.data");
            bufferedReader = new BufferedReader(fileReader);
            char[] chars = new char[8];
            String line = "";
            String[] strs = new String[10];
            int sum = 0;
            while ((line = bufferedReader.readLine()) != null){
                strs[sum] = line;
                sum ++;
            }
            int sparseArray[][] = new int[sum][3];

            for (int i = 0; i < sparseArray.length; i++) {
                    line = strs[i];
                    String[] strings = line.split(" ");
                    sparseArray[i][0] = Integer.parseInt(strings[0]);
                    sparseArray[i][1] = Integer.parseInt(strings[1]);
                    sparseArray[i][2] = Integer.parseInt(strings[2]);
            }
            System.out.println("打印稀疏数组");
            for (int[] row : sparseArray) {
                for (int i : row) {
                    System.out.printf("%d\t", i);
                }
                System.out.println();
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}