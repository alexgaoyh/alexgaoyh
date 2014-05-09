package com.alexgaoyh.util.email;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;


public class Email {
	
	private JavaMailSender mailSender;

	/**
	 * @throws MessagingException
	 * @方法名: sendMail
	 * @参数名：@param subject 邮件主题
	 * @参数名：@param content 邮件主题内容
	 * @参数名：@param to 收件人Email地址
	 * @描述语: 发送邮件
	 */
	public void sendMail(String subject, String content, String to)
			throws MessagingException {

		MimeMessage m = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(m, true,
				"utf-8");
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setFrom(((JavaMailSenderImpl) mailSender)
				.getUsername());
		mimeMessageHelper.setTo(new InternetAddress(to));
		mimeMessageHelper.setText("a", content);

		mailSender.send(m);
	}

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
}
