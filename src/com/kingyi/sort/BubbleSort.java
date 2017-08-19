package com.kingyi.sort;

/**
 * Created by xiaoyiyiyo on 2017/8/12.
 */
public class BubbleSort {
    public static void sort(int[] arr) {
        int count = arr.length;
        int temp = 0;
        System.out.println("need to sort : " + ArrayUtil.toPrintArrayByComma(arr));
        for (int i = 1; i < count; i++) {
            for (int j = 0; j < count - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("after " + i + " sort : " + ArrayUtil.toPrintArrayByComma(arr));
        }
    }

    public static void main(String args[]){
        int[] arr = new int[]{9, 7, 5, 3, 2, 1, 0};
        sort(arr);
    }
}
