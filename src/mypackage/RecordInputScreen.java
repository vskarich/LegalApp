package mypackage;

import java.io.IOException;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.*;

public class RecordInputScreen extends BaseScreen {

	private BasicEditField caseNumber = null;                   //define the edit fields
    private BasicEditField firstName = null;
    private BasicEditField lastName = null;                   //define the edit fields
    private BasicEditField date1 = null;
    private BasicEditField date2 = null;                   //define the edit fields
    
    private ButtonField submitButton  = null;    
    private ButtonField homeButton  = null;   
    
	
	public RecordInputScreen() {
		this.setTitle("Input Screen");
		
		
	
		date1        =  new BasicEditField("Time Served 1: ", "", 10, BasicEditField.FILTER_NUMERIC);
		date2        =  new BasicEditField("Time Served 2: ", "", 10, BasicEditField.FILTER_NUMERIC);
		caseNumber   =  new BasicEditField("Case Number: ", "", 10, BasicEditField.FILTER_NUMERIC);
		firstName    =  new BasicEditField("First Name: ", "", 10, BasicEditField.FILTER_DEFAULT);
		lastName     =  new BasicEditField("Last Name: ", "", 10, BasicEditField.FILTER_DEFAULT);
		
		
    submitButton =  new ButtonField("Submit"); 
    homeButton   =  new ButtonField("Home");
    ModelObject.getInstance().addStateTransition("RecordInputScreen", homeButton.getLabel(), "HomeScreen"); //update the state machine with correct screen transition 
    
    

    submitButton.setChangeListener(new FieldChangeListener() {
        public void fieldChanged(Field field,int context) {
        	Record r = new Record(Integer.parseInt(caseNumber.getText()), (Integer.parseInt(date1.getText()) + Integer.parseInt(date2.getText())), firstName.getText(), lastName.getText());
        	try {
				Storage.getInstance().save(r);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	Dialog.alert("Record has been saved."); //show text from first input field
            }
     });
    this.add(submitButton);
    
    homeButton.setChangeListener(new FieldChangeListener() {
        public void fieldChanged(Field field,int context) {
            ModelObject.getInstance().changeState(homeButton.getLabel());
        }
       });
    this.add(homeButton);
    
    this.add(caseNumber);
    this.add(firstName);
    this.add(lastName);
    this.add(date1);
    this.add(date2);
   
  
    
    	
    }

	


	
}

