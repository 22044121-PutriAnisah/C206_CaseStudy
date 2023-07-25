import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private admin admin1;
	private admin admin2;
	private admin admin3;
	private User user1;
	private User user2;
	private User user3;
	
	private ArrayList<admin> adminList;
	private ArrayList<User> userList;
	
//	public C206_CaseStudy() {
//		super();
//	}

	@Before
	public void setUp() throws Exception {
		//prepare test data
		// add new user: userName, pw, add user
		admin1 = new admin("Joshua Lim", "JoshLim_123");
		admin1 = new admin("Jane Tan", "JaneTan_132");
		admin1 = new admin("Peter Parker", "PeterParker_432");
		user1 = new User("Alan Tan","alantan@abc.com","Alantan_123",80081234);
		user2 = new User("Clark Kent", "clarkkent@abc.com", "ClarkKent_001", 81128234);
		user3 = new User("Bruce Wayne", "brucewayne@abc.com", "BruceWayne_400", 93345678);
		adminList = new ArrayList<admin>();
		userList = new ArrayList<User>();
		
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	@Test
	public void testAddNewAdmin() {
		assertNotNull("Test if there is valid Admin arraylist to add to", adminList);
		assertEquals("Test that the Admin arraylist is empty.", 0, adminList.size());
	}


	@Test
	public void testViewAllUsers() {
		
	}

}
