package LinkedList.TwoPointerTechnique;
/*
 * Title:Remove Nth Node From End of List
 * Date: 15/08/2021
 * Author: Tam Nguyen
 */
public class RemoveNthNodeFromEndOfList {
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {// coppy
	    int length = 0;
        ListNode current = head;
        ListNode nthNode = null;
        ListNode prev = null;
        while(current != null) {
            length++;
            if(length == n) {
                nthNode = head;
            } else if(length > n) {
                prev = nthNode;
                nthNode = nthNode.next;
            }
            current = current.next;
        }
        if(nthNode == null) return null;
		// delete nthNode
        if(prev == null) {
            return nthNode.next;
        } else {
            prev.next = nthNode.next;
            return head;
        }
	}

}
