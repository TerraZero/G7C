package TZ.G7.Handler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import TZ.Array.Base;
import TZ.Array.Strings;
import TZ.G7.GObj;
import TZ.G7.Config.GConfig;

/**
 * 
 * @author terrazero
 * @created Dec 11, 2014
 * 
 * @file GKeyAction.java
 * @project G7C
 * @identifier TZ.G7.Actions
 *
 */
public class GKeyHandler extends GObj implements KeyListener {
	
	protected List<String> actions;
	protected KeyEvent[] keys;
	
	protected boolean purge;
	
	@Override
	protected void init() {
		super.init();
		this.actions = new ArrayList<String>();
		this.setKeyBuffer(GConfig.singleton().getInt("keybuffer", 4));
	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.addKey(e);
		this.addAction();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.removeKey(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}
	
	public void addKey(KeyEvent add) {
		if (Base.isIntern(add, this.keys, (search, item) -> {
			return item != null && search.getKeyChar() == item.getKeyChar();
		})) return;
		for (int i = 0; i < this.keys.length; i++) {
			if (this.keys[i] == null) {
				this.keys[i] = add;
				break;
			}
		}
	}
	
	public void removeKey(KeyEvent remove) {
		for (int i = 0; i < this.keys.length; i++) {
			if (this.keys[i] != null && this.keys[i].getKeyChar() == remove.getKeyChar()) {
				this.keys[i] = null;
			}
		}
	}
	
	public void addAction() {
		StringBuilder action = new StringBuilder();
		for (int i = 0; i < this.keys.length; i++) {
			if (this.keys[i] != null) {
				action.append(this.keys[i].getKeyChar()).append("+");
			}
		}
		action.setLength(action.length() - 1);
		this.actions.add(action.toString());
	}
	
	public boolean isAction(String test) {
		if (this.actions.isEmpty()) return false;
		
		String[] items = this.actions.get(0).split("\\+");
		String[] tests = test.split("\\+");
		
		if (items.length != tests.length) return false;
		
		for (int i = 0; i < tests.length; i++) {
			if (!Strings.isIntern(tests[i], items)) return false;
		}
		return true;
	}
	
	public void clearAction() {
		if (!this.actions.isEmpty()) {
			this.actions.remove(0);
		}
		this.purge = false;
	}
	
	public void setKeyBuffer(int buffer) {
		if (this.keys == null) {
			this.keys = new KeyEvent[buffer];
		} else {
			KeyEvent[] tmp = new KeyEvent[buffer];
			for (int i = 0; i < tmp.length && i < this.keys.length; i++) {
				tmp[i] = this.keys[i];
			}
			this.keys = tmp;
		}
	}
	
	public int getKeyBuffer() {
		return this.keys.length;
	}
	
	public void preFrame() {
		this.purge = true;
	}
	
	public void purge() {
		if (this.purge) {
			this.clearAction();
		}
	}

}
