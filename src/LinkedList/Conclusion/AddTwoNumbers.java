package LinkedList.Conclusion;
/*
 * Title: Add Two Numbers
 * Date: 31/08/2021
 * Author: Tam Nguyen
 */
/*
 * Description : You are given two non-empty linked lists representing two non-negative integers.
 * 		The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * 		Add the two numbers and return the sum as a linked list.
 * Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 = 807.
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	// 2 4 3 -> 342
	// 5 6 4 -> 465
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) { //coppy
		ListNode dummyNode = new ListNode(0);
		ListNode head = dummyNode;
		int sum = 0;
		while(l1 != null || l2 != null) {
			if(l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if(l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			ListNode newNode = new ListNode(sum % 10);
			dummyNode.next = newNode;
			dummyNode = dummyNode.next;
			sum = sum / 10;
		}
		if(sum > 0 ) {
			dummyNode.next = new ListNode(sum);
			dummyNode = dummyNode.next;
		}
		return head.next;
	}
}
