package de.schimikowski.jfontchooser.demo;

import gogo98901.net.text.editor.Main;
import gogo98901.net.text.editor.open.FontPicker;

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
import javax.swing.JToolBar;
import java.awt.Component;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * Demo for the {@link JFontChooserToolBar} with to {@link TextArea}s.
 * 
 * @author daniel schimikowski
 * 
 */
public class JFontChooserWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	/**
	 * {@link TextArea} 1.
	 */
	final JTextAreaWithFontChooserListener textArea1;
	private JTextField txtClickInThe;

	/**
	 * Constructor.
	 */
	public JFontChooserWindow() {
		super("Font");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBackground(Color.LIGHT_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.FontImage));
		getContentPane().setLayout(new BorderLayout());
		setJMenuBar(buildMenuBar());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		final JFontChooserToolBar fChooser = new JFontChooserToolBar();
		fChooser.setBackground(Color.LIGHT_GRAY);
		fChooser.setFloatable(false);

		textArea1 = new JTextAreaWithFontChooserListener(fChooser);
		textArea1.setEditable(false);
		textArea1.setBackground(Color.LIGHT_GRAY);
		textArea1
				.setText("Lorem ipsum dolor sit amet, consectetur adipisicing elit");
		textArea1.setBorder(BorderFactory.createTitledBorder("Preview"));
		textArea1.setLineWrap(true);

		getContentPane().add(textArea1, BorderLayout.WEST);

		getContentPane().add(fChooser, BorderLayout.NORTH);

		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.LIGHT_GRAY);
		toolBar.setFloatable(false);
		getContentPane().add(toolBar, BorderLayout.SOUTH);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBackground(Color.LIGHT_GRAY);
		horizontalStrut.setMaximumSize(new Dimension((550 / 2) - 75 - 20, 32767));
		toolBar.add(horizontalStrut);

		JButton OkButon = new JButton("OK");
		OkButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(FontPicker.whatFont);
				Main.consoleText += "Font = " + FontPicker.whatFont +"\n";
				FontPicker.okReturn = true;
				FontPicker.writeFont();
				dispose();
			}
		});
		OkButon.setBackground(Color.GRAY);
		OkButon.setMaximumSize(new Dimension(75, 23));
		OkButon.setHorizontalTextPosition(SwingConstants.LEFT);
		OkButon.setAlignmentX(Component.CENTER_ALIGNMENT);
		toolBar.add(OkButon);
		OkButon.setSize(200, 200);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setBackground(Color.LIGHT_GRAY);
		toolBar.add(horizontalStrut_1);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FontPicker.writeFont();
				dispose();
			}
		});
		btnCancel.setBackground(Color.GRAY);
		btnCancel.setMaximumSize(new Dimension(75, 23));
		btnCancel.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCancel.setAlignmentX(Component.CENTER_ALIGNMENT);
		toolBar.add(btnCancel);
		
		txtClickInThe = new JTextField();
		txtClickInThe.setHorizontalAlignment(SwingConstants.LEFT);
		txtClickInThe.setFont(UIManager.getFont("ColorChooser.font"));
		txtClickInThe.setToolTipText("Click in the preview to see preview new font");
		txtClickInThe.setBackground(Color.LIGHT_GRAY);
		txtClickInThe.setEditable(false);
		txtClickInThe.setText("Click in the preview to see preview new font. Or just select the new font");
		getContentPane().add(txtClickInThe, BorderLayout.CENTER);
		txtClickInThe.setColumns(10);
		pack();
		setSize(550, 300);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setResizable(false);
		setVisible(true);
	}

	private JMenuBar buildMenuBar() {
		JMenuBar bar = new JMenuBar();
		bar.setBackground(Color.LIGHT_GRAY);

		JMenu menu = new JMenu("Options");
		JMenuItem item = new JMenuItem("Info");
		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
					try {
						Desktop.getDesktop()
								.browse(new URI(
										"http://code.google.com/p/jfontchoosertoolbar/"));
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(JFontChooserWindow.this,
							"http://code.google.com/p/jfontchoosertoolbar/");
				}

			}
		});
		JMenuItem item2 = new JMenuItem("Exit");
		item2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

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
