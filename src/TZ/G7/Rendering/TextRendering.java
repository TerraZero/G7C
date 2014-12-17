package TZ.G7.Rendering;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author terrazero
 * @created Dec 17, 2014
 * 
 * @file TextRendering.java
 * @project G7C
 * @identifier TZ.G7.Rendering
 *
 */
public class TextRendering {
	
	public static int getLineHeight(Graphics g) {
		return g.getFontMetrics(g.getFont()).getHeight();
	}
	
	public static int getLineHeight(Graphics g, Font font) {
		return g.getFontMetrics(font).getHeight();
	}
	
	public static int getTextWidth(Graphics g, String text) {
		return g.getFontMetrics(g.getFont()).stringWidth(text);
	}
	
	public static int getTextWidth(Graphics g, Font font, String text) {
		return g.getFontMetrics(font).stringWidth(text);
	}
	
	public static int getMiddleWidthText(Graphics g, String text, int width) {
		return (width - TextRendering.getTextWidth(g, text)) / 2;
	}
	
	public static int getRightWidthText(Graphics g, String text, int width) {
		return width - TextRendering.getTextWidth(g, text);
	}
	
	public static int getMiddleHeightText(Graphics g, int height) {
		return (height + TextRendering.getLineHeight(g) / 2) / 2;
	}
	
	public static Graphics setFontSize(Graphics g, float size) {
		g.setFont(g.getFont().deriveFont(size));
		return g;
	}
	
	public static int getSplitIndex(Graphics g, String text, int width) {
		StringBuilder s = new StringBuilder();
		char[] c = text.toCharArray();
		for (int i = 0; i < c.length; i++) {
			s.append(c[i]);
			if (TextRendering.getTextWidth(g, s.toString()) > width) return ++i;
		}
		return c.length;
	}
	
	public static int getSplitIndex(Graphics g, String text, int width, int offset) {
		StringBuilder s = new StringBuilder();
		char[] c = text.toCharArray();
		for (int i = 0; i < c.length; i++) {
			s.append(c[i]);
			if (TextRendering.getTextWidth(g, s.toString()) > width) {
				return i + 1;
			}
		}
		return s.length();
	}
	
	public static String getSplitString(Graphics g, String text, int width) {
		StringBuilder s = new StringBuilder();
		char[] c = text.toCharArray();
		for (int i = 0; i < c.length; i++) {
			s.append(c[i]);
			if (TextRendering.getTextWidth(g, s.toString()) > width) break;
		}
		return s.toString();
	}
	
	public static List<String> getLinesWrapping(Graphics g, String text, int width) {
		int lineWidth = 0;
		List<String> lines = new ArrayList<String>();
		StringBuilder line = new StringBuilder();
		String[] words = text.split(" ");
		String tmp = "";
		
		for (int i = 0; i < words.length; i++) {
			int wordWidth = TextRendering.getTextWidth(g, words[i] + " ");
			if (wordWidth > width) {
				if (i != 0) {
					lines.add(line.toString());
				}
				line.delete(0, line.length());
				do {
					tmp = TextRendering.getSplitString(g, words[i], width);
					lines.add(tmp);
					words[i] = words[i].substring(tmp.length());
					wordWidth = TextRendering.getTextWidth(g, words[i]);
				} while (wordWidth > width);
				line.delete(0, line.length());
				line.append(words[i]);
				lineWidth = wordWidth;
			} else {
				if (lineWidth + wordWidth > width) {
					lines.add(line.toString());
					line.delete(0, line.length());
					line.append(words[i]);
					lineWidth = wordWidth;
				} else {
					lineWidth += wordWidth;
					if (line.length() == 0) {
						line.append(words[i]);
					} else {
						line.append(" " + words[i]);
					}
				}
			}
		}
		lines.add(line.toString());
		return lines;
	}
	
}
