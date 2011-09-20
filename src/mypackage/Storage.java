package mypackage;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

import net.rim.device.api.system.PersistentObject;
import net.rim.device.api.system.PersistentStore;

public class Storage {
    
	private static Storage uniqueInstance;
	PersistentObject persistentObject;
	Hashtable persistentHashtable; 
	
	
	public static synchronized Storage getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Storage();
		}
		return uniqueInstance;
	}
	
	private Storage() {
		persistentObject = PersistentStore.getPersistentObject(Config.getInstance().STORAGE_KEY);
		if(persistentObject.getContents() == null) {
			persistentHashtable = new Hashtable();
			persistentObject.setContents(persistentHashtable);
		} else {
			persistentHashtable = (Hashtable)persistentObject.getContents();
		}
	}
	
	public void save(Record record) throws IOException {
		persistentHashtable.put(new Integer(record.caseNumber), record);
		this.commit();
		
	}
	
	public void listRecords() throws IOException {
		Enumeration records =  persistentHashtable.keys();
	}
	
	public Record getSingleRecordByCasenumber(Integer caseNumber) throws IOException {
		return (Record)persistentHashtable.get(caseNumber);
	}
	
	public void commit() {
		persistentObject.commit();
	}
}
