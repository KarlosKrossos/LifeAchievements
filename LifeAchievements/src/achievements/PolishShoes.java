package achievements;

import personalisation.Person;
import utility.RequirementsNotMetException;

public class PolishShoes extends Achievement {

	public PolishShoes(Person person) throws RequirementsNotMetException {
		super("PolishShoes", 0, person);

		this.addRequirement("BindShoeLaces");
	}

}
