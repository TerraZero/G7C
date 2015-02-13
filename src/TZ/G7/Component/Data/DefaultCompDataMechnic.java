package TZ.G7.Component.Data;

import TZ.Mechnic.MechnicCreator;

/**
 * 
 * @author terrazero
 * @created Feb 13, 2015
 * 
 * @file DefaultCompDataMechnic.java
 * @project G7C
 * @identifier TZ.G7.Component.Data
 *
 */
public class DefaultCompDataMechnic implements MechnicCreator<DefaultCompData> {

	/* 
	 * @see TZ.Mechnic.MechnicClass#mechnicName()
	 */
	@Override
	public String mechnicName() {
		return "gcompdata";
	}

	/* 
	 * @see TZ.Mechnic.MechnicClass#mechnic(java.lang.Object[])
	 */
	@Override
	public DefaultCompData mechnic(Object... args) {
		return new DefaultCompData();
	}

}
