package mypackage;

import java.io.IOException;

import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.container.MainScreen;

public class HomeScreen extends BaseScreen{

	

	public  String      currentScreenName      = "HomeScreen";
    private ButtonField helpButton             = null;    
    private ButtonField settingsButton         = null; 
    private ButtonField aboutButton            = null;   
    private ButtonField createNewRecordButton  = null;   
    private ButtonField searchButton           = null;
    private ButtonField quitButton             = null;
    private ButtonField listRecordsButton      = null;
    
    
    
	
	public HomeScreen() {
		this.setTitle("Welcome to the Credit Calculator!");
		
		listRecordsButton =  new ButtonField("List Records", ButtonField.CONSUME_CLICK);
        ModelObject.getInstance().addStateTransition(currentScreenName, listRecordsButton.getLabel(), "ListRecordsScreen"); //update the state machine with correct screen transition 
        listRecordsButton.setChangeListener(new FieldChangeListener() {
        public void fieldChanged(Field field,int context) {
        	ModelObject.getInstance().changeState(listRecordsButton.getLabel());
            }
        });
        this.add(listRecordsButton);
		
		
	    helpButton =  new ButtonField("Help", ButtonField.CONSUME_CLICK);
        ModelObject.getInstance().addStateTransition(currentScreenName, helpButton.getLabel(), "HelpScreen"); //update the state machine with correct screen transition 
        helpButton.setChangeListener(new FieldChangeListener() {
        public void fieldChanged(Field field,int context) {
        	ModelObject.getInstance().changeState(helpButton.getLabel());
            }
        });
        this.add(helpButton);
        
        settingsButton =  new ButtonField("Settings", ButtonField.CONSUME_CLICK);
        ModelObject.getInstance().addStateTransition(currentScreenName, settingsButton.getLabel(), "SettingsScreen"); //update the state machine with correct screen transition 
        settingsButton.setChangeListener(new FieldChangeListener() {
        public void fieldChanged(Field field,int context) {
        	ModelObject.getInstance().changeState(settingsButton.getLabel());
            }
        });
        this.add(settingsButton);
        
        aboutButton =  new ButtonField("About", ButtonField.CONSUME_CLICK);
        ModelObject.getInstance().addStateTransition(currentScreenName, aboutButton.getLabel(), "AboutScreen"); //update the state machine with correct screen transition 
        aboutButton.setChangeListener(new FieldChangeListener() {
        public void fieldChanged(Field field,int context) {
        	ModelObject.getInstance().changeState(aboutButton.getLabel());
            }
        });
        this.add(aboutButton);
        
        createNewRecordButton =  new ButtonField("New Record", ButtonField.CONSUME_CLICK);
        ModelObject.getInstance().addStateTransition(currentScreenName, createNewRecordButton.getLabel(), "RecordInputScreen"); //update the state machine with correct screen transition 
        createNewRecordButton.setChangeListener(new FieldChangeListener() {
        public void fieldChanged(Field field,int context) {
        	ModelObject.getInstance().changeState(createNewRecordButton.getLabel());
            }
        });
        this.add(createNewRecordButton);
        
        searchButton =  new ButtonField("Search Records", ButtonField.CONSUME_CLICK);
        ModelObject.getInstance().addStateTransition(currentScreenName, searchButton.getLabel(), "SearchScreen"); //update the state machine with correct screen transition 
        searchButton.setChangeListener(new FieldChangeListener() {
        public void fieldChanged(Field field,int context) {
        	ModelObject.getInstance().changeState(searchButton.getLabel());
            }
        });
        this.add(searchButton);
        
        quitButton =  new ButtonField("Quit", ButtonField.CONSUME_CLICK);
        //Since there is no screen to go to, we do not add anything to the state machine. This will quit the app according to the current implementation of the state machine.
        quitButton.setChangeListener(new FieldChangeListener() {
        public void fieldChanged(Field field,int context) {
        	 System.exit(0);
            }
        });
        this.add(quitButton);
    
    
    
    
   

}
	
	public boolean keyChar(char key, int status, int time) {
        //intercept the ESC key - exit the app on its receipt
        boolean retval = false;
        if (key == Characters.ESCAPE) {
        	close();
            return true;
        }
        return super.keyChar(key, status, time); //notice how event propagates here
    }
	
}
