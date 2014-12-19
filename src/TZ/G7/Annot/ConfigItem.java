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
 * @file Configitem.java
 * @project G7C
 * @identifier TZ.G7.Annot
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface ConfigItem {

	public String option();
	public String[] values() default {};
	public String fallback() default ConfigAnnot.NONE;
	public String data() default ConfigAnnot.DATA_LIST;
	public String datatyp() default ConfigAnnot.TYPE_STRING;
	public String description() default ConfigAnnot.NONE;
	public String category() default ConfigAnnot.NONE;
	
}
