package org.apache.commons.mail;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.mail.MessagingException;

public class EmailTest {

    private Email email;

    @Before
    public void setUp() {
        // Initialize a SimpleEmail instance before each test
        email = new SimpleEmail();
    }

    @Test
    public void testAddBcc() throws EmailException {
        // Test adding BCC addresses
        email.addBcc("bcc1@example.com", "bcc2@example.com");
        assertEquals(2, email.getBccAddresses().size());
    }

    @Test
    public void testAddCc() throws EmailException {
        // Test adding CC address
        email.addCc("cc@example.com");
        assertEquals(1, email.getCcAddresses().size());
    }

    @Test
    public void testAddHeader() throws EmailException, MessagingException {
        // Test adding a custom header
        email.addHeader("X-MyHeader", "MyValue");
        assertEquals("MyValue", email.getMimeMessage().getHeader("X-MyHeader", null));
    }

    @Test
    public void testAddReplyTo() throws EmailException {
        // Test adding reply-to address
        email.addReplyTo("replyto@example.com", "ReplyTo Test");
        assertEquals("replyto@example.com", email.getReplyToAddresses().get(0).getAddress());
        assertEquals("ReplyTo Test", email.getReplyToAddresses().get(0).getPersonal());
    }

    @Test
    public void testBuildMimeMessage() throws EmailException {
        // Test building MIME message
        email.setSubject("Test Subject");
        email.setMsg("This is a test message");
        email.addTo("recipient@example.com");
        email.setFrom("sender@example.com");
        email.buildMimeMessage();
        assertNotNull(email.getMimeMessage());
    }

    @Test
    public void testGetHostName() {
        // Test getting host name
        assertNotNull(email.getHostName());
    }

    @Test
    public void testGetMailSession() throws EmailException {
        // Test getting mail session
        assertNotNull(email.getMailSession());
    }

    @Test
    public void testGetSentDate() {
        // Test getting sent date
        assertNotNull(email.getSentDate());
    }

    @Test
    public void testGetSocketConnectionTimeout() {
        // Test getting socket connection timeout
        assertEquals(30000, email.getSocketConnectionTimeout());
    }

    @Test
    public void testSetFrom() throws EmailException {
        // Test setting 'from' address
        email.setFrom("from@example.com");
        assertEquals("from@example.com", email.getFromAddress().getAddress());
    }
}
