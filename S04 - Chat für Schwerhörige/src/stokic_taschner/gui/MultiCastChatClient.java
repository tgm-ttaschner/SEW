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

	public MultiCastChatClient()	{

		instanceMultiCastChatClient = this;

		f_chat = new JFrame("Chat Client Menü");


		String username = MultiCastChatMenu.getInstance().getTf_username().getText();
		String[] adresse = MultiCastChatMenu.getInstance().getTf_login().getText().split(":");

		mChat = new MulticastChat(username, adresse[0], Integer.parseInt(adresse[1]));
		mChat.startChat();


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