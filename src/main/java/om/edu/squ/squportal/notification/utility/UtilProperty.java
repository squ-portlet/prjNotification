/**
 * 
 */
package om.edu.squ.squportal.notification.utility;

import java.util.Locale;

import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author Bhabesh
 *
 */
public class UtilProperty 
{
	private static ResourceBundleMessageSource resourceBundle;
	
	 private UtilProperty()
	 {

	 };
	 
	 /**
	  * 
	  * method name  : getMailProp
	  * @param code
	  * @param args
	  * @return
	  * UtilProperty
	  * return type  : String
	  * 
	  * purpose		:
	  *
	  * Date    		:	Jul 25, 2017 9:11:55 AM
	  */
	 public static String getMailProp(String code, Object[] args)
	 {
		 getMailResource();
		 return resourceBundle.getMessage(code, args, Locale.ENGLISH);
	 }
	 
	 /**
	  * 
	  * method name  : getMailResource
	  * UtilProperty
	  * return type  : void
	  * 
	  * purpose		:
	  *
	  * Date    		:	Jul 25, 2017 9:12:22 AM
	  */
	 private static void getMailResource()
	 {
		 resourceBundle	=	new ResourceBundleMessageSource();
		 resourceBundle.setBasenames(new String[] {Constants.RESOURCE_PROPERTY_FILE_MAIL});
	 }
}
