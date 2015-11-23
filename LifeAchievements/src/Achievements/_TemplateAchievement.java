package Achievements;

import Personalisation.Person;
import Utility.RequirementsNotMetException;

public class _TemplateAchievement extends Achievement {

	// you may adjust this level arbitrarily
	// it should indicate how many different stages have been successful
	// e.g. walk 1 step, 2 steps, 5 steps, 10, 20, 50, 100, 200, 500, 1000,
	// 2000, 5000, 10k, 20k, ...
	private static int level = 0;

	// also achievement specific additional stats may be added
	@SuppressWarnings("unused")
	private double highestRatingAllTimes = 0;

	public _TemplateAchievement(Person person) throws RequirementsNotMetException {
		// here name and level is set
		// any previous achievements will be used to verify the validity
		super("NAME_OF_THIS_ACHIEVEMENT", level, person);

		// this requirement sets the minimum
		// multiple requirements may be added
		this.addRequirement("NAME_OF_REQUIREMENT");

		// this null achievement enables TEMPLATE-ACHIEVEMENT to be activated
		// immediately
		// if there is no requirement before
		this.addAchievement(null);
	}

}
