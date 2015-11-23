package Achievements;

import Personalisation.Person;

public class UseValcrowShoes extends Achievement {

    // TODO adjust spelling of this class ... Klettverschlussschuhe
    private static int level = 10;

    public UseValcrowShoes(Person person) {
        super("UseValcrowShoes", level, person);
        this.addRequirement("BindShoeLaces");
    }

}
