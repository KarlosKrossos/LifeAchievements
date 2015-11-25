package personalisation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import system.ConsoleController;
import utility.Permission;

public class UserDatabase {

	private static List<User> users = new CopyOnWriteArrayList<User>();

	private static ConcurrentHashMap<Integer, String> userDatabase = new ConcurrentHashMap<Integer, String>();

	// TODO method to change permission level (e.g. guest to user, user to
	// guest)

	public static void registerUser(User iCouldBeAdmin) throws IOException {
		// TODO remove that
		printUserDatabase();

		// TODO only 10 register per minute ? to prevent spammers

		// TODO proper admin check
		if (iCouldBeAdmin != null) {
			if (iCouldBeAdmin.getPermission() == Permission.ADMIN) {
				// TODO create user with any feature (incl. admin rights)
				users.add(collectNewUserData(Permission.ADMIN));
			} else if (iCouldBeAdmin.getPermission() == Permission.USER) {
				// TODO logout before registering or cancel as wished
				users.add(collectNewUserData(Permission.USER));
			} else {
				// TODO guest may createUser with user rights and then login
				users.add(collectNewUserData(Permission.GUEST));
			}
		} else {
			// TODO validate
			users.add(collectNewUserData(Permission.GUEST));
		}
	}

	public static void printUserDatabase() {
		// TODO proper admin check
		System.out.println("UserDatabase:");
		Iterator<Entry<Integer, String>> it;
		Map.Entry<Integer, String> entry;
		it = userDatabase.entrySet().iterator();
		while (it.hasNext()) {
			entry = it.next();
			System.out.println(entry.getKey().toString() + " - " + entry.getValue());
		}
	}

	private static User collectNewUserData(Permission permission) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userName = "user", password = "";
		boolean setAsAdmin = false, valid = false;

		while (!valid) {
			System.out.print("Enter user name:");
			userName = br.readLine();
			if (!userName.equals("")) {
				valid = true;
			}
		}
		valid = false;
		while (!valid) {
			System.out.print("Enter password:");
			password = br.readLine();
			// TODO validation pattern
			if (!password.equals("")) {
				valid = true;
			}
		}
		// TODO repeat password

		if (permission == Permission.ADMIN) {
			valid = false;
			while (!valid) {
				System.out.print("Set as admin?" + ConsoleController.getConfirmPhrase());
				String admin = br.readLine();
				// TODO use confirmphrase
				if (admin.equals("yes")) {
					valid = true;
					setAsAdmin = true;
				}
			}
		}
		User user = new User(Permission.GUEST, userName);
		if (setAsAdmin) {
			user = new User(Permission.ADMIN, userName);
			users.add(user);
			userDatabase.put(user.hashCode(), password);
		} else {
			user = new User(Permission.USER, userName);
			users.add(user);
			userDatabase.put(user.hashCode(), password);
		}
		return user;
	}

	public static boolean isAuthentic(User user, String password) {
		boolean authentic = false;
		if (user == null || password.equals("")) {
			return false;
		}
		// TODO verify
		if (password.equals(userDatabase.get(user.hashCode()))) {
			authentic = true;
			System.out.println("ding ding ding");
		}

		return authentic;
	}
}
