package stokic_taschner.testing;

import static org.junit.Assert.*;

import java.io.*;
import java.net.*;

import org.junit.*;

import stokic_taschner.chat.*;
import stokic_taschner.main.Main;

/**
 * @author Stefan Stokic
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
		//
	}

	@Test
	public void testgetUsername() {
		m = new MulticastChat("tt", "224.1.2.3", 8888);
		assertEquals("tt", m.getUsername());
	}
	
	@Test
	public void testsetUsername() {
		m = new MulticastChat("tt", "224.1.2.3", 8888);
		m.setUsername("herbert");
		assertEquals("herbert", m.getUsername());
	}
	
	@Test
	public void testgetHostname() {
		m = new MulticastChat("tt", "224.1.2.3", 8888);
		assertEquals("224.1.2.3", m.getHostname());
	}
	
	@Test
	public void testsetHostname() {
		m = new MulticastChat("tt", "224.1.2.3", 8888);
		m.setHostname("234.5.6.7");
		assertEquals("234.5.6.7", m.getHostname());
	}
	
	@Test
	public void testgetPort() {
		m = new MulticastChat("tt", "224.1.2.3", 8888);
		assertEquals(8888, m.getPort());
	}
	
	@Test
	public void testsetPort() {
		m = new MulticastChat("tt", "224.1.2.3", 8888);
		m.setPort(1234);
		assertEquals(1234, m.getPort());
	}
	
	@Test
	public void testMessage() {
		m = new MulticastChat("tt", "224.1.2.3", 8888);
		m.createMsg("hallo");
		assertTrue(m.getMsg().contains("hallo"));
	}
	
	@Test
	public void testgetGroup() {
		m = new MulticastChat("tt", "224.1.2.3", 8888);
		m.startChat();
		assertEquals("/224.1.2.3", m.getGroup().toString());
	}
	
	@Test
	public void testsetGroup() {
		m = new MulticastChat("tt", "224.1.2.3", 8888);
		try {
			m.setGroup(InetAddress.getByName("234.5.6.7"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		assertEquals("/234.5.6.7", m.getGroup().toString());
	}
	
	@Test (expected = NullPointerException.class)
	public void testNullSend() {
		m = new MulticastChat("tt", "224.1.2.3", 8888);
		m.send();
	}
	
	@Test
	public void testSend() {
		m = new MulticastChat("tt", "224.1.2.3", 8888);
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
	public void testLeaveNullGroup() throws UnknownHostException {
		m = new MulticastChat("tt", "224.1.2.3", 8888);
		m.setGroup(InetAddress.getByName(""));
		m.multicastLeaveGroup();
	}
	
	@Test
	public void testValidIP()	{
		m = new MulticastChat("tt", "224.1.2.3", 8888);
		assertTrue(MulticastChat.validIP(m.getHostname()));
	}
	
	@Test
	public void testNullIP()	{
		m = new MulticastChat("tt", "224.1.2.3", 8888);
		m.setHostname(null);
		assertFalse(MulticastChat.validIP(m.getHostname()));
	}
	
	@Test
	public void testEmptyIP()	{
		m = new MulticastChat("tt", "224.1.2.3", 8888);
		m.setHostname("");
		assertFalse(MulticastChat.validIP(m.getHostname()));
	}
	
	@Test
	public void test5PartsIP()	{
		m = new MulticastChat("tt", "224.1.2.3", 8888);
		m.setHostname("1.2.3.4.5");
		assertFalse(MulticastChat.validIP(m.getHostname()));
	}
	
	@Test
	public void testNegativeIP()	{
		m = new MulticastChat("tt", "-999.-999.-999.-999", 8888);
		assertFalse(MulticastChat.validIP(m.getHostname()));
	}
	
	@Test
	public void testTooBigIP()	{
		m = new MulticastChat("tt", "999.999.999.999", 8888);
		assertFalse(MulticastChat.validIP(m.getHostname()));
	}
	
	@Test
	public void testIPNFE()	{
		m = new MulticastChat("tt", "99+9.99,9.999.999", 8888);
		assertFalse(MulticastChat.validIP(m.getHostname()));
	}
	
	@Test
	public void teststatChatBad()	{
		m = new MulticastChat("tt", "1.2.3.4", 8888);
		m.startChat();
		assertEquals("1.2.3.4", m.getGroup().getHostAddress());
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testMain()	{
		Main m = new Main();
		Main.main(null);
	}
	
	@Test
	public void testBadWordFilterGetNullMessage()	{
		BadwordFilteredMessage b = new BadwordFilteredMessage(new ChatMessage());
		assertEquals(null, b.getMessage());
	}
	
	@Test
	public void testBadWordFilterGetOkMessage()	{
		ChatMessage c = new ChatMessage();
		
		BadwordFilteredMessage b = new BadwordFilteredMessage(c);
		b.setMessage("hallo");
		
		b.applyFilter(b.getMessage());
		
		assertEquals("hallo", b.getMessage());
	}
	
	@Test
	public void testBadWordFilterGetCensoredMessage()	{
		ChatMessage c = new ChatMessage();
		
		BadwordFilteredMessage b = new BadwordFilteredMessage(c);
		b.setMessage("du arsch");
		
		b.setMessage(b.applyFilter("du arsch"));
		
		assertEquals("du $%&*", b.getMessage());
	}
	
	
	/**
	 * Ich bin ein unnoetig langer Text, um deine Aufmerksamkeit zu erregen.
	 * Da ich diese nun habe
	 * 
	 * Bitte testen, danke
	 * |
	 * v
	 */
	@Test
	public void testBadWordFilterGetApplyFilter()	{
		ChatMessage c = new ChatMessage();
		
		BadwordFilteredMessage b = new BadwordFilteredMessage(c);
		
		
	}
	
	@Test
	public void testGetCapsedMessage()	{
		ChatMessage c = new ChatMessage();
		
		CapsedMessage cm = new CapsedMessage(c);
		
		cm.setMessage(cm.capsMessage("abc"));
		
		assertEquals("ABC", cm.getMessage());
	}
	
	
	/**
	 * Ich bin ein unnoetig langer Text, um deine Aufmerksamkeit zu erregen.
	 * Da ich diese nun habe
	 * 
	 * Bitte testen, danke
	 * |
	 * v
	 */
	@Test
	public void testCreateMessageCappsedMessage()	{
		ChatMessage c = new ChatMessage();
		
		CapsedMessage cm = new CapsedMessage(c);
		
		
	}
	
	@Test
	public void testGetChatMessage()	{
		
		Message m = new ChatMessage();
		m.setMessage("abc");
		
		assertEquals("abc", m.createMessage());
		
		
	}
	
	/**
	 * Ich bin ein unnoetig langer Text, um deine Aufmerksamkeit zu erregen.
	 * Da ich diese nun habe
	 * 
	 * Bitte testen, danke
	 * |
	 * v
	 */
	@Test
	public void testGetTypeChatMessage()	{
		// TypeMessage.getTypeMessage testen
	}
	
}