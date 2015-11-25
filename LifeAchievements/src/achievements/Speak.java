package achievements;

import personalisation.Person;

public class Speak extends Achievement {

    private static int level = 3;

    public Speak(Person person) {
        super("Speak", level, person);

        this.addRequirement("Babble");
    }

}
