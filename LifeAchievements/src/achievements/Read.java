package achievements;

import personalisation.Person;

public class Read extends Achievement {

    private static int level = 10;

    public Read(Person person) {
        super("Read", level, person);

        this.addRequirement("LookAtBook");
        // TODO enable OR logic
        this.addRequirement("GrabBook");
    }

}
