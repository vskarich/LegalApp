package mypackage;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

import net.rim.device.api.system.PersistentObject;
import net.rim.device.api.system.PersistentStore;
import net.rim.device.api.util.Comparator;
import net.rim.device.api.util.Persistable;
import net.rim.device.api.collection.util.BigVector;

public class Storage {
    
	private static Storage uniqueInstance;
	private PersistentObject persistentObject;
	private BigVector recordsList;
	
	
	public static synchronized Storage getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Storage();
		}
		return uniqueInstance;
	}
	
	private Storage() {
		persistentObject = PersistentStore.getPersistentObject(Config.getInstance().STORAGE_KEY);
		if(persistentObject.getContents() == null) {
			recordsList = new BigVector();
			
			
			persistentObject.setContents(recordsList);
		} else {
			recordsList = (BigVector)persistentObject.getContents();
		}
	}
	
	public void save(Record record) throws IOException {
		recordsList.insertElement(new LastNameComparator(), record);
		this.commit();
		
	}
	
	public BigVector getRecordsList() throws IOException {
		return recordsList;
	}
	
	
	
	public void commit() {
		persistentObject.commit();
	}
	
	private class LastNameComparator implements Comparator {
		public int compare(Object o1, Object o2) {
		    Record r1 = (Record) o1;
		    Record r2 = (Record) o2;
		    return r1.getLastName().toLowerCase().compareTo(r2.getLastName().toLowerCase());
		    
		  }
	}
	
	private class FirstNameComparator implements Comparator {
		public int compare(Object o1, Object o2) {
		    Record r1 = (Record) o1;
		    Record r2 = (Record) o2;
		    return r1.getFirstName().toLowerCase().compareTo(r2.getFirstName().toLowerCase());
		    
		  }
	}
	
	private class TimeChangedComparator implements Comparator {
		public int compare(Object o1, Object o2) {
		    Record r1 = (Record) o1;
		    Record r2 = (Record) o2;
		    if(r1.getLastTimeChanged() == r2.getLastTimeChanged()) {
		    	return 0; 
		    } else {
		    	return r1.getLastTimeChanged() < r2.getLastTimeChanged() ? -1 : 1;
		    }
		    
		  }
	}
	
}
