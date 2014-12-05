package TZ.G7.Component;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import TZ.G7.Component.I.GComp;

/**
 * 
 * @author Terra
 * @created 03.12.2014
 * 
 * @file GLayer.java
 * @project G7C
 * @identifier TZ.G7.Component
 *
 */
public class GLayer extends GComponent {
	
	protected boolean isbuffer;
	protected boolean refresh;
	protected BufferedImage buffer;
	
	/* 
	 * @see TZ.G7.Component.GComponent#size(int, int)
	 */
	@Override
	public GComp size(int width, int height) {
		if (width != this.width || height != this.height) this.actionResize(width, height);
		return super.size(width, height);
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		if (this.isbuffer) {
			if (this.refresh) {
				super.render(this.buffer.getGraphics());
				this.refresh = false;
			}
			g.drawImage(this.buffer, 0, 0, null);
		} else {
			super.render(g);
		}
	}
	
	/**
	 * @param buffer the buffer to set
	 */
	public void setBuffer(boolean buffer) {
		this.isbuffer = buffer;
		if (this.isbuffer) {
			this.buffer = this.createBuffer(this.width, this.height);
		}
	}
	
	/**
	 * @return get buffer
	 */
	public boolean isBuffer() {
		return this.isbuffer;
	}
	
	/**
	 * call when width or height will change
	 * @param newWidth the new width
	 * @param newHeight the new height
	 */
	protected void actionResize(int newWidth, int newHeight) {
		if (this.isbuffer) {
			this.buffer = this.createBuffer(newWidth, newHeight);
		}
	}
	
	/**
	 * create a buffer image
	 * @param width
	 * @param height
	 * @return buffer image
	 */
	protected BufferedImage createBuffer(int width, int height) {
		this.refresh = true;
		if (width < 1) width = 1;
		if (height < 1) height = 1;
		return new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}
	
	/**
	 * refresh the buffer
	 */
	public void refresh() {
		this.refresh = true;
	}
	
}
