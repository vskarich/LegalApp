package mypackage;

import net.rim.device.api.ui.container.MainScreen;

public class BaseScreen extends MainScreen{
	public BaseScreen(){
		
	}
	public void close(){
		Storage.getInstance().commit();
		super.close();
	}

}
