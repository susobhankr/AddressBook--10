package com.bridgelabz;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
	public class AddressBook {
		public static void main(String[] args) {
			System.out.println("Welcome to the AddressBook");
			ArrayList<Contacts> array = new ArrayList<Contacts>();
			try (Scanner sc = new Scanner(System.in)) {
				try (Scanner sc1 = new Scanner(System.in)) {
					int choice;
					do {
						System.out.println("1.INSERT" + "\n2.DISPLAY" + "\n3.EDIT" + "\n4.Delete");
						System.out.println("Enter your 1st choice");
						choice = sc.nextInt();

						switch (choice) {
						// To Add Contact
						case 1:
							System.out.print("Enter First Name: ");
							String firstName = sc1.nextLine();
							System.out.print("Enter last Name: ");
							String lastName = sc1.nextLine();
							System.out.print("Enter your address: ");
							String address = sc1.nextLine();
							System.out.print("Enter your city: ");
							String city = sc1.nextLine();
							System.out.print("Enter your state: ");
							String state = sc1.nextLine();
							System.out.print("Enter zip code : ");
							int zipcode = sc.nextInt();
							System.out.print("Enter phone number: ");
							String phoneNumber = sc1.nextLine();
							System.out.print("Enter your email: ");
							String emailId = sc1.nextLine();
							Contacts contact = new Contacts(firstName, lastName, address, city, state, zipcode, phoneNumber,
									emailId);
							array.add(contact);
							break;
						// To Display Contact
						case 2:
							java.util.Iterator<Contacts> iterator = array.iterator();
							while (iterator.hasNext()) {
								contact = iterator.next();
								System.out.println(array);
								break;
							}
							// To Edit Contact
						case 3:
							boolean found = false;
							System.out.println("Enter first name of the person for update ");
							firstName = sc1.nextLine();
							System.out.println("------------------------------------");

							ListIterator<Contacts> listIterator = array.listIterator();
							/*
							 * It is a java iterator which is used to traverse all types of lists including
							 * ArrayList, Vector, LinkedList, Stack
							 */

							while (listIterator.hasNext()) {
								contact = listIterator.next();
								/*
								 * Entering the condition if firstname matches
								 */
								if (contact.getFirstName().equals(firstName)) {

									System.out.print("Enter new first Name: ");
									firstName = sc1.nextLine();
									System.out.print("Enter new last Name: ");
									lastName = sc1.nextLine();
									System.out.print("Enter your new address: ");
									address = sc1.nextLine();
									System.out.print("Enter your new city: ");
									city = sc1.nextLine();
									System.out.print("Enter your state: ");
									state = sc1.nextLine();
									System.out.print("Enter zip code : ");
									zipcode = sc.nextInt();
									System.out.print("Enter phone number: ");
									phoneNumber= sc1.nextLine();
									System.out.print("Enter your email ID: ");
									emailId = sc1.nextLine();
									listIterator.set(new Contacts(firstName, lastName, address, city, state, zipcode,
											phoneNumber, emailId));
									found = true;
								}
							}
							System.out.println("_____________________________________");

							if (!found) {
								System.out.println("Record not found");
							} else {
								System.out.println("Record is updated successfully");
							}
							System.out.println("_______________________________________");
							break;
						// To Delete Contact
						case 4:
							found = false;
							System.out.println("Enter first name of the person for delete ");
							firstName = sc1.nextLine();
							System.out.println("____________________________________");
							iterator = array.iterator();
							while (iterator.hasNext()) {
								contact = iterator.next();
								if (contact.getFirstName().equals(firstName)) {
									iterator.remove();
									found = true;
								}
							}
							System.out.println("____________________________________");
							if (!found) {
								System.out.println("Record not found");
							} else {
								System.out.println("Record is deleted successfully");
							}
							System.out.println("_____________________________________");
							break;

						default:
							System.out.println("default");

						}
					} while (choice != 0);
					System.out.println("Invalid Choice!!"); // Print Invalid Result In Contact
				}
			}
		}
}