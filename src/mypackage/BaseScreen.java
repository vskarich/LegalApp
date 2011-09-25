package mypackage;

import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;

public abstract class BaseScreen extends MainScreen{
	public BaseScreen(){
		
	}
	
	public void updateUIOnScreenChange(Manager manager) {
		
	}
	
	public Manager createNextScreenManager() {
		return new VerticalFieldManager();
	}
	
	public boolean keyChar(char key, int status, int time) {
        //intercept the ESC key - exit the app on its receipt
        boolean retval = false;
        if (key == Characters.ESCAPE) {
        	ModelObject.getInstance().changeState(Config.getInstance().BACK_ACTION);
            return true;
        }
        return super.keyChar(key, status, time); //notice how event propagates here
    }
	
	public void close(){
		Storage.getInstance().commit();
		super.close();
	}
	

}
