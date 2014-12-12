package TZ.G7.Exception;

import TZ.G7.Config.GConfig;

/**
 * 
 * @author Terra
 * @created 10.12.2014
 * 
 * @file GException.java
 * @project G7C
 * @identifier TZ.G7.Exception
 *
 */
public class GException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	protected Exception e;
	protected String message;
	protected String debug;
	
	public GException(String message, String debug) {
		this.message = message;
		this.debug = debug;
	}
	
	public GException(Exception e, String message, String debug) {
		this.e = e;
		this.message = message;
		this.debug = debug;
	}
	
	/* 
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		if (GConfig.singleton().get("exception", "debug").equals("user")) {
			return this.debug;
		} else {
			return this.message;
		}
	}

}
