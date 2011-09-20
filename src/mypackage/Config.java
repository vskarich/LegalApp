package mypackage;

public class Config {
	
	public final String INITIAL_SCREEN = "HomeScreen";
	public final String INITIAL_STATE = "BOOTUP";
	public final String START_ACTION = "START";
	public static final long STORAGE_KEY = 0x70a20c681ef357b0L;
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