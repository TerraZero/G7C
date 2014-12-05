/**
 * 
 */
package TZ.G7.Canvas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import TZ.G7.Component.GLayer;
import TZ.G7.Component.I.GComp;

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
	
	protected List<GLayer> layers;
	
	protected BufferStrategy bs;
	
	public GCanvas() {
		this.init();
	}
	
	protected void init() {
		this.layers = new ArrayList<GLayer>();
	}
	
	public int addLayer() {
		this.add(new GLayer());
		return this.layers.size() - 1;
	}
	
	public void add(GLayer layer) {
		this.layers.add(layer);
	}
	
	public void remove(GLayer layer) {
		this.layers.remove(layer);
	}
	
	public void add(int layer, GComp component) {
		this.layers.get(layer).add(component);
	}
	
	public void remove(int layer, GComp component) {
		this.layers.get(layer).remove(component);
	}
	
	public GLayer getLayer(int layer) {
		return this.layers.get(layer);
	}
	
	public void createBuffer() {
		this.createBufferStrategy(3);
		this.bs = this.getBufferStrategy();
	}
	
	public Graphics getShowGraphics() {
		return this.bs.getDrawGraphics();
	}
	
	public void render() {
		Graphics g = this.getShowGraphics();
		this.renderComponents(g);
		this.bs.show();
	}
	
	public void renderComponents(Graphics g) {
		this.layers.forEach((l) -> l.bounds(0, 0, this.getWidth(), this.getHeight()).render(g));
	}
	
}
