package stokic_taschner.chat;

import java.awt.event.*;

import stokic_taschner.gui.MultiCastChatClient;

/**
 * @author Thomas Taschner
 * @version 21.11.2014
 * 
 * Diese Klasse implement den KeyListener, dank dem in der GUI Nachrichten auch per Druck auf Enter getaetigt werden koennen.
 *
 */
public class EnterListener implements KeyListener	{

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == '\n')	{
			MultiCastChatClient.getInstance().getB_send().doClick();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}