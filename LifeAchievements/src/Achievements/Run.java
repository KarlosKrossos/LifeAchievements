package Achievements;

import Personalisation.Person;
import Utility.Permission;

public class Run extends Achievement {

    private double overallDistance;

    public Run(Person person) {
        super("Run", 2, person);
        addRequirement("Walk");
    }

    public void increaseDistance(double additionalDistance) {
        if (Permission.getPermission("Run.increaseDistance")) {
            this.overallDistance += additionalDistance;
        }
    }

    public double getOverallDistance() {
        if (Permission.getPermission("Run.getOverallDistance")) {
            return overallDistance;
        } else {
            return 0;
        }
    }

    public void setOverallDistance(double overallDistance) {
        if (Permission.getPermission("Run.setOverallDistance")) {
            this.overallDistance = overallDistance;
        }
    }
}
