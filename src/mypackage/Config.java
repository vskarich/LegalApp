package mypackage;

public class Config {
	
	//this is the master class for adding all the mappings between actions and screens
	
	public final String INITIAL_SCREEN = "HomeScreen";
	public final String INITIAL_STATE = "BOOTUP";
	public final String START_ACTION = "START";
	public final String BACK_ACTION = "BACK";
	public final String VIEW_RECORD_ACTION = "VIEW_INDIVDUAL_RECORD";
	
	public final String HOME_SCREEN = "HomeScreen";
	
	
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