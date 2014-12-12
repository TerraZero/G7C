package TZ.G7.Handler;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import TZ.G7.GObj;

/**
 * 
 * @author terrazero
 * @created Dec 12, 2014
 * 
 * @file GInput.java
 * @project G7C
 * @identifier TZ.G7.Handler
 *
 */
public class GInput extends GObj {

	protected List<Integer> keyslog;
	 
	protected List<KeyEvent> keys;
	protected List<MouseEvent> mouse;
	
	/* 
	 * @see TZ.G7.GObj#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.keys = new ArrayList<KeyEvent>();
		this.mouse = new ArrayList<MouseEvent>();
		
		this.keyslog = new ArrayList<Integer>();
	}
	
	public void updateKeys(List<KeyEvent> en) {
		this.keys.forEach(item -> this.addKeyLog(item));
		this.keys.clear();
		
		this.keys.addAll(en);
	}
	
	public void addKeyLog(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_PRESSED && !this.keyslog.contains(e.getKeyCode())) {
			this.keyslog.add(e.getKeyCode());
		}
		int index = 0;
		if (e.getID() == KeyEvent.KEY_RELEASED && (index = this.keyslog.indexOf(e.getKeyCode())) != -1) {
			this.keyslog.remove(index);
		}
	}
	
	public void updateMouse(List<MouseEvent> en) {
		this.clearMouse();
		
		this.mouse.addAll(en);
	}
	
	public void clearMouse() {
		this.mouse.removeIf(item -> item.isConsumed());
	}
	
	public boolean isPressed(int... keys) {
		for (int key : keys) if (this.isCurrentPressed(key)) return this.isPress(keys);
		return false;
	}
	
	protected boolean isCurrentPressed(int key) {
		for (KeyEvent e : this.keys) if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == key) return true;
		return false;
	}
	
	protected boolean isLogPressed(int key) {
		return this.keyslog.contains(key);
				
	}
	
	protected boolean isPress(int... keys) {
		for (int key : keys) if (!this.isCurrentPressed(key) && !this.isLogPressed(key)) return false;
		return true;
	}
	
	public boolean isReleased(char... c) {
		return true;
	}
	
}
