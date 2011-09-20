package mypackage;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.container.MainScreen;

public class ListRecordsScreen extends BaseScreen {




		
		public  String      currentScreenName      = "ListRecordsScreen";
	    private ButtonField homeButton             = null;    
	    
	    
	    
	    
		
		public ListRecordsScreen() {
			this.setTitle("ListRecords Screen");
			
			
			homeButton =  new ButtonField("Home");
	        ModelObject.getInstance().addStateTransition(currentScreenName, homeButton.getLabel(), "HomeScreen"); //update the state machine with correct screen transition 
	        homeButton.setChangeListener(new FieldChangeListener() {
	        public void fieldChanged(Field field,int context) {
	        	ModelObject.getInstance().changeState(homeButton.getLabel());
	            }
	        });
	        this.add(homeButton);
	       
		
	}

	
}

	
