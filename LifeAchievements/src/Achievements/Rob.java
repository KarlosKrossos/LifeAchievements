package Achievements;

import Personalisation.Person;
import Utility.Permission;
import Utility.RequirementsNotMetException;

public class Rob extends Achievement {

    private double overallDistance;

    public Rob(Person person) throws RequirementsNotMetException {
        super("Rob", 0, person);
        this.addAchievement(null);
    }

    public void increaseDistance(double additionalDistance) {
        if (Permission.getPermission("Rob.increaseDistance")) {
            this.overallDistance += additionalDistance;
        }
    }

    public double getOverallDistance() {
        if (Permission.getPermission("Rob.getOverallDistance")) {
            return overallDistance;
        } else {
            return 0;
        }
    }

    public void setOverallDistance(double overallDistance) {
        if (Permission.getPermission("Rob.setOverallDistance")) {
            this.overallDistance = overallDistance;
        }
    }
}
