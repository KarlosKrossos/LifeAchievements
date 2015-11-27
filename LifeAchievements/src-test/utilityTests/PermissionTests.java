package utilityTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import personalisation.Person;
import utility.Permission;

public class PermissionTests {

	Person guest;
	Person user;
	Person admin;

	@Before
	public void setUp() throws Exception {
		guest = new Person("Gustav", "Gräuel", 79, true, Permission.GUEST);
		user = new Person("Ulfbert", "Uhrmacher", 800, true, Permission.USER);
		admin = new Person("Astrid", "Argon", 1, true, Permission.ADMIN);
	}
	
	/*
	* testing whether a specific method can actually really only be accessed/used 
	* given the respective rights as specified in the PermissionDatabase
	*/
	@Test
	public void getPermissionTest() {
		// TODO compare with PermissionDatabase entries(?)
	}
	
	@Test
	public void getPermissionTest_userNull() {
		// TODO same test as in getPermissionTest with special condition that person == null
	}
	
	@Test
	public void getPermissionTest_permissionNull() {
		// TODO same test as in getPermissionTest with special condition that user == null
	}
	
	@Test
	public void getPermissionTest_wrongSerialUid() {
		// TODO compare with PermissionDatabase entries(?)
	}

}
