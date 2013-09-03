package gogo98901.net.text.editor.open;

import gogo98901.net.text.editor.Main;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.VetoableChangeListener;

public class Console extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static String title = "JText Console";
	public static String titleBar = "#-------------------" + title
			+ "------------------#";

	public static void main(String[] args) {
		Console frame = new Console();
	}

	/**
	 * Create the frame.
	 */
	public Console() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Main.lookAndFeel();
		setSize(403, 350);
		setTitle(title);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.ConsoleImage));
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		final JTextArea ConsoleTextArea = new JTextArea();
		ConsoleTextArea.addVetoableChangeListener(new VetoableChangeListener() {
			public void vetoableChange(PropertyChangeEvent arg0) {
				ConsoleTextArea.setText(Main.consoleText);
			}
		});
		ConsoleTextArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				ConsoleTextArea.setText(Main.consoleText);
			}
			@Override
			public void focusLost(FocusEvent e) {
				ConsoleTextArea.setText(Main.consoleText);
			}
		});
		ConsoleTextArea.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e3) {
				ConsoleTextArea.setText(Main.consoleText);
			}
		});
		ConsoleTextArea.setEditable(false);
		ConsoleTextArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
		ConsoleTextArea.setForeground(Color.WHITE);
		ConsoleTextArea.setBackground(Color.BLACK);
		scrollPane.setViewportView(ConsoleTextArea);

		ConsoleTextArea.setText(titleBar);
		ConsoleTextArea.append(Main.consoleText);
		setVisible(true);
		String oldText = Main.consoleText;
		if (isActive()) {
			while (true) {
				if (oldText != Main.consoleText) {
					ConsoleTextArea.append(Main.consoleText);
				}
			}
		}
	}
	public static void update(){
		
	}
	
}