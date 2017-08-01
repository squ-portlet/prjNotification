/**
 * Project				:	prjNotification
 * Organization			:	Sultan Qaboos University | Muscat | Oman
 * Centre				:	Centre for Information System
 * Department			:	Web & E-Services
 * 
 * Author				:	Bhabesh
 *
 * FrameWork			:	Spring 3.2.3 (Annotation) Portlet
 * 
 * File Name			:	NotificationServiceCoreImpl.java
 * Package Name			:	om.edu.squ.squportal.notification.service.core
 * Date of creation		:	Jul 25, 2017  9:56:28 AM
 * Date of modification :	
 * 
 * Summary				:	
 *
 *
 * Copyright 2017 the original author or authors and Organization.
 *
 * Licensed under the SQU, CIS policy
 * you may not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * 
 */
package om.edu.squ.squportal.notification.service.core;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;






import om.edu.squ.squportal.notification.exception.NotificationException;
import om.edu.squ.squportal.notification.sms.MessageSoap;
import om.edu.squ.squportal.notification.sms.SendSMS1Soap;
import om.edu.squ.squportal.notification.utility.UtilProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.sun.mail.smtp.SMTPSendFailedException;

/**
 * @author Bhabesh
 *
 */
public class NotificationServiceCoreImpl implements NotificationServiceCore
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private	String 	smsUserId;
	private	String	smsPassword;
	/**
	 * Setter method : setSmsUserId
	 * @param smsUserId the smsUserId to set
	 * 
	 * Date          : Jul 25, 2017 9:57:16 AM
	 */
	public void setSmsUserId(String smsUserId)
	{
		this.smsUserId = smsUserId;
	}
	/**
	 * Setter method : setSmsPassword
	 * @param smsPassword the smsPassword to set
	 * 
	 * Date          : Jul 25, 2017 9:57:16 AM
	 */
	public void setSmsPassword(String smsPassword)
	{
		this.smsPassword = smsPassword;
	}
	
	/**
	 * 
	 * method name  : sendSingleSMS
	 * @param userId
	 * @param password
	 * @param mobilePhoneNo
	 * @param message
	 * @param locale
	 * @param scheduleDate
	 * @param userName
	 * @return
	 * NotificationServiceCoreImpl
	 * return type  : String
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jul 25, 2017 10:01:32 AM
	 */
	public String	sendSingleSMS(
			String	userId,
			String	password,
			String	mobilePhoneNo,
			String	message,
			String	locale,
			String	scheduleDate,
			String	userName
		)
	{
		String	result 	=	null;
		
		try
		{
			MessageSoap		messageSoap		=	new MessageSoap();
			SendSMS1Soap	sendSMS1Soap	=	messageSoap.SendSingleSMS();
							
							result			=	sendSMS1Soap.SendSingleSMS(userId, password, mobilePhoneNo, message, locale, scheduleDate, userName);
		}
		catch(Exception ex)
		{
			logger.error("Message sending failure : "+ex.getMessage());
		}
		
		return result;
	}

	/**
	 * 
	 * method name  : sendSingleSMS
	 * @param mobilePhoneNo
	 * @param message
	 * @param locale
	 * @param scheduleDate
	 * @param userName
	 * @return
	 * NotificationServiceCoreImpl
	 * return type  : String
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jul 25, 2017 10:01:27 AM
	 */
	public String	sendSingleSMS(
			String	mobilePhoneNo,
			String	message,
			String	locale,
			String	scheduleDate,
			String	userName
		)
	{
		String	result 	=	null;
		
		try
		{
			MessageSoap		messageSoap		=	new MessageSoap();
			SendSMS1Soap	sendSMS1Soap	=	messageSoap.SendSingleSMS();
							
							result			=	sendSMS1Soap.SendSingleSMS(this.smsUserId, this.smsPassword, mobilePhoneNo, message, locale, scheduleDate, userName);
		}
		catch(Exception ex)
		{
			logger.error("Message sending failure : "+ex.getMessage());
			ex.printStackTrace();
		}
		
		return result;
	}
	
	
	/**
	 * 
	 * method name  : sendEMail
	 * @param fromAddress
	 * @param toAddress
	 * @param ccAddress
	 * @param txtMailSubject
	 * @param txtMailBody
	 * @param multipartFile
	 * @return
	 * @throws MessagingException 
	 * @throws Exception
	 * NotificationServiceCoreImpl
	 * return type  : boolean
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jul 25, 2017 11:08:00 AM
	 */
	public boolean sendEMail(String fromAddress, String[] toAddress,
			String[] ccAddress, String txtMailSubject, String txtMailBody,
			MultipartFile multipartFile) throws NotificationException
	{

		String	SMTP_HOST_NAME	= 	UtilProperty.getMailProp("smtpHost", null);
		String	SMTP_HOST_PORT	=	UtilProperty.getMailProp("smtpPort", null);	
		
		boolean mailSuccess = false;
		Properties props = new Properties();
		
		
		//String SMTP_HOST_NAME = "squmail.squ.edu.om";
		String SMTP_AUTH_USER = fromAddress;
		//long SMTP_HOST_PORT = 25;
		
		String content = txtMailBody;
		
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.debug", "true");
		props.put("mail.smtp.auth", "false");
		// props.put("mail.smtp.starttls.enable","false");
		// props.setProperty("mail.smtp.ssl.trust", "squmail.squ.edu.om");
		props.put("mail.smtp.port", SMTP_HOST_PORT);
		//props.put("mail.smtp.auth.mechanisms","NTLM");

	    // *** CHANGED ***
	    //props.put("mail.smtp.auth.ntlm.domain","WINDOMAIN"); // Domain you log into Windows with
		Transport transport = null;
		try
		{
			SMTPAuthenticatorextends auth = new SMTPAuthenticatorextends();
			Session mailSession = Session.getInstance(props, auth);			
			
			 mailSession.setDebug(true); // Debug output in console
			transport = mailSession.getTransport();
			
			MimeMessage message = new MimeMessage(mailSession);
			InternetAddress[] addressTo = new InternetAddress[toAddress.length];
			InternetAddress[] addressCC = null;
			
			message.setSubject(txtMailSubject, "UTF-8"); // Arabic Encoding
															// iso-8859-6/ UTF-8
			
			Multipart mp = new MimeMultipart();
			
			MimeBodyPart mbp1 = new MimeBodyPart();
			
			mbp1.setContent(content, "text/html; charset=UTF-8"); // Arabic
																	// Encoding
			
			mp.addBodyPart(mbp1);
			
			if (null != multipartFile)
			{
				if (multipartFile.getSize() > 0)
				{
					// create the second message part
					MimeBodyPart mbp2 = new MimeBodyPart();
					DataSource fds;
					try
					{
						fds = new ByteArrayDataSource(
								multipartFile.getInputStream(), "application/x-any");
					}
					catch (IOException e)
					{
						throw new NotificationException(e.getMessage());
					}
					mbp2.setDataHandler(new DataHandler(fds));
					mbp2.setFileName(multipartFile.getOriginalFilename());
					mp.addBodyPart(mbp2);
				}
			}
			
			message.setContent(mp);
			
			for (int i = 0; i < toAddress.length; i++)
			{
				addressTo[i] = new InternetAddress(toAddress[i]);
			}
			
			message.addRecipients(Message.RecipientType.TO, addressTo);
			
			if (null != ccAddress)
			{
				if (ccAddress.length != 0)
				{
					addressCC = new InternetAddress[ccAddress.length];
					for (int j = 0; j < ccAddress.length; j++)
					{
						addressCC[j] = new InternetAddress(ccAddress[j]);
					}
					message.addRecipients(Message.RecipientType.CC, addressCC);
					
				}
			}
			
			message.setFrom(new InternetAddress(SMTP_AUTH_USER));
			transport.connect();
			transport.sendMessage(message,
						message.getRecipients(Message.RecipientType.TO));
				if (null != ccAddress)
				{
					if (ccAddress.length != 0)
					{
						transport.sendMessage(message,
								message.getRecipients(Message.RecipientType.CC));
					}
				}
				
				transport.close();
				mailSuccess = true;
			
		}
			catch(SMTPSendFailedException sendFailedException)
			{
				logger.error("Error in sending email : {}",sendFailedException.getMessage());
				throw new NotificationException(sendFailedException.getMessage());
				
			}
		
		catch (MessagingException ex)
		{
			mailSuccess = false;
			logger.error("Mail sending failure, Details :{}",ex.getMessage());
			throw new NotificationException(ex.getMessage());
		}

		if (transport != null && transport.isConnected())
		{
			try
			{
				mailSuccess = false;
				transport.close();
			}
			catch (MessagingException e)
			{
				mailSuccess = false;
				
				throw new NotificationException(e.getMessage());
			}
		}
		
		return mailSuccess;
	}
	
	/**
	 * The Class SMTPAuthenticatorextends.
	 */
	class SMTPAuthenticatorextends extends Authenticator
	{
		
		/* (non-Javadoc)
		 * @see javax.mail.Authenticator#getPasswordAuthentication()
		 */
		public PasswordAuthentication getPasswordAuthentication()
		{
			return new PasswordAuthentication("username", "*******");
		}
		
	}
	
}
