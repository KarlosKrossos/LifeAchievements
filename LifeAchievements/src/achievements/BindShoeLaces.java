package achievements;

import personalisation.Person;
import utility.RequirementsNotMetException;

public class BindShoeLaces extends Achievement {

    private static int level = 10;

    public BindShoeLaces(Person person) throws RequirementsNotMetException {
        super("BindShoeLaces", level, person);
        this.addAchievement(null);
    }

}
