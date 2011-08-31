package mypackage;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.*;

public class RecordInputScreen  extends MainScreen implements FieldChangeListener{

	private BasicEditField textField1 = null;                   //define the edit fields
    private BasicEditField textField2 = null;
    private ButtonField submitButton  = null;    
    private ButtonField changeScreenButton  = null;   
    private UiApplication ui = null;
	
	public RecordInputScreen() {
	
	textField1   =  new BasicEditField("Time Served 1: ", "", 10, BasicEditField.FILTER_NUMERIC);
    textField2   =  new BasicEditField("Time Served 2: ", "", 10, BasicEditField.FILTER_NUMERIC);
    submitButton =  new ButtonField("Submit"); 
    changeScreenButton =  new ButtonField("Back"); 
    
    

    submitButton.setChangeListener(this);  
    changeScreenButton.setChangeListener(this);  
    this.add(textField1);
    this.add(textField2);
    this.add(submitButton);
    this.add(changeScreenButton);
    this.ui = UiApplication.getUiApplication();
    
    	
    }

	public void fieldChanged(Field button, int context) //respond to button events
    {
        if (button == submitButton) //if first button selected
        {
            Dialog.alert((Integer.parseInt(textField1.getText()) + Integer.parseInt(textField2.getText())) + ""); //show text from first input field
        }
        
        if (button == changeScreenButton) //if first button selected
        {   
        	ui.invokeLater(new Runnable(){
       	     public void run() {
       	         ui.popScreen(ui.getActiveScreen());
       	     }
       	});
        
    }

}
}

