package com.kingyi.sort;

public class HeapSort {
	public static void main(String[] args) {
		int demo[] = new int[]{17,8,2,84,94,45};
		buildMaxHeap(demo);
		for (int i = demo.length - 1; i >= 1; i--) {  
			exchange(demo, 0, i);
            FixHeap(demo, i, 0);  
        }
		for (int i = 0; i < demo.length; i++) {
			System.out.print("  "+demo[i]);
		}
	}
	
	public static void exchange(int dTmp[], int m, int n){
		int k = dTmp[m];
		dTmp[m] = dTmp[n];
		dTmp[n] = k;
	}
	
	public static void buildMaxHeap(int dTmp[]) {
		for (int i = (dTmp.length / 2) - 1; i >= 0; i--) {
			FixHeap(dTmp, dTmp.length, i);
		}
	}

	public static void FixHeap(int dTmp[], int size,int i) {
		int largeIndex, tmp;
		if (i * 2 + 1 > size - 1) {
			return;
		}
		if (i * 2 + 2 > size - 1) {
			if (dTmp[i] < dTmp[i * 2 + 1]) {
				exchange(dTmp, i, i * 2 + 1);
			}
			return;
		}
		while ((largeIndex = dTmp[i] >= dTmp[tmp = dTmp[i * 2 + 1] > dTmp[i * 2 + 2] ? (i * 2 + 1) : (i * 2 + 2)] ? i
				: tmp) != i) {
			
			exchange(dTmp,i,largeIndex);
			FixHeap(dTmp ,size, largeIndex);
		}
	}
}
