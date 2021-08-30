package LinkedList.ClassicProblems;

/*
 * Title: Odd Even Linked List
 * Date: 29/08/2021
 * Author: Tam Nguyen
 */
/*
 * Description : Given the head of a singly linked list, 
 * group all the nodes with odd indices together followed by the nodes with even indices, 
 * and return the reordered list.
 * Input: head = [1,2,3,4,5]  Output: [1,3,5,2,4]
 * Input: head = [2,1,3,5,6,4,7] Output: [2,3,6,7,1,5,4]
 */
public class OddEvenLinkedList {
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
    public ListNode oddEvenList(ListNode head) {
    	if(head == null) return  null;
    	ListNode oddNode = null;
    	ListNode evenNode = null;
    	ListNode tailOdd = null;
    	ListNode tailEven = null;
    	int pos = 1; 
    	for(ListNode initNode = head ; initNode != null ; initNode = initNode.next) {
    		ListNode newNode = new ListNode(initNode.val);
    		if(pos % 2 == 0) {
    			//evenNode
    			if(evenNode == null) {
    				evenNode = tailEven = newNode;
    			}else {
    				tailEven.next = newNode;
    				tailEven = newNode;
    			}
    		}else {
    			//oddNode
    			if(oddNode == null) {
    				oddNode = tailOdd = newNode;
    			}else {
    				tailOdd.next = newNode;
    				tailOdd = newNode;
    			}
    		}
    		pos++;
    	}
    	//join 2 node
    	tailOdd.next = evenNode;
        return oddNode;
    }
}
