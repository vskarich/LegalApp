package mypackage;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.container.MainScreen;

public class AboutScreen extends BaseScreen {




		
		public  String      currentScreenName      = "AboutScreen";
	    private ButtonField homeButton             = null;    
	    
	    
	    
	    
		
		public AboutScreen() {
			this.setTitle("About Screen");
			ModelObject.getInstance().addStateTransition(currentScreenName, Config.getInstance().BACK_ACTION, "HomeScreen");
			
			
			
		
	}

	
}

	

