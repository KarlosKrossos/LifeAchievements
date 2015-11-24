package Achievements;

import Personalisation.Person;
import Utility.RequirementsNotMetException;

public class BeWaiter extends Achievement {

	public BeWaiter(Person person) throws RequirementsNotMetException {
		super("BeWaiter", 0, person);

		this.addRequirement("DryDishes");
	}

}
