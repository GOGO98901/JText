package de.schimikowski.jfontchooser;

import java.awt.Font;
/**
 * A {@link JFontChooserListener} can be registered at {@link JFontChooserToolBar#addFontChooserListener(JFontChooserListener)}.
 * @author daniel schimikowski
 *
 */
public interface JFontChooserListener {
	/**
	 * Font updated.
	 * @param font new Font
	 */
	void fontChanged(Font font);
		
	
}
