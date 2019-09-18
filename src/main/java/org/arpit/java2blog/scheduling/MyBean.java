package org.arpit.java2blog.scheduling;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {

	private static Logger log = Logger.getLogger(MyBean.class);
	public void printMessage() {
		log.info("I am called by MethodInvokingJobDetailFactoryBean using SimpleTriggerFactoryBean");
		System.out.println("I am called by MethodInvokingJobDetailFactoryBean using SimpleTriggerFactoryBean");
	}
}
