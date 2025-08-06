/*
- Stack using singly linked list
- This is the code for a stack using singly linked list
- Operations: push, pop, top, isEmpty, size
*/
package linkedLists;
class Node {
	int data;
	Node next;
	Node(int data) {
		this.data = data;
		this.next = null;
	}
}
public class Stack {
	private Node head;
	private int length;
	//Time complexity: O(1)
	public void push(int data) {
		Node new_node = new Node(data);
		new_node.next = this.head;
		this.head = new_node;
		length++;
	}
	//Time complexity: O(1)
	public int pop() {
		if(length==0) {
			throw new RuntimeException("Stack underflow"); 
		}
		int deleted = this.head.data;
	        this.head = head.next;
	        length--;
	        return deleted;
	}
	//Time complexity: O(1)
	public int top() {
		if(length==0) {
			throw new RuntimeException("Stack underflow"); 
		}
		return this.head.data;
	}
	//Time complexity: O(1)
	public boolean isEmpty() {
		return this.length==0;
	}
	//Time complexity: O(1)
	public int size() {
		return this.length;
	}
}
