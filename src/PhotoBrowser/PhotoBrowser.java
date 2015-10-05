/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhotoBrowser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 *
 * @author XUAN Ziyan
 */
public class PhotoBrowser {

    /**
     * @param args the command line arguments
     */
    JFrame frame = createFrame();
    Container container = frame.getContentPane();

    private void launchFrame() {

        addMenu();
        addToolBar();
        addPanel();

    }

    private JFrame createFrame() {
        frame = new JFrame("Photo Brower");
        frame.setSize(800, 500);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
        frame.setMinimumSize(new Dimension(220, 180));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        return frame;
    }

    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = fileMenu();
        menuBar.add(menu);
        menu = viewMenu();
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

    }

    private JMenu fileMenu() {
        JMenu menu = new JMenu("File");
        JMenuItem myItemImport = new JMenuItem("Import");
        menu.add(myItemImport);
        JMenuItem myItemDel = new JMenuItem("Delete");
        myItemDel.setEnabled(false);
        menu.add(myItemDel);
        menu.addSeparator();
        JMenuItem myItemQuit = new JMenuItem("Quit");
        menu.add(myItemQuit);
        myItemImport.addActionListener(new ImportListener());
        myItemQuit.addActionListener(new ExitListener());
        return menu;
    }

    private JMenu viewMenu() {
        JMenu myMenu = new JMenu("View");
        ButtonGroup myGroup = new ButtonGroup();
        JRadioButtonMenuItem myItem1, myItem2, myItem3;
        myItem1 = new JRadioButtonMenuItem("Photo viewer");
        myItem1.setSelected(true);
        myItem2 = new JRadioButtonMenuItem("Browser");
        myItem3 = new JRadioButtonMenuItem("Split mode");

        myGroup.add(myItem1);
        myMenu.add(myItem1);

        myGroup.add(myItem2);
        myMenu.add(myItem2);

        myGroup.add(myItem3);
        myMenu.add(myItem3);

        JLabel statuLab = new JLabel("statu: Photo viewer");
        container.add(statuLab, BorderLayout.SOUTH);

        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButtonMenuItem radio = (JRadioButtonMenuItem) e.getSource();
                if (radio == myItem1) {
                    statuLab.setText("statu: Photo viewer");
                } else if (radio == myItem2) {
                    statuLab.setText("statu: Browser viewer");
                } else {
                    statuLab.setText("statu: Split mode viewer");
                }
            }
        };

        myItem1.addActionListener(al);
        myItem2.addActionListener(al);
        myItem3.addActionListener(al);
        return myMenu;
    }

    private void addToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        JToggleButton btn1 = new JToggleButton("Family");
        JToggleButton btn2 = new JToggleButton("Vacation");
        JToggleButton btn3 = new JToggleButton("School");

        toolBar.add(btn1);
        toolBar.add(btn2);
        toolBar.add(btn3);
        container.add(toolBar, BorderLayout.NORTH);
    }

    private void addPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.lightGray);
        container.add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {

        (new PhotoBrowser()).launchFrame();

    }

}
