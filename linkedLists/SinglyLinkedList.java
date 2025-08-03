/*
- Singly Linked List
- This is the code for a singly linked list using a single pointer (head)
- Operations: insertAtFirst, insertAtLast, insertAfter, deleteFirst, deleteLast, display, reverse
*/
package linkedLists;
class Node{
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}
public class SinglyLinkedList {
	private Node head;       // Points to the first node in the list
	private int size = 0;    // Tracks the number of nodes in the list
  // Inserts a node at the beginning of the list
  //Time Complexity is O(1)
	public void insertAtFirst(int data) {
		Node new_node = new Node(data);
		new_node.next = this.head;
		this.head = new_node;
		size++;
	}
  // Inserts a node at the end of the list
  //Time Complexity is O(n)
	public void insertAtLast(int data) {
		Node new_node = new Node(data);
		if(this.size==0) {
			this.head = new_node;
		}
		else {
			Node current = this.head;
			while(current.next!=null) {
				current = current.next;
			}
			current.next = new_node;
		}
		size++;
	}
  // Inserts a new node after the first node containing the target value
  //Time Complexity is O(n)
	public void insertAfter(int target,int data) {
		if(size==0) {
			System.out.println("List is empty");
			return;
		}
		Node current = this.head;
		while(current!=null && current.data!=target) {
			current = current.next;
		}
		if(current==null) {
			System.out.println("Target not found");
			return;
		}
		Node new_node = new Node(data);
		new_node.next = current.next;
		current.next = new_node;
		size++;
	}
  // Deletes and returns the first node in the list
  //Time Complexity is O(1)
	public int deleteFirst() {
		if(size==0) {
			throw new RuntimeException("Empty list");
		}
		int deleted = this.head.data;
		this.head = head.next;
		size--;
		return deleted;
	}
  // Deletes and returns the last node in the list
  //Time Complexity is O(n)
	public int deleteLast() {
		if(size==0) {
			throw new RuntimeException("Empty list");
		}
		int deleted;
		if(size==1) {
			deleted = head.data;
			this.head = null;
		}
		else {
			Node current = this.head;
			while(current.next.next!=null) {
				current = current.next;
			}
			deleted = current.next.data;
			current.next = null;
		}
		size--;
	        return deleted;
	}
  // Checks if the list is empty and returns true or false
  //Time Complexity is O(1)
	public boolean isEmpty() {
		return this.size==0;
	}
  // Returns the current size of the list
  //Time Complexity is O(1)
	public int listSize() {
		return this.size;
	}
  // Displays all elements of the linked list
  //Time Complexity is O(n)
	public void display() {
		if(size==0) {
			System.out.println("Empty list");
		}
		else {
			Node current = this.head;
			while(current!=null) {
				System.out.print(current.data+" ");
				current = current.next;
			}
			System.out.println();
		}
	}
  // Reverses the linked list
  //Time Complexity is O(n)
	public void reverse() {
		if(size==0) {
			return;
		}
		else {
			Node prev = null;
			Node current = this.head;
			Node next_node;
			while(current!=null) {
				next_node = current.next;
				current.next = prev;
				prev = current;
				current = next_node;
			}
			this.head = prev;
		}
	}
}
