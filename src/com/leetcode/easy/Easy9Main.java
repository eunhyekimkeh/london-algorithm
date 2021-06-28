package com.leetcode.easy;

import javafx.scene.chart.Chart;

public class Easy9Main {

    public static void main(String[] str){
        System.out.println(isPalindrome(10));
    }
    public static boolean isPalindrome(int x) {
        boolean isNotPalindrome = false;

        if(x < 0){
            isNotPalindrome = true;
        }

        char[] arr = String.valueOf(x).toCharArray();


        for(int i=0; i< arr.length /2;i++){
            if(arr[i] != arr[arr.length-(i+1)]){
                isNotPalindrome = true;
            }
        }


        return !isNotPalindrome;

    }
}
