package mypackage;

import net.rim.device.api.system.Characters;
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
			ModelObject.getInstance().addStateTransition(currentScreenName, Config.getInstance().BACK_ACTION, "ListRecordsScreen");
			
	        
		
	    }
		public boolean keyChar(char key, int status, int time) {
	        //intercept the ESC key - exit the app on its receipt
	        boolean retval = false;
	        if (key == Characters.ESCAPE) {
	        	ModelObject.getInstance().changeState(Config.getInstance().BACK_ACTION);
	            return true;
	        }
	        return super.keyChar(key, status, time); //notice how event propagates here
	    }
		
		public void updateUIOnScreenChange(Manager manager){
			    if(this.manager != null) {
			    	delete(this.manager);
			    }
				this.manager = (VerticalFieldManager) manager;
				add(this.manager);
			
		}

	
}

