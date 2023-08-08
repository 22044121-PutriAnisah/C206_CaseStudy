import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.naming.NameNotFoundException;

/**
 * 
 */

/**
 * @author 22044121
 *
 */
public class C206_CaseStudy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User(2, "customer", "Alan Tan", "alantan@abc.com", "Alantan_123", 80081234));
		userList.add(new User(3, "customer", "Barbie", "barbie@123.com", "Barbie_234", 81171345));
		userList.add(new User(4, "customer", "Ken", "ken02@hotmail.com", "Ken_3455", 82261456));

		ArrayList<Admin> adminList = new ArrayList<Admin>();
		adminList.add(new Admin(1, "admin", "Joshua Lim", "joshualim@abc.com", "JoshLim_123", 90123123));

		// Currency array
		currency[] currencyArr = new currency[100];
		currency c1 = new currency("Singapore", "SGD");
		currencyArr[0] = c1;

		// Transaction array
		/*
		 * DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 * ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		 * transactionList.add(new Transaction(1, 1, LocalDate.parse("15/07/2022",
		 * date), 500.00, "USD", 10000.00, "Approved")); transactionList.add(new
		 * Transaction(2, 1, LocalDate.parse("01/07/2022", date), 300.00, "RM",
		 * 4000.00)); transactionList.add(new Transaction(1, 1,
		 * LocalDate.parse("01/12/2022", date), 700.00, "USD", 12000.00, "Approved"));
		 * transactionList.add(new Transaction(2, 1, LocalDate.parse("28/09/2022",
		 * date), 800.00, "RM", 7000.00));
		 */

		// Account array
		// Account ArrayList
		ArrayList<Account> accountList = new ArrayList<Account>();
		Account account1 = new Account(1, 1, 355.22, "Active", "alantannn", "Alantan_123", "80081234");
		accountList.add(account1);

		// Rate array
		// write code

		// Feedback array
		
		  ArrayList<feedback> feedbackList = new ArrayList<feedback>();
		  DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); feedback
		  fb1 = new feedback(22, "best store", LocalDate.parse("12/02/2023", f1));
		  feedbackList.add(fb1);
		 

		int option = 0;
		boolean showMainMenu = true;
		boolean isAdminIn = false; // check if admin is loggIn

		while (option != 7) {
			// Show Main Menu
			if (showMainMenu) {
				menu();
				if (isAdminIn) {
					option = 2; // set to option 2 which is the login page
					showMainMenu = false;
				} else {
					option = Helper.readInt("Enter an option > ");
				}
			}
			showMainMenu = true; // show the "Money Exchange" menu

			if (option == 1) { // Register
				// write code
				C206_CaseStudy userRegistration = new C206_CaseStudy();

				boolean addUser = true;
				C206_CaseStudy.setHeader("User Register");
				while (addUser) {
					int userId = Helper.readInt("Enter userId > ");
					String role = Helper.readString("Enter role (customer/admin) > ");
					if ("customer".equalsIgnoreCase(User.getRole())) {
						// Code for customer role

					} else if ("admin".equalsIgnoreCase(User.getRole())) {
						// Code for admin role
					}

					String name = Helper.readString("Enter name > ");
					String email = Helper.readString("Enter email > ");
					String pw = Helper.readString("Enter password > ");

					String phoneStr = Helper.readString("Enter phone number > ");
					boolean isNumeric = phoneStr.matches("\\d+"); // Check if it contains only digits

					if (!isNumeric) {
						System.out.println("Invalid phone number format. Please enter digits only.");
						continue; // Go back to the beginning of the loop
					}

					int phoneNum = Integer.parseInt(phoneStr);
					boolean result = C206_CaseStudy.registerUser(userList, accountList, userId, role, name, email, pw,
							phoneNum);

					if (result) {
						System.out.println("User registration is successful.");
					} else {
						System.out.println("User registration failed.");
					}

					addUser = Helper.readBoolean("Do you want to register another user (y/n)?");
				}

				System.out.println("Bye bye.");

			}
			if (option == 2) { // Login
				// write code
				C206_CaseStudy.setHeader("Login Page");
				int adminOrUser = Helper.readInt("User ID: ");
				String pw = Helper.readString("Password: ");

				// To find if UserID & pw matches with the one in the admin / user class
				boolean adminFound = false;
				boolean userFound = false;

				if (adminOrUser == 1) {
					for (Admin admin : adminList) { // Admin Page
						if (adminOrUser == admin.getAdminId() && pw.equals(admin.getPassword())) {
							adminFound = true;
							System.out.println("Login Successful!");
							showAdminMenu(); // call the showAdminMenu method which will display the admin menu

							int selectOption = Helper.readInt("Please select one of the options > ");
							while (selectOption != 4) {
								if (selectOption == 1) { // Add new user
									User newUser = inputUser(userList, accountList);
									addNewUser(userList, newUser);
									// Create New account by getting the newUser variable and putting that inside
									// the newAccount variable
									Account newAccount = new Account(newUser.getUserId(), newUser.getName(),
											newUser.getPassword(), newUser.getPhoneNum());
									addAccount(accountList, newAccount); // newAccount is added inside the addAccount
																			// method
									System.out.println("New user has been added!");
									showMainMenu = false; // Main Menu is not shown
									showAdminMenu();

								} else if (selectOption == 2) { // View all Users
									showMainMenu = false; // Main Menu is not shown
									viewAllUsers(userList); // update this one oso: need to view all Account
									showAdminMenu();

								} else if (selectOption == 3) { // Delete Existing User
									// TOD0: call deleteExistingUser method
									deleteExistingUser(userList, accountList);
									showMainMenu = false; // Main Menu is not shown
									showAdminMenu();

								} else if (selectOption == 4) { // Logout of Admin Page
									System.out.println("You have successfully logout of the system.");
									showMainMenu = true;
								}

								selectOption = Helper.readInt("Please select one of the options > ");
							}

						}
						if (!adminFound) {
							System.out.println("Invalid! Either your User ID or Password do not match!");
						} else if (adminOrUser >= 2) { // User Page
							for (User user : userList) {
								if (adminOrUser == user.getUserId() && pw.equals(user.getPassword())) {
									System.out.println("Login Successful!");
									showUserMenu();
									int selectOption = Helper.readInt("Please select one of the options > ");
									while (selectOption != 6) {
										if (selectOption == 1) { // Manage User Account
											// write code
											C206_CaseStudy.setHeader("Choose one option");
											System.out.println("1. Add a new account");
											System.out.println("2. View all transactions");
											System.out.println("3. Delete an existing transaction");

											if (option == 1) {
												C206_CaseStudy.setHeader("Add new account");
											}

										} else if (selectOption == 2) { // Manage Currencies
											// write code
										} else if (selectOption == 3) { // Manage Transaction
											// write code
										} else if (selectOption == 4) { // Give Feedback
											// write code
										} else if (selectOption == 5) { // Logout
											// write code
										}
									}

									userFound = true; // UserID & pw matches with the one in the user class
									break;// exit out of the loop once user found
								}
								if (!userFound) {
									System.out.println("Invalid! Either your User ID or Password do not match!");
								}

							}
						}
					}

				} else if (option == 3) { // Quit
					// write code
					System.out.println("Bye!");
				} else {
					// write code
					System.out.println("Invalid option");
				}
			} // Option 2 login
		} // while loop
	} // main

	public static void menu() { // Main Menu
		C206_CaseStudy.setHeader("Money Exchange");
		System.out.println("1. Register");
		System.out.println("2. Login");
		System.out.println("3. Quit");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// Show Admin Menu
	public static void showAdminMenu() {
		C206_CaseStudy.setHeader("Admin Menu");
		System.out.println("1. Add a new user");
		System.out.println("2. View all users");
		System.out.println("3. Delete an existing user");
		System.out.println("4. Logout");
	}

	// Show User Menu
	public static void showUserMenu() {
		C206_CaseStudy.setHeader("User Menu");
		System.out.println("1. Manage User Account");
		System.out.println("2. Manage Currencies");
		System.out.println("3. Manage Transaction");
		System.out.println("4. Give Feedback");
		System.out.println("5. Logout");
	}

	// User Registration - Check Password
	private static boolean checkPassword(String password) {
		boolean correctLength = false;
		if (password.length() >= 8) {
			correctLength = true;
		}
		String alphaberts = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		boolean checkAlphaberts = false;
		for (int i = 0; i < alphaberts.length(); i++) {
			if (password.contains(String.valueOf(alphaberts.charAt(i)))) {
				checkAlphaberts = true;
			}
		}
		String numbers = "1234567890";
		boolean checkNumber = false;
		for (int i = 0; i < numbers.length(); i++) {
			if (password.contains(String.valueOf(numbers.charAt(i)))) {
				checkNumber = true;
			}
		}
		return checkNumber && checkAlphaberts && correctLength;
	}

	// Option 1 - Register User Verify & Authenticate the Registration Form
	public static User registerAndInputUser(ArrayList<User> userList, ArrayList<Account> accountList) {
		int userId = Helper.readInt("Enter userId > ");
		String role = Helper.readString("Enter role (customer/admin) > ");
		String name = Helper.readString("Enter name > ");
		String email = Helper.readString("Enter email > ");
		String pw = Helper.readString("Enter password > ");
		while (!checkPassword(pw)) {
			System.out.println("Password must be at least 8 characters long and contain both letters and numbers.");
			pw = Helper.readString("Enter password > ");
		}
		int phoneNum = Helper.readInt("Enter phone number > ");

		boolean registrationResult = registerUser(userList, accountList, userId, role, name, email, pw, phoneNum);

		if (registrationResult) {
			System.out.println("User registration is successful.");
		} else {
			System.out.println("User registration failed.");
		}

		User newUser = new User(userId, role, name, email, pw, phoneNum);
		userList.add(newUser);
		return newUser;
	}

	// Add User to list
	public static void addNewUser(ArrayList<User> userList, User newUser) {
		int newUserId = newUser.getUserId();

		// Check if the new user ID already exists in the userList
		for (User user : userList) {
			if (user.getUserId() == newUserId) {
				System.out.println("User ID already exists. User not added.");
				return;
			}
		}

		userList.add(newUser);
		System.out.println("New user has been added!");
	}

	// Option 2 - View All Users
	// Header Format to display Users & to display the UserList
	public static String retrieveAllUser(ArrayList<User> userList) {
		String output = "";

		for (User u : userList) {
			output += String.format("%-10d %-15s %-20s %-20s %-10d\n", u.getUserId(), u.getName(), u.getEmail(),
					u.getPassword(), u.getPhoneNum());
		}
		return output;
	}

	public static void viewAllUsers(ArrayList<User> userList) {
		C206_CaseStudy.setHeader("USER LIST");
		String output = String.format("%-10s %-15s %-20s %-20s %-10s\n", "USER ID", "NAME", "EMAIL", "PASSWORD",
				"PHONE NUMBER");
		output += retrieveAllUser(userList);
		System.out.println(output);
	}

	// Delete Existing User
	public static void deleteExistingUser(ArrayList<User> userList, ArrayList<Account> accountList) {
		int deleteUserId = Helper.readInt("Enter UserID > ");

		if (deleteUserId > 1) {
			char confirmDelete = Helper.readChar("Do you want to delete this user (y/n)? > ");

			if (confirmDelete == 'y') {
				boolean userFound = false; // check if user found
				for (int i = 0; i < userList.size(); i++) {
					if (deleteUserId == userList.get(i).getUserId()) {
						userList.remove(i);
						System.out.println("User with UserID " + deleteUserId + " has been deleted.");
						userFound = true; // user found
						break; // exit out of loop
					}
				}

				if (!userFound) {
					System.out.println("User ID has not been found.");
				}
			} else {
				System.out.println("Your action has been cancelled!");
			}

		} else {
			System.out.println("Invalid User ID!");
		}
	}

	/*
	 * // CURRENCY public static void addCurrency(currency[] currencyArr) { String
	 * currency = Helper.readString("Enter the currency you want to add > "); String
	 * country = Helper.readString("Enter the country the currency is from > ");
	 * 
	 * }
	 */
	/*
	 * public static void addTransaction() { // write code
	 * 
	 * }
	 * 
	 * // Transaction ArrayList<Transaction> transactionList = new
	 * ArrayList<Transaction>();
	 * 
	 * // Add Transaction public static void inputAddTransaction() { Transaction t =
	 * null;
	 * 
	 * int amount = Helper.readInt("Enter amount to be changed > "); String currency
	 * = Helper.readString("Enter currency > "); String date =
	 * Helper.readString("Enter today's date > ");
	 * 
	 * t = new Transaction(currency, amount, date);
	 * 
	 * }
	 * 
	 * public static void addTransaction() { // write code
	 * 
	 * }
	 * 
	 * public static void viewAllTransaction() { // write code }
	 * 
	 * public static void deleteTransaction() { // write code
	 * 
	 * }
	 */

	// ACCOUNT
	// Account
	// option1: Add Account
	public static void addAccount(ArrayList<Account> accountList) {
		String username = Helper.readString("Enter username > ");
		String contactInfo = Helper.readString("Enter contact > ");

		boolean isDuplicate = false;
		for (Account a : accountList) {
			if (a.getUsername().equals(username) || a.getContactInfo().equals(contactInfo)) {
				System.out.println("Username/Contact already in use.");
				isDuplicate = true;
				break;
			}
		}

		if (!isDuplicate) {
			int accountID = Helper.readInt("Enter account ID > ");
			int customerID = Helper.readInt("Enter customer ID > ");
			double accountBalance = Helper.readDouble("Enter account balance > ");
			String status = Helper.readString("Enter status > ");
			String password = Helper.readString("Enter password > ");

			Account newAccount = new Account(accountID, customerID, accountBalance, status, username, password,
					contactInfo);
			accountList.add(newAccount);
			System.out.println("Account added successfully.");
		}
	}

	// option2: View All Account
	public static void viewAllAccounts(ArrayList<Account> accountList) {
		C206_CaseStudy.setHeader("ACCOUNTS LIST");
		String output = String.format("%-15s %-15s %-20s %-10s %-15s %-15s %-15s\n", "ACCOUNT ID", "CUSTOMER ID",
				"ACCOUNT BALANCE", "STATUS", "USERNAME", "PASSWORD", "CONTACT INFO");
		for (Account a : accountList) {
			output += String.format("%-15d %-15d %-20.2f %-10s %-15s %-15s %-15s\n", a.getAccountID(),
					a.getCustomerID(), a.getAccountBalance(), a.getStatus(), a.getUsername(), a.getPassword(),
					a.getContactInfo());
		}
		System.out.println(output);
	}

	// option3: Delete Account
	public static void deleteAccount(ArrayList<Account> accountList) {
		Account a = null;
		int deleteAccountID = Helper.readInt("Enter Account ID > ");

		if (deleteAccountID >= 1) {
			for (int i = 0; i < accountList.size(); i++) {
				if (deleteAccountID == accountList.get(i).getAccountID()) {
					int deleteCustomerID = Helper.readInt("Enter Customer ID > ");
					if (deleteCustomerID >= 1) {
						for (int z = 0; z < accountList.size(); z++) {
							if (deleteCustomerID == accountList.get(z).getCustomerID()) {
								char confirmDelete = Helper.readChar("Do you want to delete this account? (Y/N) > ");
								if (confirmDelete == 'Y' || confirmDelete == 'y') {
									accountList.remove(i);
									System.out.println(
											"Account with AccountID " + deleteAccountID + " has been deleted.");

								} else {
									System.out.println("Your action has been cancelled!");
								}

							} else {
								System.out.println("Customer ID not found.");
							}
						}

					} else {
						System.out.println("Invalid input!");
					}
				} else {
					System.out.println("Account ID not found.");
				}
			}

		} else {
			System.out.println("Invalid input!");
		}
	}

	// RATE
	// write code

	// FEEDBACK
	/*
	 * public static String retrieveAllFeedback(ArrayList<feedback> feedbackList) {
	 * String output = "";
	 * 
	 * for (int i = 0; i < feedbackList.size(); i++) { output +=
	 * String.format("%-60s\n", feedbackList.get(i).toString()); } return output; }
	 * 
	 * public static String viewAllFeedback(ArrayList<feedback> feedbackList) {
	 * C206_CaseStudy.setHeader("FEEDBACK LIST"); String output = ""; output +=
	 * String.format("%-10s %-20s %-20s %-10s\n", "ID", "FEEDBACK", "DATE",
	 * "COMMENTS"); output += retrieveAllFeedback(feedbackList);
	 * System.out.println(output); return output; }
	 * 
	 * // Add feedback public static feedback inputFeedback(ArrayList<User>
	 * userList) { String name = Helper.readString("Enter your name > "); try { for
	 * (int i = 0; i < userList.size(); i++) { if
	 * (name.contains(userList.get(i).getName())) { String feedback =
	 * Helper.readString("Write feedback here > "); LocalDate today =
	 * LocalDate.now(); DateTimeFormatter f1 =
	 * DateTimeFormatter.ofPattern("dd/MM/yyyy"); String formatted =
	 * today.format(f1); feedback fb = new feedback(); return fb; } } throw new
	 * NameNotFoundException("Name not found in user list: " + name); } catch
	 * (NameNotFoundException e) { System.out.println(e.getMessage()); return null;
	 * } }
	 * 
	 * public static void addFeedback(ArrayList<feedback> feedbackList, feedback fb)
	 * { if ((fb.getfeedback().isBlank())) { return; } feedbackList.add(fb);
	 * feedbackList.toString(); }
	 * 
	 * // Add comment public static boolean inputComments(ArrayList<feedback>
	 * feedbackList, String comment) { boolean isCommented = false; if
	 * (comment.isEmpty()) return false;
	 * 
	 * for (int i = 0; i < feedbackList.size(); i++) { if
	 * (comment.equalsIgnoreCase(feedbackList.get(i).getComment())) {
	 * feedbackList.get(i).setComment(comment);
	 * 
	 * isCommented = true; } } return isCommented; }
	 * 
	 * public static void addComments(ArrayList<feedback> feedbackList) { int id =
	 * Helper.readInt("Enter id to comment > "); for (int i = 0; i <
	 * feedbackList.size(); i++) { if (id == feedbackList.get(i).getId()) { String
	 * comment = Helper.readString("Enter comments > "); Boolean isCommented =
	 * inputComments(feedbackList, comment); if (isCommented == true) {
	 * System.out.println("Comment succesfully uploaded."); } } } }
	 * 
	 * // Edit feedback for user public static void editFeedback
	 * (ArrayList<feedback>feedbackList, ArrayList<User> userList) { String name =
	 * Helper.readString("Enter name > "); for (int i = 0; i < userList.size(); i++)
	 * { if (name.equalsIgnoreCase(userList.get(i).getName())) { String editted =
	 * Helper.readString("Enter editted feedback: ");
	 * feedbackList.get(i).setfeedback(editted); feedbackList.get(i).toString(); } }
	 * 
	 * }
	 * 
	 * // Delete feedback for admin public static void
	 * deleteFeedback(ArrayList<feedback> feedbackList) { int id =
	 * Helper.readInt("Enter id to delete > "); for (int i = 0; i
	 * <feedbackList.size(); i++) { if (id == feedbackList.get(i).getId()) {
	 * feedbackList.remove(i); feedbackList.toString(); } } feedbackList.toString();
	 * }
	 */

}
