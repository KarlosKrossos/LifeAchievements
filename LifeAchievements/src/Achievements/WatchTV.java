package Achievements;

import Personalisation.Person;
import Utility.RequirementsNotMetException;

public class WatchTV extends Achievement {

	public WatchTV(Person person) throws RequirementsNotMetException {
		super("WatchTV", 0, person);

		this.addRequirement("DryDishes");
	}

}
