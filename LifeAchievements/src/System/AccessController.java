package System;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import Personalisation.Person;
import Personalisation.PersonDatabase;
import Personalisation.User;
import Utility.Permission;

public class AccessController {

	private static final String admin = "admin";
	private static final String password = "admin";
	private static boolean loggedInAsUser = false;
	private static boolean loggedInAsAdmin = false;
	private static String confirmPhrase = "yes";
	// loggedInAs immutable until logout
	private static User loggedInAs = new User(Permission.GUEST, "guest");
	private static Person currentPerson = null;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void getStatus() {
		if (loggedInAsUser || loggedInAsAdmin) {
			System.out.println("Logged in.");
		} else {
			System.out.println("Not logged in.");
		}
		// TODO when person is deleted (e.g. guest) currentPerson should be cleaned too (if deleted)
		if (currentPerson != null) {
			System.out.println("Person in use: " + currentPerson.getFirstName() + " " + currentPerson.getLastName()
					+ " [" + currentPerson.getPermission() + "]");
		} else {
			System.out.println("No person in use.");
		}
	}

	public static void selectPerson(int id) {
		if (Permission.getPermission("AccessController.selectPerson")) {
			List<Person> persons = PersonDatabase.getPersons(getAdmin().getPerson());
			boolean found = false;
			for (Person p : persons) {
				if (p.getId() == id) {
					currentPerson = p;
					found = true;
				}
			}
			if (!found) {
				System.out.println("Could not change to other user.");
			}
		}
	}

	protected static boolean login() throws IOException {

		boolean loggedOut = true;
		if (loggedInAsUser || loggedInAsAdmin) {
			System.out.print("Logout current user?" + getConfirmPhrase());
			String logout = br.readLine();
			if (logout.equals(confirmPhrase)) {
				logout();
				loggedOut = true;
			} else {
				loggedOut = false;
			}
		} else {
			loggedInAs = new User(Permission.GUEST, "guest");
		}
		boolean authentic = false;
		if (loggedOut) {
			String loginUser = "", loginPassword = "";
			authentic = false;
			System.out.print("Enter user name:");
			loginUser = br.readLine();
			System.out.print("Enter password:");
			loginPassword = br.readLine();

			if (loginUser.equals(admin) && loginPassword.equals(password)) {
				System.out.println("Login success.");
				loggedInAs = new User(Permission.ADMIN, "admin");
				loggedInAsAdmin = true;
				authentic = true;
			} else if (isUser(loginUser, loginPassword)) {
				System.out.println("Login success.");
				loggedInAs = new User(Permission.USER, "user");
				loggedInAsUser = true;
				authentic = true;
			} else {
				System.out.println("Wrong credentials.");
				authentic = false;
				loggedInAs = new User(Permission.GUEST, "guest");
				System.out.println("Guest status persists.");
			}

			if (loggedInAs != null) {
				if (loggedInAs.getPerson() != null) {
					System.out.println(">>>> " + loggedInAs.toString() + ", " + loggedInAs.getPermission());
				}
			}
		}
		return authentic;
	}

	private static boolean isUser(String loginUser, String loginPassword) {
		boolean isUser = false;
		if (loginUser.equals("user") && loginPassword.equals("1234")) {
			isUser = true;
		}
		return isUser;
	}

	protected static User getAdmin() {
		// TODO log this event
		return new User(Permission.ADMIN, "admin");
	}

	private static String getConfirmPhrase() {
		return "(confirm with '" + confirmPhrase + "')";
	}

	protected static void logout() {
		loggedInAsAdmin = false;
		loggedInAsUser = false;
		currentPerson = null;
		loggedInAs = new User(Permission.GUEST, "guest");
		System.out.println("Logout successful.");
	}

	public static boolean isLoggedInAsAdmin() {
		return loggedInAsAdmin;
	}

	public static boolean isLoggedInAsUser() {
		return loggedInAsUser;
	}

	public static void setCurrentPerson(Person person) {
		if (Permission.getPermission("AccessController.setCurrentPerson")) {
			currentPerson = person;
		} else {
			System.out.println("No new person selected.");
		}

	}

	public static User getCurrentUser() {
		// TODO change
		// if (Permission.getPermission("getCurrentUser")) {
		// if (loggedInAs == null) {
		// // change to actual user
		// // loggedInAs = new User(new Person("guest", "", -1, false,
		// // Permission.GUEST));
		// }
		// }
		return loggedInAs;
	}

	public static Person getCurrentPerson() {
		return currentPerson;
	}

	protected static void loginTempUser() {
		loggedInAs = new User(Permission.GUEST, "guest");
	}

	protected static void logoutTempUser() {
		loggedInAs = null;
	}
}
