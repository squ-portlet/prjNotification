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
 * File Name			:	MessageSoap.java
 * Package Name			:	om.edu.squ.squportal.notification.sms
 * Date of creation		:	Apr 6, 2017  10:25:26 AM
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
package om.edu.squ.squportal.notification.sms;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;

import om.edu.squ.squportal.notification.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Bhabesh
 *
 */
public class MessageSoap extends Service
{

	private final static Logger logger = LoggerFactory.getLogger(MessageSoap.class);
	private	static	URL		url;
	
	/**
	 * Static block for set url
	 */
	static
	{
		try
		{
			url	=	new URL(MessageSoap.class.getResource("."),Constants.CONST_SMS_WSDL);
			//url	=	new URL(MessageSoap.class.getResource("."),"https://smsws.squ.edu.om/sendsms.asmx?wsdl");
		}
		catch(MalformedURLException ex)
		{
			logger.error("Error in URL. Details : {}",ex.getMessage());
		}
	}
	
	/**
	 * 
	 * Constructor
	 *
	 */
	public MessageSoap()
	{
		super(url, new QName(Constants.CONST_SMS_WEB_SERVICE,Constants.CONST_SMS_SERVICE_NAME));
		//super(url, new QName("http://smsws.squ.edu.om/","SendSMS1"));
	}
	
	/**
	 * 
	 * method name  : sendSingleSMS
	 * @return
	 * MessageSoap
	 * return type  : SendSMS1Soap
	 * 
	 * purpose		: 
	 *
	 * Date    		:	Apr 6, 2017 12:19:12 PM
	 */
	@WebEndpoint(name=Constants.CONST_SMS_PORT_TYPE)
	//@WebEndpoint(name="\""+Constants.CONST_SMS_PORT_TYPE+"\"")
	//@WebEndpoint(name = "SendSMS1Soap")
	public SendSMS1Soap	SendSingleSMS()
	{
		return super.getPort(new QName(Constants.CONST_SMS_WEB_SERVICE, Constants.CONST_SMS_PORT_TYPE), SendSMS1Soap.class);
		//return super.getPort(new QName("http://smsws.squ.edu.om/", "SendSMS1Soap"), SendSMS1Soap.class);
				
	}
	
	
}
