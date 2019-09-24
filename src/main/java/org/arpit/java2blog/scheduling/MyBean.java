package org.arpit.java2blog.scheduling;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.arpit.java2blog.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component("myBean")
@PropertySource("classpath:scheduling.properties")
public class MyBean {

	private static Logger log = Logger.getLogger(MyBean.class);

	@Autowired 
	private Environment env;

	@Autowired 
	private JavaMailSender mailSender;

	@Autowired
	EmployeeService empService;
	public void printMessage() {
		log.info("Scheduling :: In MethodInvokingJobDetailFactoryBean using SimpleTriggerFactoryBean");
	}

	public void printAllEmployees() {
		log.info("Employee List :: "+empService.getEmployeeList());
	}

	public void sendAllEmployeestoMail() { 
		System.out.println("In sendMail");
		try {
			MimeMessage message = 	mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(env.getProperty("employeeDetailsMail.GMAIL_USER_NAME"));
			helper.setTo(env.getProperty("employeeDetailsMail.GMAIL_USER_NAME"));
			
			helper.setSubject(env.getProperty("employeeDetailsMail.SUBJECT"));
			helper.setText(env.getProperty("employeeDetailsMail.MessageBody")+new java.util.Date(System.currentTimeMillis())+"\r\n"+
					empService.getEmployeeList());
			System.out.println("Sending Mail :: "+message);
			this.mailSender.send(message);
		}catch(MessagingException me) {
			System.out.println("Messaging Exception : "+me.getMessage());
		}
	}

}
