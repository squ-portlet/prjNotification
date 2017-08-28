package om.edu.squ.squportal.notification.dao;

import java.util.List;

import om.edu.squ.squportal.notification.dto.AppNotificationDto;

public interface AppNotificationDao
{
	public long insert(AppNotificationDto dto);

	public List<AppNotificationDto> getAll(String appName);


}
