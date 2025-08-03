package linkedLists;
class Node{
	int data;
	Node next,prev;
	public Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}
public class DoublyLinkedList {
	private Node head, tail;                // References to the start and end of the list
	private int size = 0;                   // Tracks number of elements
  // Insert a new node at the beginning of the list
  // Time Complexity: O(1)
	public void insertAtFirst(int data) {
		Node new_node = new Node(data);
		if(size==0) {
			this.head = this.tail = new_node;
		}
		else {
			new_node.next = this.head;
			this.head.prev = new_node;
			this.head = new_node;
		}
		size++;
	}
  // Insert a new node at the end of the list
  // Time Complexity: O(1)
	public void insertAtLast(int data) {
		Node new_node = new Node(data);
		if(size==0) {
			this.head = this.tail = new_node;
		}
		else {
			this.tail.next = new_node;
			new_node.prev = this.tail;
			this.tail = new_node;
		}
		size++;
	}
  // Insert a new node after a given target value
  // Time Complexity: O(n)
	public void insertAfter(int target, int data) {
		if(size==0) {
			System.out.println("Empty list");
			return;
		}
		Node current = this.head;
		while(current!=null) {
			if(current.data==target) {
					Node new_node = new Node(data);
					new_node.next = current.next;
					new_node.prev = current;
					if(current.next==null) {        //if it is inserted after last node
						this.tail = new_node;
					}
					else {
						current.next.prev = new_node;
					}
					current.next = new_node;
					size++;
					return;
				}
			current = current.next;
		}
		System.out.println("Target not found");
	}
  // Delete the first node and return its data
  // Time Complexity: O(1)
	public int deleteFirst() {
		if(size==0) {
			throw new RuntimeException("Empty list");
		}
      int deleted = head.data;
		if(size==1) {
			this.head = this.tail = null;
		}
		else {
			this.head = head.next;
			head.prev = null;
		}
    size--;
		return deleted;
	}
  // Delete the last node and return its data
  // Time Complexity: O(1)
	public int deleteLast() {
		if(size==0) {
			throw new RuntimeException("Empty list");
		}
    int deleted = tail.data;
		if(size==1) {
			this.head = this.tail = null;
		}
		else {
			this.tail = tail.prev;
			tail.next = null;
		}
    size--;
		return deleted;
	}
  // Check if the list is empty
  // Time Complexity: O(1)
	public boolean isEmpty() {
		return size==0;
	}
  // Return the number of nodes in the list
  // Time Complexity: O(1)
	public int listSize() {
		return this.size;
	}
  // Print the list from head to tail
  // Time Complexity: O(n)
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
  // Reverse the list by swapping next and prev of all nodes
  // Time Complexity: O(n)
	public void reverse() {
		if(size==0) {
			return;
		}
    Node current = head;
  	Node temp = null;
  	while (current != null) {
  		temp = current.prev;
  		current.prev = current.next;
  		current.next = temp;
  		current = current.prev;
  	}
  	// Swap head and tail
  	temp = head;
  	head = tail;
  	tail = temp;
}
