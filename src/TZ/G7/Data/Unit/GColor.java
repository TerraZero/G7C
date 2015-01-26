package TZ.G7.Data.Unit;

import java.awt.Color;

import TZ.G7.Annot.ConfigItem;
import TZ.G7.Annot.ConfigUse;
import TZ.G7.Annot.ConfigDefinition;
import TZ.G7.Config.GConfig;
import TZ.G7.Exception.GException;
import TZ.Strings.Strings;

/**
 * 
 * @author terrazero
 * @created Dec 17, 2014
 * 
 * @file GColor.java
 * @project G7C
 * @identifier TZ.G7.Data
 *
 */
@ConfigDefinition({
	@ConfigItem(option = "color-output-type", values = {"hex", "rgb", "rgba"}, description = "The default output format for color's.", category = "Color")
})
public class GColor {

	public static String toHex(Color color) {
		return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
	}

	public static String toRGBA(Color color) {
		return String.format("rgba(%d, %d, %d, %d)", color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
	}
	
	public static String toRGB(Color color) {
		return String.format("rgb(%d, %d, %d)", color.getRed(), color.getGreen(), color.getBlue());
	}
	
	@ConfigUse({
		@ConfigItem(option = "color-output-type", fallback = "hex")
	})
	public static String output(Color color) {
		String config = GConfig.singleton().get("color-output-type", "hex");
		if (config.equals("hex")) {
			return GColor.toHex(color);
		} else if (config.equals("rgb")) {
			return GColor.toRGB(color);
		} else if (config.equals("rgba")) {
			return GColor.toRGBA(color);
		} else {
			throw new GException("Unknown output configuration for 'color-output-type'.", "Unknown output configuration for 'color-output-type' value: '" + config + "'");
		}
	}
	
	public static Color input(String input) {
		Color color = null;
		try {
			if (input.startsWith("#")) {
				color = Color.decode(input.substring(1));
			} else if (input.startsWith("rgba(")) {
				input = Strings.clearString(input.substring(5, input.length() - 1), " ");
				String[] colors = input.split(",");
				color = new Color(Integer.parseInt(colors[0]), Integer.parseInt(colors[1]), Integer.parseInt(colors[2]), Integer.parseInt(colors[3]));
			} else if (input.startsWith("rgb(")) {
				input = Strings.clearString(input.substring(4, input.length() - 1), " ");
				String[] colors = input.split(",");
				color = new Color(Integer.parseInt(colors[0]), Integer.parseInt(colors[1]), Integer.parseInt(colors[2]));
			}
		} catch (NumberFormatException e) {
			throw new GException(e, "The string was expected as integer to interpret color.", "The string '" + input + "' has a expected integer as string.");
		} catch (Exception e) {
			throw new GException(e, "Unknown failure by interpret a color string.", "Unknown failure by interpret '" + input + "' as color.");
		}
		return color;
	}
	
}
