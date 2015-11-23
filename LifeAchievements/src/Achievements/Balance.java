package Achievements;

import Personalisation.Person;

public class Balance extends Achievement {

	private static int level = 4;

	public Balance(Person person) {
		super("Balance", level, person);
		// this null achievement enables Crawl to be activated immediately
		this.addRequirement("Walk");
	}

}
