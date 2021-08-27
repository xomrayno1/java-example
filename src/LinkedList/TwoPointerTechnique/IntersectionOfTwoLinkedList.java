package LinkedList.TwoPointerTechnique;
/*
 * Title: Intersection Of Two Linked List
 * Date: 28/08/2021
 * Author: Tam Nguyen
 */
/*
 * Description: Tìm điểm giao nhau giữa 2 node 
 */
public class IntersectionOfTwoLinkedList {
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		while(headA != null) {
			ListNode newNode = headB;
			while(newNode != null) {
				if(headA == newNode) {
					return headA;
				}
				newNode = newNode.next;
			}
			headA = headA.next;
		}
        return null;
    }
}
