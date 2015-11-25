package utility;

public class RequirementsNotMetException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2214802304429380620L;
	
	public RequirementsNotMetException(String requirement) {
		System.err.println("RequirementsNotMetException:" + requirement);
	}

}
