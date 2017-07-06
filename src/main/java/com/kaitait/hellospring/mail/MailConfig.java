package com.kaitait.hellospring.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * If we can't or don't want to add @Component annotations we
 * can configure using java using a class like this
 */
@Configuration // can also be an @Component class
public class MailConfig {
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    @Bean
    @Profile("dev")
//    @ConditionalOnProperty(name = "spring.mail.host",
//            havingValue = "foo",
//            matchIfMissing = true)
    public MailSender mockMailSender() {
        return new MockMailSender();
    }
    
    @Bean
    @Profile("!dev")
//    @ConditionalOnProperty(name = "spring.mail.host")
    public MailSender smtpMailSender(JavaMailSender javaMailSender, DemoBean demoBean) {
//        return new SmtpMailSender();
        demoBean.foo();
        SmtpMailSender mailSender = new SmtpMailSender();
        mailSender.setJavaMailSender(javaMailSender);
        return mailSender;
    }
    
    @Bean
    public DemoBean demoBean() {
        return new DemoBean();
    }
}
