package LinkedList.ClassicProblems;
/*
 * Title: Reverse Linked List
 * Date: 28/08/2021
 * Author: Tam Nguyen
 */

/*
 * Description: Given the head of a linked list and an integer val, 
 * 	remove all the nodes of the linked list that has Node.val == val, and return the new head.
 * Input: head = [1,2,6,3,4,5,6], val = 6  Output: [1,2,3,4,5]
 * Input: Input: head = [], val = 1 Output: []
 * Input: head = [7,7,7,7], val = 7 Output: []
 */
public class RemoveLinkedListElements {
	public class ListNode{
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
	public ListNode removeElements(ListNode head, int val) {
		if(head == null) return null;
		ListNode prevNode = null;
		ListNode headNode = head;
		for(ListNode P = head ; P != null ; P = P.next) {
			if(P.val == val) {
				if(headNode == P) { //delete head 
					ListNode G = head.next;
					head = headNode = G;
				}else if(P.next == null) { //delete tail
					prevNode.next = null;
				}else{ //delete index
					ListNode nextNode = P.next;
					prevNode.next = nextNode;
					continue; // Tránh prevNode ở cái node vừa delele;
				}
			}
			prevNode = P;
		}
		return head;
	}
}
