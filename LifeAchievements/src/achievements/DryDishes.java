package achievements;

import personalisation.Person;
import utility.RequirementsNotMetException;

public class DryDishes extends Achievement {

	public DryDishes(Person person) throws RequirementsNotMetException {
		super("DryDishes", 0, person);

		this.addRequirement("Stand");
	}

}
