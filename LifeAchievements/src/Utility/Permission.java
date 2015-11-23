package Utility;

import Personalisation.User;
import System.AccessController;
import System.ConsoleController;

public enum Permission {
    ADMIN, USER, GUEST;

    /**
     * this UID is used to identify this call for the PermissionDatabase
     */
    private static final long serialVersionUID = 2214802304429380620L;

    public static boolean getPermission(String methodName) {
        User person = AccessController.getCurrentUser();
        if (ConsoleController.printRequests()) {
            System.out.println("Request to use " + methodName);
        }
        if (person == null) {
            try {
                throw new PermissionDeniedException(null, methodName);
            } catch (PermissionDeniedException e) {
                return false;
            }
        } else {

            Permission user = person.getPermission();
            Permission required = PermissionDatabase.checkPermissionRequired(
                    methodName, serialVersionUID);
            if (user == null) {
                return false;
            } else if (user == Permission.ADMIN || user == required) {
                return true;
            } else if (required == Permission.GUEST) {
                return true;
            } else {
                try {
                    throw new PermissionDeniedException(user, methodName);
                } catch (PermissionDeniedException e) {
                    return false;
                }
            }
        }
    }

}
