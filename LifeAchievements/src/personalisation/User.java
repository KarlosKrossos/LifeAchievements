package personalisation;

import utility.Permission;

public class User {

	private String userName = ""; // , password = "";
	private boolean editable = false;
	private Permission permission = Permission.ADMIN;
	private int hashId = -1;

	@Override
	public int hashCode() {
		// such a cool prime number
		final int prime = 3571;
		int result = 1;
		result = prime * result + ((permission == null) ? 0 : permission.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		this.hashId = result;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (permission != other.permission)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	protected boolean equals(int hashId) {
		if (this.hashId == hashId) {
			return true;
		} else {
			return false;
		}
	}

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
		return userName + " [" + permission + "]";
	}

	public User(Permission perm, String userName) {
		this.editable = false;
		this.permission = perm;
		
		// validate userName, must not be too long due to hashCode overflow
		this.userName = userName;
		this.hashId = hashCode();
		// this.password = password;
	}

	public Permission getPermission() {
		return permission;
	}

	public boolean isEditable() {
		return editable;
	}

}
