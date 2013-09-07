package de.schimikowski.jfontchooser;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import de.schimikowski.jfontchooser.JFontChooserComboBoxRenderer.CellType;

/**
 * A {@link JToolBar} for selecting Fonts.
 * To use this {@link JToolBar} implement a {@link JFontChooserListener} and add or set it
 * to this {@link JFontChooserToolBar} by using {@link JFontChooserToolBar#addFontChooserListener(JFontChooserListener)} or
 * {@link JFontChooserToolBar#setFontChooserListener(JFontChooserListener)}.
 * 
 * @author daniel schimikowski
 * 
 */
public class JFontChooserToolBar extends JToolBar implements ItemListener {
	private static final long serialVersionUID = 1L;
	/**
	 * {@link JComboBox} with all available fonts.
	 */
	private final JComboBox fontComboBox;
	/**
	 * {@link JComboBox} with some font sizes.
	 */
	private final JComboBox sizeComboBox;
	/**
	 * {@link JCheckBox} for a bold font.
	 */
	private final JCheckBox boldCheck;
	
	/**
	 * {@link JCheckBox} for italic font.
	 */
	private final JCheckBox italCheck;

	
	/**
	 * All registered {@link JFontChooserListener}s.
	 */
	private final List<JFontChooserListener> listeners = new ArrayList<JFontChooserListener>();
	
	/**
	 * Font sizes.
	 */
	private final Integer[] sizes = { 7, 8, 9, 10, 11, 12, 14, 18, 20, 22, 24, 36 };
	
	/**
	 * The default size index. 
	 */
	private final int sizeDefaultIndex = 5;
	/**
	 * Index at which the user is hovering the combobox for the selected font family.
	 */
	private int mouseOverFontCellIndex = -1;
	/**
	 * Index at which the user is hovering the combobox for the selected font size.
	 */
	private int mouseOverSizeCellIndex = sizeDefaultIndex;

	/**
	 * Flag, which is set to true in {@link #setCurrentSelectedFont(Font)} 
	 * to not inform the listeners about any dynamic changes.
	 */
	private boolean ignoreEvents = false;
	
	/**
	 * Constructor.
	 */
	public JFontChooserToolBar() {
		super();

		final GraphicsEnvironment g = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		final String[] fonts = g.getAvailableFontFamilyNames();

		final JPanel controlPanel = new JPanel();
		fontComboBox = new JComboBox(fonts);
		fontComboBox.setRenderer(new JFontChooserComboBoxRenderer(this,
				CellType.font));
		fontComboBox.addItemListener(this);

		controlPanel.add(new JLabel("Font Family: "));
		controlPanel.add(fontComboBox);

		

		sizeComboBox = new JComboBox(sizes);
		sizeComboBox.setRenderer(new JFontChooserComboBoxRenderer(this,
				CellType.size));
		sizeComboBox.setSelectedIndex(sizeDefaultIndex);
		sizeComboBox.addItemListener(this);

		controlPanel.add(new JLabel("Size: "));
		controlPanel.add(sizeComboBox);

		boldCheck = new JCheckBox("Bold");
		boldCheck.addItemListener(this);
		controlPanel.add(boldCheck);

		italCheck = new JCheckBox("Ital");
		italCheck.addItemListener(this);
		controlPanel.add(italCheck);

		this.add(controlPanel, BorderLayout.SOUTH);

		this.setVisible(true);
	}

	/**
	 * Called by {@link JFontChooserComboBoxRenderer} when the user opens the Combobox and
	 * hovers the Font families. 
	 * @param i index
	 */
	public void setMouseOverFontCellIndex(final int i) {
		if (this.mouseOverFontCellIndex != i) {
			this.mouseOverFontCellIndex = i;
			updateFont();
		}

	}
	/**
	 * Called by {@link JFontChooserComboBoxRenderer} when the user opens the Combobox and
	 * hovers the Font size. 
	 * @param i index
	 */
	public void setMouseOverSizeCellIndex(final int i) {
		if (this.mouseOverSizeCellIndex != i) {
			this.mouseOverSizeCellIndex = i;
			updateFont();
		}

	}

	

	/**
	 * Use this method to set the current selected Font in the {@link JFontChooserToolBar}.
	 * @param font
	 *            the new font
	 */
	public void setCurrentSelectedFont(final Font font) {
		ignoreEvents = true;
		fontComboBox.setSelectedItem(font.getName());
		fontComboBox.setFont(font);
		System.out.println("JFontChooserToolBar.setCurrentSelectedFont()");
		// important!!!
		mouseOverFontCellIndex = fontComboBox.getSelectedIndex();
		sizeComboBox.setSelectedItem(font.getSize());
		// important!!!
		mouseOverSizeCellIndex = sizeComboBox.getSelectedIndex();
		boldCheck.setSelected(font.isBold());
		italCheck.setSelected(font.isItalic());

		ignoreEvents = false;
	}
	/**
	 * Returns the current selected Font size.
	 * @return selected font size
	 */
	public int getCurrentFontSize() {
		return (Integer) sizeComboBox.getSelectedItem();
	}
	/**
	 * Removes the {@link JFontChooserListener}.
	 * @param listener the Listener 
	 */
	public void removeFontChooser(JFontChooserListener listener) {
		this.listeners.remove(listener);
	}
	/**
	 * Removes all {@link JFontChooserListener} and adds the new listener.
	 * @param listener the new and only {@link JFontChooserListener}
	 */
	public void setFontChooserListener(final JFontChooserListener listener) {
		this.listeners.clear();
		addFontChooserListener(listener);
	}
	/**
	 * Adds a new {@link JFontChooserListener}.
	 * @param listener the new Listener.
	 */
	public void addFontChooserListener(final JFontChooserListener listener) {
		this.listeners.add(listener);
	}

	/**
	 * Updates all Listeners.
	 * @param f the new Font
	 */
	private void updateListeners(final Font f) {
		for (JFontChooserListener listener : listeners) {
			listener.fontChanged(f);
		}

	}

	/**
	 * Reads the current selected Font settings and updates all registered
	 * {@link JFontChooserListener}.
	 */
	private void updateFont() {
		if (!ignoreEvents) {
			final String name = (String) fontComboBox
					.getItemAt(mouseOverFontCellIndex);
			final Integer size = (Integer) sizeComboBox
					.getItemAt(mouseOverSizeCellIndex);

			int style;
			if (boldCheck.isSelected() && italCheck.isSelected())
				style = Font.BOLD | Font.ITALIC;	
			else if (boldCheck.isSelected())
				style = Font.BOLD;
			else if (italCheck.isSelected())
				style = Font.ITALIC;
			else
				style = Font.PLAIN;

			
			final Font f = new Font(name, style, size.intValue());
			updateListeners(f);

		}
		

	}

	@Override
	public void itemStateChanged(final ItemEvent e) {
		updateFont();
		fontComboBox.revalidate();
		sizeComboBox.revalidate();
	}

}