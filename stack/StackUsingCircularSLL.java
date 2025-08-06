/*
- Stack using circular singly linked list
- This is the code for a stack using circular singly linked list with a head and tail pointer
- Operations: push, pop, top, isEmpty, size
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
public class stackCircularSLL {
	Node head, tail;
	int length;
	// Time complexity: O(1)
	public void push(int data) {
		Node new_node = new Node(data);
		if(length==0) {
			this.head = new_node;
			this.tail = new_node;
			new_node.next = this.head;
		}
		else {
			new_node.next = this.head;
			this.head = new_node;
			this.tail.next = this.head;
		}
		length++;
	}
	//Time complexity: O(1)
	public int pop() {
		if(length==0) {
			throw new RuntimeException("Stack Underflow");
		}
		int deleted = this.head.data;
		if(length==1) {
			this.head = null;
			this.tail = null;
		}
		else {
			this.tail.next = this.head.next;
			this.head = this.head.next;
		}
		length--;
		return deleted;
	}
	//Time complexity: O(1)
	public int top() {
		if(length==0) {
			throw new RuntimeException("Stack Underflow");
		}
		return this.head.data;
	}
	//Time complexity: O(1)
	public boolean isEmpty() {
		return length==0;
	}
	//Time complexity: O(1)
	public int size() {
		return length;
	}
}
