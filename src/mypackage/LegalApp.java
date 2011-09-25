package mypackage;



import java.util.Hashtable;


import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.VerticalFieldManager;

/**
 * This class extends the UiApplication class, providing a
 * graphical user interface.
 */
public class LegalApp extends UiApplication
{
    /**
     * Entry point for application
     * @param args Command line arguments (not used)
     */ 
	
	
	
    
	public static void main(String[] args)
    {
        // Create a new instance of the application and make the currently
        // running thread the application's event dispatch thread.
    	LegalApp theApp = new LegalApp();   
        theApp.enterEventDispatcher();
        
    }
    

    /**
     * Creates a new MyApp object
     */
    public LegalApp()
    {   //instantiate the singleton configuration, model and view objects
    	
    	ModelObject model = ModelObject.getInstance();
    	ViewObject view   = ViewObject.getInstance();
    	Config config     = Config.getInstance();
    	model.addStateTransition(config.INITIAL_STATE, config.START_ACTION, config.INITIAL_SCREEN);
    	model.changeState(config.START_ACTION);
    	
    }    
}
