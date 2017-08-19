package com.kingyi.sort;

/**
 * Created by xiaoyiyiyo on 2017/8/13.
 */
public class ArrayUtil {
    public static String toPrintArrayByComma(int[] arr) {
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
}
