package Achievements;

import Personalisation.Person;
import Utility.Permission;

public class Sprint extends Achievement {

    private double overallDistance;

    public Sprint(Person person) {
        super("Sprint", 3, person);
        addRequirement("Run");
    }

    public void increaseDistance(double additionalDistance) {
        if (Permission.getPermission("Sprint.increaseDistance")) {
            this.overallDistance += additionalDistance;
        }
    }

    public double getOverallDistance() {
        if (Permission.getPermission("Sprint.getOverallDistance")) {
            return overallDistance;
        } else {
            return 0;
        }
    }

    public void setOverallDistance(double overallDistance) {
        if (Permission.getPermission("Sprint.setOverallDistance")) {
            this.overallDistance = overallDistance;
        }
    }
}
