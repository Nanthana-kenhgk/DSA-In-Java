/*  circular doubly linked list
 * This implements a circular doubly linked list data structure
 * The tail node's next pointer points to the head and the head 
 * node's prev pointer points to the tail
 * The variables used are:
 * - head and tail of type Node referring to the first and last nodes
 * - size of type int
 * - node class has: 
 *   - next and prev to store the memory address of the next and 
 *     previous node respectively
 */
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
public class CircularDLL {
	private Node head, tail;
	private int size;
  // time complexity O(1)
	public void insertAtFirst(int data) {
		Node new_node = new Node(data);
		if(size==0) {
			this.head = this.tail = new_node;
			this.head.prev = this.tail;
			this.tail.next = this.head.next = this.head;
		}
		else {
			new_node.next = this.head;
			new_node.prev = this.tail;
			this.head.prev = new_node;
			this.tail.next = new_node;
			this.head = new_node;
		}
		size++;
	}
  // time complexity O(1)
	public void insertAtLast(int data) {
		Node new_node = new Node(data);
		if(size==0) {
			this.head = this.tail = new_node;
			this.head.prev = this.tail;
			this.tail.next = this.head.next = this.head;
		}
		else {
			this.tail.next = new_node;
			new_node.prev = this.tail;
			new_node.next = this.head;
			this.head.prev = new_node;
			this.tail = new_node;
		}
		size++;
	}
  // time complexity O(n)
	public void insertAfter(int target, int data) {
		if(size==0) {
			System.out.println("Empty list");
			return;
		}
		Node current = this.head;
		do {
			if(current.data==target) {
				Node new_node = new Node(data);
				new_node.next = current.next;
				new_node.prev = current;
				current.next.prev = new_node;
				current.next = new_node;
				if(current==tail) {
					this.tail = new_node;
				}
				size++;
				return;
			}
		current = current.next;
		}
		while(current!=this.head);
		System.out.println("Target not found");
	}
  // time complexity O(1)
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
			head.prev = this.tail;
			tail.next = this.head;
		}
    size--;
		return deleted;
	}
  // time complexity O(1)
	public int deleteLast() {
		if(size==0) {
			throw new RuntimeException("Empty list");
		}
    int deleted = tail.data;
		else if(size==1) {
			this.head = this.tail = null;
		}
		else {
			this.tail = tail.prev;
			tail.next = this.head;
			head.prev = this.tail;
		}
    size--;
		return deleted;
	}
  // time complexity O(1)
	public boolean isEmpty() {
		return this.size==0;
	}
  // time complexity O(1)
	public int listSize() {
		return this.size;
	}
  // time complexity O(n)
	public void display() {
		if(size==0) {
			System.out.println("Empty list");
		}
		else {
			Node current = this.head;
			do {
				System.out.print(current.data+" ");
				current = current.next;
			}
			while(current!=this.head);
			System.out.println();
		}
	}
  // time complexity O(n)
	public void reverse() {
		if(size==0) {
			return;
		}
		else {
			Node current = this.head;
			Node next_node, prev_node;
			do {
				prev_node = current.prev;
				next_node = current.next;
				current.next = prev_node;
				current.prev = next_node;
				current = next_node;
			}while(current!=this.head);
			Node temp = this.head;
			this.head = this.tail;
			this.tail = temp;
			head.prev = tail;
			tail.next = head;
		}
	}
}
