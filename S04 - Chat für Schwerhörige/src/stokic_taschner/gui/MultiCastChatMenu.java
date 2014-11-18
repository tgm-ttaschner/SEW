package stokic_taschner.gui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
	
	JFrame f = new JFrame();
	
	public MultiCastChatMenu() {
		
		
		
		this.addContents();
		
		f.setTitle("Chat Client Menü");
		
		f.setSize(320, 480);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(this);
	}
	
	public void addContents() {
		
		JLabel l_hallo = new JLabel("Herzlich Willkommen");
		
		JLabel l_username = new JLabel("Benutzername");
		JTextField tf_username = new JTextField();
		
		JLabel l_login = new JLabel("IP:Port");
		JTextField tf_login = new JTextField();
		
		JButton b_connect = new JButton("Connect");
		b_connect.addActionListener(this);
		
		JButton b_help = new JButton("Help");
		b_help.addActionListener(this);
		
		
		BoxLayout l = new BoxLayout(this, BoxLayout.Y_AXIS);
		
		
		
		this.setLayout(l);
		
		this.add(l_hallo);
		this.add(new JPanel());
		this.add(l_username);
		this.add(tf_username);
		this.add(new JPanel());
		this.add(l_login);
		this.add(tf_login);
		this.add(new JPanel());
		
		this.add(b_connect);
		this.add(b_help);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		
		
		if (b.getText().equals("Connect"))	{
			f.setVisible(false);
			System.exit(0);
		}
		
		if (b.getText().equals("Help"))	{
			
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		MultiCastChatMenu m = new MultiCastChatMenu();
	}
}