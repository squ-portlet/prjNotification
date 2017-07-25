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
 * File Name			:	Constants.java
 * Package Name			:	om.edu.squ.squportal.notification.utility
 * Date of creation		:	Apr 6, 2017  10:24:44 AM
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
package om.edu.squ.squportal.notification.utility;

/**
 * @author Bhabesh
 *
 */
public interface Constants
{
	public static final String	CONST_SMS_WSDL										=	"https://smsws.squ.edu.om/sendsms.asmx?wsdl";
	public static final	String	CONST_SMS_WEB_SERVICE								=	"http://smsws.squ.edu.om/";
	public static final	String	CONST_SMS_SERVICE_NAME								=	"SendSMS1";
	public static final	String	CONST_SMS_PORT_TYPE									=	"SendSMS1Soap";
	public static final	String	CONST_SMS_OPERATION_SEND_SINGLE_SMS					=	"SendSingleSMS";
	public static final	String	CONST_SMS_OPERATION_SEND_SINGLE_SMS_URL				=	"http://smsws.squ.edu.om/SendSingleSMS";
	
	public static final	String	CONST_SMS_RESULT_SEND_SINGLE_SMS					=	"SendSingleSMSResult";
	public static final	String	CONST_SMS_RESPONSE_SEND_SINGLE_SMS					=	"SendSingleSMSResponse";
	
	public static final	String	CONST_SMS_OPERATION_CLASS_SEND_SINGLE_SMS			=	"om.edu.squ.squportal.notification.sms.soap.SendSingleSMS";
	public static final	String	CONST_SMS_OPERATION_RESPONSE_CLASS_SEND_SINGLE_SMS	=	"om.edu.squ.squportal.notification.sms.soap.SendSingleSMSResponse";
	
	public static final	String	CONST_SMS_WS_PARAM_NAME_USER_ID						=	"UserID";
	public static final	String	CONST_SMS_WS_PARAM_NAME_PASSWORD					=	"Pwd";
	public static final	String	CONST_SMS_WS_PARAM_NAME_MOBILE_NO					=	"MobileNo";
	public static final	String	CONST_SMS_WS_PARAM_NAME_MESSAGE						=	"Message";
	public static final	String	CONST_SMS_WS_PARAM_NAME_LANGUAGE					=	"Language";
	public static final	String	CONST_SMS_WS_PARAM_NAME_SCH_DATE					=	"SchDate";
	public static final	String	CONST_SMS_WS_PARAM_NAME_SENDER						=	"Sender";
	
	/************* PROPERTY FILE ******************************/
	public	static	String	RESOURCE_PROPERTY_FILE_MAIL								=	"mail";
}
