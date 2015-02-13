package TZ.Mechnic.Mechnics;

import TZ.G7.Component.Data.DefaultCompDataMechnic;
import TZ.G7.Component.Render.DefaultCompRenderMechnic;
import TZ.G7.Component.Updater.DefaultCompUpdaterMechnic;
import TZ.Mechnic.Mechnic;

/**
 * 
 * @author terrazero
 * @created Feb 13, 2015
 * 
 * @file DefaultMechnics.java
 * @project G7C
 * @identifier TZ.Mechnic
 *
 */
public class DefaultMechnics {

	public static void init() {
		Mechnic.register(new GArrayList());
		
		// comp
		Mechnic.register(new DefaultCompDataMechnic());
		Mechnic.register(new DefaultCompRenderMechnic());
		Mechnic.register(new DefaultCompUpdaterMechnic());
	}
	
}
