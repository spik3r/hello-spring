package com.kaitait.hellospring.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/*
    By annotating MockMailSender with @Component,
    we told Spring to create an instance of MockMailSender
    and keep it at some place when the application starts.
     
    Can pick a name for this bean by doing @Component("name").
    Default name is the class name in camelcase eg mockMailSender
*/

//@Component //spring creates beans for classes annotated with @Component
public class MockMailSender implements MailSender {
    
    private static final Log log = LogFactory.getLog(MockMailSender.class);
    @Override
    public void send(String to, String subject, String body) {
        log.info("Sending mail to: " + to);
        log.info("Subject: " + subject);
        log.info("Body: " + body);
    }
}
