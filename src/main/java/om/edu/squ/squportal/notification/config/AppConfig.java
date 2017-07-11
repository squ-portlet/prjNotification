package om.edu.squ.squportal.notification.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
public class AppConfig
{
	@Bean(destroyMethod = "")
	public DataSource notificationDataSource()
	{
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);
		DataSource notificationDataSource = dsLookup.getDataSource("jdbc/testuser");
		return notificationDataSource;
	}
	
	@Bean
	public PropertiesFactoryBean notificationSqlQueryProp()
	{
		PropertiesFactoryBean prop = new PropertiesFactoryBean();
		prop.setLocation(new ClassPathResource("sql/notificationSqlQueries.xml"));
		return prop;
	}
}
