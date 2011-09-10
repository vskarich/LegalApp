package mypackage;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.*;

public class RecordInputScreen extends MainScreen {

	private BasicEditField textField1 = null;                   //define the edit fields
    private BasicEditField textField2 = null;
    private ButtonField submitButton  = null;    
    private ButtonField homeButton  = null;   
    
	
	public RecordInputScreen() {
		this.setTitle("Input Screen");
		
		
	
	textField1   =  new BasicEditField("Time Served 1: ", "", 10, BasicEditField.FILTER_NUMERIC);
    textField2   =  new BasicEditField("Time Served 2: ", "", 10, BasicEditField.FILTER_NUMERIC);
    submitButton =  new ButtonField("Submit"); 
    homeButton   =  new ButtonField("Home");
    ModelObject.getInstance().addStateTransition("RecordInputScreen", homeButton.getLabel(), "HomeScreen"); //update the state machine with correct screen transition 
    
    

    submitButton.setChangeListener(new FieldChangeListener() {
        public void fieldChanged(Field field,int context) {
        	Dialog.alert((Integer.parseInt(textField1.getText()) + Integer.parseInt(textField2.getText())) + ""); //show text from first input field
            }
     });
    this.add(submitButton);
    
    homeButton.setChangeListener(new FieldChangeListener() {
        public void fieldChanged(Field field,int context) {
            ModelObject.getInstance().changeState(homeButton.getLabel());
        }
       });
    this.add(homeButton);
    
    this.add(textField1);
    this.add(textField2);
   
  
    
    	
    }

	


	
}

