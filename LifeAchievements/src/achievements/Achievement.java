package achievements;

import interfaces.AchievementInterface;
import personalisation.Person;
import utility.Permission;
import utility.RequirementsNotMetException;

import java.util.ArrayList;
import java.util.List;

public class Achievement implements AchievementInterface {

	@Override
	public String toString() {
		return "Achievement [activated=" + activated + ", name=" + name + "]";
	}

	private boolean activated = false;
	private String name = "";
	private List<String> requirements = new ArrayList<>();
	private List<String> achievements = new ArrayList<>();
	private double difficulty = 9999;
	private static int level;

	public Achievement(String name, double difficulty, Person person) {
		super();
		if (Permission.getPermission("Achievement.newAchievement")) {

			this.activated = false;
			this.name = name;

			this.requirements = new ArrayList<String>();
			if (person != null) {
				this.achievements = person.getAchievementsAsString();
			}
			this.difficulty = difficulty;
		}
	}

	public void addAchievement(Achievement achievement) throws RequirementsNotMetException {
		if (Permission.getPermission("Achievement.addAchievement")) {
			if (achievement == null) {
				System.out.println("Achievement is void of meaning.");
			} else {
				if (achievement.isActivated()) {
					this.achievements.add(achievement.getName());
					System.out.println("Achievement '" + achievement.getName() + "' added.");
				} else {
					System.out.println("Achievement not active. Cannot add '" + achievement.getName() + "'.");
				}
			}
			this.setActivated();
		}
	}

	public List<String> getAchievements() {
		if (Permission.getPermission("Achievement.getAchievements")) {
			return this.achievements;
		} else {
			return null;
		}
	}

	public void removeAchievement(String achievement) {
		if (Permission.getPermission("Achievement.removeAchievement")) {
			this.achievements.remove(achievement);
		}
	}

	public void addRequirement(String requirement) {
		if (Permission.getPermission("Achievement.addRequirement")) {
			this.requirements.add(requirement);
		}
	}

	public void removeRequirement(String requirement) {
		if (Permission.getPermission("Achievement.removeRequirement")) {
			this.requirements.remove(requirement);
		}
	}

	public boolean isActivated() {
		if (Permission.getPermission("Achievement.isActivated")) {
			return activated;
		} else {
			return false;
		}
	}

	public void setActivated() throws RequirementsNotMetException {
		if (Permission.getPermission("Achievement.setActivated")) {
			this.activated = true;

			for (int i = 0; i < this.requirements.size(); i++) {
				try {
					if (this.achievements != null) {
						if (!this.achievements.contains(this.requirements.get(i))) {
							System.out.println(
									"Activation failed: Requirement " + this.requirements.get(i) + " not met.");
							this.activated = false;
							throw new RequirementsNotMetException(this.requirements.get(i));
						}
					}
				} catch (RequirementsNotMetException e) {
					// System.out.println("Caught it");
				}
			}

			if (this.activated) {
				System.out.println("Activation of '" + this.getName() + "' succeeded.");
			}
		}
	}

	public String getName() {
		if (Permission.getPermission("Achievement.getName")) {
			return name;
		} else {
			return "";
		}
	}

	public void setName(String name) {
		if (Permission.getPermission("Achievement.setName")) {
			this.name = name;
		}
	}

	public List<String> getRequirements() {
		if (Permission.getPermission("Achievement.getRequirements")) {
			return requirements;
		}
		{
			return null;
		}
	}

	public void setRequirements(ArrayList<String> requirements) {
		if (Permission.getPermission("Achievement.setRequirements")) {
			this.requirements = requirements;
		}
	}

	public double getDifficulty() {
		if (Permission.getPermission("Achievement.getDifficulty")) {
			return difficulty;
		} else {
			return 0;
		}
	}

	public void setDifficulty(double difficulty) {
		if (Permission.getPermission("Achievement.setDifficulty")) {
			this.difficulty = difficulty;
		}
	}

	public static int getLevel() {
		if (Permission.getPermission("Achievement.getLevel")) {
			return level;
		} else {
			return 0;
		}
	}

	public static void setLevel(int level) {
		if (Permission.getPermission("Achievement.setLevel")) {
			Achievement.level = level;
		}
	}

}
