package stokic_taschner.gui;

import java.awt.*;
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
	
	JFrame f_menu;
	
	JPanel p_hallo, p_username, p_login, p_buttons;
	
	JLabel l_hallo, l_username, l_login;
	
	JTextField tf_username, tf_login;
	
	JButton b_connect, b_help;
	
	public MultiCastChatMenu() {
		
		f_menu = new JFrame("Chat Client Menü");
		
		this.addMenuContents();
		
		f_menu.setSize(320, 480);
		f_menu.setVisible(true);
		f_menu.setLocationRelativeTo(null);
		f_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addMenuContents() {
		
		p_hallo = new JPanel();
		l_hallo = new JLabel("Herzlich Willkommen");
		
		p_username = new JPanel();
		l_username = new JLabel("Benutzername");
		tf_username = new JTextField();
		
		p_login = new JPanel();
		l_login = new JLabel("IP:Port");
		tf_login = new JTextField();
		
		p_buttons = new JPanel();
		b_connect = new JButton("Connect");
		b_connect.addActionListener(this);
		
		b_help = new JButton("Help");
		b_help.addActionListener(this);
		
		BoxLayout lay_main = new BoxLayout(this, BoxLayout.Y_AXIS);
		BoxLayout lay_hallo = new BoxLayout(p_hallo, BoxLayout.LINE_AXIS);
		BoxLayout lay_username = new BoxLayout(p_username, BoxLayout.PAGE_AXIS);
		BoxLayout lay_login = new BoxLayout(p_login, BoxLayout.Y_AXIS);
		FlowLayout lay_buttons = new FlowLayout();
	
		p_hallo.setLayout(lay_hallo);
		p_username.setLayout(lay_username);
		p_login.setLayout(lay_login);
		p_buttons.setLayout(lay_buttons);
		this.setLayout(lay_main);
		
		
		this.add(new JPanel());
		p_hallo.add(l_hallo);
		
		this.add(new JPanel());
		p_username.add(l_username);
		p_username.add(tf_username);
		
		this.add(new JPanel());
		p_login.add(l_login);
		p_login.add(tf_login);
		
		this.add(new JPanel());
		p_buttons.add(b_connect);
		p_buttons.add(b_help);
		
		this.add(new JPanel());
		this.add(p_hallo);
		this.add(p_username);
		this.add(p_login);
		this.add(p_buttons);
		
		f_menu.add(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		
		if (b.getText().equals("Connect"))	{
			f_menu.setVisible(false);
			new MultiCastChatClient();
		}
		
		if (b.getText().equals("Help"))	{
			
			System.exit(0);
		}
	}
}