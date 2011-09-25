package mypackage;

import java.io.IOException;
import java.util.Vector;

import net.rim.device.api.collection.util.BigVector;
import net.rim.device.api.system.Characters;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.ListField;
import net.rim.device.api.ui.component.ListFieldCallback;
import net.rim.device.api.ui.container.VerticalFieldManager;

public class ListRecordsScreen extends BaseScreen {




		
		public  String        currentScreenName = "ListRecordsScreen";
	    private ButtonField   homeButton        = null;
	    private ScreenChangeUIRefresher screenChanger     = null;
	    private ListField _listField = null;
	    private Vector _listElements;
	    private VerticalFieldManager currentRecordScreenManager = null;
	    private BigVector recordslist = null;
		public ListRecordsScreen() {
			this.setTitle("ListRecords Screen");
           
			ModelObject.getInstance().addStateTransition(currentScreenName, Config.getInstance().BACK_ACTION, "HomeScreen");
            
	        ModelObject.getInstance().addStateTransition(currentScreenName, Config.getInstance().VIEW_RECORD_ACTION, "RecordScreen");
	        
	        
	        _listElements = new Vector(); 
	        _listField = new ListField();
	        ListCallback _callback = new ListCallback();
	        _listField.setCallback(_callback);
	        add(_listField);
	        initializeList();
	        
	        
	        
	        
		
	   }
		private void initializeList() 
		{
			try {
				recordslist = Storage.getInstance().getRecordsList();
				_listElements.removeAllElements();
			
			for (int x = 0; x < recordslist.size(); x++) {
					Record record = (Record) recordslist.elementAt(x);
					 _listElements.addElement(record.getLastName() + ", " + record.getFirstName());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    reloadList();
		}
		private void reloadList()
		{
		    _listField.setSize(_listElements.size());
		}
		
		
		
	   public VerticalFieldManager initializeVerticalFieldManager(Record record) {
		   VerticalFieldManager manager = new VerticalFieldManager();
		   manager.add(new LabelField("First Name: " + record.getFirstName()));
		   manager.add(new LabelField("Last Name: " + record.getLastName()));
		   manager.add(new LabelField("Case #: " + record.getCaseNumber()));
		   manager.add(new LabelField("Time Credit: " + record.getCredit()));
		   return manager;
	   }
	   
		
	   public void updateUIOnScreenChange(Manager manager){//called when entering this screen 
		   this.initializeList();
	   }
	   protected boolean navigationClick(int status, int time)
	   {
		   int selectedindex = _listField.getSelectedIndex();
		   if(selectedindex != -1) {
			   Record record = (Record)recordslist.elementAt(selectedindex);
	   
			   this.currentRecordScreenManager = initializeVerticalFieldManager(record);
			   ModelObject.getInstance().changeState("VIEW_INDIVDUAL_RECORD"); 
			   return true;
	   
		   }
		   return false;
	   }
	   
	   public Manager createNextScreenManager(){ //called when navigating to specific record screen
		    return this.currentRecordScreenManager;
	   }
	 
		
		
		private class ListCallback implements ListFieldCallback 
		{
		    public void drawListRow(ListField list, Graphics g, int index, int y, int w) 
		    { 
		        String text = (String)_listElements.elementAt(index); 
		        g.drawText(text, 0, y, 0, w); 
		    } 
		    public Object get(ListField list, int index) 
		    {
		        return _listElements.elementAt(index); 
		    } 
		    public int indexOfList(ListField list, String prefix, int string) 
		    { 
		        return _listElements.indexOf(prefix, string); 
		    } 
		    public int getPreferredWidth(ListField list) 
		    { 
		        return Display.getWidth(); 
		    } 
		}

	
}

	

