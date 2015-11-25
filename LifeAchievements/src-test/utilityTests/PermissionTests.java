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

	@Test
	public void test() {
		// TODO find out how to expect exceptions
		// TODO then throw them accordingly
		// fail("Not yet implemented");
	}

}
