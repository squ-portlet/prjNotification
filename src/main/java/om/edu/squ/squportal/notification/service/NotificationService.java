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

/**
 * @author Bhabesh
 *
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
}
