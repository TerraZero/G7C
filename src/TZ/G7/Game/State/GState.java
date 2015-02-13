package TZ.G7.Game.State;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import TZ.G7.Animation.GTransformControlled;
import TZ.G7.Component.GComponentTransition;
import TZ.G7.Component.I.GCompAlt;
import TZ.G7.Handler.GInput;

/**
 * 
 * @author Terra
 * @created 10.12.2014
 * 
 * @file GState.java
 * @project G7C
 * @identifier TZ.G7.Game
 *
 */
public class GState extends GComponentTransition {
	
	public enum GStateStates {
		
		PRELOAD,
		INIT,
		NORMAL,
		PURGE,
		
	}
	
	protected boolean transparentUpdate;
	protected boolean transparentRender;
	protected boolean transparentEvent;
	protected String name;
	protected int scrollX;
	protected int scrollY;
	
	protected GTransformControlled load;
	
	private GStateStates state;
	
	public GState(String name) {
		this.name = name;
	}
	
	/*
	 * @see TZ.G7.Component.GComponent#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.state = GStateStates.PRELOAD;
		this.load = new GTransformControlled(360).speed(0.3f);
	}
	
	public boolean isTransparentUpdate() {
		return this.transparentUpdate;
	}
	
	public boolean isTransparentRender() {
		return this.transparentRender;
	}
	
	public boolean isTransparentEvent() {
		return this.transparentEvent;
	}
	
	public String name() {
		return this.name;
	}
	
	public void render(Graphics g, int parentWidth, int parentHeight) {
		this.setBounds(0, 0, parentWidth, parentHeight);
		if (this.state == GStateStates.INIT) {
			this.renderLoad(g, parentWidth, parentHeight);
		} else if (this.state == GStateStates.NORMAL) {
			this.renderState(g, parentWidth, parentHeight);
		}
	}
	
	public void renderState(Graphics g, int widht, int height) {
		super.render(g, widht, height);
	}
	
	public void updateState(float delta) {
		super.update(delta);
	}
	
	public void eventState(GInput input) {
		super.event(input);
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#updateComponent(float)
	 */
	@Override
	public void update(float delta) {
		if (this.state == GStateStates.INIT) {
			this.updateLoad(delta);
		} else if (this.state == GStateStates.NORMAL) {
			this.updateState(delta);
		}
	}
	
	/* 
	 * @see TZ.G7.Component.GComponent#eventComponent(TZ.G7.Handler.GInput)
	 */
	@Override
	public void event(GInput input) {
		if (this.state == GStateStates.NORMAL) {
			this.eventState(input);
		}
	}
	
	public void stateInit() {
		
	}
	
	public void stateFinish() {
		
	}
	
	public void statePurge() {
		
	}
	
	public GStateStates stateState() {
		return this.state;
	}
	
	public void stateState(GStateStates states) {
		this.state = states;
	}
	
	public void renderLoad(Graphics g, int width, int height) {
		g.setColor(Color.CYAN);
		((Graphics2D)g).setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g.drawArc(width / 2 - 45, height / 2 - 42, 80, 80, this.load.getInt(), 90);
	}
	
	public void updateLoad(float delta) {
		this.load.updateUp(delta);
		if (this.load.isUp()) this.load.value(0);
	}
	
	public void renderContainer(Graphics g, int parentWidth, int parentHeight) {
		this.getComponents().forEach((c) -> {
			if (this.isRenderComponent(c, parentWidth, parentHeight)) {
				c.render(g.create(c.x() - this.scrollX, c.y() - this.scrollY, c.width(), c.height()), parentWidth, parentHeight);
			}
		});
	}
	
	public boolean isRenderComponent(GCompAlt c, int width, int height) {
		return c.x() > this.scrollX && c.x() < width + this.scrollX && c.y() > this.scrollY && c.y() < height + this.scrollY
		 || c.x() + c.width() > this.scrollX && c.x() + c.width() < width + this.scrollX && c.y() > this.scrollY && c.y() < height + this.scrollY
		 || c.x() > this.scrollX && c.x() < width + this.scrollX && c.y() + c.height() > this.scrollY && c.y() + c.height() < height + this.scrollY
		 || c.x() + c.width() > this.scrollX && c.x() + c.width() < width + this.scrollX && c.y() + c.height() > this.scrollY && c.y() + c.height() < height + this.scrollY;
	}
	
}