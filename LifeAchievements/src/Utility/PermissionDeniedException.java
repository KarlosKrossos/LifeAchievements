package Utility;

import System.ConsoleController;

public class PermissionDeniedException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9155956844905834063L;

	public PermissionDeniedException(Permission permission, String methodName) {
		if (permission == null) {
			System.out.println("[...] rights not sufficient to use " + methodName);
		} else if (permission == Permission.USER || ConsoleController.printRequests()) {
			System.out.println(permission + " rights not sufficient to use " + methodName);
		}
	}
}
