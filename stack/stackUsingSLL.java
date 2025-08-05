package llinkedLists;
public class Stack {
	private Node head;
	private int length;
	public void push(int data) {
		Node new_node = new Node(data);
		new_node.next = this.head;
		this.head = new_node;
		length++;
	}
	public int pop() {
		if(length==0) {
			throw new RuntimeException("Stack underflow"); 
		}
		int deleted = this.head.data;
    this.head = head.next;
    length--;
    return deleted;
	}
	public int top() {
		if(length==0) {
			throw new RuntimeException("Stack underflow"); 
		}
		return this.head.data;
	}
	public boolean isEmpty() {
		return this.length==0;
	}
	public int size() {
		return this.length;
	}
}
