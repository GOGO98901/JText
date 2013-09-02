package gogo98901.net.text.editor;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main implements WindowListener {
	public static String title = "JText";
	public static String IconImage = "res/icon.png";
	public static String CrossImage = "res/cross.png";
	public static String NewImage = "res/new.png";
	public static String OpenImage = "res/open.png";
	public static String QuitImage = "res/quit.png";
	public static String SaveImage = "res/save.png";
	public static String SaveAsImage = "res/saveAs.png";
	public static String TickImage = "res/tick.png";
	public static String CutImage = "res/cut.png";
	public static String CopyImage = "res/copy.png";
	public static String PasteImage = "res/paste.png";
	public static String SelectAllImage = "res/selectAll.png";
	public static String DeleteImage = "res/delete.png";
	public static String InternetImage = "res/net.png";
	public static String HelpImage = "res/help.gif";
	public static String errorI = "There are no current errors";
	public static String systemName = System.getProperty("os.name");
	public static String systemversion = System.getProperty("os.version");

	static File icon = new File(IconImage);
	static File cross = new File(CrossImage);
	static File newI = new File(NewImage);
	static File open = new File(OpenImage);
	static File quit = new File(QuitImage);
	static File save = new File(SaveImage);
	static File saveAs = new File(SaveAsImage);
	static File tick = new File(TickImage);
	static File cut = new File(CutImage);
	static File copy = new File(CopyImage);
	static File paste = new File(PasteImage);
	static File delete = new File(DeleteImage);
	static File help = new File(HelpImage);
	static File internet = new File(InternetImage);

	static ImageIcon newIcon = new ImageIcon(NewImage);

	public static boolean running = false;
	public static boolean errorT = false;

	public static void main(String[] args) {
		running = true;
		System.out.println("Starting " + title);
		System.out.println("Operrating System : " + systemName + "| Version : "
				+ systemversion);
		Images();
		if (errorT) {
			JOptionPane
					.showMessageDialog(
							null,
							"These problems will not effect the app runing\nHowever will cause the app to look ugly");
		} else {
			System.out.println("There are no Errors");
		}
		Form GUI = new Form();
		GUI.setVisible(true);
		GUI.setIconImage(Toolkit.getDefaultToolkit().getImage(IconImage));
		GUI.setName("JText by GOGO98901, Produced by SystemDragon");
		GUI.setTitle(title);

	}

	public static void newPage() {
		Form GUI = new Form();
		GUI.setVisible(true);
		GUI.setIconImage(Toolkit.getDefaultToolkit().getImage(IconImage));
		GUI.setName("JText by GOGO98901, Produced by SystemDragon");
		GUI.setTitle(title);

	}

	public static void Images() {

		if (!icon.exists()) {
			errorI = IconImage;
			error();
		}

		if (!cross.exists()) {
			errorI = CrossImage;
			error();
		}

		if (!newI.exists()) {
			errorI = NewImage;
			error();
		}

		if (!open.exists()) {
			errorI = OpenImage;
			error();
		}

		if (!quit.exists()) {
			errorI = QuitImage;
			error();
		}

		if (!save.exists()) {
			errorI = SaveImage;
			error();
		}

		if (!saveAs.exists()) {
			errorI = SaveAsImage;
			error();
		}

		if (!tick.exists()) {
			errorI = TickImage;
			error();
		}

		if (!cut.exists()) {
			errorI = CutImage;
			error();
		}

		if (!copy.exists()) {
			errorI = CopyImage;
			error();
		}

		if (!paste.exists()) {
			errorI = PasteImage;
			error();
		}
		File selectAll = new File(SelectAllImage);
		if (!selectAll.exists()) {
			errorI = SelectAllImage;
			error();
		}

		if (!delete.exists()) {
			errorI = DeleteImage;
			error();
		}

		if (!help.exists()) {
			errorI = HelpImage;
			error();
		}

		if (!internet.exists()) {
			errorI = InternetImage;
			error();
		}
	}

	public static void error() {
		if (errorI != "There are no current errors") {
			JOptionPane.showMessageDialog(null, "Error\nCan't Find Image '"
					+ errorI + "'", "Error", 0);
			System.out.println("Error\nCan't Find Image '" + errorI + "'");
			errorT = true;
			errorI = "There are no current errors";
		} else {
			JOptionPane.showMessageDialog(null, errorI, "There are no Errors",
					0);

		}
	}

	public static void exit() {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure?",
				title, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.YES_OPTION) {
			System.out.println("Exiting");
			System.exit(0);
		}
	}

	public static void lookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Error ---> " + e);
		}
	}
	@Override
	public void windowClosing(WindowEvent e) {
		exit();
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}
}
