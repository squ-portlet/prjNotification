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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import om.edu.squ.squportal.notification.sms.MessageSoap;
import om.edu.squ.squportal.notification.sms.SendSMS1Soap;

/**
 * @author Bhabesh
 *
 */
public class NotificationServiceImpl implements NotificationService
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private	String 	smsUserId;
	private	String	smsPassword;

	/**
	 * Setter method : setSmsUserId
	 * @param smsUserId the smsUserId to set
	 * 
	 * Date          : Apr 6, 2017 1:18:06 PM
	 */
	public void setSmsUserId(String smsUserId)
	{
		this.smsUserId = smsUserId;
	}

	/**
	 * Setter method : setSmsPassword
	 * @param smsPassword the smsPassword to set
	 * 
	 * Date          : Apr 6, 2017 1:18:06 PM
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
	
}
