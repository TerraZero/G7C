package TZ.G7;

import TZ.G7.Config.GConfig;
import TZ.G7.Exception.GException;
import TZ.G7.Game.GFrame;
import TZ.G7.Game.GLoop;

/**
 * 
 * @author TerraZero
 * @created 02.12.2014
 * 
 * @file MainG.java
 * @project V7S
 * @identifier TZ.G7.MainG
 *
 */
public class MainG {

	public static void main(String[] args) {
		// fatal
		/*
		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {

			@Override
			public void eventDispatched(AWTEvent e) {
				System.out.println(e);
			}
			
		}, AWTEvent.MOUSE_EVENT_MASK + AWTEvent.KEY_EVENT_MASK);
		//*/
		try {
			MainG.start();
		} catch (GException e) {
			System.out.println(e);
		}
	}
	
	public static void start() {
		GConfig.singleton().initSettings();
		GFrame.singleton().start();
		GLoop.singleton().start();
	}
	
}
