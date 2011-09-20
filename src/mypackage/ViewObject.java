package mypackage;

import java.util.Hashtable;

import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.container.VerticalFieldManager;

public class ViewObject
{
  
  private Screen            currentScreen;
  private Hashtable         screenRetriever;
  private HomeScreen     	homeScreen;
  private AboutScreen    	aboutScreen;
  private HelpScreen        helpScreen;
  private SettingsScreen    settingsScreen;
  private SearchScreen      searchScreen;
  private RecordScreen      recordScreen;
  private RecordInputScreen recordInputScreen;
  private ListRecordsScreen listRecordsScreen;
	 
  private static ViewObject uniqueInstance;
	 
  
  public static synchronized ViewObject getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ViewObject();
		}
		return uniqueInstance;
	}

	private ViewObject() {
		this.initializeScreenRetriever();
		
	}
  
  private void initializeScreenRetriever() {
  	  this.screenRetriever = new Hashtable();
  	  
    homeScreen        = new HomeScreen();
	aboutScreen       = new AboutScreen();
	helpScreen        = new HelpScreen();
	settingsScreen	  = new SettingsScreen();
	searchScreen      = new SearchScreen();
	recordScreen      = new RecordScreen();
	recordInputScreen = new RecordInputScreen();
	listRecordsScreen = new ListRecordsScreen();
  	  
  	  screenRetriever.put("HomeScreen", homeScreen);
  	  screenRetriever.put("AboutScreen", aboutScreen);
  	  screenRetriever.put("HelpScreen", helpScreen);
  	  screenRetriever.put("SettingsScreen", settingsScreen);
  	  screenRetriever.put("SearchScreen", searchScreen);
  	  screenRetriever.put("RecordInputScreen", recordInputScreen);
  	  screenRetriever.put("RecordScreen", recordScreen);
  	  screenRetriever.put("ListRecordsScreen", listRecordsScreen);
    }
  
 

  public void updateUsingState( String inState ) {
	
    Screen noLongerCurrent = currentScreen;
    currentScreen = (Screen)screenRetriever.get(inState);
    
    if(currentScreen == null) {
      System.exit(0);
      // we exit 
    }
    
    UiApplication.getUiApplication().pushScreen( currentScreen );
    // remove screen since not needed
    if (noLongerCurrent != null) { //for the first screen, there will not be a previous screen
    	UiApplication.getUiApplication().popScreen( noLongerCurrent );
    }
   }
  }
