package com.kingyi.sort;

/**
 * Created by xiaoyiyiyo on 2017/8/12.
 */
public class BubbleSort {
    public static void sort(int[] arr) {
        int count = arr.length;
        int temp = 0;
        System.out.println("need to sort : " + toPrintArrayByComma(arr));
        for (int i = 1; i < count; i++) {
            for (int j = 0; j < count - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("after " + i + " sort : " + toPrintArrayByComma(arr));
        }
    }

    private static String toPrintArrayByComma(int[] arr) {
        if (arr == null || arr.length == 0){
            return null;
        }

        int arrLength = arr.length;

        if(arrLength == 1) {
            return String.valueOf(arr[0]);
        }

        StringBuilder sb = new StringBuilder(arrLength * 2);
        for (int i = 0; i < arrLength - 1; i++) {
            sb.append(arr[i]).append(",");
        }
        sb.append(arr[arrLength - 1]);

        return sb.toString();
    }

    public static void main(String args[]){
        int[] arr = new int[]{9, 7, 5, 3, 2, 1, 0};
        sort(arr);
    }
}
