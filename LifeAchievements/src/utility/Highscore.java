package utility;

import java.util.Hashtable;

import personalisation.Person;

public class Highscore {

	private static Hashtable<Person, Integer> highscore = new Hashtable<Person, Integer>();

	public static void updateHighscores() {
		if (Permission.getPermission("Highscore.updateHighscores")) {
			
		}
	}

	public static void printHighscores(Person person) {
		if (Permission.getPermission("Highscore.printHighscores")) {
			
		}
	}

	public static void addPersonToHighscore(Person person) {
		if (Permission.getPermission("Highscore.addPerson")) {
			highscore.put(person, person.getScore());
		}
	}

}
