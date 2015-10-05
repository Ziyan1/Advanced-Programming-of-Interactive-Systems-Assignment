/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhotoBrowser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 *
 * @author XUAN Ziyan
 */
public class ImportListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        JFileChooser fChooser = new JFileChooser();
        fChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fChooser.showDialog(new JLabel(), "Import");
    }
}
