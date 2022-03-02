package com.example.demo.test;

import java.io.*;

/**
 * @author guoyanrui on 2022/2/22
 */
public class Sort {
    //charu
    public static void charu(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int insertValue = nums[i];
            int index = i - 1;
            while (index >= 0 && insertValue < nums[index]) {
                nums[index + 1] = nums[index];
                index--;
            }
            nums[index + 1] = insertValue;
        }

    }

    //xuanze
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
    }
//read
    public static void read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\etst.txt'"));
        String str = null;
        while ((str=reader.readLine())!=null){
            System.out.println(str);
        }
        reader.close();
    }
    //write
    public static void write() throws IOException {
        FileWriter writer = new FileWriter("src\\main\\resources\\etst.txt'",true);
        writer.write("\rhello!everyone");
        writer.close();
    }
    //zi
    public static void readin() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("src\\main\\resources\\etst.txt'"));
        char[] chars=new char[inputStreamReader.read()];
        int length;
        while ((length=inputStreamReader.read(chars))!=-1){
            System.out.println(chars);
        }
        inputStreamReader.close();
    }
    public static void main(String[] args) throws IOException {
        write();
        read();
//        readin();
    }
}
