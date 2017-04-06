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
 * File Name			:	SendSMS1Soap.java
 * Package Name			:	om.edu.squ.squportal.notification.sms
 * Date of creation		:	Apr 6, 2017  10:47:40 AM
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

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import om.edu.squ.squportal.notification.sms.soap.ObjectFactory;
import om.edu.squ.squportal.notification.utility.Constants;



/**
 * @author Bhabesh
 *
 */
@WebService (name=Constants.CONST_SMS_PORT_TYPE, targetNamespace=Constants.CONST_SMS_WEB_SERVICE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SendSMS1Soap
{
	/**
	 * 
	 * method name  : SendSingleSMS
	 * @param userID
	 * @param pwd
	 * @param mobileNo
	 * @param message
	 * @param language
	 * @param schDate
	 * @param sender
	 * @return
	 * SendSMS1Soap
	 * return type  : String
	 * 
	 * purpose		: WS method for connecting thirdparty s/w to sending single SMS 
	 *
	 * Date    		:	Apr 6, 2017 12:03:36 PM
	 */
	@WebMethod(operationName =Constants.CONST_SMS_OPERATION_SEND_SINGLE_SMS, action=Constants.CONST_SMS_OPERATION_SEND_SINGLE_SMS_URL)
	@WebResult(name = Constants.CONST_SMS_RESULT_SEND_SINGLE_SMS, targetNamespace=Constants.CONST_SMS_WEB_SERVICE)
	@RequestWrapper(localName=Constants.CONST_SMS_OPERATION_SEND_SINGLE_SMS,targetNamespace=Constants.CONST_SMS_WEB_SERVICE,className=Constants.CONST_SMS_OPERATION_CLASS_SEND_SINGLE_SMS)
	@ResponseWrapper(localName=Constants.CONST_SMS_RESPONSE_SEND_SINGLE_SMS,targetNamespace=Constants.CONST_SMS_WEB_SERVICE,className=Constants.CONST_SMS_OPERATION_RESPONSE_CLASS_SEND_SINGLE_SMS)
	public String SendSingleSMS(
			@WebParam(name=Constants.CONST_SMS_WS_PARAM_NAME_USER_ID,targetNamespace=Constants.CONST_SMS_WEB_SERVICE)
			String	userID,
			@WebParam(name=Constants.CONST_SMS_WS_PARAM_NAME_PASSWORD,targetNamespace=Constants.CONST_SMS_WEB_SERVICE)
			String	pwd,
			@WebParam(name=Constants.CONST_SMS_WS_PARAM_NAME_MOBILE_NO,targetNamespace=Constants.CONST_SMS_WEB_SERVICE)
			String	mobileNo,
			@WebParam(name=Constants.CONST_SMS_WS_PARAM_NAME_MESSAGE,targetNamespace=Constants.CONST_SMS_WEB_SERVICE)
			String	message,
			@WebParam(name=Constants.CONST_SMS_WS_PARAM_NAME_LANGUAGE,targetNamespace=Constants.CONST_SMS_WEB_SERVICE)
			String language,
			@WebParam(name=Constants.CONST_SMS_WS_PARAM_NAME_SCH_DATE,targetNamespace=Constants.CONST_SMS_WEB_SERVICE)
			String schDate,
			@WebParam(name=Constants.CONST_SMS_WS_PARAM_NAME_SENDER,targetNamespace=Constants.CONST_SMS_WEB_SERVICE)
			String sender
	);
}
