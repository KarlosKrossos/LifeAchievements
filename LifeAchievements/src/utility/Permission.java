package utility;

import personalisation.User;
import system.AccessController;
import system.ConsoleController;

public enum Permission {
    ADMIN, USER, GUEST;

    /**
     * this UID is used to identify this call for the PermissionDatabase
     */
    private static final long serialVersionUID = 2214802304429380620L;

    
    // TODO do this annotation based
    public static boolean getPermission(String methodName) {
        User user = AccessController.getCurrentUser();
        if (ConsoleController.printRequests()) {
            System.out.println("Request to use " + methodName);
        }
        if (user == null) {
            try {
                throw new PermissionDeniedException(null, methodName);
            } catch (PermissionDeniedException e) {
                return false;
            }
        } else {

            Permission permission = user.getPermission();
            Permission required = PermissionDatabase.checkPermissionRequired(
                    methodName, serialVersionUID);
            if (permission == null) {
                return false;
            } else if (permission == Permission.ADMIN || permission == required) {
                return true;
            } else if (required == Permission.GUEST) {
                return true;
            } else {
                try {
                    throw new PermissionDeniedException(permission, methodName);
                } catch (PermissionDeniedException e) {
                    return false;
                }
            }
        }
    }

}
