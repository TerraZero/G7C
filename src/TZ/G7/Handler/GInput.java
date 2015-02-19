package TZ.G7.Handler;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import TZ.Base.Data.IntReply;
import TZ.G7.GObj;
import TZ.G7.Component.Mechnic.GCompAlt;
import TZ.G7.Handler.Function.ToggleFunction;
import TZ.Reflect.Boot.Booter;

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
@Booter(name="test-booter")
public class GInput extends GObj {
	 
	protected List<KeyEvent> keys;
	protected List<KeyEvent> keyPressed;
	
	protected MouseEvent moved;
	protected MouseEvent oldmoved;
	
	protected MouseEvent pressed;
	protected List<MouseEvent> released;
	
	/* 
	 * @see TZ.G7.GObj#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.keys = new ArrayList<KeyEvent>();
		this.keyPressed = new ArrayList<KeyEvent>();
		this.released = new ArrayList<MouseEvent>();
	}
	
	public void updateKeys(List<KeyEvent> en) {
		this.keys.clear();	
		this.keys.addAll(en);
		
		for (KeyEvent e : this.keys) {
			if (e.getID() == KeyEvent.KEY_PRESSED) this.keyPressed.add(e);
			if (e.getID() == KeyEvent.KEY_RELEASED) this.removePressed(e);
		}
	}
	
	public void removePressed(KeyEvent e) {
		List<KeyEvent> tl = new ArrayList<KeyEvent>();
		for (KeyEvent ke : this.keyPressed) {
			if (ke.getKeyCode() == e.getKeyCode()) tl.add(ke);
		}
		this.keyPressed.removeAll(tl);
	}
	
	public void updateMouse(MouseEvent moved, MouseEvent pressed, List<MouseEvent> released) {
		this.oldmoved = this.moved;
		this.moved = moved;
		if (this.moved == null) this.moved = this.oldmoved;
		
		this.pressed = pressed;
		
		this.released.clear();
		this.released.addAll(released);
	}
	
	public MouseEvent moved() {
		return this.moved;
	}
	
	public MouseEvent oldmoved() {
		return this.oldmoved;
	}
	
	public MouseEvent pressed() {
		return this.pressed;
	}
	
	public List<MouseEvent> released() {
		return this.released;
	}
	
	// toggle
	
	public void toggle(ToggleFunction function) {
		if (function.strickt()) {
			if (function.inActive(this)) {
				function.active();
			} else if (function.inDeactive(this)) {
				function.deactive();
			}
		} else {
			if (function.inActive(this)) {
				function.active();
			}
			if (function.inDeactive(this)) {
				function.deactive();
			}
		}
	}
	
	// key
	
	public boolean isPressed(char pressed) {
		for (KeyEvent e : this.keyPressed) {
			if (e.getKeyChar() == pressed) return true;
		}
		return false;
	}
	
	public boolean isReleased(char released) {
		for (KeyEvent e : this.keys) {
			if (e.getID() == KeyEvent.KEY_RELEASED && e.getKeyChar() == released) return true;
		}
		return false;
	}
	
	public KeyEvent pressed(char pressed) {
		for (KeyEvent e : this.keys) {
			if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyChar() == pressed) return e;
		}
		return null;
	}
	
	public KeyEvent released(char released) {
		for (KeyEvent e : this.keys) {
			if (e.getID() == KeyEvent.KEY_RELEASED && e.getKeyChar() == released) return e;
		}
		return null;
	}
	
	public boolean isAnyPressed(char... chars) {
		for (int i = 0; i < chars.length; i++) {
			if (this.isPressed(chars[i])) return true;
		}
		return false;
	}
	
	public boolean isAnyReleased(char... chars) {
		for (int i = 0; i < chars.length; i++) {
			if (this.isReleased(chars[i])) return true;
		}
		return false;
	}
	
	// mouse 
	
	protected boolean isMouseEvent(MouseEvent e, int x, int y, int w, int h) {
		return e.getX() > x && e.getX() < x + w && e.getY() > y && e.getY() < y + h;
	}
	
	public IntReply isIntern(int x, int y, int w, int h) {
		if (this.moved == null) return new IntReply(IntReply.IS_NULL);
		return new IntReply(this.isMouseEvent(this.moved, x, y, w, h));
	}
	
	public IntReply isIntern(GCompAlt c) {
		return this.isIntern(c.x(), c.y(), c.width(), c.height());
	}
	
	public IntReply isExtern(int x, int y, int w, int h) {
		if (this.moved == null) return new IntReply(IntReply.IS_NULL);
		return new IntReply(!this.isMouseEvent(this.moved, x, y, w, h));
	}
	
	public IntReply isExtern(GCompAlt c) {
		return this.isExtern(c.x(), c.y(), c.width(), c.height());
	}
	
	public IntReply isHover(int x, int y, int w, int h) {
		if (this.moved == null) return new IntReply(IntReply.IS_NULL);
		if (this.oldmoved == null) return new IntReply(this.isMouseEvent(this.moved, x, y, w, h));
		
		boolean save = this.isMouseEvent(this.oldmoved, x, y, w, h);
		boolean move = this.isMouseEvent(this.moved, x, y, w, h);
		if (save != move) return new IntReply(move);
		return new IntReply(IntReply.IS_NULL);
	}
	
	public IntReply isHover(GCompAlt c) {
		return this.isHover(c.x(), c.y(), c.width(), c.height());
	}
	
	public IntReply isClick(int x, int y, int w, int h) {
		if (this.released.size() == 0) return new IntReply(IntReply.IS_NULL);
		for (MouseEvent e : this.released) {
			if (this.isMouseEvent(e, x, y, w, h)) return new IntReply(IntReply.IS_TRUE);
		}
		return new IntReply(IntReply.IS_FALSE);
	}
	
	public IntReply isClick(GCompAlt c) {
		return this.isClick(c.x(), c.y(), c.width(), c.height());
	}
	
}
