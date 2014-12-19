package TZ.G7.Exception;

import TZ.G7.Annot.ConfigItem;
import TZ.G7.Annot.ConfigUse;
import TZ.G7.Annot.ConfigDefinition;
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
@ConfigDefinition({
	@ConfigItem(option = "exception-message", values = {"user", "debug", "dev"}, description = "The exception message option.", category = "Exception")
})
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
	@ConfigUse({
		@ConfigItem(option = "exception-message", fallback = "user")
	})
	public String toString() {
		String config = GConfig.singleton().get("exception-message", "user");
		if (config.equals("dev")) {
			return "[debug] " + this.debug + " [message] " + this.message;
		} else if (config.equals("debug")) {
			return this.debug;
		} else {
			return this.message;
		}
	}

}
