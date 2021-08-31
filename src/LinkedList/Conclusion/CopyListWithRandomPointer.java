package LinkedList.Conclusion;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyListWithRandomPointer { //coppy
    public Node copyRandomList(Node head) {
    	if(head == null) return null;
        HashMap<Node, Node> hm = new HashMap<>();
        Node temp = head;
        while(temp!=null) {
            hm.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while(temp!=null) {
            Node x = hm.get(temp);
            x.next = hm.get(temp.next);
            x.random = hm.get(temp.random);
            temp = temp.next;
        }
        return hm.get(head);
    }
}
