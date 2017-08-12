package com.kingyi.sort;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] demo = {3,5,9,6,1,2,0,4,8,7};
		merge_Sort(demo,0,9);
		System.out.println(Arrays.toString(demo));
	}
	
	public static void merge_Sort(int demo[], int begin, int end){
		int mid = (begin + end)/2;
		if(begin < end){
			merge_Sort(demo,begin,mid);
			merge_Sort(demo,mid+1,end);
			merge(demo,begin,mid,end);
		}
	}
	
	public static void merge(int demo[], int begin, int mid, int end){
		int [] temp = new int[end - begin + 1];
		int left = begin, right = mid + 1, k = 0;
		
		while(left <= mid && right <= end){
			temp[k++] = demo[left] < demo[right] ? demo[left++] : demo[right++];
		}
		
		while(left <= mid){
			temp[k++] = demo[left++];
		}
		
		while(right <= end){
			temp[k++] = demo[right++];
		}
		
		System.arraycopy(temp, 0, demo, begin, temp.length);
	}
}
