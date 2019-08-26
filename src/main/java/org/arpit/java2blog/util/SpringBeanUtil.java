package org.arpit.java2blog.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class SpringBeanUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("In SpringBeanUtil :: setApplicationContext");
		this.applicationContext = applicationContext;
	}
	public ApplicationContext getApplicationContext() {
	      return applicationContext;
	    }
	public static Object getBeanByName(String beanName){
		return applicationContext.getBean(beanName);
	}
}
