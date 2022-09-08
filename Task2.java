package ru.zotin;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 7};
        int t = 10;
        System.out.println(Arrays.toString(search(arr,t)));
    }

    public static int[] search(int[] numbers,int target) {

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{numbers[i], numbers[j]};
                }
            }
        }
        return numbers;
    }
}
