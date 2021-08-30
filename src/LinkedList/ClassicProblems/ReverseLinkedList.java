package LinkedList.ClassicProblems;
/*
 * Title: Reverse Linked List
 * Date: 28/08/2021
 * Author: Tam Nguyen
 */

/*
 * Description: Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Input: head = [1,2,3,4,5] Output: [5,4,3,2,1] 
 * Input: head = [1,2] Output: [2,1] 
 * Input: head = [] Output: []
 */
public class ReverseLinkedList {
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
		public ListNode(int val, ListNode next) {
			super();
			this.val = val;
			this.next = next;
		}
	}
	// tạo ra node đầu tiên trỏ đến null, những node sau trỏ đến node đã tạo trước
	public ListNode reverseList(ListNode head) {
		if(head == null) {
			return null;
		}
		ListNode reverse = null;
		for(ListNode node = head; node != null ; node = node.next) {
			ListNode newNode = new ListNode(node.val, reverse);
			reverse = newNode;
		}
        return reverse;
    }
}
