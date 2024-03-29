package mypackage;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.container.MainScreen;

public class HelpScreen extends BaseScreen {


		
		public  String      currentScreenName      = "HelpScreen";
	    private ButtonField homeButton             = null;    
	    
	    
	    
	    
		
		public HelpScreen() {
			this.setTitle("Help Screen");
			ModelObject.getInstance().addStateTransition(currentScreenName, Config.getInstance().BACK_ACTION, "HomeScreen");
			
			
			homeButton =  new ButtonField("Home", ButtonField.CONSUME_CLICK);
	        ModelObject.getInstance().addStateTransition(currentScreenName, homeButton.getLabel(), "HomeScreen"); //update the state machine with correct screen transition 
	        homeButton.setChangeListener(new FieldChangeListener() {
	        public void fieldChanged(Field field,int context) {
	        	ModelObject.getInstance().changeState(homeButton.getLabel());
	            }
	        });
	        this.add(homeButton);
		
	}

	
}
