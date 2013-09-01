package gogo98901.net.text.editor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Form extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		if (Main.running) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Form form = new Form();
						form.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}else{
			System.out.println("Unable to run!");
			System.out.println("Run through (Main.java/Mian.class)");
			Main.exit();
		}
	}

	/**
	 * Create the frame.
	 */
	public Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(720, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
	}

}
