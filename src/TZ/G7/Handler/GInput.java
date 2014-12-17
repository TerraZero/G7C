package TZ.G7.Handler;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import TZ.G7.GObj;
import TZ.G7.Component.GComponent;
import TZ.G7.Handler.Function.ToggleFunction;
import TZ.Ints.IntReply;

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
	}
	
	public void updateKeys(List<KeyEvent> en) {
		this.keys.clear();	
		this.keys.addAll(en);
	}
	
	public void updateMouse(List<MouseEvent> en) {
		this.mouse.clear();
		this.mouse.addAll(en);
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
		for (KeyEvent e : this.keys) {
			if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyChar() == pressed) return true;
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
		int reply = IntReply.IS_NULL;
		for (MouseEvent e : this.mouse) {
			if (e.getID() == MouseEvent.MOUSE_MOVED) {
				reply = IntReply.IS_FALSE;
				if (this.isMouseEvent(e, x, y, w, h)) return new IntReply(IntReply.IS_TRUE); 
			}
		}
		return new IntReply(reply);
	}
	
	public IntReply isIntern(GComponent c) {
		return this.isIntern(c.x(), c.y(), c.width(), c.height());
	}
	
	public MouseEvent intern(int x, int y, int w, int h) {
		for (MouseEvent e : this.mouse) {
			if (e.getID() == MouseEvent.MOUSE_MOVED && this.isMouseEvent(e, x, y, w, h)) return e; 
		}
		return null;
	}
	
	public MouseEvent intern(GComponent c) {
		return this.intern(c.x(), c.y(), c.width(), c.height());
	}
	
	public boolean isExtern(int x, int y, int w, int h) {
		for (MouseEvent e : this.mouse) {
			if (e.getID() == MouseEvent.MOUSE_MOVED && !this.isMouseEvent(e, x, y, w, h)) return true; 
		}
		return false;
	}
	
	public boolean isExtern(GComponent c) {
		return this.isExtern(c.x(), c.y(), c.width(), c.height());
	}
	
	public MouseEvent extern(int x, int y, int w, int h) {
		for (MouseEvent e : this.mouse) {
			if (e.getID() == MouseEvent.MOUSE_MOVED && !this.isMouseEvent(e, x, y, w, h)) return e; 
		}
		return null;
	}
	
	public MouseEvent extern(GComponent c) {
		return this.extern(c.x(), c.y(), c.width(), c.height());
	}
	
	public IntReply isClick(int x, int y, int w, int h) {
		int reply = IntReply.IS_NULL;
		for (MouseEvent e : this.mouse) {
			if (e.getID() == MouseEvent.MOUSE_RELEASED) {
				reply = IntReply.IS_FALSE;
				if (this.isMouseEvent(e, x, y, w, h)) return new IntReply(IntReply.IS_TRUE);
			}
		}
		return new IntReply(reply);
	}
	
	public IntReply isClick(GComponent c) {
		return this.isClick(c.x(), c.y(), c.width(), c.height());
	}
	
	public MouseEvent click(int x, int y, int w, int h) {
		for (MouseEvent e : this.mouse) {
			if (e.getID() == MouseEvent.MOUSE_RELEASED && this.isMouseEvent(e, x, y, w, h)) return e;
		}
		return null;
	}
	
	public MouseEvent click(GComponent c) {
		return this.click(c.x(), c.y(), c.width(), c.height());
	}
	
}
