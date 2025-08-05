/*
- This is the code for implementation of stack
- Use this file for testing the code of stack
*/
package llinkedLists;
import java.util.Scanner;

public class StackImplementation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Stack s = new Stack();
		String command;
		System.out.println("Enter the below commands for operations (x - data):");
		System.out.println("PUSH x - insert\nPOP - delete\nTOP - show top element\nI - isEmpty\nS - size\nE -exit");
		do {
			System.out.println("Enter command: ");
			command = input.nextLine().trim();
			if(command.equalsIgnoreCase("E")) {
				System.out.println("Exiting...");
				break;
			}
			String[] command_parts = command.split(" ");
			try {
				switch(command_parts[0].toUpperCase()) {
				case "PUSH":
					s.push(Integer.parseInt(command_parts[1]));
					break;
				case "POP":
					System.out.println(s.pop());
					break;
				case "TOP":
					System.out.println(s.top());
					break;
				case "I":
					System.out.println(s.isEmpty());
					break;
				case "S":
					System.out.println(s.size());
					break;
				default:
					System.out.println("Invalid command");
					break;
				}
			}
			catch(RuntimeException e) {
				System.out.println(e.getMessage());
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(true);
	}

}
