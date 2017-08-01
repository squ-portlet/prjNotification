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
 * File Name			:	NotificationException.java
 * Package Name			:	om.edu.squ.squportal.notification.exception
 * Date of creation		:	Jul 31, 2017  1:43:48 PM
 * Date of modification :	
 * 
 * Summary				:	Custom Exception class
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
package om.edu.squ.squportal.notification.exception;

/**
 * @author Bhabesh
 *
 */
public class NotificationException extends Exception
{

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage()
	{
		// TODO Auto-generated method stub
		return super.getMessage();
	}

	public NotificationException(String message, Throwable cause)
	{
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NotificationException(String message)
	{
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NotificationException(Throwable cause)
	{
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
