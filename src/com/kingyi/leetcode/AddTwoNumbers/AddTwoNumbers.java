package com.kingyi.leetcode.AddTwoNumbers;

/**
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 * }
 */
public class AddTwoNumbers {
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 ListNode ln_tmp = l1,ln_pre = l1;
		 int jw = 0;
		 while(l1 != null && l2 != null){
			 l1.val += (l2.val + jw);
			 jw = l1.val / 10;
			 l1.val = l1.val%10;
			 ln_pre = l1;
			 l1 = l1.next;
			 l2 = l2.next;
		 }
		 if(l2 != null){
			 ln_pre.next = l2;
			 l1 = l2;
		 }
		 while (l1 != null) {  
	         l1.val += jw;  
	         jw = l1.val / 10;  
	         l1.val = l1.val % 10; 
	         ln_pre = l1;
	         l1 = l1.next;  
	     }
		 if(jw == 1){
			 ln_pre.next = new ListNode(1);
		 }
		 return ln_tmp;
	 }
	 
	 public static void main(String[] args) {
		ListNode l1 = new ListNode(0);
		
		ListNode l2 = new ListNode(7);
		l2.next = new ListNode(3);

		AddTwoNumbers atn = new AddTwoNumbers();
		ListNode ln = atn.addTwoNumbers(l1, l2);
		while(ln != null){
			System.out.println(ln.val);
			ln = ln.next;
		}
	}
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){ val = x;}
}