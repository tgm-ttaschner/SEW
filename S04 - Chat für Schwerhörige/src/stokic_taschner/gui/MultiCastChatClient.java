package stokic_taschner.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MultiCastChatClient extends JPanel implements ActionListener	{

	JFrame f_chat;

	JPanel p_chat, p_input;

	JTextField tf_input;
	
	JTextArea ta_output;

	JButton b_send;

	public MultiCastChatClient()	{

		f_chat = new JFrame("Chat Client Menü");

		this.addChatContents();

		f_chat.setSize(320, 480);
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
		
		b_send = new JButton("Senden");
		
		GridBagLayout lay_client = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		lay_client.addLayoutComponent(ta_output, c);
		
		this.setLayout(new BorderLayout());
		p_chat.setLayout(new BorderLayout());
		p_input.setLayout(new BorderLayout());
		
		p_chat.add(ta_output);
		
		p_input.add(tf_input, BorderLayout.WEST);
		p_input.add(b_send);
		
		this.add(p_chat, BorderLayout.CENTER);
		this.add(p_input, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();

		if (b.getText().equals("Senden"))	{
			// Text von JTextField an Socket senden und im Fenster anzeigen lassen
		}
	}
}