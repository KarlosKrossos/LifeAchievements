package achievements;

import personalisation.Person;
import utility.RequirementsNotMetException;

public class PolishCuttlery extends Achievement {

	public PolishCuttlery(Person person) throws RequirementsNotMetException {
		super("PolishCuttlery", 0, person);

		this.addAchievement(null);
	}

}
