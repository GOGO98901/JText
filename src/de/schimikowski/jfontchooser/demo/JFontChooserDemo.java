package de.schimikowski.jfontchooser.demo;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import de.schimikowski.jfontchooser.JFontChooserToolBar;

/**
 * Demo for the {@link JFontChooserToolBar} with to {@link TextArea}s.
 * @author daniel schimikowski
 *
 */
public class JFontChooserDemo extends JFrame {
	private static final long serialVersionUID = 1L;
	/**
	 * {@link TextArea} 1.
	 */
	final JTextAreaWithFontChooserListener textArea1;
	/**
	 * {@link TextArea} 2.
	 */
	final JTextAreaWithFontChooserListener textArea2;
	/**
	 * Constructor.
	 */
	public JFontChooserDemo() {
		super("JFontChooserToolBar Demo");
		
		setLayout(new BorderLayout());
		setJMenuBar(buildMenuBar());
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
		final JFontChooserToolBar fChooser = new JFontChooserToolBar();
		textArea1 = new JTextAreaWithFontChooserListener(fChooser);
		textArea1.setText("Lorem ipsum dolor sit amet, consectetur adipisicing elit");
		textArea1.setBorder(BorderFactory.createTitledBorder("TextArea 1"));
		textArea1.setLineWrap(true);

		textArea2 = new JTextAreaWithFontChooserListener(fChooser);
		textArea2
				.setText("Lorem ipsum dolor sit amet, consectetur adipisicing elit");
		textArea2.setBorder(BorderFactory.createTitledBorder("TextArea 2"));
		textArea2.setLineWrap(true);

		

		add(textArea1, BorderLayout.WEST);
		JLabel helpLabel = new JLabel("<html>1. Select a TextArea by clicking to it.<br>2. Choose a font from the ToolBar.</html>");
		
		
		add(helpLabel, BorderLayout.CENTER);
		add(textArea2, BorderLayout.EAST);

		add(fChooser, BorderLayout.NORTH);
		pack();
		setSize(550, 300);
		textArea2.requestFocus();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	private JMenuBar buildMenuBar(){
		JMenuBar bar = new JMenuBar();
		
				
		JMenu menu = new JMenu("File");
		JMenuItem item = new JMenuItem("Info");
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()){
					try {
						Desktop.getDesktop().browse(new URI("http://code.google.com/p/jfontchoosertoolbar/"));
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(JFontChooserDemo.this, "http://code.google.com/p/jfontchoosertoolbar/");
				}
				
			}
		});
		JMenuItem item2 = new JMenuItem("Exit");
		item2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
	
		
		menu.add(item);
		menu.add(item2);
		bar.add(menu);
		return bar;
	}
	
	public static void main(final String[] args) {
		new JFontChooserDemo();

	}

}
