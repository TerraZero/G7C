package TZ.G7.Annot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author terrazero
 * @created Dec 17, 2014
 * 
 * @file Configa.java
 * @project G7C
 * @identifier TZ.G7.Annot
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ConfigDefinition {

	public ConfigItem[] value();
	
}
