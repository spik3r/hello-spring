package com.kaitait.hellospring.controllers;

import com.kaitait.hellospring.mail.MailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@RestController
public class MailController {
    
    private MailSender mailSender;
    /*
        By annotating mailSender variable  with @Resource,
        we told Spring to go to that place,
        search for an object of type MailSender,
        and assign a reference of that to this variable.
    */
    //@Resource find bean by type, will break if more than one of type is available
    //@Resource(name = "smtpMailSender") // chose bean by name
        
    //    @Resource
    //    public void setMailSender(MailSender mailSender) {
    //        this.mailSender = mailSender;
    //    }
    
    /**
     * So, @Resource, @Autowired or @Inject? Which one to prefer?
     *
     * In case of the multiple-bean problem,
     * @Resource, when supplied with a name, seems cleaner than using
     * @Autowired or @Inject along with
     * @Qualifier. But,
     * @Autowired or @Inject is more powerful.
     * Probably that’s why people seem to be preferring
     * @Autowired nowadays. In fact,
     * the Spring team seem to be recommending
     * @Autowired over the others.
     */
    
    @Autowired // doesn't take name like @Resource use @Qualifier("smtpMailSender")
    public MailController(MailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    @RequestMapping("/mail")
    public String sendMail() throws MessagingException
    {
        mailSender.send("abc@example.com", "Some subject", "the content");
        return "Mail sent";
    }
}
