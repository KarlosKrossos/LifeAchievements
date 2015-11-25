package rewards;

import achievements.Achievement;
import personalisation.Person;
import utility.RequirementsNotMetException;

public class WatchTV extends Achievement {

	public WatchTV(Person person) throws RequirementsNotMetException {
		super("WatchTV", 0, person);

		this.addRequirement("DryDishes");
	}

}
