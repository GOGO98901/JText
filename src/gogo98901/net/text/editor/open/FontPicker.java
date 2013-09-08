package gogo98901.net.text.editor.open;

import gogo98901.net.text.editor.Form;
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

	public static String setFont = "";
	public static int setFontStyle = 0;
	public static int setFontSize = 12;

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
				viewFont = new java.awt.Font(setFont, setFontStyle, setFontSize);
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
		try {
			BufferedReader br = new BufferedReader(new FileReader(fontTxt));
			System.out.println("Reading Font from File:");
			Main.consoleText += "Reading Font from File:\n";
			for (int i = 0; i < 1; i++) {
				data1 = br.readLine();
				System.out.println("--Font Name = '" + data1 + "'");
				Main.consoleText += "--Font Name = '" + data1 + "'\n";
			}
			for (int i = 1; i < 2; i++) {
				data2 = br.readLine();
				System.out.println("--Font Style = '" + data2 + "'");
				Main.consoleText += "--Font Style = '" + data2 + "'\n";
			}
			for (int i = 2; i < 3; i++) {
				data3 = br.readLine();
				System.out.println("--Font Size = '" + data3 + "'");
				Main.consoleText += "--Font Size = '" + data3 + "'\n";
			}

			br.close();
			setFont = data1;
			data2Int = Integer.parseInt(data2);
			setFontStyle = data2Int;
			data3Int = Integer.parseInt(data3);
			setFontSize = data3Int;
			System.out.println("Set Font to '" + setFont + "' With a size of '"
					+ setFontSize + "' And a style int of '" + setFontStyle + "'");
			Main.consoleText += "Set Font to '" + setFont + "' With a size of '"
					+ setFontSize + "' And a style int of '" + setFontStyle + "'\n";
			viewFont = new java.awt.Font(setFont, setFontStyle, setFontSize);
			Form.textArea.setFont(viewFont);
		} catch (IOException ioe) {
			System.out.println("Error Finding previous Font");
			ioe.printStackTrace();
			defult();
		}
		if (setFont == null) {

			System.out.println("ERROR --- SetFont is null");
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
