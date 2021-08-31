package LinkedList.Conclusion;
/*
 * Title: Merge Two Sorted Lists
 * Date: 31/08/2021
 * Author: Tam Nguyen
 */
/*
 * Description : Merge two sorted linked lists and return it as a sorted list. 
 * 		The list should be made by splicing together the nodes of the first two lists.
 * Input: l1 = [1,2,4], l2 = [1,3,4] Output: [1,1,2,3,4,4]
 * Input: l1 = [], l2 = [0] Output: [0]
 */
public class MergeTwoSortedLists {
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

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummyNode = new ListNode();
		ListNode head = dummyNode;
		while(l1 != null && l2 != null) {
			if(l1.val >= l2.val) {
				dummyNode.next = new ListNode(l2.val);
				l2 = l2.next;
			}else {
				dummyNode.next = new ListNode(l1.val);
				l1 = l1.next;
			}
			dummyNode = dummyNode.next;
		}
		dummyNode.next = l1 == null ? l2 : l1;
		return head.next; //head  bat dau = 0 , nen . head.next
	}
}
