package com.kingyi.leetcode.TwoNum;

import java.util.Hashtable;

/*
  Given an array of integers, find two numbers such that they add up to a specific target number.
  The function twoSum should return indices of the two numbers such that they add up to the target, 
  where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
  You may assume that each input would have exactly one solution.
 */
public class TwoNum {
	public int[] twoSum(int[] nums, int target) {
		int answers[] = new int[2];
		Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer n = ht.get(nums[i]);
			if(n==null){
				ht.put(nums[i], i);
			}
			n = ht.get(target - nums[i]);
			if(n!=null && n<i){
				answers[0] = n + 1;
				answers[1] = i + 1;
				return answers;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		TwoNum tn = new TwoNum();
		int[] a = tn.twoSum(new int[]{2,-1,3,4}, 5);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
