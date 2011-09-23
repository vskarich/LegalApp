package mypackage;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;

public class RecordScreen extends BaseScreen {




		
		public  String      currentScreenName      = "RecordScreen";
	    private ButtonField homeButton             = null;    
	    private VerticalFieldManager manager       = null;
	    
	    
	    
		
		public RecordScreen() {
			this.setTitle("Record Screen");
			
			homeButton =  new ButtonField("Home");
	        ModelObject.getInstance().addStateTransition(currentScreenName, homeButton.getLabel(), "HomeScreen"); //update the state machine with correct screen transition 
	        homeButton.setChangeListener(new FieldChangeListener() {
	        public void fieldChanged(Field field,int context) {
	        	ModelObject.getInstance().changeState(homeButton.getLabel());
	            }
	        });
	        this.add(homeButton);
	        
		
	    }
		
		public void updateUIOnScreenChange(Manager manager){
			    if(this.manager != null) {
			    	delete(this.manager);
			    }
				this.manager = (VerticalFieldManager) manager;
				add(this.manager);
			
		}

	
}

