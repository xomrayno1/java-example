package LinkedList.DoublyLinkedList;
//double linked list
public class DesignLinkedList {
	public class Node {
		Node next;
		Node prev;
		int val;

		public Node(int x) {
			this.val = x;
			this.next = null;
			this.prev = null;
		}
		Node(int val, Node next, Node prev) {
			this.val = val;
			this.next = next;
			this.prev = prev;
		}
 

	}
	public Node head;
	public Node tail;
	public int size;

	/** Initialize your data structure here. */
	public DesignLinkedList() {
//		this.head = new Node(-1);
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		/* If the index is invalid, return -1. */
		if(head == null || this.size < index) {
			return -1;
		}
		int position = 0;
		for(Node node = head ; node != null ; node = node.next) {
			if(index == position) {
				return node.val;
			}
			position++;
		}
		return -1;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		if(head == null) {
			head = new Node(val);
			tail = head;
		}else {
			Node newNode = new Node(val);
			newNode.next = head;
			head.prev = newNode;
			tail = head;
			head = newNode;
		}
		size++;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		if(head == null) {
			head = new Node(val);
			tail = head;
		}else {
			Node newNode = new Node(val);
			newNode.prev =  tail;
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		if (index == this.size) {
			addAtTail(val);
		} else if (index > this.size) {
			return;
		} else if(index == 0){
			addAtHead(val);
		}else {
			int position = 0;
			for (Node node = head; node != null; node = node.next) {
				if (position == index) {
					Node prevNode = node.prev;
					Node newNode = new Node(val);
					prevNode.next = newNode;
					newNode.next = node;
					newNode.prev = prevNode;
					node.prev = newNode;
					this.size++;
					return;
				}
				position++;
			}
		}
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if(head != null) {
			if(index == 0) {
				Node node = head;
				head = node.next;
				this.size--;
			}else if(index == size - 1) {
				Node prevNode = null;
				for(Node node = head ; node != null ; node = node.next) {
					if(node.next == null) {
						prevNode.next = null;
						tail = prevNode;
						this.size--;
						return;
					}
					prevNode = node;
				}
			}else {  // 1 2 3			
				int position = 0;
				for(Node node = head ; node != null ; node = node.next) {
					if(index == position) {
						Node prevNode = node.prev;
						Node nextNode = node.next;
						prevNode.next = nextNode;
						nextNode.prev = prevNode;
						this.size--;
						return;
					}	
					position++;
				}
			}
		}else {
			return;
		}
	}
	
	public void displayAllNode() {
		for(Node node = head ; node != null ; node = node.next) {
			System.out.println(node.val);
		}
	}
}
