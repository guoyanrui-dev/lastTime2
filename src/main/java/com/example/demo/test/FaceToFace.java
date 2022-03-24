package com.example.demo.test;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author guoyanrui on 2022/2/28
 */
public class FaceToFace {
    public static void insertObject(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int index = i - 1;
            while (index >= 0 && value < nums[index]) {
                nums[index + 1] = nums[index];
                index--;
            }
            nums[index + 1] = value;
        }
    }

    //快速排序
    public static void quikly(int[] nums, int left, int right) {
        if (left > right) return;
        int i = left;
        int j = right;
        int base = nums[i];
        while (i != j) {
            while (nums[j] >= base && i < j) {
                j--;
            }
            while (nums[i] <= base && i < j) {
                i++;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[left] = nums[i];
        nums[i] = base;
        quikly(nums, left, i - 1);
        quikly(nums, i + 1, right);
    }

    //xuanze
    public static void sele(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
    }

    @Test
    public static void test() {
        int[] nums = {43, 54, 23, 6, 7, 8, 12, 3, 6577, 886};
//        insertObject(nums);
//        quikly(nums, 0, nums.length - 1);
        sele(nums);
        System.out.println(Arrays.toString(nums));
    }
}
