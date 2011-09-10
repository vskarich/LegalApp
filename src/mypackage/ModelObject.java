package mypackage;

import java.util.Hashtable;

//Follows the Singleton pattern

public class ModelObject {
	private Hashtable  stateMachine;
	private String     currentState;
	private static ModelObject uniqueInstance;
	
	public static synchronized ModelObject getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ModelObject();
		}
		return uniqueInstance;
	}

	private ModelObject() {
		this.stateMachine = new Hashtable();
		this.currentState = Config.getInstance().INITIAL_STATE;
		
	}
	
	private String getFutureState(String action){
		  return ((String)stateMachine.get(this.currentState + action));
	}
	
	public void changeState(String action) {
		String futureState      = getFutureState(action);
		this.currentState       = futureState;
		ViewObject.getInstance().updateUsingState(this.currentState);
	}
	
	
	public void addStateTransition(String currentState, String action, String nextState){
		stateMachine.put(currentState + action, nextState);
	}
}













