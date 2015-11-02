package com.kingyi.quick_sort;

public class QuickSort {
	public static void main(String[] args){
		int[] demo = new int[]{5,1,3,4,7,9,2,0,8,6};
		
		quick_sort(demo,0,9);
		
		for (int i = 0; i < demo.length; i++) {
			System.out.print(demo[i]+"  ");
		}
	}

	public static void quick_sort(int demo[], int start, int end) {
		if (start < end) {
			int left = start, right = end;
			int key = demo[start];

			while (left < right) {
				while (left < right && key <= demo[right]) {
					--right;
				}

				if (left < right) {
					demo[left] = demo[right];
				}

				while (left < right && key > demo[left]) {
					++left;
				}

				if (left < right) {
					demo[right] = demo[left];
				}
			}
			
			demo[left] = key;
			quick_sort(demo,start,left-1);
			quick_sort(demo,right+1,end);

		}
	}
}
