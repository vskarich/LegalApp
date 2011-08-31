package mypackage;

import net.rim.device.api.database.Database;
import net.rim.device.api.database.DatabaseFactory;
import net.rim.device.api.database.DatabaseSecurityOptions;
import net.rim.device.api.database.Row;
import net.rim.device.api.database.Statement;
import net.rim.device.api.io.URI;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.MainScreen;

public class WelcomeScreen extends MainScreen implements FieldChangeListener{

    private ButtonField changeScreenButton  = null;                    //define the buttons
	
	public WelcomeScreen() {
	
		this.setTitle("Welcome to the Credit Calculator!");
		changeScreenButton =  new ButtonField("Start"); 
		

	changeScreenButton.setChangeListener(this);  
    this.add(changeScreenButton);
    this.createDatabase();
    
    	
    }
	
	public void createDatabase() {
    	try
    	{  add(new RichTextField("HELLO69"));
    	   URI myURI = URI.create("file:///SDCard/BlackBerry/databases/" +
    	   "LegalRecordsDatabase.db");
    	   add(new RichTextField("HELLO70"));
    	   DatabaseSecurityOptions dbso = new DatabaseSecurityOptions(true);
    	   add(new RichTextField("HELLO71"));
    	   Database d = DatabaseFactory.openOrCreate(myURI,dbso);
    	   add(new RichTextField("HELLO72"));
    	   //Statement st1 = d.createStatement( "CREATE TABLE 'People' ( " +
             //      "'Name' TEXT, " +
               //    "'Age' INTEGER )" );

    	   //st1.prepare();
    	   //st1.execute();
    	   //st1.close();
    	   add(new RichTextField("HELLO1"));
    	   Statement st2 = d.createStatement("INSERT INTO People(Name,Age) " +
           "VALUES ('John',37)");
    	   st2.prepare();
    	   st2.execute();
    	   st2.close();
    	   
    	   Statement st3 = d.createStatement("SELECT Name,Age FROM People");
    	   add(new RichTextField("HELLO2"));
           st3.prepare();
           net.rim.device.api.database.Cursor c = st3.getCursor();
           add(new RichTextField("HELLO3"));
           Row r;
           int i = 0;
           while(c.next()) 
           {   add(new RichTextField("HELLO4"));
               r = c.getRow();
               i++;
               add(new RichTextField(i + ". Name = " + r.getString(0) +
                                         " , " +
                                         "Age = " + r.getInteger(1)));
           }
           if (i==0)
           {   add(new RichTextField("HELLO5"));
               add(new RichTextField("No data in the People table."));
           }
           st3.close();


    	   d.close();

          
        }
        catch ( Exception e )
        {
           System.out.println( e.getMessage() );
           add(new RichTextField(e.getMessage()));
           e.printStackTrace();
        }
     }

	public void fieldChanged(Field button, int context) //respond to button events
    {
        if (button == changeScreenButton) //if first button selected
        {   
        	UiApplication.getUiApplication().invokeLater(new Runnable(){
       	     public void run() {
       	         UiApplication.getUiApplication().pushScreen(new RecordInputScreen());
       	     }
       	});
        }
        
    }
	
	

}

