package TZ.G7.Component.Render;

import java.awt.Graphics;

import TZ.G7.Component.Data.DefaultCompData;
import TZ.G7.Component.I.GCompRender;

/**
 * 
 * @author terrazero
 * @created Feb 13, 2015
 * 
 * @file DefaultCompRender.java
 * @project G7C
 * @identifier TZ.G7.Component.Render
 *
 */
public class DefaultCompRender implements GCompRender<DefaultCompData> {

	/* 
	 * @see TZ.G7.Component.I.GCompRender#render(TZ.G7.Component.I.GCompData, java.awt.Graphics, int, int)
	 */
	@Override
	public void render(DefaultCompData data, Graphics g, int x, int y, int width, int height) {
		g.setColor(data.background());
		g.fillRect(x + data.x(), y + data.y(), data.width(), data.height());
	}

}
