package TZ.G7.Data.Unit;

import java.awt.Color;
import java.awt.Graphics;

import TZ.G7.GObj;
import TZ.G7.Animation.GColorTransform;
import TZ.G7.Animation.GTransform;
import TZ.G7.Annot.ConfigAnnot;
import TZ.G7.Annot.ConfigItem;
import TZ.G7.Annot.ConfigUse;
import TZ.G7.Annot.ConfigDefinition;
import TZ.G7.Component.I.GCompAlt;
import TZ.G7.Config.GConfig;
import TZ.G7.Rendering.TextRendering;

/**
 * 
 * @author terrazero
 * @created Dec 15, 2014
 * 
 * @file GText.java
 * @project G7C
 * @identifier TZ.G7.Data
 *
 */
@ConfigDefinition({
	@ConfigItem(option = "text-color", data = ConfigAnnot.DATA_COLOR, description = "The default text color.", category = "Text"),
	@ConfigItem(option = "text-size", data = ConfigAnnot.DATA_SIZE, datatyp = ConfigAnnot.TYPE_INT, description = "The default font size.", category = "Text")
})
public class GText extends GObj {

	protected String text;
	protected GColorTransform color;
	protected GTransform size;
	
	public GText() {
		
	}
	
	public GText(String text) {
		this.text = text;
	}
	
	public GText(String text, Color color) {
		this.text = text;
		
	}
	
	/* 
	 * @see TZ.G7.GObj#init()
	 */
	@Override
	@ConfigUse({
		@ConfigItem(option = "text-color", fallback = "#000000"),
		@ConfigItem(option = "text-size", fallback = "13")
	})
	protected void init() {
		super.init();
		this.text = "";
		this.color = new GColorTransform(GColor.input(GConfig.singleton().get("text-color", "#000000")));
		this.size = new GTransform(GConfig.singleton().getFloat("text-size", 13)).speed(0.2f);
	}
	
	public String get() {
		return this.text;
	}
	
	public GText set(String text) {
		this.text = text;
		return this;
	}
	
	/* 
	 * @see TZ.G7.GObj#toString()
	 */
	@Override
	public String toString() {
		return this.text;
	}
	
	public void render(Graphics g, GCompAlt c) {
		this.render(g, 0, 0, c.width(), c.height());
	}
	
	public void render(Graphics g, int x, int y, int width, int height) {
		g.setColor(this.color.get());
		TextRendering.setFontSize(g, this.size.get()).drawString(this.text, x + TextRendering.getMiddleWidthText(g, this.text, width), y + TextRendering.getMiddleHeightText(g, height));
	}
	
	public GText color(Color color) {
		this.color.set(color);
		return this;
	}
	
	public GText size(float size) {
		this.size.set(size);
		return this;
	}
	
	public GText setSize(float size) {
		this.size.value(size);
		return this;
	}
	
	public GText setColor(Color color) {
		this.color.setColor(color);
		return this;
	}
	
	public void update(float delta) {
		this.color.update(delta);
		this.size.update(delta);
	}
	
	public int renderingWidth(Graphics g) {
		return TextRendering.getTextWidth(g, g.getFont().deriveFont(this.size.get()), this.text);
	}
	
	public int renderingHeight(Graphics g) {
		return TextRendering.getLineHeight(g, g.getFont().deriveFont(this.size.get()));
	}
	
	public GTransform size() {
		return this.size;
	}
	
	public GColorTransform color() {
		return this.color;
	}
	
}
