package Personalisation;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import Utility.Permission;

public class UserDatabase {

    private static List<User> users = new CopyOnWriteArrayList<User>();

    
    public void registerUser(User iCouldBeAdmin) {
    	if(iCouldBeAdmin!=null) {
    		if(iCouldBeAdmin.getPermission()==Permission.ADMIN) {
    			// TODO create user with any feature (incl. admin rights)
    		} else if(iCouldBeAdmin.getPermission()==Permission.USER) {
    			// TODO logout before registering or cancel as wished
    		} else {
    			// TODO guest may createUser with user rights and then login
    		}
    	}
    	else { 
    		// TODO validate
    		users.add(retrieveNewUserData());
    	}
    }
    
    private User retrieveNewUserData() {
    	// TODO collect data
    	return null;
    }
}
