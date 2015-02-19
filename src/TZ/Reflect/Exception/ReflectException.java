package TZ.Reflect.Exception;

import TZ.G7.Exception.GException;

/**
 * 
 * @author Terra
 * @created 19.02.2015
 * 
 * @file ReflectException.java
 * @project G7C
 * @identifier TZ.Reflect.Exception
 *
 */
public class ReflectException extends GException {

	private static final long serialVersionUID = 1L;

	public ReflectException(String message, String debug) {
		super(message, debug);
	}

	public ReflectException(Exception e, String message, String debug) {
		super(e, message, debug);
	}

}
