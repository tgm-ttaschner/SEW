package stokic_taschner.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import stokic_taschner.chat.*;

/**
 * @author Stefan Stokic
 * @author Thomas Taschner
 * @version 20.11.2014
 * 
 * Die Klasse repraesentiert einen Chat Client.
 * Die Ausgabe der Nachrichten erfolgt in einem großen Ausgabepanel oben.
 * Fuer die Eingabe stehen unten ein Textfeld und ein Senden Knopf zur Verfuegung.
 */
@SuppressWarnings("serial")
public class MultiCastChatClient extends JPanel implements ActionListener {

	private JFrame f_chat;
	private JPanel p_chat, p_input;
	private JScrollPane sp_output;
	private JTextField tf_input;
	private JTextArea ta_output;
	private JButton b_send;

	private MulticastChat mChat;
	private static MultiCastChatClient instanceMultiCastChatClient = null;

	private String username;
	private String[] adresse;

	/**
	 * Konstruktor, der das JFrame initialisiert und die Benutzereingaben ueberprueft und der Chatvorgang gestartet.
	 * Bei fehlerhaften Eingaben wird eine entsprechende Fehlermeldung ausgegeben.
	 */
	public MultiCastChatClient()	{

		instanceMultiCastChatClient = this;

		f_chat = new JFrame("Chat Client Menü");

		
		username = MultiCastChatMenu.getInstance().getTf_username().getText();
		adresse = MultiCastChatMenu.getInstance().getTf_login().getText().split(":");
		
		// Initialisieren des Sockets mit den eingegebenen Daten
		try {
			mChat = new MulticastChat(username, adresse[0], Integer.parseInt(adresse[1]));
		} catch (NumberFormatException e)	{
			JOptionPane.showMessageDialog(null, "Geben Sie bitte einen gueltigen Port an!");
			System.exit(1);
		} catch (ArrayIndexOutOfBoundsException ex) {
			JOptionPane.showMessageDialog(null, "Geben Sie bitte IP-Adresse:Port an!");
			System.exit(1);
		}
		
		// Check, ob der String eine gueltige IP-Adresse beinhaltet
		if (MulticastChat.validIP(adresse[0]))	{
			
			// Check, ob ein Port zwischen 0 und 65536 eingegeben wurde
			if (Integer.parseInt(adresse[1]) >= 0 && Integer.parseInt(adresse[1]) <= 65536)	{
				
				// Check, ob der Benutzername nicht leer und laenger, als 2 Zeichen ist
				if (username != null && !username.isEmpty() && username.length() >= 2)	{
					
					// Starten des ChatListeners
					mChat.startChat();
				} else {
					JOptionPane.showMessageDialog(null, "Geben Sie bitte einen laengeren Namen (2 Zeichen oder mehr) ein!");
					System.exit(1);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Geben Sie bitte einen gueltigen Port an! (0-65536)");
				System.exit(1);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Geben Sie bitte eine gueltige IP-Adresse ein!");
			System.exit(1);
		}

		f_chat.addWindowListener(new GUIWindowListener());
		this.addChatContents();

		f_chat.setSize(640, 480);
		f_chat.setVisible(true);
		f_chat.setLocationRelativeTo(null);
		f_chat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f_chat.add(this);

	}

	/**
	 * GUI Elemente werden mir selber (JPanel) hinzugefuegt
	 */
	public void addChatContents()	{
		
		// Initialisierung der Elemente
		p_chat = new JPanel();
		p_input = new JPanel();

		tf_input = new JTextField();
		ta_output = new JTextArea();

		sp_output = new JScrollPane(ta_output, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		b_send = new JButton("Senden");
		b_send.addActionListener(this);
		
		// Setzen der Layouts der JPanel
		this.setLayout(new BorderLayout());
		p_chat.setLayout(new BorderLayout());
		p_input.setLayout(new BorderLayout());
		
		// // Hinzufuegen der Elemente
		p_chat.add(sp_output);
		p_input.add(tf_input);
		p_input.add(b_send, BorderLayout.EAST);

		this.add(p_chat, BorderLayout.CENTER);
		this.add(p_input, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton bSend = (JButton) e.getSource();
		
		// Sobald Senden gedrueckt wurde, wird der eingegebe Text des Eingabefeldes dekoriert und an den Socket gesendet
		if (bSend.getText().equals("Senden"))	{
			
			/** CapsedMessage - Anfang */
//			Message chatMessage = new ChatMessage();
//			CapsedMessage capsedMessage = new CapsedMessage(chatMessage);
//			
//			chatMessage.setMessage(tf_input.getText());
//			
//			mChat.createMsg(capsedMessage.createMessage());
			/** CapsedMessage - Ende */
			
			/** BadwordFilteredMessage - Anfang */
//			Message chatMessage = new ChatMessage();
//			BadwordFilteredMessage filteredMessage = new BadwordFilteredMessage(chatMessage);
//			
//			chatMessage.setMessage(tf_input.getText());
//			
//			mChat.createMsg(filteredMessage.createMessage());
			/** BadwordFilteredMessage - Ende */
			
			mChat.createMsg(tf_input.getText());
			mChat.send();
		}
	}

	/**
	 * @return eine Instanz von MultiCastChatClient
	 */
	public static MultiCastChatClient getInstance() {

		if(instanceMultiCastChatClient == null)
			instanceMultiCastChatClient = new MultiCastChatClient();

		return instanceMultiCastChatClient;
	}

	/**
	 * @return das Textfeld, in dem der Output ausgegeben wird
	 */
	public JTextArea getTa_output() {

		return ta_output;
	}
}