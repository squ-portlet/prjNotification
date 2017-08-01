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
 * File Name			:	NotificationServiceCore.java
 * Package Name			:	om.edu.squ.squportal.notification.service.core
 * Date of creation		:	Jul 25, 2017  11:06:48 AM
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

import om.edu.squ.squportal.notification.exception.NotificationException;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Bhabesh
 *
 */
public interface NotificationServiceCore
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
		);
	
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
			MultipartFile multipartFile) throws NotificationException;
}
