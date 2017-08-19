package com.kingyi.sort;

/**
 * Created by xiaoyiyiyo on 2017/8/13.
 */
public class InsertSort {
    public static void sort(int[] arr){
        System.out.println("need to sort : " + ArrayUtil.toPrintArrayByComma(arr));
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = key;
            System.out.println("after " + i + " sort : " + ArrayUtil.toPrintArrayByComma(arr));
        }
    }

    public static void main(String args[]){
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
    }
}
