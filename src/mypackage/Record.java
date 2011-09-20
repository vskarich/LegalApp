package mypackage;

import net.rim.device.api.util.Persistable;

public class Record implements Persistable{

	public int caseNumber;
	public String firstName;
	public String lastName;
	public int credit;
	
	public Record(int caseNumber, int credit, String firstName, String lastName){
		this.caseNumber = caseNumber;
		this.firstName  = firstName;
		this.lastName   = lastName;
		this.credit     = credit; 
	}
}
