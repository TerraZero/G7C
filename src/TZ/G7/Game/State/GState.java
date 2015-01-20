package TZ.G7.Game.State;

import java.awt.Color;
import java.awt.Graphics;

import TZ.G7.Animation.GTransformControlled;
import TZ.G7.Component.GComponent;
import TZ.G7.Component.I.GComp;
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
public class GState extends GComponent {
	
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
		for (int i = 0 ; i < 4; i++) {
			g.drawArc((width - (30 + 10 * i)) / 2, (height - (30 + 10 * i)) / 2, (30 + 10 * i), (30 + 10 * i), (90 * i) + (i % 2 == 0 ? -this.load.getInt() : this.load.getInt()), 90 + (i % 2 == 0 ? -(30 * i) : 30 * i));
			g.drawArc((width - (30 + 10 * i)) / 2, (height - (30 + 10 * i)) / 2, (30 + 10 * i), (30 + 10 * i), (90 * i) - 180 + (i % 2 == 0 ? -this.load.getInt() : this.load.getInt()), 90 + (i % 2 == 0 ? 30 * i : -(30 * i)));
		}
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
	
	public boolean isRenderComponent(GComp c, int width, int height) {
		return c.x() > this.scrollX && c.x() < width + this.scrollX && c.y() > this.scrollY && c.y() < height + this.scrollY
		 || c.x() + c.width() > this.scrollX && c.x() + c.width() < width + this.scrollX && c.y() > this.scrollY && c.y() < height + this.scrollY
		 || c.x() > this.scrollX && c.x() < width + this.scrollX && c.y() + c.height() > this.scrollY && c.y() + c.height() < height + this.scrollY
		 || c.x() + c.width() > this.scrollX && c.x() + c.width() < width + this.scrollX && c.y() + c.height() > this.scrollY && c.y() + c.height() < height + this.scrollY;
	}
	
}