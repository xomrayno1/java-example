package LinkedList.ClassicProblems;
/*
 * Title: Palindrome Linked List
 * Date: 30/08/2021
 * Author: Tam Nguyen
 */
/*
 * Description : Given the head of a singly linked list, return true if it is a palindrome.
 * Input: head = [1,2,2,1] Output: true
 * Input: head = [1,2] Output: false
 */
public class PalindromeLinkedList {
	public class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
    public boolean isPalindrome(ListNode head) {
    	if(head == null || head.next == null) return true;
    	ListNode midPrev = findMidPrev(head);
    	ListNode head2 = midPrev.next;
    	midPrev.next = null;
    	ListNode reverseHead1 = reverse(head2);
    	while(head != null) {
    		if(head.val != reverseHead1.val) return false;
    		reverseHead1 = reverseHead1.next;
    		head = head.next;
    	}
        return true;
    }
    public ListNode reverse(ListNode head) { // đảo ngược từ mid cho đến sau 1 2 3 2 1 , đảo từ 3 2 1 
    	ListNode nextNode = null;
    	while(head != null) {
    		ListNode newNode = new ListNode(head.val, nextNode);
    		nextNode = newNode;
    		head = head.next;
    	}
    	return nextNode;
    }
    public ListNode findMidPrev(ListNode head) {
    	ListNode fast = head, slow = head, prev = null;
    	while(fast != null && fast.next != null) { //prev chấp đi trc, prev luôn sau slow
    		prev = slow;
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	return prev;
    }
}
