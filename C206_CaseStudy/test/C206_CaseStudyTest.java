import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Admin admin1;
	private User user1;
	private User user2;
	private User user3;

	private currency c1;
	private currency c2;
	private currency c3;
	
	private Transaction t1;
	private Transaction t2;
	private Transaction t3;
	private Transaction t4;
	
	private ArrayList<Admin> adminList;
	private ArrayList<User> userList;
	
	private ArrayList<Transaction> transactionList;
	
	
	public C206_CaseStudyTest() { //add comment
		super();
	}

	@Before
	public void setUp() throws Exception {
		//prepare test data
		// add new user
		admin1 = new Admin(1, "customer", "Joshua Lim", "joshualim@abc.com", "JoshLim_123", 90123123);
		user1 = new User(2, "customer", "Alan Tan", "alantan@abc.com", "Alantan_123", 80081234);
		user2 = new User(3, "customer", "Barbie", "barbie@123.com", "Barbie_234", 81171345);
		user2 = new User(4, "customer", "Ken", "ken02@hotmail.com", "Ken_345", 82261456);
		
		adminList = new ArrayList<Admin>();
		userList = new ArrayList<User>();

		
		
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

	@Test
	public void testAddNewUser() {
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid User arraylist to add to", userList);
		assertEquals("Test that the User arraylist is empty.", 0, userList.size());
		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addNewUser(userList, user1);
		assertEquals("Test that the User arraylist size is 1.", 1, userList.size());

		// Add an item
		C206_CaseStudy.addNewUser(userList, user2);
		assertEquals("Test that the User arraylist size is now 2.", 2, userList.size());
		// The item just added is as same as the last item in the list
		assertSame("Test that User is added to the end of the list.", user2, userList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addNewUser(userList, user2);
		assertEquals("Test that the User arraylist size is unchange.", 2, userList.size());

		// Add an item that has missing details
		C206_CaseStudy.addNewUser(userList, user3); // user3 has missing details
		assertEquals("Test that the User arraylist size remains unchanged.", 2, userList.size());

		// Verify that user3 is not added to the list due to missing details
		assertFalse("Test that user3 is not added to the list.", userList.contains(user3));
	}
	
	@Test
	public void testRetrieveAllUser() {//comment
		//Test Case 1
		// Test if Item list is not null and empty
		assertNotNull("Test if there is valid User arraylist to add to", userList);
		assertEquals("Test that the Users arraylist is empty.", 0, userList.size());
		// Attempt to view the Users 
		String allUser= C206_CaseStudy.retrieveAllUser(userList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allUser);
		
		// Test Case 2
		C206_CaseStudy.addNewUser(userList, user1);
		C206_CaseStudy.addNewUser(userList, user2);
		// Test that the list is not empty
		assertEquals("Test that User arraylist size is 2.", 2, userList.size());
		// Attempt to view the Users
		allUser = C206_CaseStudy.retrieveAllUser(userList);
		testOutput = String.format("%-10d %-15s %-20s %-20s %-10d\n", 5, "Maya", "maya@gmk.com", "maya_123", 90014334);
		testOutput += String.format("%-10d %-15s %-20s %-20s %-10d\n", 6, "Bluey", "bluey@123.com", "bluey12", 96634423);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allUser);
		
		//Test Case 3
	    C206_CaseStudy.deleteExistingUser(userList);
	    // Test that the list size has decreased
	    assertEquals("Test that User arraylist size is 1 after deleting a user.", 1, userList.size());

	    // Try to view the Users after deletion
	    allUser = C206_CaseStudy.retrieveAllUser(userList);
	    testOutput = String.format("%-10d %-15s %-20s %-20s %-10d\n", 5, "Maya", "maya@gmk.com", "maya_123", 90014334);
	    // Test that the display shows only one user after deletion
	    assertEquals("Test that the display is correct after deleting a user.", testOutput, allUser);

	}
	
	@Test
	public void testDeleteExistingUser() {
	    // Test Case 1
	    assertNotNull("Test if there is valid User arraylist to delete from", userList);
	    assertEquals("Test that the User arraylist is empty.", 0, userList.size());
	    // Add some users to the User List for testing
	    C206_CaseStudy.addNewUser(userList, user1);
	    C206_CaseStudy.addNewUser(userList, user2);

	    // Test Case 2
	    // Test if user list size 2
	    assertEquals("Test that User arraylist size is 2.", 2, userList.size());

	    // Test Case 3 
	    C206_CaseStudy.deleteExistingUser(userList, null);
	    // Test if user is successfully deleted from User List
	    assertEquals("Test that User arraylist size is now 1.", 1, userList.size());

	    // Test Case 4 
	    C206_CaseStudy.deleteExistingUser(userList, null);
	    // Test if the correct user is deleted from the User List
	    assertSame("Test that the correct user is deleted.", 2, userList.get(0));

	    // Test Case 5 
	    C206_CaseStudy.deleteExistingUser(userList, null);
	    // Test if User List is empty after all users are deleted
	    assertEquals("Test that User arraylist size is 0.", 0, userList.size());
	}
	
	// Currency
	@Test
	public void testAddNewCurrency() {
		
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid Currency array to add to", currencyArr);
		assertEquals("Test that the currency array is empty.",  currencyArr.length);
		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addCurrency(c1);
		assertEquals("Test that the currency array size is 1.", 1,currencyArr.length);

		// Add an item
		C206_CaseStudy.addCurrency(c2);
		assertEquals("Test that the currency array length is now 2.", 2,currencyArr.length);
		// The item just added is as same as the last item in the list
		assertSame("Test that currency is added to the end of the list.", c2, currencyArr[1]);

		// Add an item that already exists in the list
		C206_CaseStudy.addCurrency(c3);
		assertEquals("Test that the currency array size is unchange.", 2, currencyArr.length);

		// Add an item that has missing details
		C206_CaseStudy.addCurrency(c3); 
		assertEquals("Test that the currency array size remains unchanged.", 2, currencyArr.length);

		// Verify that c3 is not added to the list due to missing details
		assertFalse("Test thatc3 is not added to the list.", currencyArr[2]);
	}
	
	@Test
	public void testRetrieveAllCurrency() {//comment
		//Test Case 1
		// Test if Item list is not null and empty
		assertNotNull("Test if there is valid currency array to add to", currencyArr);
		assertEquals("Test that the currency array is empty.", 0, currencyArr.length);
		// Attempt to view the Users 
		String allCurrency= C206_CaseStudy.retrieveAllCurrency(currencyArr);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allCurrency);
		
		// Test Case 2
		C206_CaseStudy.addCurrency(c1);
		C206_CaseStudy.addCurrency(c2);
		// Test that the list is not empty
		assertEquals("Test that currency arrya size is 2.", 2, currencyArr.length);
		// Attempt to view the currency
		allCurrency = C206_CaseStudy.retrieveAllCurrency(currencyArr);
		testOutput = String.format("%-15s, %-15s", "COUNTRY","CURRENCY");
		testOutput += String.format("%-15s %-15s","Singapore","SGD");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allCurrency);
		
		//Test Case 3
	    C206_CaseStudy.deleteExistingCurrency(currencyArr);
	    // Test that the list size has decreased
	    assertEquals("Test that User arraylist size is 1 after deleting a user.", 1, currencyArr.length));

	    // Try to view the currency after deletion
	    allCurrency = C206_CaseStudy.retrieveAllCurrency(currencyArr);
	    testOutput = String.format("%-15s, %-15s", "COUNTRY","CURRENCY");
		testOutput += String.format("%-15s %-15s","Singapore","SGD");
	    // Test that the display shows only one currency after deletion
	    assertEquals("Test that the display is correct after deleting a user.", testOutput, allCurrency);

	}
	
	@Test
	public void testDeleteExistingCurrency() {
	    // Test Case 1
	    assertNotNull("Test if there is valid currency array to delete from", currencyArr);
	    assertEquals("Test that the currency array is empty.", 0, currencyArr.length);
	    // Add some currency to the currency array for testing
	    C206_CaseStudy.addCurrency(c1);
        C206_CaseStudy.addCurrency(c2);

	    // Test Case 2
	    // Test if currency array size 2
	    assertEquals("Test that currency array size is 2.", 2, currencyArr.length);

	    // Test Case 3 
	    C206_CaseStudy.deleteExistingCurrency(c1);
	    // Test if currency is successfully deleted from currency array
	    assertEquals("Test that User arraylist size is now 1.", 1, currencyArr.length);

	    // Test Case 4 
	    C206_CaseStudy.deleteExistingCurrency(c2);
	    // Test if the correct currency is deleted from the currency array
	    assertSame("Test that the correct user is deleted.", 2, currencyArr[0]);

	    // Test Case 5 
	    C206_CaseStudy.deleteExistingCurrency(currencyArr);
	    // Test if currency array is empty after all currencies are deleted
	    assertEquals("Test that User arraylist size is 0.", 0,currencyArr.length);
	}
	// Account
	
	//Transaction
	@Before
	public void setUp() throws Exception {
		//prepare test data
		t1 = new Transaction(2, 1, "01/07/2022", 500.00, "USD", 10000.00, "Approved");
		t2 = new Transaction(2, 2, "15/07/2022", 300.00, "RM", 4000.00);
		t3 = new Transaction(3, 1, "01/12/2022", 700.00, "USD", 12000.00, "Approved");
		t4 = new Transaction(3, 2, "28/09/2022", 200.00, "", 7000.00);
		
		transactionList = new ArrayList<Transaction>();
	}

	@Test
	public void testAddTransaction() {
		//Test 1 - Boundary
		// Transaction list is not null and it is empty
		assertNotNull("Test if there is a valid Transaction arraylist to add to.", transactionList);
		assertEquals("Test that the Transaction arraylist is empty.", 0, transactionList.size());
		
		//Test 2 - Normal
		//Given an empty list, after adding 1 transaction, the size of the list is 1
		transactionList.add(new Transaction(2, 1, "01/07/2022", 500.00, "USD", 10000.00, "Approved"));		
		assertEquals("Test that the Transaction arraylist size is 1.", 1, transactionList.size());
			    
		//Test 3 - Error
		// Add an item
		transactionList.add(new Transaction(2, 2, "15/07/2022", 1000.00, "", 9000.00));
		assertEquals("Test that the Transaction arraylist size is now 2.", 2, transactionList.size());
	}
	
	@Test
	public void testViewAllTransaction() {
		//Test 1 - Boundary
		// Test if Transaction list is not null and empty
		assertNotNull("Test if there is a valid Transaction arraylist to add to", transactionList);
		assertEquals("Test that the Transaction arraylist is empty.", 0, transactionList.size());
		
		//Test 2 - Normal
		transactionList.add(new Transaction(2, 1, "01/07/2022", 500.00, "USD", 10000.00, "Approved"));
		transactionList.add(new Transaction(3, 1, "01/12/2022", 700.00, "USD", 12000.00, "Approved"));
		//Test that the list is not empty
		assertEquals("Test that Transaction arraylist size is 2.", 2, transactionList.size());
		//Attempt to retrieve the Transactions for userID 2
		String testOutput = "";
		String allTransaction = C206_CaseStudy.retrieveAllTransaction(transactionList, 2);
		testOutput = String.format("%-15d %-15d %-18s $%-19.2f %-20s $%-17.2f %-10s\n",2, 1, "01/07/2022", 500.00, "USD", 10000.00, "Approved");
		//Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", allTransaction, testOutput);
		
		//Test 3 - Error
		//Test that there is no Transaction for User
		String noTransactions = C206_CaseStudy.retrieveAllTransaction(transactionList, 5);
		// Verify that the output is an empty string since there are no transactions
        assertEquals("Test that the display is correct.", "", noTransactions);		
	}
	
	@Test
	public void testDeleteTransaction() {
		//Test 1 - Boundary
		// Test if Transaction list is not null and empty
		assertNotNull("Test if there is valid Transaction arraylist to add to", transactionList);
		assertEquals("Test that the Transaction arraylist is empty.", 0, transactionList.size());

	    //Test 2 - Normal
		Transaction transaction1 = new Transaction(2, 1, "01/07/2022", 500.00, "USD", 10000.00, "Approved");
	    // Add transactions to the list
	    transactionList.add(transaction1);
	    // Perform the deletion (let's assume user confirms)
	    C206_CaseStudy.deleteTransaction(transactionList, userList, 2, 1, 'Y');
	    // Verify that the transaction has been deleted
	    assertNull("Test that the deleted transaction is not found.", C206_CaseStudy.getMatchingTransactionID(1, transactionList));
	    assertEquals("Test that Transaction arraylist size is 1 after deletion.", 0, transactionList.size());
		
	    //Test 3 - Error
	    //Prepare some transactions for testing
	    Transaction transaction2 = new Transaction(2, 1, "01/07/2022", 500.00, "USD", 10000.00, "Approved");
	    // Add a transaction to the list
	    transactionList.add(transaction2);
	    // Attempt to delete a transaction with non-matching IDs
	    C206_CaseStudy.deleteTransaction(transactionList, userList, 3, 4, 'Y');
	    // Verify that the transaction list is unchanged
	    assertEquals("Test that Transaction arraylist size is 1 after unsuccessful deletion.", 1, transactionList.size());
	}
	
	// Rate
	// write code
	
	// Feedback
	@Before
	  public void setUp() throws Exception {
	    //prepare test data
	    
	      user1 = new User(2, "Customer", "Alan Tan", "alantan@abc.com", "Alantan_123", "80081234");
	      user2 = new User(3, "Customer", "Barbie", "barbie@123.com", "Barbie_234", "81171345");
	      user3 = new User(4, "Customer", "Ken", "ken02@hotmail.com", "Ken_345", "82261456");
	      userList = new ArrayList<User>();
	    feedbackList = new ArrayList<feedback>();
	   
	    DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    fb1 = new feedback(2, "best store", LocalDate.parse("12/02/2023", f1), "Thank you!");
	    fb2 = new feedback(3, "decent store", LocalDate.parse("12/04/2023", f1), "");
	  }
	  

	  @Test
	  public void c206_test() {
	    //fail("Not yet implemented"); 
	    assertTrue("C206_CaseStudy_SampleTest ",true);
	  }
	  
	  @Test
	  public void testRetrieveAllFeedback() {

	    assertNotNull("Test if there is a valid feedback arraylist to retrieve items", feedbackList);
	    DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    C206_CaseStudy.addFeedback(feedbackList, fb1);
	    C206_CaseStudy.addFeedback(feedbackList, fb2);
	    String allFeedback = C206_CaseStudy.viewAllFeedback(feedbackList);
	    String testOutput = String.format("%-10s %-20s %-20s %-10s\n", "ID", "FEEDBACK", "DATE", "COMMENTS");
	    testOutput += String.format("%-10d %-20s %-20s %-10s\n", 2, "best store", LocalDate.parse("12/02/2023", f1),
	        "Thank you!");
	    testOutput += String.format("%-10d %-20s %-20s %-10s\n", 3, "decent store", LocalDate.parse("12/04/2023", f1),
	        "");
	    assertEquals(testOutput, allFeedback);

	  }
	  
	  @Test
	  public void testAddNewFeedback() {
	    assertNotNull("Check if there is valid feedback arraylist to add to", feedbackList);
	    
	    C206_CaseStudy.addFeedback(feedbackList, fb1);
	    assertEquals("Check that feedback arraylist size is 1", 1, feedbackList.size());
	    assertSame("Check that feedback is added", fb1, feedbackList.get(0));
	    
	    C206_CaseStudy.addFeedback(feedbackList, fb2);
	    assertEquals("Check that feedback arraylist size is 2", 2, feedbackList.size());
	    assertSame("Check that feedback is added", fb2, feedbackList.get(1));
	  }
	  
	  public void testDoComment() {
	    assertNotNull("Test if there is valid feedback arraylist to add to", feedbackList);
	    C206_CaseStudy.addFeedback(feedbackList, fb2);
	    //normal
	    Boolean ok = C206_CaseStudy.inputComments(feedbackList, "Thank you!");
	    assertTrue("Test if an available item is ok to loan?", ok);    
	    //error condition
	    ok = C206_CaseStudy.inputComments(feedbackList, "");
	    assertFalse("Test if the comment is written", ok);  
	  }
	  
	  @Test
	  public void testEditFeedback() {
	    assertNotNull("Test if there is valid feedback arraylist to add to", feedbackList);
	    //normal
	    C206_CaseStudy.addFeedback(feedbackList, fb1);
	    C206_CaseStudy.addFeedback(feedbackList, fb2);
	    userList.add(user1);
	    userList.add(user2);
	    userList.add(user3);
	    C206_CaseStudy.editFeedback(feedbackList, userList);
	    assertEquals("Check that editted feedback has been updated", "good customer service", feedbackList.get(0).getfeedback());
	  }
	  
	  @Test
	  public void testDeleteFeedback() {
	    assertNotNull("Check if there is an arraylist to delete to", feedbackList);
	    C206_CaseStudy.addFeedback(feedbackList, fb1);
	    C206_CaseStudy.addFeedback(feedbackList, fb2);
	    C206_CaseStudy.deleteFeedback(feedbackList);
	    assertEquals("Check that feedback arraylist size is 0 after deletion", 1, feedbackList.size());
	  }  
	 
	
	
	@After
	public void tearDown() throws Exception {
		user1 = null;
		user2 = null;
		user3 = null;
		admin1 = null;
		userList = null;
		adminList = null;
		
		c1 = null;
		c2 = null;
		c3 = null;
		
		t1 = null;
		t2 = null;
		t3 = null;
		t4 = null;
		transactionList = null;
		
		fb1 = null;
		fb2 = null;
		
	}


}
