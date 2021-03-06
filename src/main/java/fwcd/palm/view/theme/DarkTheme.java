package fwcd.palm.view.theme;

import java.awt.Color;

public class DarkTheme extends TemplateTheme {
	public DarkTheme() {
		setBgColor(Color.DARK_GRAY);
		setMildBgColor(Color.GRAY);
		setFgColor(Color.WHITE);
		setMildFgColor(Color.WHITE.darker());
		setPopupBgColor(Color.DARK_GRAY.brighter());
		set(ThemedElement.EDITOR_BG, new Color(0x252525));
		set(ThemedElement.TOOLBAR, new Color(0x333333));
		set(ThemedElement.LINE_HIGHLIGHT, new Color(0x333333));
		set(SyntaxElement.KEYWORD, Color.ORANGE);
		set(SyntaxElement.TYPE, Color.GREEN);
		set(SyntaxElement.VARIABLE, Color.CYAN);
		set(SyntaxElement.STRING, Color.ORANGE);
		set(SyntaxElement.COMMENT, Color.GREEN);
		set(SyntaxElement.FUNCTION, Color.YELLOW);
		set(SyntaxElement.OTHER, Color.WHITE);
	}
}
