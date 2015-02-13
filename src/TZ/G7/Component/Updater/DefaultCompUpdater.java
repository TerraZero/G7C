package TZ.G7.Component.Updater;

import TZ.G7.Component.Data.DefaultCompData;
import TZ.G7.Component.I.GCompUpdater;

/**
 * 
 * @author terrazero
 * @created Feb 13, 2015
 * 
 * @file DefaultCompUpdater.java
 * @project G7C
 * @identifier TZ.G7.Component.Updater
 *
 */
public class DefaultCompUpdater implements GCompUpdater<DefaultCompData> {

	/* 
	 * @see TZ.G7.Component.I.GCompUpdater#update(TZ.G7.Component.I.GCompData, float)
	 */
	@Override
	public void update(DefaultCompData data, float delta) {
		data.setSize(data.dwidth(), data.dheight());
		data.setLocation(data.dx(), data.dy());
		data.background(data.dbackground());
	}

}
