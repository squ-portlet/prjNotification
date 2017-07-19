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
 * File Name			:	NotificationService.java
 * Package Name			:	om.edu.squ.squportal.notification.service
 * Date of creation		:	Apr 6, 2017  12:57:38 PM
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

// TODO: Auto-generated Javadoc
/**
 * The Interface NotificationService.
 *
 * @author Bhabesh
 */
public interface NotificationService
{
	
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
			);
	
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
		);
	
	
	
	
	/**
	 * method name  : sendSingleSMS.
	 *
	 * @param userId the user id
	 * @param password the password
	 * @param mobilePhoneNo the mobile phone no
	 * @param message the message
	 * @param locale the locale
	 * @param scheduleDate the schedule date
	 * @param sender the sender
	 * @param appName (project name)
	 * @param appRef (project feature,module etc)
	 * @param refKey (PK, if any)
	 * @return NotificationServiceImpl
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
				String	sender,
				String  appName,
				String  appRef,
				String  refKey				
			);
	
	/**
	 * method name  : sendSingleSMS.
	 *
	 * @param mobilePhoneNo the mobile phone no
	 * @param message the message
	 * @param locale the locale
	 * @param scheduleDate the schedule date
	 * @param sender the sender
	 * @param appName (project name)
	 * @param appRef (project feature,module etc)
	 * @param refKey (PK, if any)
	 * @return NotificationServiceImpl
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
			String	sender,
			String  appName,
			String  appRef,
			String  refKey
		);
	
	
	
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
	public boolean sendEmail(String fromAddress, String[] toAddress, String lang, String subject, String body, String appName, String appRef, String refKey);
	
}
