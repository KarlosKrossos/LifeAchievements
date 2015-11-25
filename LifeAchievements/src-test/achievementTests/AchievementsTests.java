package achievementTests;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import personalisation.Person;
import achievements.*;
import rewards.*;
import utility.Permission;
import utility.RequirementsNotMetException;

@SuppressWarnings("deprecation")
public class AchievementsTests {

	Person person;

	@Before
	public void setUp() throws Exception {
		person = new Person("Hermi", "Möbm", 21, false, Permission.ADMIN);
	}

	@Test
	public void testBabble() throws RequirementsNotMetException {
		// TODO implement Babble achievement
		// person.addAchievement(new Babble(person));
		// Assert.assertTrue(person.getAchievementsAsString().contains("Babble"));
	}

	@Test
	public void testBalance() throws RequirementsNotMetException {
		person.addAchievement(new Rob(person));
		person.addAchievement(new Crawl(person));
		person.addAchievement(new Stand(person));
		person.addAchievement(new Walk(person));
		person.addAchievement(new Balance(person));
		Assert.assertTrue(person.getAchievementsAsString().contains("Balance"));
	}

	@Test
	public void testBindShoeLaces() throws RequirementsNotMetException {
		person.addAchievement(new BindShoeLaces(person));
		Assert.assertTrue(person.getAchievementsAsString().contains("BindShoeLaces"));
	}

	@Test
	public void testCrawl() throws RequirementsNotMetException {
		person.addAchievement(new Rob(person));
		person.addAchievement(new Crawl(person));
		Assert.assertTrue(person.getAchievementsAsString().contains("Crawl"));
	}

	@Test
	public void testGiggle() throws RequirementsNotMetException {
		person.addAchievement(new Giggle(person));
		Assert.assertTrue(person.getAchievementsAsString().contains("Giggle"));
	}

	@Test
	public void testGrow() throws RequirementsNotMetException {
		person.addAchievement(new Grow(person));
		Assert.assertTrue(person.getAchievementsAsString().contains("Grow"));
	}

	@Test
	public void testLaugh() throws RequirementsNotMetException {
		person.addAchievement(new Giggle(person));
		person.addAchievement(new Laugh(person));
		Assert.assertTrue(person.getAchievementsAsString().contains("Laugh"));
	}

	@Test
	public void testLookAtBook() throws RequirementsNotMetException {
		// TODO implement LookAtBook achievement
		// person.addAchievement(new LookAtBook(person));
		// Assert.assertTrue(person.getAchievementsAsString().contains("LookAtBook"));
	}

	@Test
	public void testRead() throws RequirementsNotMetException {
		// TODO implement LookAtBook achievement
		// person.addAchievement(new LookAtBook(person));
		// person.addAchievement(new Read(person));
		// Assert.assertTrue(person.getAchievementsAsString().contains("Read"));
	}

	@Test
	public void testRob() throws RequirementsNotMetException {
		person.addAchievement(new Rob(person));
		Assert.assertTrue(person.getAchievementsAsString().contains("Rob"));
	}

	@Test
	public void testRun() throws RequirementsNotMetException {
		person.addAchievement(new Rob(person));
		person.addAchievement(new Crawl(person));
		person.addAchievement(new Stand(person));
		person.addAchievement(new Walk(person));
		person.addAchievement(new Run(person));
		Assert.assertTrue(person.getAchievementsAsString().contains("Run"));
	}

	@Test
	public void testSpeak() throws RequirementsNotMetException {
		// TODO implement Babble achievement
		// person.addAchievement(new Babble(person));
		// person.addAchievement(new Speak(person));
		// Assert.assertTrue(person.getAchievementsAsString().contains("Speak"));
	}

	@Test
	public void testSprint() throws RequirementsNotMetException {
		person.addAchievement(new Rob(person));
		person.addAchievement(new Crawl(person));
		person.addAchievement(new Stand(person));
		person.addAchievement(new Walk(person));
		person.addAchievement(new Run(person));
		person.addAchievement(new Sprint(person));
		person.addAchievement(new Stand(person));
		Assert.assertTrue(person.getAchievementsAsString().contains("Sprint"));
	}

	@Test
	public void testStand() throws RequirementsNotMetException {
		person.addAchievement(new Rob(person));
		person.addAchievement(new Crawl(person));
		person.addAchievement(new Stand(person));
		Assert.assertTrue(person.getAchievementsAsString().contains("Stand"));
	}

	@Test
	public void testUseValcrowShoes() throws RequirementsNotMetException {
		person.addAchievement(new BindShoeLaces(person));
		person.addAchievement(new UseValcrowShoes(person));
		Assert.assertTrue(person.getAchievementsAsString().contains("UseValcrowShoes"));
	}

	@Test
	public void testWalk() throws RequirementsNotMetException {
		person.addAchievement(new Rob(person));
		person.addAchievement(new Crawl(person));
		person.addAchievement(new Stand(person));
		person.addAchievement(new Walk(person));
		Assert.assertTrue(person.getAchievementsAsString().contains("Walk"));
	}
}
