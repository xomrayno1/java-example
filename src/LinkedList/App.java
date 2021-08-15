package LinkedList;

import java.util.LinkedList;
import java.util.List;

import LinkedList.SinglyLinkedList.DesignLinkedList;
//run code linked list
public class App {
	/*
	 * ["MyLinkedList[]",
	 * "addAtHead[86]",
	 * "addAtIndex[1,54]",
	 * "addAtIndex[1,14]",
	 * "addAtHead[83]",
	 * "deleteAtIndex[4]"
	 * ,"addAtIndex[3,18]",
	 * "addAtHead[46]"
	 * ,"addAtTail[3]",
	 * "addAtHead[76]",
	 * "get[5]","addAtTail","addAtTail","addAtIndex","addAtTail","addAtTail","addAtHead","addAtTail","addAtHead","addAtTail","addAtHead","addAtTail","addAtTail","addAtHead","addAtTail","addAtIndex","addAtHead","deleteAtIndex","addAtHead","addAtHead","addAtHead","addAtHead","addAtIndex","addAtHead","addAtTail","addAtHead","deleteAtIndex","addAtTail","deleteAtIndex","addAtTail","addAtTail","addAtTail","addAtTail","addAtHead","addAtTail","get","addAtIndex","get","deleteAtIndex","addAtTail","addAtHead","addAtTail","addAtTail","addAtIndex","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtTail","deleteAtIndex","deleteAtIndex","addAtHead","addAtHead","addAtTail","addAtHead","get","addAtIndex","addAtIndex","get","addAtTail","get","addAtTail","deleteAtIndex","get","addAtTail","addAtTail","addAtHead","addAtTail","deleteAtIndex","addAtHead","addAtHead","addAtHead","deleteAtIndex","addAtTail","addAtIndex","addAtTail","addAtTail","addAtIndex","addAtIndex","addAtHead","addAtIndex","addAtHead","addAtHead","addAtTail","addAtIndex","addAtTail","get","addAtHead","addAtTail","addAtHead","addAtHead"]
	[[],[86],[1,54],[1,14],[83],[4],[3,18],[46],[3],[76],[5],[79],[74],[7,28],[68],[16],[82],[24]
	 */
	
	public static void main(String[] args) {
		DesignLinkedList linkedList  = new DesignLinkedList();
		linkedList.addAtHead(86);  //76 46 83 86 14 18 54 3
		linkedList.addAtIndex(1, 54);
		linkedList.addAtIndex(1, 14);
		linkedList.addAtHead(83);
		linkedList.deleteAtIndex(4);
		linkedList.addAtIndex(3, 18);
		linkedList.addAtHead(46);
		linkedList.addAtTail(3);
		linkedList.addAtHead(76);
		System.out.println("get "+ linkedList.get(5));;
		System.out.println("size "+ linkedList.size);
		linkedList.displayAllNode();

		
//		List<String> list = new LinkedList<>();
//		list.add("Red");
//		list.add("Yellow");
//		list.add("Orange");
//		list.add("Black");
//		list.remove(3);
//		for(String ele : list) {
//			System.out.println(ele);
//		}
//		
	}

}
