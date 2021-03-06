package fwcd.palm.view.theme;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class TemplateTheme implements Theme {
	private final Map<ThemedElement, Color> elementMap = new HashMap<>();
	private final Map<SyntaxElement, Color> syntaxElementMap = new HashMap<>();
	private Color bgColor = Color.WHITE;
	private Color mildBgColor = Color.LIGHT_GRAY;
	private Color fgColor = Color.BLACK;
	private Color mildFgColor = Color.DARK_GRAY;
	private Color popupBgColor = Color.WHITE.darker();

	@Override
	public Color bgColor() { return bgColor; }

	@Override
	public Color mildBGColor() { return mildBgColor; }

	@Override
	public Color fgColor() { return fgColor; }

	@Override
	public Color mildFGColor() { return mildFgColor; }
	
	@Override
	public Color popupBGColor() { return popupBgColor; }
	
	@Override
	public Optional<Color> colorOf(ThemedElement element) { return Optional.ofNullable(elementMap.get(element)); }

	@Override
	public Optional<Color> colorOf(SyntaxElement element) { return Optional.ofNullable(syntaxElementMap.get(element)); }
	
	protected void set(ThemedElement element, Color color) { elementMap.put(element, color); }
	
	protected void set(SyntaxElement element, Color color) { syntaxElementMap.put(element, color); }
	
	protected void setPopupBgColor(Color popupBgColor) { this.popupBgColor = popupBgColor; }
	
	protected void setBgColor(Color bgColor) { this.bgColor = bgColor; }

	protected void setMildBgColor(Color mildBgColor) { this.mildBgColor = mildBgColor; }

	protected void setFgColor(Color fgColor) { this.fgColor = fgColor; }

	protected void setMildFgColor(Color mildFgColor) { this.mildFgColor = mildFgColor; }
}
