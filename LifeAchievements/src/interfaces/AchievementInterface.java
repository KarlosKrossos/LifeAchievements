package interfaces;

import java.util.List;

import Achievements.Achievement;
import Utility.RequirementsNotMetException;

public interface AchievementInterface {

	public void addAchievement(Achievement achievement) throws RequirementsNotMetException;

	public List<String> getAchievements();

	public void removeAchievement(String achievement);

	public void addRequirement(String requirement);

	public void removeRequirement(String requirement);

	public boolean isActivated();

	public void setActivated() throws RequirementsNotMetException;

	public String getName();

	public List<String> getRequirements();

	public double getDifficulty();
}
