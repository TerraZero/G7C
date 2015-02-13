package TZ.G7.Component;

import TZ.G7.GObj;
import TZ.G7.Component.Data.DefaultCompData;
import TZ.G7.Component.Mechnic.GComp;
import TZ.G7.Component.Render.DefaultCompRender;
import TZ.G7.Component.Updater.DefaultCompUpdater;
import TZ.Mechnic.Mechnic;

/**
 * 
 * @author terrazero
 * @created Feb 13, 2015
 * 
 * @file DefaultComponent.java
 * @project G7C
 * @identifier TZ.G7.Component
 *
 */
public class DefaultComponent extends GObj implements GComp<DefaultCompData, DefaultCompUpdater, DefaultCompRender> {
	
	protected DefaultCompData data;
	protected DefaultCompRender render;
	protected DefaultCompUpdater updater;
	
	/* 
	 * @see TZ.G7.GObj#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.data = Mechnic.get("gcompdata");
		this.render = Mechnic.get("gcomprender");
		this.updater = Mechnic.get("gcompupdater");
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#data()
	 */
	@Override
	public DefaultCompData data() {
		return this.data;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#updater()
	 */
	@Override
	public DefaultCompUpdater updater() {
		return this.updater;
	}

	/* 
	 * @see TZ.G7.Component.I.GComp#render()
	 */
	@Override
	public DefaultCompRender render() {
		return this.render;
	}

}
