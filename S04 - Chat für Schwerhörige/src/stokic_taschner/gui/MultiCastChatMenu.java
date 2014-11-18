package stokic_taschner.gui;

import java.awt.event.*;
import javax.swing.*;

/**
 * @author Thomas Taschner
 * @version 18112014
 * 
 * Die Klasse dient zur grafischen Darstellung eines Menüs des ChatClient. Hier kann der Benutzer einen Benutzernamen, IP-Adresse bzw. URL und einen Port angeben.
 * Es steht ebenfalls eine Hilfe zur Verfügung, die über einen Klick auf den entsprechenden Button aufgerufen werden kann.
 */
@SuppressWarnings("serial")
public class MultiCastChatMenu extends JPanel implements ActionListener {
	
	public MultiCastChatMenu() {
		
		JFrame f = new JFrame();
		
		this.addContents();
		
		f.setTitle("Chat Client Menü");
		
		f.setSize(320, 480);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(this);
	}
	
	public void addContents() {
		JButton abc = new JButton("abc");
		abc.addActionListener(this);
		
		this.add(abc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		
		if (b.getText().equals("abc"))	{
			System.out.println(b.getText());
		}
	}
	
	public static void main(String[] args) {
		MultiCastChatMenu m = new MultiCastChatMenu();
	}
}