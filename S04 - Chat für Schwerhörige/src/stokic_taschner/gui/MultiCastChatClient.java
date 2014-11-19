package stokic_taschner.gui;

import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MultiCastChatClient extends JPanel implements ActionListener	{

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		
		if (b.getText().equals("Senden"))	{
			// Text von JTextField an Socket senden und im Fenster anzeigen lassen
		}
	}
	
}
