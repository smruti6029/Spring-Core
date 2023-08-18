package con.configuration;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.employ.Dao")
public class configuration {
	
	
	
	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource ds =new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/employ_detalis");
		ds.setUsername("root");
		ds.setPassword("password");
		
		return ds;
	}
	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBean lsb = new LocalSessionFactoryBean();
		lsb.setDataSource(getDataSource());
		lsb.setHibernateProperties(hibernateProperties());
		lsb.setPackagesToScan("com.employ.Detalis.Entity");
		try {
			  lsb.afterPropertiesSet();
			} catch (IOException e) {
			  e.printStackTrace();
			}
		return lsb.getObject();
		
	}
	

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", true);
		return properties;
	}

	@Bean
	public HibernateTemplate hibernateTemplate()
	{
		return new HibernateTemplate(sessionFactory());
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		return new HibernateTransactionManager(sessionFactory());
	}
	
	

}
