package stokic_taschner.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MultiCastChatClient extends JPanel implements ActionListener	{

	JFrame f_chat;

	JPanel p_chat, p_input;

	JScrollPane sp_output;

	JTextField tf_input;

	JTextArea ta_output;

	JButton b_send;

	public MultiCastChatClient()	{

		f_chat = new JFrame("Chat Client Menü");

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
		tf_input.setText("ewtpoughoizghogrsfi");

		ta_output = new JTextArea("reiwgffdsildsfh");
		
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
		JButton b = (JButton) e.getSource();

		if (b.getText().equals("Senden"))	{
			ta_output.append(tf_input.getText() + "\n");
		}
	}
}