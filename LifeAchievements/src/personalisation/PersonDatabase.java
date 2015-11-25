package personalisation;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import system.AccessController;
import utility.Permission;

public class PersonDatabase {
    private static int counter;
    private static List<Person> persons = new CopyOnWriteArrayList<Person>();

    public static void addPerson(Person person) {
        cleanInvalidPersons();
        // if (Permission.getPermission("PersonDatabase.addPerson")) {
        persons.add(person);
        // }
        counter++;
    }

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

    public static int getCounter(Person person) {
        cleanInvalidPersons();
        final int NULL = 0;
        if (Permission.getPermission("PersonDatabase.getCounter")) {
            return counter;
        } else {
            return NULL;
        }
    }

    public static int getCounter(Permission permission) {
        cleanInvalidPersons();
        final int NULL = 0;
        if (permission == Permission.ADMIN) {
            return counter;
        } else {
            return NULL;
        }
    }

    public static List<Person> getPersons(Person person) {
        if (Permission.getPermission("PersonDatabase.getPersons")) {
            return persons;
        } else {
            // TODO or maybe return new empty list
            return null;
        }
    }

    public static void printDatabase() {
        if (Permission.getPermission("PersonDatabase.printDatabase")) {
            System.out.println("### "
                    + AccessController.getCurrentUser().getPermission()
                    + " requests list of all persons. ###");

            cleanInvalidPersons();
            printSize();
            if (Permission.getPermission("PersonDatabase.printDatabase")) {
                for (Person p : persons) {
                    System.out.println(p.toString());
                }
            }
        }
    }

    public static void cleanGuests() {
        if (Permission.getPermission("PersonDatabase.cleanGuests")) {
            for (Person p : persons) {
                if (p.getPermission() == Permission.GUEST) {
                    persons.remove(p);
                }
            }
        }
    }

    private static void cleanInvalidPersons() {
        for (Person p : persons) {
            if (p.getFirstName().equals("") || p.getLastName().equals("")) {
                // System.err.println("Removing invalid person " + p);
                persons.remove(p);
            }
        }
    }

    private static void printSize() {
        if (Permission.getPermission("PersonDatabase.getSize")) {
            System.out.println("DataBase (size=" + persons.size() + "): ");
        }
    }
}
