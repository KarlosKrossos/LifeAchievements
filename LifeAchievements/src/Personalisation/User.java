package Personalisation;

import Utility.Permission;

public class User {

	private String firstName = "", lastName = "";
	private boolean editable = false;
	private Permission permission = Permission.ADMIN;

	/**
	 * TODO user can have more than 1 person, guest can not, admin has access to
	 * other users and persons
	 */
	// make sure only accessible from specific areas
	public Person getPerson() {
		return null; // new Person(firstName, lastName, age, editable,
						// permission);
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " [" + permission + "]";
	}

	public User(Permission perm) {
		this.editable = false;
		this.permission = perm;
	}

	public Permission getPermission() {
		return permission;
	}

	public boolean isEditable() {
		return editable;
	}

}
