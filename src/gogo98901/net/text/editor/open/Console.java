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
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JTextPane;

public class Console extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static String title = Main.title + " Console";
	public static String titleBar = "#------------------- " + title
			+ " -------------------#";

	public static void main(String[] args) {
		Console frame = new Console();
		if(frame.isEnabled()){
			System.out.println("Console is 'Enabled'");
			Main.consoleText += "Console is 'Enabled' \n";
		}
	}

	/**
	 * Create the frame.
	 */
	public Console() {
		setBackground(Color.WHITE);
		setType(Type.POPUP);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Main.lookAndFeel();
		setSize(400, 350);
		setTitle("");
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.ConsoleImage));
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextPane txtpnJtextConsole = new JTextPane();
		contentPane.add(txtpnJtextConsole, BorderLayout.NORTH);
		txtpnJtextConsole.setEditable(false);
		txtpnJtextConsole.setToolTipText("JTEXT CONSOLE");
		txtpnJtextConsole.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtpnJtextConsole.setBackground(Color.DARK_GRAY);
		txtpnJtextConsole.setForeground(Color.WHITE);
		txtpnJtextConsole.setText("Loading");

		txtpnJtextConsole.setText(titleBar);

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
addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent arg0) {
				ConsoleTextArea.setText(Main.consoleText);
			}
		});
		ConsoleTextArea.append(Main.consoleText);
		setVisible(true);
		String oldText = Main.consoleText;
		if (isEnabled()) {
			//while (true) {
				if (oldText != Main.consoleText) {
					ConsoleTextArea.append(Main.consoleText);
				}
			//}
		}
	}
	public static void logConsole(){
		
	}
	
}
