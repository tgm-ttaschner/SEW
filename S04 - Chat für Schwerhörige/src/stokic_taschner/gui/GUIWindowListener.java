package stokic_taschner.gui;
import java.awt.event.*;

import stokic_taschner.chat.MulticastChat;

public class GUIWindowListener implements WindowListener {

	@Override
	public void windowActivated(WindowEvent arg0) {}

	@Override
	public void windowClosed(WindowEvent arg0) {


		System.exit(0);
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		
		MulticastChat.getInstance().multicastLeaveGroup();
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {}

	@Override
	public void windowDeiconified(WindowEvent arg0) {}

	@Override
	public void windowIconified(WindowEvent arg0) {}

	@Override
	public void windowOpened(WindowEvent arg0) {}
}