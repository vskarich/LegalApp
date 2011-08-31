package mypackage;



import net.rim.device.api.database.Database;
import net.rim.device.api.database.DatabaseFactory;
import net.rim.device.api.database.DatabaseSecurityOptions;
import net.rim.device.api.database.Row;
import net.rim.device.api.database.Statement;
import net.rim.device.api.io.URI;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.RichTextField;

/**
 * This class extends the UiApplication class, providing a
 * graphical user interface.
 */
public class MyApp extends UiApplication
{
    /**
     * Entry point for application
     * @param args Command line arguments (not used)
     */ 
    public static void main(String[] args)
    {
        // Create a new instance of the application and make the currently
        // running thread the application's event dispatch thread.
        MyApp theApp = new MyApp();   
        
        theApp.enterEventDispatcher();
        
    }
    

    /**
     * Creates a new MyApp object
     */
    public MyApp()
    {        
        // Push a screen onto the UI stack for rendering.
    	WelcomeScreen welcomeScreen  = new WelcomeScreen();
    	pushScreen(welcomeScreen);    
    	
    }    
 

}
