package TZ.G7.Loader;

import java.util.HashMap;
import java.util.Map;

import TZ.G7.GObj;
import TZ.G7.Exception.GException;

/**
 * 
 * @author Terra
 * @created 15.01.2015
 * 
 * @file GSynchronized.java
 * @project G7C
 * @identifier TZ.G7.Loader
 *
 */
public class GSynchronized extends GObj {
	
	private static GSynchronized singleton;
	
	public static GSynchronized singleton() {
		if (GSynchronized.singleton == null) {
			GSynchronized.singleton = new GSynchronized();
		}
		return GSynchronized.singleton;
	}
	
	public static Object sync(String identifer) {
		return GSynchronized.singleton().getSync(identifer);
	}
	
	public static void syncWaitOn(String identifer) {
		GSynchronized.singleton().synchronWait(identifer);
	}
	
	public static void syncWait(String identifer) {
		try {
			GSynchronized.singleton().getSync(identifer).wait();
		} catch (InterruptedException e) {
			throw new GException(e, "Synchronized error in synchron wait!", "Synchronized error in synchron wait!");
		}
	}
	
	public static void syncNotifyOn(String identifer) {
		GSynchronized.singleton().synchronNotify(identifer);
	}
	
	public static void syncNotify(String identifer) {
		GSynchronized.singleton().getSync(identifer).notifyAll();
	}
	
	public static void syncFunction(String identifer, GSynchronFunction function) {
		GSynchronized.singleton().synchronFunction(identifer, function);
	}

	protected Map<String, Object> syncs;
	
	/* 
	 * @see TZ.G7.GObj#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.syncs = new HashMap<String, Object>();
	}
	
	public synchronized Object getSync(String identifer) {
		Object o = this.syncs.get(identifer);
		if (o == null) {
			o = new Object();
			this.syncs.put(identifer, o);
		}
		return o;
	}
	
	public void remove(String identifer) {
		this.syncs.remove(identifer);
	}
	
	public void synchronWait(String identifer) {
		Object o = this.getSync(identifer);
		synchronized (o) {
			try {
				o.wait();
			} catch (InterruptedException e) {
				throw new GException(e, "Synchronized error in synchron wait!", "Synchronized error in synchron wait!");
			}
		}
	}
	
	public void synchronNotify(String identifer) {
		Object o = this.getSync(identifer);
		synchronized (o) {
			o.notifyAll();
		}
	}
	
	public void synchronFunction(String identifer, GSynchronFunction function) {
		Object o = this.getSync(identifer);
		synchronized (o) {
			function.synchron(o);
		}
	}
	
}
