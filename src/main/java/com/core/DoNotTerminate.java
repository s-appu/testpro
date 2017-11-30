import java.security.Permission;

public class DoNotTerminate {
	public static class CannotExitException extends SecurityException {
		private static final long serialVersionUID = 1379509680859956142L;
	}

	public static void forbidExit() {
		final SecurityManager securityManager = new SecurityManager() {

			@Override
			public void checkPermission(final Permission permission) {
				if (permission.getName().contains("exitVM")) {
					throw new CannotExitException();
				}
			}
		};
		System.setSecurityManager(securityManager);
	}
}
