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
	public int top() {
		if(length==0) {
			throw new RuntimeException("Stack Underflow");
		}
		return this.head.data;
	}
	public boolean isEmpty() {
		return length==0;
	}
	public int size() {
		return length;
	}
}
