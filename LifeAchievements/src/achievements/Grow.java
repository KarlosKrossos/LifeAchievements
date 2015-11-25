package achievements;

import personalisation.Person;
import utility.Permission;
import utility.RequirementsNotMetException;

public class Grow extends Achievement {

    private double size;

    public Grow(Person person) throws RequirementsNotMetException {
        super("Grow", 0, person);
        this.addAchievement(null);
    }

    public double getSize() {
        if (Permission.getPermission("Grow.getSize")) {
            return size;
        } else {
            return 0;
        }
    }

    public void setSize(double size) {
        if (Permission.getPermission("Grow.setSize")) {
            this.size = size;
        }
    }

}
