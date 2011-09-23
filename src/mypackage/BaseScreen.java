package mypackage;

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
	public void close(){
		Storage.getInstance().commit();
		super.close();
	}
	

}
