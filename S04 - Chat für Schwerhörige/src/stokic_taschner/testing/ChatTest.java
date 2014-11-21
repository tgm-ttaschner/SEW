package stokic_taschner.testing;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.*;

import stokic_taschner.chat.MulticastChat;
import stokic_taschner.gui.MultiCastChatMenu;

/**
 * @author Thomas Taschner
 * @version 20.11.2014
 * 
 * In dieser Klasse wird unser Chatprogramm getestet
 *
 */
public class ChatTest {
	
	MulticastChat m;
	
	@Before
	public void setup() {
		//MulticastChat.getInstance().setupChatConnection("tt", "224.1.2.3", 8888);
		m = new MulticastChat("tt", "224.1.2.3", 8888);
	}

	@Test
	public void testgetUsername() {
		assertEquals("tt", m.getUsername());
	}
	
	@Test
	public void testsetUsername() {
		m.setUsername("herbert");
		assertEquals("herbert", m.getUsername());
	}
	
	@Test
	public void testgetHostname() {
		assertEquals("224.1.2.3", m.getHostname());
	}
	
	@Test
	public void testsetHostname() {
		m.setHostname("234.5.6.7");
		assertEquals("234.5.6.7", m.getHostname());
	}
	
	@Test
	public void testgetPort() {
		assertEquals(8888, m.getPort());
	}
	
	@Test
	public void testsetPort() {
		m.setPort(1234);
		assertEquals(1234, m.getPort());
	}
	
	@Test
	public void testMessage() {
		m.createMsg("hallo");
		assertTrue(m.getMsg().contains("hallo"));
	}
	
	@Test
	public void testgetGroup() {
		m.startChat();
		assertEquals("/224.1.2.3", m.getGroup().toString());
	}
	
	@Test
	public void testsetGroup() {
		try {
			m.setGroup(InetAddress.getByName("234.5.6.7"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		assertEquals("/234.5.6.7", m.getGroup().toString());
	}
	
	@Test (expected = NullPointerException.class)
	public void testNullSend() {
		m.send();
	}
	
	@Test
	public void testSend() {
		m.startChat();
		m.createMsg("hallo welt");
		m.send();
		assertTrue(m.getMsg().contains("hallo welt"));
	}
	
	@Test
	public void testSetupConnection() {
		MulticastChat n = new MulticastChat("test", "224.1.2.3", 8888);
		n.setupChatConnection("test", "224.1.2.3", 8888);
		n.startChat();
		n.createMsg("hallo welt");
		n.send();
		assertTrue(n.getMsg().contains("hallo welt"));
	}
	
	@Test
	public void testgetInstance() {
		MulticastChat.getInstance().startChat();
		MulticastChat.getInstance().createMsg("test");
		MulticastChat.getInstance().send();
		assertTrue(MulticastChat.getInstance().getMsg().contains("test"));
	}
	
	@Test
	public void testLeaveGroup() {
		MulticastChat.getInstance().startChat();
		MulticastChat.getInstance().createMsg("test");
		MulticastChat.getInstance().send();
		MulticastChat.getInstance().multicastLeaveGroup();
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    // IMPORTANT: Save the old System.out!
	    PrintStream old = System.out;
	    // Tell Java to use your special stream
	    System.setOut(ps);
	    // Print some output: goes to your special stream
	    MulticastChat.getInstance().send();
	    // Put things back
	    System.out.flush();
	    System.setOut(old);
	    // Show what happened
	    assertTrue(baos.toString().contains("Error"));
	}
	
	@Test
	public void testValidIP()	{
		assertTrue(MulticastChat.validIP(m.getHostname()));
	}
	
}