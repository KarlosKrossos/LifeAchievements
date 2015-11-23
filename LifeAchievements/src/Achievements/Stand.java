package Achievements;

import Personalisation.Person;
import Utility.Permission;

public class Stand extends Achievement {

    private double timeWithoutFalling;

    public Stand(Person person) {
        super("Stand", 0, person);
        addRequirement("Crawl");
    }

    public void increaseTime(double additionalTime) {
        if (Permission.getPermission("Stand.increaseTime")) {
            this.setTimeWithoutFalling((this.timeWithoutFalling + additionalTime));
        }
    }

    public double getTimeWithoutFalling() {
        if (Permission.getPermission("Stand.getTimeWithoutFalling")) {
            return timeWithoutFalling;
        } else {
            return 0;
        }
    }

    public void setTimeWithoutFalling(double timeWithoutFalling) {
        if (Permission.getPermission("Stand.setTimeWithoutFalling")) {
            this.timeWithoutFalling = timeWithoutFalling;
        }
    }
}
