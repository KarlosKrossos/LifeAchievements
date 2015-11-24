package Achievements;

import Personalisation.Person;

public class Drink extends Achievement {

	private static int level = 4;

	public Drink(Person person) {
		super("Drink", level, person);

		this.addRequirement("Swallow");
	}

}
