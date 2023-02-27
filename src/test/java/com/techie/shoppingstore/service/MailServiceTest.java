package com.techie.shoppingstore.service;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import com.techie.shoppingstore.exceptions.SpringStoreException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {MailService.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MailServiceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @MockBean
    private JavaMailSender javaMailSender;

    @MockBean
    private MailContentBuilder mailContentBuilder;

    @Autowired
    private MailService mailService;

    /**
     * Method under test: {@link MailService#sendMail(String, String)}
     */
    @Test
    public void testSendMail() throws MailException {
        doNothing().when(this.javaMailSender).send((org.springframework.mail.javamail.MimeMessagePreparator) any());
        this.mailService.sendMail("Recipient", "Not all who wander are lost");
        verify(this.javaMailSender).send((org.springframework.mail.javamail.MimeMessagePreparator) any());
    }

    /**
     * Method under test: {@link MailService#sendMail(String, String)}
     */
    @Test
    public void testSendMail2() throws MailException {
        doThrow(new MailAuthenticationException("Msg")).when(this.javaMailSender)
                .send((org.springframework.mail.javamail.MimeMessagePreparator) any());
        thrown.expect(SpringStoreException.class);
        this.mailService.sendMail("Recipient", "Not all who wander are lost");
        verify(this.javaMailSender).send((org.springframework.mail.javamail.MimeMessagePreparator) any());
    }

    /**
     * Method under test: {@link MailService#sendMail(String, String)}
     */
    @Test
    public void testSendMail3() throws MailException {
        doThrow(new SpringStoreException("An error occurred")).when(this.javaMailSender)
                .send((org.springframework.mail.javamail.MimeMessagePreparator) any());
        thrown.expect(SpringStoreException.class);
        this.mailService.sendMail("Recipient", "Not all who wander are lost");
        verify(this.javaMailSender).send((org.springframework.mail.javamail.MimeMessagePreparator) any());
    }
}

