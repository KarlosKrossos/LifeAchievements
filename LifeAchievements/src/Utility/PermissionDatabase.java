package Utility;

import java.util.Hashtable;

final class PermissionDatabase {

    private static boolean hasBeenFilledAlready = false;
    private static final long serialVersionUID_Permission = 2214802304429380620L;
    private static final Hashtable<String, Permission> permissionsAllMethods = new Hashtable<String, Permission>();

    // TODO ensure this method can be accessed from Permission class only
    protected static Permission checkPermissionRequired(String methodName,
            long who) {

        if (who == serialVersionUID_Permission) {
            // fill table once
            if (!hasBeenFilledAlready) {
                fillTable();
                hasBeenFilledAlready = true;
                System.out.println("### Permission table filled. ###");
            }

            // return required permission from table
            Permission required = permissionsAllMethods.get(methodName);
            if (required == null) {
//                try {
//                    throw new PermissionDeniedException(required, methodName);
//                } catch (PermissionDeniedException e) {
//
//                }
                required = Permission.ADMIN;
            }
            return required;
        } else {
            return null;
        }
    }

    private static void fillTable() {
        fillTableForPersonDatabase();
        fillTableForAchievement();
        fillTableForPerson();
        fillTableForSystem();
    }

    private static void fillTableForSystem() {
        permissionsAllMethods.put("AccessController.setCurrentPerson",
                Permission.GUEST);
        permissionsAllMethods.put("AccessController.selectPerson",
                Permission.ADMIN);
    }

    private static void fillTableForPerson() {
        permissionsAllMethods.put("Person.getAchievementsAsString",
                Permission.GUEST);
        permissionsAllMethods.put("Person.getAchievements", Permission.GUEST);
        permissionsAllMethods.put("Person.addAchievement", Permission.GUEST);
        permissionsAllMethods.put("Person.getFirstName", Permission.GUEST);
        permissionsAllMethods.put("Person.getLastName", Permission.GUEST);
        // TODO Person.toString does fail with admin rights somewhere -> resolve
        permissionsAllMethods.put("Person.toString", Permission.USER);
        permissionsAllMethods.put("Person.getScore", Permission.USER);
        permissionsAllMethods.put("Person.printAchievements", Permission.USER);
        permissionsAllMethods.put("Person.getAge", Permission.USER);
        permissionsAllMethods.put("Person.getId", Permission.USER);
    }

    private static void fillTableForAchievement() {
        permissionsAllMethods.put("Achievement.newAchievement",
                Permission.GUEST);
        permissionsAllMethods.put("Achievement.addRequirement",
                Permission.GUEST);
        permissionsAllMethods.put("Achievement.addAchievement",
                Permission.GUEST);
        permissionsAllMethods.put("Achievement.setActivated", Permission.GUEST);
        permissionsAllMethods.put("Achievement.isActivated", Permission.GUEST);
        permissionsAllMethods.put("Achievement.getName", Permission.GUEST);
        fillTableForIndividualMethods();
    }

    private static void fillTableForIndividualMethods() {
        // TODO add additional methods from individual achievements here

    }

    private static void fillTableForPersonDatabase() {
        permissionsAllMethods.put("PersonDatabase.getCounter", Permission.USER);
        permissionsAllMethods.put("PersonDatabase.addPerson", Permission.GUEST);
        permissionsAllMethods.put("PersonDatabase.printDatabase",
                Permission.ADMIN);
        permissionsAllMethods.put("PersonDatabase.getSize", Permission.USER);
        permissionsAllMethods.put("PersonDatabase.cleanGuests",
                Permission.ADMIN);
        permissionsAllMethods
                .put("PersonDatabase.getPersons", Permission.ADMIN);
    }

}
