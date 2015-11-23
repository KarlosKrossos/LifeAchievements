package Achievements;

import Personalisation.Person;
import Utility.Permission;

public class Walk extends Achievement {

    private double overallDistance;

    public Walk(Person person) {
        super("Walk", 0, person);
        addRequirement("Crawl");
        addRequirement("Stand");
    }

    public void increaseDistance(double additionalDistance) {
        if (Permission.getPermission("Walk.increaseDistance")) {
            this.overallDistance += additionalDistance;
        }
    }

    public double getOverallDistance() {
        if (Permission.getPermission("Walk.getOverallDistance")) {
            return overallDistance;
        } else {
            return 0;
        }
    }

    public void setOverallDistance(double overallDistance) {
        if (Permission.getPermission("Walk.setOverallDistance")) {
            this.overallDistance = overallDistance;
        }
    }
}
