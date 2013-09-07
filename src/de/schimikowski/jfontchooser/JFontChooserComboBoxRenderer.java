package de.schimikowski.jfontchooser;

import java.awt.Component;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;

/**
 * This renderer is used to realize the current selected entry of the {@link JComboBox} while the user 
 * is scrolling through the items. 
 * @author daniel schimikowski
 *
 */
public class JFontChooserComboBoxRenderer extends DefaultListCellRenderer{
	private static final long serialVersionUID = 1L;
		/**
		 * Type to know which Combobox this is.
		 * @author daniel
		 */
		public enum CellType{
			/**
			 * Its a combobox for setting the font family.
			 */
			font,
			/**
			 * Its a combobox for setting the font size.
			 */
			size
		}
	
		/**
		 * The {@link JFontChooserToolBar}.
		 */
		private final JFontChooserToolBar chooser;
		/**
		 * The Type.
		 */
		private final CellType type;
		/**
		 * Constructor.
		 * @param chooser the {@link JFontChooserToolBar}
		 * @param type the {@link CellType}
		 */
		public JFontChooserComboBoxRenderer(final JFontChooserToolBar chooser, final CellType type){
			this.chooser = chooser;
			this.type = type;
			
		}
	
	
		
	  @Override
	    public Component getListCellRendererComponent(final JList list, final Object value,
	                        final int index, final boolean isSelected, final boolean cellHasFocus) {

	        final JComponent comp = (JComponent) super.getListCellRendererComponent(list,
	                value, index, isSelected, cellHasFocus);
	        
	       
	        if (type.equals(CellType.font)){
	        	final Font f = getFontForFontItem((String)value);
	        	 comp.setFont(f);
	        }
	      
	        if (isSelected && index != -1){
	        	if (type.equals(CellType.font)){
	        		setMouseOverIndexForFont(index);
	        	}
	        	else if (type.equals(CellType.size)){
	        		setMouseOVerIndexForSize(index);
	        	}
	        }
	        
	        return comp;
	    }
	  /**
	   * Returns a font.
	   * @param txt the font Family name.
	   * @return a new created font
	   */
	  private Font getFontForFontItem(final String txt){
		 
		  final Font f = new Font(txt, Font.PLAIN, chooser.getCurrentFontSize());
		  return f;
		}
		    
		    
	
	  /**
	   * Updates the {@link JFontChooserToolBar} on combobox mouse over.
	   * @param index mouse over index
	   */
	  private void setMouseOverIndexForFont(final int index){
		  chooser.setMouseOverFontCellIndex(index);
	  }
	  /**
	   * Updates the {@link JFontChooserToolBar} on combobox mouse over.
	   * @param index mouse over index
	   */
	  private void setMouseOVerIndexForSize(final int index){
		  chooser.setMouseOverSizeCellIndex(index);
	  }

}
