package gogo98901.net.text.editor.open;

import gogo98901.net.text.editor.Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Font extends JFrame {

	private JPanel contentPane;
	public static String setFont = "Arial";
	public static int setFontSize = 13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Font frame = new Font();
					frame.setTitle("Font");
					frame.setResizable(false);

					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Font() {
		setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
		setAlwaysOnTop(true);
		setSize(550, 340);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main.lookAndFeel();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		final Choice choice = new Choice();

		choice.setBackground(Color.WHITE);
		choice.setForeground(Color.BLACK);
		choice.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
		choice.addItem("Arial");
		choice.addItem("Monospaced");
		choice.addItem("Tahoma");
		choice.addItem("Font 4");
		contentPane.add(choice, BorderLayout.NORTH);
		
		final JTextArea txtrThisIsSample = new JTextArea();
		txtrThisIsSample.setFont(new java.awt.Font(setFont,
				java.awt.Font.PLAIN, 13));
		txtrThisIsSample.setEditable(false);
		txtrThisIsSample.setText("This is sample text\r\nfor");
		contentPane.add(txtrThisIsSample, BorderLayout.WEST);
		
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (choice.getSelectedItem() == "Arial") {
					setFont = "Arial";
					txtrThisIsSample.setFont(new java.awt.Font(setFont,
							java.awt.Font.PLAIN, setFontSize));
				}
				if (choice.getSelectedItem() == "Monospaced") {
					setFont = "Monospaced";
					txtrThisIsSample.setFont(new java.awt.Font(setFont,
							java.awt.Font.PLAIN, setFontSize));
				}
				if (choice.getSelectedItem() == "Tahoma") {
					setFont = "Tahoma";
					txtrThisIsSample.setFont(new java.awt.Font(setFont,
							java.awt.Font.PLAIN, setFontSize));
				}
				if (choice.getSelectedItem() == "Arial") {
					setFont = "Arial";
					txtrThisIsSample.setFont(new java.awt.Font(setFont,
							java.awt.Font.PLAIN, setFontSize));
				}
			}
		});
	}

}
