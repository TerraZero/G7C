package TZ.G7.Component.Render;

import TZ.Mechnic.MechnicCreator;

/**
 * 
 * @author terrazero
 * @created Feb 13, 2015
 * 
 * @file DefaultCompRenderMechnic.java
 * @project G7C
 * @identifier TZ.G7.Component.Render
 *
 */
public class DefaultCompRenderMechnic implements MechnicCreator<DefaultCompRender> {
	
	private DefaultCompRender render;
	
	public DefaultCompRenderMechnic() {
		this.render = new DefaultCompRender();
	}

	/* 
	 * @see TZ.Mechnic.MechnicCreator#mechnicName()
	 */
	@Override
	public String mechnicName() {
		return "gcomprender";
	}

	/* 
	 * @see TZ.Mechnic.MechnicCreator#mechnic(java.lang.Object[])
	 */
	@Override
	public DefaultCompRender mechnic(Object... args) {
		return this.render;
	}

}
