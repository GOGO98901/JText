package gogo98901.net.text.editor;

import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;

public class testTab extends JPanel {
public testTab() {
ImageIcon icon = new ImageIcon("res/new.png");
JTabbedPane tabbedPane = new JTabbedPane();

Component panel1 = makeTextPanel("Java Tutorial");
tabbedPane.addTab("One", icon, panel1, "Does nothing");
tabbedPane.setSelectedIndex(0);

Component panel2 = makeTextPanel("Java, JavaScript,JSP");
tabbedPane.addTab("Two", icon, panel2, "Does twice as much nothing");

Component panel3 = makeTextPanel("Java, Servlet JSP Struts2.0 ");
tabbedPane.addTab("Three", icon, panel3, "Still something else");

Component panel4 = makeTextPanel("Java, Servlet JSP Struts2.0 HTML ");
tabbedPane.addTab("Four", icon, panel4, "Now click get more title");

//Add the tabbed pane to this panel.
setLayout(new GridLayout(1, 1)); 
add(tabbedPane);
}

private Component makeTextPanel(String text) {
JPanel panel = new JPanel(false);
JLabel lable = new JLabel(text);
lable.setHorizontalAlignment(JLabel.CENTER);
panel.setLayout(new GridLayout(1, 1));
panel.add(lable);
return panel;
}

public static void main(String[] args) {
JFrame frame = new JFrame("Jtabbed pane example");
frame.addWindowListener(new WindowAdapter() {
public void windowClosing(WindowEvent e){
System.exit(0);
}
});

frame.getContentPane().add(new testTab(), BorderLayout.CENTER);
frame.setSize(400, 250);
frame.setVisible(true);
}
}