package Achievements;

import Personalisation.Person;
import Utility.RequirementsNotMetException;

public class Giggle extends Achievement {

    private static int level = 1;

    public Giggle(Person person) throws RequirementsNotMetException {
        super("Giggle", level, person);

        this.addAchievement(null);
    }

}
