package personalisation;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import system.AccessController;
import utility.Permission;

/*
*   the PersonDatabase holds all currently entered persons in some kind of storage
*   currently [26.11.2015] this is done in a CopyOnWriteArrayList<Person>
*   TODO change the format of the storage to a secure separate file
*   TODO this file should be read to initiatlize the database at the beginning of the programm
*/
public class PersonDatabase {
    private static int counter;
    private static final int NULL = 0;
    private static List<Person> persons = new CopyOnWriteArrayList<Person>();

    /*
    *   anyone may add a person, the default permission should be guest
    *   in a logged in state this person is given user rights
    *   or, if issued by an admin, it may be given admin rights too
    */
    public static void addPerson(Person person) {
        if (Permission.getPermission("PersonDatabase.addPerson")) {
            cleanInvalidPersons();
            // if (Permission.getPermission("PersonDatabase.addPerson")) {
            persons.add(person);
            // }
            counter++;
        }
    }

    /*
    *   admins can remove a person from the database 
    *   this requires the correct ID
    *   TODO if an admin requests the removal with an incorrect ID 
    *   TODO this method should be blocked until released in a separate step
    */
    public static void removePerson(int id) {
        if (Permission.getPermission("PersonDatabase.removePerson")) {
            for (Person p : persons) {
                if (p.getId() == id) {
                    // TODO if not editable should require admin rights
                    persons.remove(p);
                    System.out.println("Person with ID " + id
                            + " has been removed.");
                }
            }
        }
    }

    /*
    *   as part of printing the database this method provides the raw number of entries
    *   this can be done two ways, with a person or just the permission
    *   TODO potential security issue here. Reduce to only one proper method
    */
    public static int getCounter(Person person) {
        if (Permission.getPermission("PersonDatabase.getCounter")) {
            cleanInvalidPersons();
            return counter;
        } else {
            return NULL;
        }
    }
    
    /*
    *   as part of printing the database this method provides the raw number of entries
    *   this can be done two ways, with a person or just the permission
    *   TODO potential security issue here. Reduce to only one proper method
    */
    public static int getCounter(Permission permission) {
        // TODO shouldn't permission come from user here? or otherwise breaking functionality?
        if (permission == Permission.ADMIN) {
            cleanInvalidPersons();
            return counter;
        } else {
            return NULL;
        }
    }

    /*
    *   admins may request all person entries of the database
    *   this is in order to select or process person data
    *   processing may be changing or deleting
    */
    public static List<Person> getPersons(Person person) {
        if (Permission.getPermission("PersonDatabase.getPersons")) {
            return persons;
        } else {
            // TODO or maybe return new empty list
            return new CopyOnWriteArrayList<Person>();
        }
    }
    
    /*
    *   users and admins may see some details of the person database
    */
    public static void printDatabase() {
        if (Permission.getPermission("PersonDatabase.printDatabaseBasics")) {
            System.out.println("### "
                    + AccessController.getCurrentUser().getPermission()
                    + " requests list of all persons. ###");

            cleanInvalidPersons();
            printSize();
            if (Permission.getPermission("PersonDatabase.printDatabaseDetails")) {
                for (Person p : persons) {
                    System.out.println(p.toString());
                }
            }
        }
    }
    
    /*
    *   admins may remove all guests from the database
    */
    public static void cleanGuests() {
        if (Permission.getPermission("PersonDatabase.cleanGuests")) {
            for (Person p : persons) {
                if (p.getPermission() == Permission.GUEST) {
                    persons.remove(p);
                }
            }
        }
    }

    /*
    *   removing persons from database whose data are not properly filled
    *
    *   TODO ensure such data cannot be entered in the first place
    */
    public static void cleanInvalidPersons() {
        if (Permission.getPermission("PersonDatabase.cleanInvalidPersons")) {
            for (Person p : persons) {
                if (p.getFirstName().equals("") || p.getLastName().equals("") || p.getAge() < 0) {
                    persons.remove(p);
                }
            }
        }
    }

    /*
    *   user may not see person details 
    *   but they are allowed to see the number of users
    */
    public static void printSize() {
        if (Permission.getPermission("PersonDatabase.getSize")) {
            System.out.println("DataBase (size=" + persons.size() + "): ");
        }
    }
}
