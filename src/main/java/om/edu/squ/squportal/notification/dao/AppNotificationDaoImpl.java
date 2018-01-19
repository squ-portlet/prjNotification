package om.edu.squ.squportal.notification.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import om.edu.squ.squportal.notification.dto.AppNotificationDto;

@Repository
public class AppNotificationDaoImpl implements AppNotificationDao, RowMapper<AppNotificationDto>
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
	
	@Override
	public AppNotificationDto mapRow(ResultSet rs, int arg1) throws SQLException
	{
		AppNotificationDto dto = new AppNotificationDto();
		
		dto.setAppName(rs.getString("APP_NAME"));
		dto.setAppRef(rs.getString("APP_REF"));
		dto.setComments(rs.getString("COMMENTS"));
		dto.setDateSent(rs.getDate("DATE_SENT"));
		dto.setLang(rs.getString("LANG"));
		dto.setMedium(rs.getString("MEDIUM"));
		dto.setMsg_subject(rs.getString("MSG_SUBJECT"));
		dto.setMsg_text(rs.getString("MSG_TEXT"));
		dto.setRefKey(rs.getString("REF_KEY"));
		dto.setResponse(rs.getString("RESPONSE"));
		dto.setToAddress(rs.getString("TO_ADDRESS"));
		dto.setStrDateSent(rs.getString("STR_DATE_SENT"));
		
		return dto;
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

	@Override
	public List<AppNotificationDto> getAll(String appName)
	{
		String strQuery = "select APP_NOTIFICATION.*, to_char(DATE_SENT,'DD/MM/YYYY HH24:MI') str_date_sent from APP_NOTIFICATION where APP_NAME=:appName order by date_sent desc";
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("appName",appName);
		List<AppNotificationDto> notificationList = jdbcTemplate.query(strQuery, paramMap, this);
		return notificationList;
	}

	
	
}
