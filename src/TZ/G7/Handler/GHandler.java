package TZ.G7.Handler;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import TZ.G7.GObj;

/**
 * 
 * @author terrazero
 * @created Dec 11, 2014
 * 
 * @file GActions.java
 * @project G7C
 * @identifier TZ.G7.Actions
 *
 */
public class GHandler extends GObj implements AWTEventListener {
	
	private static GHandler singleton;
	
	public static GHandler singleton() {
		if (GHandler.singleton == null) {
			GHandler.singleton = new GHandler();
		} 
		return GHandler.singleton;
	}
	
	protected GInput input;
	
	protected List<KeyEvent> keys;
	
	protected MouseEvent moved;
	protected MouseEvent pressed;
	protected List<MouseEvent> released;
	
	@Override
	protected void init() {
		super.init();
		this.keys = new ArrayList<KeyEvent>();
		this.released = new ArrayList<MouseEvent>();
		this.input = new GInput();
		
		Toolkit.getDefaultToolkit().addAWTEventListener(this, AWTEvent.KEY_EVENT_MASK + AWTEvent.MOUSE_EVENT_MASK + AWTEvent.MOUSE_MOTION_EVENT_MASK);
	}
	
	public void updateInput() {
		this.input.updateKeys(this.keys);
		this.keys.clear();
		
		
		this.input.updateMouse(this.moved, this.pressed, this.released);
		this.released.clear();
	}
	
	public GInput getInput() {
		return this.getInput(true);
	}
	
	public GInput getInput(boolean refresh) {
		if (refresh) {
			this.updateInput();
		}
		return this.input;
	}

	/* 
	 * @see java.awt.event.AWTEventListener#eventDispatched(java.awt.AWTEvent)
	 */
	@Override
	public void eventDispatched(AWTEvent event) {
		if (event instanceof MouseEvent) {
			this.addMouseEvent(event);
		} else if (event instanceof KeyEvent) {
			this.addKeyEvent(event);
		}
	}
	
	public void addMouseEvent(AWTEvent e) {
		MouseEvent me = (MouseEvent)e;
		
		switch (me.getID()) {
			case MouseEvent.MOUSE_MOVED :
				this.moved = me;
				break;
			case MouseEvent.MOUSE_PRESSED :
				this.pressed = me;
				break;
			case MouseEvent.MOUSE_RELEASED :
				this.released.add(me);
				break;
			default : 
				break;
		}
	}
	
	public void addKeyEvent(AWTEvent e) {
		KeyEvent ke = (KeyEvent)e;
		this.keys.add(ke);
	}
	
}
