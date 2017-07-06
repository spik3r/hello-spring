package com.kaitait.hellospring.mail;

import org.apache.commons.logging.Log;


import static org.apache.commons.logging.LogFactory.*;

/**
 * Created by kai-tait on 6/07/2017.
 */
public class DemoBean {
    
    private static final Log log = getLog(DemoBean.class);
    public DemoBean () {   log.info("DemoBean created!");  }
    
    
    
    public String foo() {
        return "something";
    }
}
