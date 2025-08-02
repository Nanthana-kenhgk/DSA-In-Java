package llinkedLists;
/*  circular singly linked list
* This class implements a circular singly linked list where:
 * - The last node points back to the head
 * - Each node contains a reference to the next node
 * Key Fields:
 * - head: reference to the first node
 * - size: number of nodes in the list
 */
public class CircularSLL {
	private Node head;
	private int size;
	//O(n) time complexity
	public void insertAtFirst(int data) {
		Node new_node = new Node(data);
		if(size==0) {
			this.head = new_node;
			this.head.next = this.head;
		}
		else {
			Node current = this.head;
			while(current.next!=this.head) {
				current = current.next;
			}
			new_node.next = this.head;
			current.next = new_node;
			this.head = new_node;
		}
		size++;
	}
	//O(n) time complexity
	public void insertAtLast(int data) {
		Node new_node = new Node(data);
		if(this.size==0) {
			this.head = new_node;
			this.head.next = this.head;
		}
		else {
			Node current = this.head;
			while(current.next!=this.head) {
				current = current.next;
			}
			new_node.next = this.head;
			current.next = new_node;
		}
		size++;
	}
	//O(n) time complexity
	public void insertAfter(int target,int data) {
		if(size==0) {
			System.out.println("List is empty");
			return;
		}
		Node current = this.head;
		boolean isFound = false;
		do {
			if(current.data == target) {
				isFound = true;
				break;
			}
			current = current.next;
		}
		while(current!=this.head);
		if(!isFound) {
			System.out.println("Target not found");
			return;
		}
		Node new_node = new Node(data);
		new_node.next = current.next;
		current.next = new_node;
		size++;
	}
	//O(n) time complexity
	public int deleteFirst() {
		if(size==0) {
			throw new RuntimeException("Empty list");
		}
		else if(size==1) {
			int deleted = this.head.data;
			this.head = null;
			size--;
			return deleted;
		}
		else {
			int deleted = this.head.data;
			Node current = this.head;
			while(current.next!=this.head) {
				current = current.next;
			}
			this.head = head.next;
			current.next = this.head;
			size--;
			return deleted;
		}
	}
	//O(n) time complexity
	public int deleteLast() {
		if(size==0) {
			throw new RuntimeException("Empty list");
		}
		else if(size==1) {
			int deleted = head.data;
			this.head = null;
			size--;
			return deleted;
		}
		else {
			Node current = this.head;
			while(current.next.next!=this.head) {
				current = current.next;
			}
			int deleted = current.next.data;
			current.next = this.head;
			size--;
			return deleted;
		}
	}
	//O(1) time complexity
	public boolean isEmpty() {
		return this.size==0;
	}
	//O(1) time complexity
	public int listSize() {
		return this.size;
	}
	//O(n) time complexity
	public void display() {
		if(size==0) {
			System.out.println("Empty list");
		}
		else {
			Node current = this.head;
			do {
				System.out.print(current.data + " ");
				current = current.next;
			} while (current != head);
			System.out.println();
		}
	}
	//O(n) time complexity
	public void reverse() {
		if(size==0) {
			return;
		}
		else {
			Node current = this.head;
			Node last = this.head;
			Node prev = null, next_node;
			do {
				next_node = current.next;
				current.next = prev;
				prev = current;
				current = next_node;
			}while(current!=this.head);
			this.head = prev;
			last.next = this.head;
		}
	}
}
