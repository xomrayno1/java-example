package LinkedList.Conclusion;

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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) { //coppy
        ListNode head = new ListNode(0);
        ListNode move = head;
        
        int sum = 0;
        
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                sum = sum +l1.val;
                l1 = l1.next;
            }  
            if(l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            move.next = new ListNode(sum % 10);
            move = move.next;
            sum = sum/10;
        }
        
        if(sum > 0) {
            move.next = new ListNode(sum);
            move = move.next;
        }
        
        return head.next;
	}
}
