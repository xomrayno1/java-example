package LinkedList.TwoPointerTechnique;

/*
 * Title:  Linked List Cycle
 * Date: 15/08/2021
 * Author: Tam Nguyen
 */
/*
 * Description : Nếu các element tạo vòng tròn thì sẽ return true, ngược lại return false
 */
public class LinkedListCycle {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public boolean hasCycle(ListNode head) {
		if (head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;

		while (fast.next != null && fast != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
}
