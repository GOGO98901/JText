package de.schimikowski.jfontchooser.demo;

import gogo98901.net.text.editor.open.FontPicker;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextArea;

import de.schimikowski.jfontchooser.JFontChooserListener;
import de.schimikowski.jfontchooser.JFontChooserToolBar;
/**
 * {@link JTextArea} implementing {@link JFontChooserListener} and {@link FocusListener}.
 * When the JTextarea gains the focus (by clicking in it) it sets the current Font to the {@link JFontChooserToolBar}.
 * @author daniel schimikowski
 *
 */
public class JTextAreaWithFontChooserListener extends JTextArea implements JFontChooserListener, FocusListener {
	private static final long serialVersionUID = 1L;
	/**
	 * The toolbar.
	 */
	private final JFontChooserToolBar fontChooserToolBar;
	/**
	 * Constructor.
	 * @param fontChooserToolBar
	 */
	public JTextAreaWithFontChooserListener(JFontChooserToolBar fontChooserToolBar){
		super();
		addFocusListener(this);
		this.fontChooserToolBar = fontChooserToolBar;
	}
	
	@Override
	public void fontChanged(Font f) {
		setFont(f);
		FontPicker.viewFont = f;
		System.out.println("New font = " + f);
		FontPicker.setFontSize = f.getSize();
		FontPicker.setFont = f.getFontName();
		FontPicker.setFontStyle = f.getStyle();
	}

	@Override
	public void focusGained(FocusEvent e) {
		fontChooserToolBar.setCurrentSelectedFont(this.getFont());
		fontChooserToolBar.setFontChooserListener(this);
	}

	@Override
	public void focusLost(FocusEvent e) {
	}

}
