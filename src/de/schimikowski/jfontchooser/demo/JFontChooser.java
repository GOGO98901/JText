package de.schimikowski.jfontchooser.demo;

import gogo98901.net.text.editor.Main;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
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
public class JFontChooser extends JFrame {
	private static final long serialVersionUID = 1L;
	/**
	 * {@link TextArea} 1.
	 */
	final JTextAreaWithFontChooserListener textArea1;
	/**
	 * Constructor.
	 */
	public JFontChooser() {
		super("Font");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.FontImage));
		setLayout(new BorderLayout());
		setJMenuBar(buildMenuBar());
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
		final JFontChooserToolBar fChooser = new JFontChooserToolBar();
		
		textArea1 = new JTextAreaWithFontChooserListener(fChooser);
		textArea1.setText("Lorem ipsum dolor sit amet, consectetur adipisicing elit");
		textArea1.setBorder(BorderFactory.createTitledBorder("TextArea 1"));
		textArea1.setLineWrap(true);
		
		add(textArea1, BorderLayout.WEST);
		
		JButton OkButon = new JButton("OK");
		OkButon.setSize(200,200);
		
		//JButton CancelButon = new JButton("Cancel");
		//CancelButon.setSize(100,100);
		
		//add(CancelButon, BorderLayout.LINE_START);
		add(OkButon, BorderLayout.LINE_END);

		add(fChooser, BorderLayout.NORTH);
		pack();
		setSize(550, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	private JMenuBar buildMenuBar(){
		JMenuBar bar = new JMenuBar();
		
				
		JMenu menu = new JMenu("Options");
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
					JOptionPane.showMessageDialog(JFontChooser.this, "http://code.google.com/p/jfontchoosertoolbar/");
				}
				
			}
		});
		JMenuItem item2 = new JMenuItem("Exit");
		item2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(3);
				
			}
		});
	
		
		menu.add(item);
		menu.add(item2);
		bar.add(menu);
		return bar;
	}
	
	public static void main(final String[] args) {
		Main.lookAndFeel();
		new JFontChooserWindow();

	}

}
