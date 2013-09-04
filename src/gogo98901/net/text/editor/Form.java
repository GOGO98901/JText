package gogo98901.net.text.editor;

import gogo98901.net.text.editor.open.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JScrollPane;
import java.awt.event.WindowFocusListener;
import javax.swing.JToolBar;

public class Form extends JFrame {
	private static final long serialVersionUID = 1L;

	public static String ClipBoardData = "";

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		if (Main.running) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					System.out.println("Running...");
					Main.consoleText += "Running..." + "\n";
				}
			});
		} else {
			Main.lookAndFeel();
			System.out.println("Unable to run!");
			System.out.println("Run through (Main.java/Mian.class)");
			JOptionPane.showOptionDialog(null, "Unable to run", "JText",
					JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE,
					UIManager.getIcon("OptionPane.errorIcon"), null, null);
			JOptionPane.showOptionDialog(null,
					"Attempting to run through Main.java", "JText",
					JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE,
					UIManager.getIcon("OptionPane.errorIcon"), null, null);
			Main.consoleText += "Unable to run\nAttempting to run through Main.java\n";
			Main.main(args);
		}
	}

	/**
	 * Create the frame.
	 */
	public Form() {
		setBackground(Color.LIGHT_GRAY);
		setFont(new Font("Arial", Font.BOLD, 12));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(720, 500);
		Main.lookAndFeel();
		setVisible(true);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.newPage();
				System.out.println("Starting New");
				Main.consoleText += "Starting New" + "\n";
			}
		});
		mntmNew.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmNew.setIcon(new ImageIcon(Main.NewImage));
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));
		mnFile.add(mntmNew);

		JMenuItem mntmOpen = new JMenuItem("Open...");
		mntmOpen.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmOpen.setIcon(new ImageIcon(Main.OpenImage));
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				InputEvent.CTRL_MASK));
		mnFile.add(mntmOpen);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmSave.setIcon(new ImageIcon(Main.SaveImage));
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK));
		mnFile.add(mntmSave);

		JMenuItem mntmSaveAs = new JMenuItem("Save As...");
		mntmSaveAs.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmSaveAs.setIcon(new ImageIcon(Main.SaveAsImage));
		mntmSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnFile.add(mntmSaveAs);

		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);

		JMenuItem mntmExit = new JMenuItem("Exit (close all)");
		mntmExit.setFont(new Font("Arial", Font.PLAIN, 13));
		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnEdit);

		JMenuItem mntmCut = new JMenuItem("Cut");
		mntmCut.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmCut.setIcon(new ImageIcon(Main.CutImage));
		mntmCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				InputEvent.CTRL_MASK));
		mnEdit.add(mntmCut);

		JMenuItem mntmCopy = new JMenuItem("Copy");
		mntmCopy.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmCopy.setIcon(new ImageIcon(Main.CopyImage));
		mntmCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				InputEvent.CTRL_MASK));
		mnEdit.add(mntmCopy);

		JMenuItem mntmPaste = new JMenuItem("Paste");
		mntmPaste.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmPaste.setIcon(new ImageIcon(Main.PasteImage));
		mntmPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				InputEvent.CTRL_MASK));
		mnEdit.add(mntmPaste);

		JSeparator separator_4 = new JSeparator();
		mnEdit.add(separator_4);

		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmDelete.setIcon(new ImageIcon(Main.DeleteImage));
		mntmDelete
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		mnEdit.add(mntmDelete);

		JSeparator separator_3 = new JSeparator();
		mnEdit.add(separator_3);

		JMenuItem mntmSelectAll = new JMenuItem("Select All");
		mntmSelectAll.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmSelectAll.setIcon(new ImageIcon(Main.SelectAllImage));
		mntmSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK));
		mnEdit.add(mntmSelectAll);

		JMenu mnFormat = new JMenu("Format");
		mnFormat.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnFormat);

		final JMenuItem mntmWordWrap = new JMenuItem("Word Wrap");
		mntmWordWrap.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmWordWrap.setIcon(new ImageIcon(Main.TickImage));
		mnFormat.add(mntmWordWrap);
		
		JMenuItem mntmFont = new JMenuItem("Font");
		mntmFont.setIcon(new ImageIcon(Main.FontImage));
		mntmFont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gogo98901.net.text.editor.open.FontF.main(null);
			}
		});
		mnFormat.add(mntmFont);

		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);

		JMenuItem mntmErrors = new JMenuItem("Errors");
		mntmErrors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.Images();
				Main.error();
			}
		});
		
		final JMenuItem mntmToolbar = new JMenuItem("Toolbar");
		mnView.add(mntmToolbar);
		mnView.add(mntmErrors);

		JMenuItem mntmConsole = new JMenuItem("Console");
		mntmConsole.setIcon(new ImageIcon(Main.ConsoleIconImage));
		mntmConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Console.main(null);
				Main.consoleText += "Opening Console" + "\n";
			}
		});
		mnView.add(mntmConsole);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnHelp);

		JMenuItem mntmViewHelp = new JMenuItem("View Help");
		mntmViewHelp.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmViewHelp.setIcon(new ImageIcon(Main.HelpImage));
		mnHelp.add(mntmViewHelp);

		JSeparator separator_2 = new JSeparator();
		mnHelp.add(separator_2);

		JMenuItem mntmAboutJtext = new JMenuItem("About " + Main.title);
		mntmAboutJtext.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmAboutJtext.setIcon(new ImageIcon(Main.InternetImage));

		mnHelp.add(mntmAboutJtext);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		final JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		toolBar.setFont(new Font("Arial", Font.PLAIN, 12));
		toolBar.setToolTipText("Tool Bar");
		
		JMenuItem mntmSave_1 = new JMenuItem("Save");
		mntmSave_1.setIcon(new ImageIcon(Main.SaveImage));
		toolBar.add(mntmSave_1);
		
		JMenuItem mntmSaveAs_1 = new JMenuItem("Save As");
		mntmSaveAs_1.setIcon(new ImageIcon(Main.SaveAsImage));
		toolBar.add(mntmSaveAs_1);
		
		JMenuItem mntmPaste_1 = new JMenuItem("Paste");
		mntmPaste_1.setIcon(new ImageIcon(Main.PasteImage));
		toolBar.add(mntmPaste_1);
		
		JMenuItem mntmCopy_1 = new JMenuItem("Copy");
		mntmCopy_1.setIcon(new ImageIcon(Main.CopyImage));
		toolBar.add(mntmCopy_1);
		
		JMenuItem mntmCut_1 = new JMenuItem("Cut");
		mntmCut_1.setIcon(new ImageIcon(Main.CutImage));
		toolBar.add(mntmCut_1);
		final File toolBarFile = new File("cfg/config/toolBarFile.txt");
		if(toolBarFile.exists()){
			toolBar.setVisible(true);
		}else{
			toolBar.setVisible(false);
		}
		
		
		final JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setToolTipText("Type here");
		textArea.setFont(new java.awt.Font(FontF.setFont,
				java.awt.Font.PLAIN, FontF.setFontSize));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(textArea);
		mntmCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClipBoardData = textArea.getSelectedText();
				StringSelection stringSelction = new StringSelection(
						ClipBoardData);
				Clipboard clipBoard = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				clipBoard.setContents(stringSelction, null);
				textArea.replaceSelection("");
			}
		});
		mntmCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClipBoardData = textArea.getSelectedText();
				StringSelection stringSelction = new StringSelection(
						ClipBoardData);
				Clipboard clipBoard = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				clipBoard.setContents(stringSelction, null);
			}
		});
		mntmPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append(ClipBoardData);
			}
		});
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.replaceSelection("");
			}
		});
		mntmSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.selectAll();
			}
		});
		mntmAboutJtext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String htmlFilePath = "cfg/JText.html";
				Main.consoleText += "Opening '" + htmlFilePath + "'" + "\n";
				System.out.println("Opening '" + htmlFilePath + "'");
				File htmlFile = new File(htmlFilePath);
				try {
					Desktop.getDesktop().browse(htmlFile.toURI());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		mntmExit.setIcon(new ImageIcon(Main.QuitImage));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.exit();
			}
		});
		final File wrap = new File("cfg/config/wordWrap.txt");
		mntmWordWrap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (wrap.exists()) {
					textArea.setLineWrap(false);
					mntmWordWrap.setIcon(new ImageIcon(Main.CrossImage));
					wrap.delete();
					System.out.println("Word Wrap Disabled");
					Main.consoleText += "Word Wrap Disabled" + "\n";
				} else {
					textArea.setLineWrap(true);
					mntmWordWrap.setIcon(new ImageIcon(Main.TickImage));
					try {
						wrap.createNewFile();
					} catch (IOException e1) {}
					System.out.println("Word Wrap Enabled");
					Main.consoleText += "Word Wrap Enabled" + "\n";
				}
			}
		});

		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser sdChooser = new JFileChooser();
				FileNameExtensionFilter filterTxt = new FileNameExtensionFilter("Text File", "txt");
				sdChooser.setFileFilter(filterTxt);
				int returnVal = sdChooser.showSaveDialog(null);
				
				String locationF = "";
				
				try{
					if(returnVal == JFileChooser.APPROVE_OPTION){
						File directory = sdChooser.getCurrentDirectory();
						String path = directory.getAbsolutePath();
						String fileName = sdChooser.getSelectedFile().getName();
						FileFilter cFilter = sdChooser.getFileFilter();
						if(cFilter == filterTxt){
							if(!fileName.contains(".txt")){
								fileName += ".txt";
							}
						}
						locationF = path + "\\" + fileName;
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(locationF), "UTF-8"));
						bw.write(textArea.getText());
						bw.close();
						System.out.println("Saved '" + locationF + "'");
						Main.consoleText += "Saved '" + locationF + "'\n";
						setTitle(locationF + " - " + Main.title);
							
					}
				}catch(IOException IOe2){
					System.out.println("Error trying to save this to '" + locationF + "':");
					System.out.println(textArea.getText());
					Main.consoleText += "Error trying to save this to '" + locationF + "':\n";
					Main.consoleText += textArea.getText() + "\n";
				}
				
			}
		});
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser opChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"Text File", "txt");
				opChooser.setFileFilter(filter);
				int returnVal = opChooser.showOpenDialog(null);
				File chosenFile = opChooser.getSelectedFile();

				try {
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						BufferedReader br = new BufferedReader(new FileReader(chosenFile));
						String data;
						while ((data = br.readLine()) != null) {
							textArea.append(data + "\n");
						}
						br.close();
					}
					System.out.println("Opened '" + chosenFile + "'");
					Main.consoleText += "Opened '" + chosenFile + "'";
					setTitle(chosenFile + " - " + Main.title);
				} catch (IOException IOe) {
					System.out.println("Error opening '" + chosenFile + "'");
					Main.consoleText += "Error opening '" + chosenFile + "'";
					JOptionPane.showMessageDialog(null, "Error opening '" + chosenFile + "'");
				}
			}
		});
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				System.out.println("Welcome Back - 'windowGainedFocus'");
				Main.consoleText += "Welcome Back - 'windowGainedFocus'\n";
				textArea.setFont(new java.awt.Font(FontF.setFont,
						java.awt.Font.PLAIN, FontF.setFontSize));
			}

			public void windowLostFocus(WindowEvent arg0) {
				System.out.println("Good bye - 'windowLostFocus'");
				Main.consoleText += "Good bye - 'windowLostFocus'\n";
			}
		});
		mntmToolbar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (toolBarFile.exists()) {
					mntmToolbar.setIcon(new ImageIcon(Main.CrossImage));
					toolBarFile.delete();
					System.out.println("Tool Bar Disabled");
					Main.consoleText += "Tool Bar Disabled" + "\n";
					toolBar.setVisible(false);
				} else {
					mntmToolbar.setIcon(new ImageIcon(Main.TickImage));
					try {
						toolBarFile.createNewFile();
					} catch (IOException e1) {}
					System.out.println("Tool Bar Enabled");
					Main.consoleText += "Tool Bar Enabled" + "\n";
					toolBar.setVisible(true);
				}
				
			}
		});
		
		mntmCut_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClipBoardData = textArea.getSelectedText();
				StringSelection stringSelction = new StringSelection(
						ClipBoardData);
				Clipboard clipBoard = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				clipBoard.setContents(stringSelction, null);
				textArea.replaceSelection("");
			}
		});
		mntmCopy_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClipBoardData = textArea.getSelectedText();
				StringSelection stringSelction = new StringSelection(
						ClipBoardData);
				Clipboard clipBoard = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				clipBoard.setContents(stringSelction, null);
			}
		});
		mntmSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//save area
			}
		});
		mntmPaste_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append(ClipBoardData);
			}
		});
		if (wrap.exists()) {
			textArea.setLineWrap(true);
			mntmWordWrap.setIcon(new ImageIcon(Main.TickImage));
			Main.consoleText += "Word Wrap is Enabled" + "\n";
			System.out.println("Word Wrap is Enabled");
		} else {
			textArea.setLineWrap(false);
			mntmWordWrap.setIcon(new ImageIcon(Main.CrossImage));
			Main.consoleText += "Word Wrap is Disabled" + "\n";
			System.out.println("Word Wrap is Disabled");
		}
	}
}