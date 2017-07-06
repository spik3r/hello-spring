package com.kaitait.hellospring.mail;

import javax.mail.MessagingException;

/**
 * Created by kai-tait on 6/07/2017.
 */
public interface MailSender {
    
    void send(String to, String subject, String body) throws MessagingException;
}
