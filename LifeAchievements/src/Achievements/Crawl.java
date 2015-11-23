package Achievements;

import Personalisation.Person;
import Utility.Permission;

public class Crawl extends Achievement {

    private double overallDistance;

    public Crawl(Person person) {
        super("Crawl", 0, person);
        this.addRequirement("Rob");
    }

    public void increaseDistance(double additionalDistance) {
        if (Permission.getPermission("Crawl.increaseDistance")) {
            this.overallDistance += additionalDistance;
        }
    }

    public double getOverallDistance() {
        if (Permission.getPermission("Crawl.getOverallDistance")) {
            return overallDistance;
        } else {
            return 0;
        }
    }

    public void setOverallDistance(double overallDistance) {
        if (Permission.getPermission("Crawl.setOverallDistance")) {
            this.overallDistance = overallDistance;
        }
    }
}
