package TZ.G7.Component.Updater;

import TZ.Mechnic.MechnicCreator;

/**
 * 
 * @author terrazero
 * @created Feb 13, 2015
 * 
 * @file DefaultCompUpdaterMechnic.java
 * @project G7C
 * @identifier TZ.G7.Component.Updater
 *
 */
public class DefaultCompUpdaterMechnic implements MechnicCreator<DefaultCompUpdater> {

	private DefaultCompUpdater updater;
	
	public DefaultCompUpdaterMechnic() {
		this.updater = new DefaultCompUpdater();
	}
	
	/* 
	 * @see TZ.Mechnic.MechnicCreator#mechnicName()
	 */
	@Override
	public String mechnicName() {
		return "gcompupdater";
	}

	/* 
	 * @see TZ.Mechnic.MechnicCreator#mechnic(java.lang.Object[])
	 */
	@Override
	public DefaultCompUpdater mechnic(Object... args) {
		return this.updater;
	}
	
}
