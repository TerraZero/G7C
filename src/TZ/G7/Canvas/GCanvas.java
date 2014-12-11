/**
 * 
 */
package TZ.G7.Canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import TZ.G7.Game.State.GState;
import TZ.G7.Handler.GHandler;

/**
 * 
 * @author Terra
 * @created 03.12.2014
 * 
 * @file GCanvas.java
 * @project G7C
 * @identifier TZ.G7.Canvas
 *
 */
public class GCanvas extends Canvas {

	private static final long serialVersionUID = 1L;
	
	private static GCanvas singleton;

	protected BufferStrategy bs;
	
	public static GCanvas singleton() {
		if (GCanvas.singleton == null) {
			GCanvas.singleton = new GCanvas();
		}
		return GCanvas.singleton;
	}
	
	public GCanvas() {
		this.init();
	}
	
	protected void init() {
		this.setBackground(Color.BLACK);
		this.addKeyListener(GHandler.singleton().keys());
	}
	
	public void createBuffer() {
		this.createBufferStrategy(3);
		this.bs = this.getBufferStrategy();
	}
	
	public Graphics getShowGraphics() {
		Graphics g =  this.bs.getDrawGraphics();
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		return g;
	}
	
	public void render(GState state) {
		Graphics g = this.getShowGraphics();
		state.render(g, this.getWidth(), this.getHeight());
		this.bs.show();
	}
	
}
