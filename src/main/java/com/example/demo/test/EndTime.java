package com.example.demo.test;

import com.thoughtworks.qdox.tools.QDoxTester;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang3.RandomUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guoyanrui on 2022/3/16
 */
public class EndTime {
    //charu
    public static void inserinto(int[] nums) {
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

    //erfenchazhao
    public static int binary(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //maopao
    public static void bubble(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
//http
    @Test
    void send() throws IOException {
        CloseableHttpClient build = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("http://baidu.com");
        CloseableHttpResponse execute = build.execute(get);
        System.out.println(execute);

    }
    public static void main(String[] args) throws IOException {
        int[] nums = {1, 5, 23, 43, 76, 45, 87, 435, 7, 9865, 86};
        inserinto(nums);

        System.out.println(Arrays.toString(nums));

    }
}
