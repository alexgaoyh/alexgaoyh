package com.alexgaoyh.util.email;

import javax.mail.MessagingException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 发送邮件的方法，直接调用EmailUtil.send(subject, content, to)，即可发送邮件
 * @author gaoyihang
 *
 */
public class EmailUtil {

	/**
	 * @参数名：@param subject 邮件主题
	 * @参数名：@param content 邮件主题内容
	 * @参数名：@param to 收件人Email地址
	 */
	public static void send(String subject, String content, String to){
    	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-smtp-mail.xml");
 
    	Email mm = (Email) context.getBean("simpleMail");
        try {
			mm.sendMail(subject, content, to);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
