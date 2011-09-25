package mypackage;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.container.MainScreen;

public class SettingsScreen extends BaseScreen {



		
		public  String      currentScreenName      = "SettingsScreen";
	    private ButtonField homeButton             = null;    
	    
	    
	    
	    
		
		public SettingsScreen() {
			this.setTitle("Settings Screen");
			
			
			ModelObject.getInstance().addStateTransition(currentScreenName, Config.getInstance().BACK_ACTION, "HomeScreen");
		
	}

	
}

	

