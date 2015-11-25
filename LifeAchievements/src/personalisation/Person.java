package personalisation;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import achievements.Achievement;
import utility.Permission;
import utility.RequirementsNotMetException;

public class Person {

    private final int id;
    private final Permission permission;
    private String firstName;
    private String lastName;
    private int age;
    // should be changed from long to Date
    private long lastEdit;
    private final long personCreated;
    // TODO incorporate points
    private int score;
    private final boolean editable;
    private List<Achievement> achievements = new CopyOnWriteArrayList<Achievement>();

    public Person(String firstName, String lastName, int age, boolean editable,
            Permission permission) {

        // TODO if permission ADMIN ask for specific credentials
        this.id = PersonDatabase.getCounter(Permission.ADMIN);
        // editable refers to the base data such as name, age, permission
        if (permission == Permission.ADMIN) {
            this.editable = editable;
        } else {
            this.editable = false;
        }
        this.permission = permission;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.personCreated = System.currentTimeMillis();
        this.lastEdit = System.currentTimeMillis();
        PersonDatabase.addPerson(this);
    }

    public void addAchievement(Achievement achievement)
            throws RequirementsNotMetException {
        if (Permission.getPermission("Person.addAchievement")) {
            if (achievement != null) {
                achievement.setActivated();
                this.achievements.add(achievement);
            }
            cleanUpAchievements();
        }
    }

    private List<Achievement> getAchievements() {
        if (Permission.getPermission("Person.getAchievements")) {
            cleanUpAchievements();

            if (!this.achievements.isEmpty()) {
                return this.achievements;
            } else {
                System.out
                        .println("Returning Achievements failed. No achievements yet.");
                return new CopyOnWriteArrayList<Achievement>();
            }
        } else {
            // TODO or return empty list
            return null;
        }
    }

    private void cleanUpAchievements() {
        // System.out.println("Cleaning up achievements:");
        // TODO don't use secondary list, work on original achievements
        List<Achievement> cleanedUpAchievements = new CopyOnWriteArrayList<Achievement>();

        // removing inactive achievements
        for (Achievement a : this.achievements) {
            if (a.isActivated()) {
                cleanedUpAchievements.add(a);
            } else {
                System.out.println("Removing inactive achievement: "
                        + a.getName());
            }
        }

        // removing double entries
        for (int i = 0; i < this.achievements.size(); i++) {
            for (int k = i + 1; k < this.achievements.size(); k++) {
                Achievement achievement_i = this.achievements.get(i);
                Achievement achievement_k = this.achievements.get(k);
                if (achievement_i != null && achievement_k != null) {
                    if (achievement_i.getName().equals(achievement_k.getName())) {
                        System.out.println("Removing double entry '"
                                + this.achievements.get(k).getName() + "'");
                        cleanedUpAchievements.remove(this.achievements.get(k));
                    }
                }
            }
        }
        this.achievements = cleanedUpAchievements;
    }

    public List<String> getAchievementsAsString() {
        if (Permission.getPermission("Person.getAchievementsAsString")) {
            List<String> aStrings = new CopyOnWriteArrayList<String>();
            if (this.getAchievements() != null) {
                for (Achievement a : this.getAchievements()) {
                    aStrings.add(a.getName());
                }
            }
            return aStrings;
        } else {
            // TODO or return empty list
            return null;
        }
    }

    public int getId() {
        if (Permission.getPermission("Person.getId")) {
            return this.id;
        } else {
            return 0;
        }
    }

    public String getFirstName() {
        if (Permission.getPermission("Person.getFirstName")) {
            return firstName;
        } else {
            return "";
        }
    }

    public void setFirstName(String firstName) {
        if (Permission.getPermission("Person.setFirstName")) {
            if (editable) {
                this.lastEdit = System.currentTimeMillis();
                this.firstName = firstName;
            }
        }
    }

    public String getLastName() {
        if (Permission.getPermission("Person.getLastName")) {
            return lastName;
        } else {
            return "";
        }
    }

    public void setLastName(String lastName) {
        if (Permission.getPermission("Person.setLastName")) {
            if (editable) {
                this.lastEdit = System.currentTimeMillis();
                this.lastName = lastName;
            }
        }
    }

    public int getAge() {
        if (Permission.getPermission("Person.getAge")) {
            // TODO convert from long to years,months, days
            return age;
        } else {
            return 0;
        }
    }

    public void setAge(int age) {
        if (Permission.getPermission("Person.setAge")) {
            if (editable) {
                this.lastEdit = System.currentTimeMillis();
                this.age = age;
            } else {
                this.lastEdit = System.currentTimeMillis();
                this.age = (int) (this.lastEdit - this.personCreated);
            }
        }
    }

    public Permission getPermission() {
        return permission;
    }

    public Integer getScore() {
        if (Permission.getPermission("Person.getScore")) {
            return this.score;
        } else {
            return 0;
        }
    }

    public String toString() {
        if (Permission.getPermission("Person.toString")) {
            return "Person [id=" + id + ", firstName=" + firstName
                    + ", lastName=" + lastName + ", age=" + age + ", score="
                    + score + ", achievements=" + printAchievements() + "]";
        } else {
            return "";
        }
    }

    private String printAchievements() {
        String achievementsString = "";
        for (Achievement a : achievements) {
            if (!achievementsString.equals("")) {
                achievementsString += ", ";
            }
            achievementsString += a.getName();
        }
        if (achievementsString.equals("")) {
            achievementsString = "none";
        }
        return achievementsString;
    }

}
