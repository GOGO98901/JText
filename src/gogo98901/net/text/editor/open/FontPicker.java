package gogo98901.net.text.editor.open;

import gogo98901.net.text.editor.Main;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FontPicker {

	public static String dataCheck = "";

	public static String data1;
	public static String data2;
	public static String data3;
	public static int data2Int;
	public static int data3Int;

	public static String setFont;
	public static int setFontStyle;
	public static int setFontSize;

	public static boolean okReturn = false;

	public static Font viewFont = new java.awt.Font(setFont, setFontStyle,
			setFontSize);

	public static String whatFont = setFont + " | " + setFontSize + " | "
			+ setFontStyle;

	public static File fontTxt = new File("cfg/config/font.txt");

	public static void main(String[] args) {
		de.schimikowski.jfontchooser.demo.JFontChooserWindow.main(args);
	}

	public static void writeFont() {
		if (okReturn) {
			try {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(fontTxt), "UTF-8"));
				bw.write(setFont + "\n" + setFontStyle + "\n" + setFontStyle);
				bw.close();
				viewFont = new java.awt.Font(setFont, setFontStyle,
						setFontSize);
			} catch (IOException ioe) {
			}
		} else {
			System.out.println("File(" + fontTxt
					+ ") cant save because its not going to be updated");
			Main.consoleText += "File(" + fontTxt
					+ ") cant save because its not going to be updated";
		}
		okReturn = false;
	}

	public static void preFont() {
		if (fontTxt.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(fontTxt));
				String data;
				while ((data = br.readLine()) != null) {
					dataCheck = data;
				}
				br.close();
			} catch (IOException ioe) {
			}
			try {
				BufferedReader br = new BufferedReader(new FileReader(fontTxt));
				for (int i = 0; i < 2; i++)
					;
				data1 = br.readLine();
				for (int i = 1; i < 3; i++)
					;
				data2 = br.readLine();
				for (int i = 2; i < 4; i++)
					;
				data3 = br.readLine();
				br.close();
				data2Int = Integer.parseInt(data2);
				data2Int = setFontStyle;
				data3Int = Integer.parseInt(data3);
				data3Int = setFontSize;
				
				viewFont = new java.awt.Font(setFont, setFontStyle,
						setFontSize);
			} catch (IOException ioe) {
				System.out.println("Error Finding previous Font");
			}
		} else {
			defult();
		}
	}

	public static void defult() {
		setFont = "Arial";
		setFontStyle = 0;
		setFontSize = 12;

		System.out.println("Set Font to defult");
		Main.consoleText += "Set Font to defult\n";
	}
}
