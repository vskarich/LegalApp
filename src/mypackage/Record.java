package mypackage;

import java.util.Date;

import net.rim.device.api.util.Persistable;

public class Record implements Persistable{

	private int caseNumber;
	private String firstName;
	private String lastName;
	private int credit;
	private long lastTimeChanged;
	
	public int getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(int caseNumber) {
		this.caseNumber      = caseNumber;
		this.lastTimeChanged = (new Date()).getTime();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		this.lastTimeChanged = (new Date()).getTime();
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		this.lastTimeChanged = (new Date()).getTime();
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
		this.lastTimeChanged = (new Date()).getTime();
	}

	public long getLastTimeChanged() {
		return lastTimeChanged;
	}

	public void setLastTimeChanged(long lastTimeChanged) {
		this.lastTimeChanged = lastTimeChanged;
	}
	
	public Record(int caseNumber, int credit, String firstName, String lastName){
		this.caseNumber      = caseNumber;
		this.firstName       = firstName;
		this.lastName        = lastName;
		this.credit          = credit; 
		this.lastTimeChanged = (new Date()).getTime();
	}
}
