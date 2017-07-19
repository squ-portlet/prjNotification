/**
 * Project				:	prjNotification
 * Organization			:	Sultan Qaboos University | Muscat | Oman
 * Centre				:	Centre for Information System
 * Department			:	Web & E-Services
 * 
 * Author				:	Bhabesh
 *
 * FrameWork			:	Spring 4.0.8 (Annotation) Portlet
 * 
 * File Name			:	NotificationServiceImpl.java
 * Package Name			:	om.edu.squ.squportal.notification.service
 * Date of creation		:	Apr 6, 2017  12:28:43 PM
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
package om.edu.squ.squportal.notification.service;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;



import om.edu.squ.squportal.notification.dao.AppNotificationDao;
import om.edu.squ.squportal.notification.dto.AppNotificationDto;
import om.edu.squ.squportal.notification.sms.MessageSoap;
import om.edu.squ.squportal.notification.sms.SendSMS1Soap;

// TODO: Auto-generated Javadoc
/**
 * The Class NotificationServiceImpl.
 *
 * @author Bhabesh
 */
public class NotificationServiceImpl implements NotificationService
{
	
	/** The smtp host name. */
	@Value("${smtpHost}")
	private String SMTP_HOST_NAME;
	
	/** The smtp host port. */
	@Value("${smtpPort}")
	private int SMTP_HOST_PORT;
	
	/** The logger. */
	private final Logger	logger	= LoggerFactory.getLogger(this.getClass());
	
	/** The sms user id. */
	private String			smsUserId;
	
	/** The sms password. */
	private String			smsPassword;
	
	/** The dao. */
	@Autowired
	AppNotificationDao		dao;
	
	
	/**
	 * Setter method : setSmsUserId.
	 *
	 * @param smsUserId            the smsUserId to set
	 * 
	 *            Date : Apr 6, 2017 1:18:06 PM
	 */
	public void setSmsUserId(String smsUserId)
	{
		this.smsUserId = smsUserId;
	}
	
	/**
	 * Setter method : setSmsPassword.
	 *
	 * @param smsPassword            the smsPassword to set
	 * 
	 *            Date : Apr 6, 2017 1:18:06 PM
	 */
	public void setSmsPassword(String smsPassword)
	{
		this.smsPassword = smsPassword;
	}

	/**
	 * 
	 * method name  : sendSingleSMS
	 * @param smsUserId
	 * @param smsPassword
	 * @param mobilePhoneNo
	 * @param message
	 * @param locale
	 * @param scheduleDate
	 * @param userName
	 * @return
	 * NotificationServiceImpl
	 * return type  : String
	 * 
	 * purpose		: 
	 *
	 * Date    		:	Apr 6, 2017 12:47:48 PM
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
	 * NotificationServiceImpl
	 * return type  : String
	 * 
	 * purpose		:
	 *
	 * Date    		:	Apr 6, 2017 1:10:48 PM
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
	 * method name : sendSingleSMS.
	 *
	 * @param userId the user id
	 * @param password the password
	 * @param mobilePhoneNo the mobile phone no
	 * @param message the message
	 * @param locale the locale
	 * @param scheduleDate the schedule date
	 * @param sender the sender
	 * @param appName the app name
	 * @param appRef the app ref
	 * @param refKey the ref key
	 * @return NotificationServiceImpl return type : String
	 * 
	 *         purpose :
	 * 
	 *         Date : Apr 6, 2017 12:47:48 PM
	 */
	public String sendSingleSMS(String userId, String password,
			String mobilePhoneNo, String message, String locale,
			String scheduleDate, String sender, String appName, String appRef,
			String refKey)
	{
		String result = null;
		
		try
		{
			MessageSoap messageSoap = new MessageSoap();
			SendSMS1Soap sendSMS1Soap = messageSoap.SendSingleSMS();
			
			result = sendSMS1Soap.SendSingleSMS(userId, password,
					mobilePhoneNo, message, locale, scheduleDate, sender);
			addNotification2DB("sms", result, mobilePhoneNo, message, locale,
					appName, appRef, refKey, "", "");
		}
		catch (Exception ex)
		{
			logger.error("Message sending failure : " + ex.getMessage());
		}
		
		return result;
	}
	
	/**
	 * method name : sendSingleSMS.
	 *
	 * @param mobilePhoneNo the mobile phone no
	 * @param message the message
	 * @param locale the locale
	 * @param scheduleDate the schedule date
	 * @param sender the sender
	 * @param appName the app name
	 * @param appRef the app ref
	 * @param refKey the ref key
	 * @return NotificationServiceImpl return type : String
	 * 
	 *         purpose :
	 * 
	 *         Date : Apr 6, 2017 1:10:48 PM
	 */
	public String sendSingleSMS(String mobilePhoneNo, String message,
			String locale, String scheduleDate, String sender, String appName,
			String appRef, String refKey)
	{
		String result = null;
		
		try
		{
			MessageSoap messageSoap = new MessageSoap();
			SendSMS1Soap sendSMS1Soap = messageSoap.SendSingleSMS();
			
			result = sendSMS1Soap.SendSingleSMS(this.smsUserId,
					this.smsPassword, mobilePhoneNo, message, locale,
					scheduleDate, sender);
			addNotification2DB("sms", result, mobilePhoneNo, message, locale,
					appName, appRef, refKey, "", "");
		}
		catch (Exception ex)
		{
			logger.error("Message sending failure : " + ex.getMessage());
			ex.printStackTrace();
			addNotification2DB("sms", "ERROR", mobilePhoneNo, message, locale,
					appName, appRef, refKey, ex.getMessage(), "");
		}
		
		return result;
	}
	
	
	/**
	 * Adds the notification2 db.
	 *
	 * @param medium : sms or email
	 * @param response from the actual call
	 * @param toAddress the to address
	 * @param msgText the msg text
	 * @param lang the lang
	 * @param appName the app name
	 * @param appRef the app ref
	 * @param refKey the ref key
	 * @param comments : could be anything. ex: exception message if any error
	 * @param msgSubject the msg subject
	 */
	private void addNotification2DB(String medium, String response,
			String toAddress, String msgText, String lang, String appName,
			String appRef, String refKey, String comments, String msgSubject)
	{
		AppNotificationDto dto = new AppNotificationDto();
		dto.setMedium(medium);
		dto.setResponse(response);
		dto.setToAddress(toAddress);
		dto.setMsg_text(msgText);
		dto.setLang(lang);
		dto.setAppName(appName);
		dto.setAppRef(appRef);
		dto.setRefKey(refKey);
		dto.setComments(comments);
		dto.setMsg_subject(msgSubject);
		
		dao.insert(dto);
	}
	
	
	/**
	 * Send email. send email notification and log in database
	 *
	 * @param fromAddress the from address
	 * @param toAddress the to address
	 * @param lang the lang
	 * @param subject the subject
	 * @param body the body
	 * @param appName (project name)
	 * @param appRef (project feature,module etc)
	 * @param refKey (PK, if any)
	 * @return true, if successful
	 */
	public boolean sendEmail(String fromAddress, String[] toAddress,
			String lang, String subject, String body, String appName,
			String appRef, String refKey)
	{
		
		try
		{
			boolean result = sendMail(fromAddress,toAddress,null,subject,body,null);
			addNotification2DB("email", Boolean.toString(result),
					StringUtils.arrayToCommaDelimitedString(toAddress), body,
					lang, appName, appRef, refKey, "", subject);
			return true;
		}
		catch (Exception ex)
		{
			logger.error("Message sending failure : " + ex.getMessage());
			ex.printStackTrace();
			addNotification2DB("email", "ERROR",
					StringUtils.arrayToCommaDelimitedString(toAddress), body,
					lang, appName, appRef, refKey, ex.getMessage(), subject);
			return false;
		}
	}
	
	/**
	 * Send mail.
	 *
	 * @param fromAddress the from address
	 * @param toAddress the to address
	 * @param ccAddress the cc address
	 * @param txtMailSubject the txt mail subject
	 * @param txtMailBody the txt mail body
	 * @param multipartFile the multipart file
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean sendMail(String fromAddress, String[] toAddress,
			String[] ccAddress, String txtMailSubject, String txtMailBody,
			MultipartFile multipartFile) throws Exception
	{
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
					DataSource fds = new ByteArrayDataSource(
							multipartFile.getInputStream(), "application/x-any");
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
		catch (Exception ex)
		{
			if (transport != null && transport.isConnected())
			{
				transport.close();
			}
			mailSuccess = false;
			// System.out.println("Mail sending failure, Details : "+ex);
			//ex.printStackTrace();
			throw ex;
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
