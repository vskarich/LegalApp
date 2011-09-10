package mypackage;

public class Config {
	
	public final String INITIAL_SCREEN = "HomeScreen";
	public final String INITIAL_STATE = "BOOTUP";
	public final String START_ACTION = "START";
	private static Config uniqueInstance;
	private Config() {
		
		
	}

	public static synchronized Config getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Config();
		}
		return uniqueInstance;
	}

}