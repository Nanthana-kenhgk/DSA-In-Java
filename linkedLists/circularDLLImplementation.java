package linkedLists;

import java.util.Scanner;

public class CircularDLLImplementation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		CircularDLL dll = new CircularDLL();
		String command;
		System.out.println("Enter the below commands for operations (x - data, t - target):");
		System.out.println("IF x - insert first\nIL x - insert last\nIA t x - insert after\nDF - delete first\nDL - delete last\nI - isEmpty\nS - size\nD - display\nE -exit");
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
				case "IF":
					dll.insertAtFirst(Integer.parseInt(command_parts[1]));
					break;
				case "IL":
					dll.insertAtLast(Integer.parseInt(command_parts[1]));
					break;
				case "IA":
					if(command_parts.length<3) {
						System.out.println("Invalid input");
						break;
					}
					dll.insertAfter(Integer.parseInt(command_parts[1]), Integer.parseInt(command_parts[2]));
					break;
				case "DF":
					System.out.println(dll.deleteFirst());
					break;
				case "DL":
					System.out.println(dll.deleteLast());
					break;
				case "I":
					System.out.println(dll.isEmpty());
					break;
				case "S":
					System.out.println(dll.listSize());
					break;
				case "D":
					dll.display();
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
