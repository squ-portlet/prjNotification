package om.edu.squ.squportal.notification.dto;

import java.util.Date;

public class AppNotificationDto
{
	private String medium;
	private String response;
	private String toAddress;
	private String msg_subject;
	private String msg_text;
	private String lang;
	private Date dateSent;
	private String strDateSent;
	private String appName;
	private String appRef;
	private String refKey;
	private String comments;

	/**
	 * Getter Method : getMedium
	 * 
	 * @return the medium
	 * 
	 *         Date : Jul 10, 2017
	 */
	public String getMedium()
	{
		return medium;
	}

	/**
	 * Setter method : setMedium
	 * 
	 * @param medium
	 *            the medium to set
	 * 
	 *            Date : Jul 10, 2017 9:42:59 AM
	 */
	public void setMedium(String medium)
	{
		this.medium = medium;
	}

	/**
	 * Getter Method : getResponse
	 * 
	 * @return the response
	 * 
	 *         Date : Jul 10, 2017
	 */
	public String getResponse()
	{
		return response;
	}

	/**
	 * Setter method : setResponse
	 * 
	 * @param response
	 *            the response to set
	 * 
	 *            Date : Jul 10, 2017 9:42:59 AM
	 */
	public void setResponse(String response)
	{
		this.response = response;
	}

	/**
	 * Getter Method : getToAddress
	 * 
	 * @return the toAddress
	 * 
	 *         Date : Jul 10, 2017
	 */
	public String getToAddress()
	{
		return toAddress;
	}

	/**
	 * Setter method : setToAddress
	 * 
	 * @param toAddress
	 *            the toAddress to set
	 * 
	 *            Date : Jul 10, 2017 9:42:59 AM
	 */
	public void setToAddress(String toAddress)
	{
		this.toAddress = toAddress;
	}

	/**
	 * Getter Method : getMsg_subject
	 * 
	 * @return the msg_subject
	 * 
	 *         Date : Jul 10, 2017
	 */
	public String getMsg_subject()
	{
		return msg_subject;
	}

	/**
	 * Setter method : setMsg_subject
	 * 
	 * @param msg_subject
	 *            the msg_subject to set
	 * 
	 *            Date : Jul 10, 2017 9:42:59 AM
	 */
	public void setMsg_subject(String msg_subject)
	{
		this.msg_subject = msg_subject;
	}

	/**
	 * Getter Method : getMsg_text
	 * 
	 * @return the msg_text
	 * 
	 *         Date : Jul 10, 2017
	 */
	public String getMsg_text()
	{
		return msg_text;
	}

	/**
	 * Setter method : setMsg_text
	 * 
	 * @param msg_text
	 *            the msg_text to set
	 * 
	 *            Date : Jul 10, 2017 9:42:59 AM
	 */
	public void setMsg_text(String msg_text)
	{
		this.msg_text = msg_text;
	}

	/**
	 * Getter Method : getLang
	 * 
	 * @return the lang
	 * 
	 *         Date : Jul 10, 2017
	 */
	public String getLang()
	{
		return lang;
	}

	/**
	 * Setter method : setLang
	 * 
	 * @param lang
	 *            the lang to set
	 * 
	 *            Date : Jul 10, 2017 9:42:59 AM
	 */
	public void setLang(String lang)
	{
		this.lang = lang;
	}

	/**
	 * Getter Method : getDateSent
	 * 
	 * @return the dateSent
	 * 
	 *         Date : Jul 10, 2017
	 */
	public Date getDateSent()
	{
		return dateSent;
	}

	/**
	 * Setter method : setDateSent
	 * 
	 * @param dateSent
	 *            the dateSent to set
	 * 
	 *            Date : Jul 10, 2017 9:42:59 AM
	 */
	public void setDateSent(Date dateSent)
	{
		this.dateSent = dateSent;
	}

	/**
	 * Getter Method : getAppName
	 * 
	 * @return the appName
	 * 
	 *         Date : Jul 10, 2017
	 */
	public String getAppName()
	{
		return appName;
	}

	/**
	 * Setter method : setAppName
	 * 
	 * @param appName
	 *            the appName to set
	 * 
	 *            Date : Jul 10, 2017 9:42:59 AM
	 */
	public void setAppName(String appName)
	{
		this.appName = appName;
	}

	/**
	 * Getter Method : getAppRef
	 * 
	 * @return the appRef
	 * 
	 *         Date : Jul 10, 2017
	 */
	public String getAppRef()
	{
		return appRef;
	}

	/**
	 * Setter method : setAppRef
	 * 
	 * @param appRef
	 *            the appRef to set
	 * 
	 *            Date : Jul 10, 2017 9:42:59 AM
	 */
	public void setAppRef(String appRef)
	{
		this.appRef = appRef;
	}

	/**
	 * Getter Method : getRefKey
	 * 
	 * @return the refKey
	 * 
	 *         Date : Jul 10, 2017
	 */
	public String getRefKey()
	{
		return refKey;
	}

	/**
	 * Setter method : setRefKey
	 * 
	 * @param refKey
	 *            the refKey to set
	 * 
	 *            Date : Jul 10, 2017 9:42:59 AM
	 */
	public void setRefKey(String refKey)
	{
		this.refKey = refKey;
	}

	/**
	 * Getter Method : getComments
	 * 
	 * @return the comments
	 * 
	 *         Date : Jul 10, 2017
	 */
	public String getComments()
	{
		return comments;
	}

	/**
	 * Setter method : setComments
	 * 
	 * @param comments
	 *            the comments to set
	 * 
	 *            Date : Jul 10, 2017 9:42:59 AM
	 */
	public void setComments(String comments)
	{
		this.comments = comments;
	}

	/**
	 * @return the strDateSent
	 */
	public String getStrDateSent()
	{
		return strDateSent;
	}

	/**
	 * @param strDateSent the strDateSent to set
	 */
	public void setStrDateSent(String strDateSent)
	{
		this.strDateSent = strDateSent;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "AppNotificationDto [medium=" + medium + ", response=" + response + ", toAddress=" + toAddress
				+ ", msg_subject=" + msg_subject + ", msg_text=" + msg_text + ", lang=" + lang + ", dateSent="
				+ dateSent + ", strDateSent=" + strDateSent + ", appName=" + appName + ", appRef=" + appRef
				+ ", refKey=" + refKey + ", comments=" + comments + "]";
	}



}
