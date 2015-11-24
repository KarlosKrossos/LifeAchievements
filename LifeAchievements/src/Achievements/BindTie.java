package Achievements;

import Personalisation.Person;
import Utility.RequirementsNotMetException;

public class BindTie extends Achievement {

	public BindTie(Person person) throws RequirementsNotMetException {
		super("BindTie", 0, person);
		this.addAchievement(null);
	}

}
