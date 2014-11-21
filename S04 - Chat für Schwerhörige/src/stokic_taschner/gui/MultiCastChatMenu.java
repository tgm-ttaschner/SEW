package stokic_taschner.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * @author Stefan Stokic
 * @author Thomas Taschner
 * @version 18.11.2014
 * 
 * Die Klasse dient zur grafischen Darstellung eines Menues des ChatClient. Hier kann der Benutzer einen Benutzernamen, IP-Adresse bzw. URL und einen Port angeben.
 */
@SuppressWarnings("serial")
public class MultiCastChatMenu extends JPanel implements ActionListener {

	private JFrame f_menu;
	private JPanel p_hallo, p_username, p_login, p_buttons;
	private JLabel l_hallo, l_username, l_login;
	private JTextField tf_username, tf_login;
	private JButton b_connect, b_help;
	private JCheckBox cb_censor;

	private static MultiCastChatMenu instanceMultiCastChatMenu = null;

	/**
	 * Konstruktor, in dem die Instanz der Klasse initialisiert und das JFrame initialsiert und sichtbar gemacht wird
	 */
	public MultiCastChatMenu() {

		instanceMultiCastChatMenu = this;

		f_menu = new JFrame("Chat Client Menü");

		this.addMenuContents();

		f_menu.setSize(320, 480);
		f_menu.setVisible(true);
		f_menu.setResizable(false);
		f_menu.setLocationRelativeTo(null);
		f_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * GUI Elemente werden mir selber (JPanel) hinzugefuegt
	 */
	public void addMenuContents() {

		// Initialisierung der Elemente
		p_hallo = new JPanel();
		l_hallo = new JLabel("Herzlich Willkommen");

		p_username = new JPanel();
		l_username = new JLabel("Benutzername");
		tf_username = new JTextField();

		p_login = new JPanel();
		l_login = new JLabel("IP:Port");
		tf_login = new JTextField();

		p_buttons = new JPanel();
		b_help = new JButton("Help");
		b_connect = new JButton("Connect");
		cb_censor = new JCheckBox("Zensieren aus");
		b_help.addActionListener(this);
		b_connect.addActionListener(this);
		cb_censor.addActionListener(this);

		// Initialisieren der Layouts der JPanel
		BoxLayout lay_main = new BoxLayout(this, BoxLayout.Y_AXIS);
		BoxLayout lay_hallo = new BoxLayout(p_hallo, BoxLayout.LINE_AXIS);
		BoxLayout lay_username = new BoxLayout(p_username, BoxLayout.PAGE_AXIS);
		BoxLayout lay_login = new BoxLayout(p_login, BoxLayout.Y_AXIS);
		FlowLayout lay_buttons = new FlowLayout();

		// Setzen der Layouts der JPanel
		p_hallo.setLayout(lay_hallo);
		p_username.setLayout(lay_username);
		p_login.setLayout(lay_login);
		p_buttons.setLayout(lay_buttons);
		this.setLayout(lay_main);

		// Hinzufuegen der Elemente
		this.add(new JPanel());
		p_hallo.add(l_hallo);

		this.add(new JPanel());
		p_username.add(l_username);
		p_username.add(tf_username);

		this.add(new JPanel());
		p_login.add(l_login);
		p_login.add(tf_login);

		this.add(new JPanel());
		p_buttons.add(b_help);
		p_buttons.add(b_connect);
		p_buttons.add(cb_censor);

		this.add(new JPanel());
		this.add(p_hallo);
		this.add(p_username);
		this.add(p_login);
		this.add(p_buttons);

		f_menu.add(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(b_connect) || e.getSource().equals(b_help))	{
			JButton b = (JButton) e.getSource();

			// Hauptmenue wird auf Knopfdruck unsichtbar und ein Chatfenster ploppt auf
			if (b.getText().equals("Connect"))	{
				f_menu.setVisible(false);
				new MultiCastChatClient();
			}
			
			// JOptionFrame mit zusaetzlicher Hilfe wird angezeigt
			if (b.getText().equals("Help"))	{
				JOptionPane.showMessageDialog(f_menu, "Herzlich Willkommen zur Chat Client Hilfe:\n"
						+ "Geben Sie im 1. Feld den Namen ein, der im Chatfenster erscheinen soll.\n"
						+ "Geben Sie im 2. Feld die IP-Adresse des Multicastnetzes (224.0.0.0 - 239.255.255.255)\n"
						+ "und eine, mit einem : getrennte, gueltige, im Idealfall auch freie, Portnummer (0 - 65535) an\n"
						+ "Ein Beispielaufruf koente so aussehen:\n"
						+ "max549876\n"
						+ "224.1.2.3:1234");
			}
		}
		
		// Text wird geaendert, sobald der Status der Checkbox geaendert wurde
		if (e.getSource().equals(cb_censor))	{
			JCheckBox cb = (JCheckBox) e.getSource();

			if (cb.isSelected())	{
				cb_censor.setText("Zensur an");
			} else	{
				cb_censor.setText("Zensur aus");
			}
		}
	}

	/**
	 * @return JTextField, in welches der Benutzername eingegeben wird
	 */
	public JTextField getTf_username() {
		return tf_username;
	}

	/**
	 * @return JTextField, in welches der die IP-Adresse und der Port eingegeben wird
	 */
	public JTextField getTf_login() {
		return tf_login;
	}

	/**
	 * @return die Checkbox, dank der entschieden wird, ob zensiert werden soll oder nicht
	 */
	public JCheckBox getCb_censor() {
		return cb_censor;
	}

	/**
	 * @param cb_censor die Checkbox, dank der entschieden wird, ob zensiert werden soll oder nicht
	 */
	public void setCb_censor(JCheckBox cb_censor) {
		this.cb_censor = cb_censor;
	}

	/**
	 * @return Instanz von MultiCastChatMenu
	 */
	public static MultiCastChatMenu getInstance() {

		if(instanceMultiCastChatMenu == null)
			instanceMultiCastChatMenu = new MultiCastChatMenu();

		return instanceMultiCastChatMenu;
	}
}