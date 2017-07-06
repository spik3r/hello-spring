package com.kaitait.hellospring.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

//@Primary // tell spring to chose this bean if multiple are available. not for @Autowired
//@Component//("mailSender") add name.
@Qualifier("smtp")
public class SmtpMailSender implements MailSender {
    
    private static final Log log = LogFactory.getLog(SmtpMailSender.class);
    private JavaMailSender javaMailSender;
    
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    @Override
    public void send(String to, String subject, String body) throws MessagingException
    {
        log.info("Sending SMTP mail to " + to);
        log.info("Subject: " + subject);
        log.info("Body: " + body);
    
//        MimeMessage message = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper;
//        helper = new MimeMessageHelper(message, true); // true indicates multipart message
//        helper.setSubject(subject);
//        helper.setTo(to);
//        helper.setText(body, true); // true indicates html
//                                          // continue using helper for more functionalities
//                                          // like adding attachments, etc.
//        javaMailSender.send(message);
    }
}
