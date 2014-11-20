package stokic_taschner.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import stokic_taschner.chat.MulticastChat;

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

	public MultiCastChatClient()	{

		instanceMultiCastChatClient = this;

		f_chat = new JFrame("Chat Client Menü");


		username = MultiCastChatMenu.getInstance().getTf_username().getText();
		adresse = MultiCastChatMenu.getInstance().getTf_login().getText().split(":");

		try {
			mChat = new MulticastChat(username, adresse[0], Integer.parseInt(adresse[1]));
		} catch (NumberFormatException e)	{
			JOptionPane.showMessageDialog(null, "Geben Sie bitte einen gueltigen Port an!");
			System.exit(1);
		} catch (ArrayIndexOutOfBoundsException ex) {
			JOptionPane.showMessageDialog(null, "Geben Sie bitte IP-Adresse:Port an!");
			System.exit(1);
		}

		if (MulticastChat.validIP(adresse[0]))	{
			if (Integer.parseInt(adresse[1]) >= 0 && Integer.parseInt(adresse[1]) <= 65536)	{
				if (username != null && !username.isEmpty() && username.length() >= 2)	{
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

	public void addChatContents()	{

		p_chat = new JPanel();
		p_input = new JPanel();

		tf_input = new JTextField();
		ta_output = new JTextArea();

		sp_output = new JScrollPane(ta_output, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		b_send = new JButton("Senden");
		b_send.addActionListener(this);

		this.setLayout(new BorderLayout());
		p_chat.setLayout(new BorderLayout());
		p_input.setLayout(new BorderLayout());

		p_chat.add(sp_output);
		p_input.add(tf_input);
		p_input.add(b_send, BorderLayout.EAST);

		this.add(p_chat, BorderLayout.CENTER);
		this.add(p_input, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton bSend = (JButton) e.getSource();

		if (bSend.getText().equals("Senden"))	{
			mChat.createMsg(this.tf_input.getText());
			mChat.send();
		}
	}



	public static MultiCastChatClient getInstance() {

		if(instanceMultiCastChatClient == null)
			instanceMultiCastChatClient = new MultiCastChatClient();

		return instanceMultiCastChatClient;
	}

	public JTextArea getTa_output() {

		return ta_output;
	}
}