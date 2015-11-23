package Achievements;

import Personalisation.Person;

public class Laugh extends Achievement {

    private static int level = 2;

    public Laugh(Person person) {
        super("Laugh", level, person);

        this.addRequirement("Giggle");
    }

}
