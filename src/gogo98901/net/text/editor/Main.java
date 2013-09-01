package gogo98901.net.text.editor;

import java.awt.Toolkit;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main {
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

	public static boolean running = false;
	public static boolean errorT = false;

	public static void main(String[] args) {
		running = true;
		System.out.println("Operrating System : " + systemName + "| Version : " + systemversion);
		Images();
		if(errorT){
			JOptionPane.showMessageDialog(null, "These problems will not effect the app runing\nHowever will cause the app to look ugly");
		}
		Form GUI = new Form();
		GUI.setIconImage(Toolkit.getDefaultToolkit().getImage(IconImage));
		GUI.setName("JText by GOGO98901, Produced by SystemDragon");
		GUI.setTitle(title);
		GUI.setVisible(true);
	}

	public static void Images() {
		File icon = new File(IconImage);
		if (!icon.exists()) {
			errorI = IconImage;
			error();
		}
		File cross = new File(CrossImage);
		if (!cross.exists()) {
			errorI = CrossImage;
			error();
		}
		File newI = new File(NewImage);
		if (!newI.exists()) {
			errorI = NewImage;
			error();
		}
		File open = new File(OpenImage);
		if (!open.exists()) {
			errorI = OpenImage;
			error();
		}
		File quit = new File(QuitImage);
		if (!quit.exists()) {
			errorI = QuitImage;
			error();
		}
		File save = new File(SaveImage);
		if (!save.exists()) {
			errorI = SaveImage;
			error();
		}
		File saveAs = new File(SaveAsImage);
		if (!saveAs.exists()) {
			errorI = SaveAsImage;
			error();
		}
		File tick = new File(TickImage);
		if (!tick.exists()) {
			errorI = TickImage;
			error();
		}
		File cut = new File(CutImage);
		if (!cut.exists()) {
			errorI = CutImage;
			error();
		}
		File copy = new File(CopyImage);
		if (!copy.exists()) {
			errorI = CopyImage;
			error();
		}
		File paste = new File(PasteImage);
		if (!paste.exists()) {
			errorI = PasteImage;
			error();
		}
		File selectAll = new File(SelectAllImage);
		if (!selectAll.exists()) {
			errorI = SelectAllImage;
			error();
		}
		File delete = new File(DeleteImage);
		if (!delete.exists()) {
			errorI = DeleteImage;
			error();
		}
		File help = new File(HelpImage);
		if (!help.exists()) {
			errorI = HelpImage;
			error();
		}
		File internet = new File(InternetImage);
		if (!internet.exists()) {
			errorI = InternetImage;
			error();
		}
	}

	public static void error() {
		JOptionPane.showMessageDialog(null, "Error\nCan't Find Image '" + errorI+"'", null, 0);
		errorT = true;
		errorI = "There are no current errors";
	}

	public static void exit() {
		System.out.println("Exiting");
		System.exit(0);
	}

	public static void lookAndFeel() {
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){
			System.out.println("Error ---> " + e);
		}
	}
}
