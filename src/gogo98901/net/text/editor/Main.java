package gogo98901.net.text.editor;

import java.awt.Toolkit;
import java.io.File;

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
public static String systemName = System.getProperty("os.name");
public static String systemversion = System.getProperty("os.version");	

public static boolean running = false;
	public static void main(String[] args) {
		running = true;
		Images();
		Form GUI = new Form();
		GUI.setIconImage(Toolkit.getDefaultToolkit().getImage(IconImage));
		GUI.setName("JText by GOGO98901, Produced by SystemDragon");
		GUI.setTitle(title);
		GUI.setVisible(true);
	}
	public static void Images(){
		File icon = new File(IconImage);
		if(!icon.exists()){
			
		}
		File cross = new File(CrossImage);
		if(!cross.exists()){
			
		}
		File newI = new File(NewImage);
		if(!newI.exists()){
			
		}
		File open = new File(OpenImage);
		if(!open.exists()){
			
		}
		File quit = new File(QuitImage);
		if(!quit.exists()){
			
		}
		File save = new File(SaveImage);
		if(!save.exists()){
			
		}
		File saveAs = new File(SaveAsImage);
		if(!saveAs.exists()){
			
		}
		File tick = new File(TickImage);
		if(!tick.exists()){
			
		}
	}
	public static void error(){
		
	}
	public static void exit() {
		System.out.println("Exiting");
		System.exit(0);
	}

}
