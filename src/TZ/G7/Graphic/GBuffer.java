package TZ.G7.Graphic;

import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

/**
 * 
 * @author Terra
 * @created 14.01.2015
 * 
 * @file GBuffer.java
 * @project G7C
 * @identifier TZ.G7.Data
 *
 */
public class GBuffer {

	/**
	 * Create buffer from graphic card
	 * @param width
	 *   buffer width
	 * @param height
	 *   buffer height
	 * @return
	 */
	public static BufferedImage getBuffer(int width, int height) {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleImage(height, width, Transparency.OPAQUE);
	}
	
}
