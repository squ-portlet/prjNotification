package om.edu.squ.squportal.notification.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import om.edu.squ.squportal.notification.dto.AppNotificationDto;

@Repository
public class AppNotificationDaoImpl implements AppNotificationDao
{
	@Autowired
	@Qualifier("notificationSqlQueryProp")
	private Properties notificationSqlQueries;

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource notificationDataSource)
	{
		this.jdbcTemplate = new NamedParameterJdbcTemplate(notificationDataSource);

	}
	
	public long insert(AppNotificationDto dto)
	{
		long result = 0;
		String sqlQuery = notificationSqlQueries.getProperty("insertNotification");
		
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("MEDIUM",dto.getMedium());
		paramMap.put("RESPONSE",dto.getResponse());
		paramMap.put("TO_ADDRESS",dto.getToAddress());
		paramMap.put("MSG_TEXT",dto.getMsg_text());
		paramMap.put("LANG",dto.getLang());
		paramMap.put("DATE_SENT",dto.getDateSent());
		paramMap.put("APP_NAME",dto.getAppName());		
		paramMap.put("APP_REF",dto.getAppRef());
		paramMap.put("REF_KEY",dto.getRefKey());
		paramMap.put("COMMENTS",dto.getComments());
		paramMap.put("MSG_SUBJECT",dto.getMsg_subject());
		
		result = jdbcTemplate.update(sqlQuery, paramMap);
		
		return result;
	}
	
}
