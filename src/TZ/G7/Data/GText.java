package TZ.G7.Data;

import java.awt.Color;
import java.awt.Graphics;

import TZ.G7.GObj;
import TZ.G7.Annot.ConfigItem;
import TZ.G7.Annot.ConfigUse;
import TZ.G7.Annot.ConfigDefinition;
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
	@ConfigItem(option = "text-color", data = "color", description = "The default text color."),
	@ConfigItem(option = "text-size", data = "size", datatyp = "int", description = "The default font size.")
})
public class GText extends GObj {

	protected String text;
	protected Color color;
	protected float size;
	
	public GText() {
		
	}
	
	public GText(String text) {
		this.text = text;
	}
	
	public GText(String text, Color color) {
		this.text = text;
		this.color = color;
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
		this.color = GColor.input(GConfig.singleton().get("text-color", "#000000"));
		this.size = GConfig.singleton().getInt("text-size", 13);
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
	
	public void render(Graphics g, int x, int y, int width, int height) {
		Color save = g.getColor();
		g.setColor(this.color);
		TextRendering.setFontSize(g, this.size).drawString(this.text, x + TextRendering.getMiddleWidthText(g, this.text, width), y + TextRendering.getMiddleHeightText(g, height));
		g.setColor(save);
	}
	
	public GText color(Color color) {
		this.color = color;
		return this;
	}
	
	public Color color() {
		return this.color;
	}
	
	public GText size(float size) {
		this.size = size;
		return this;
	}
	
}
