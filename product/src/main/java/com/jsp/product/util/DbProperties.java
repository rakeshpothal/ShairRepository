package com.jsp.product.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DbProperties {
//	private static SessionFactory SESSION_FACTORY = null;
	private static Configuration DATABASE_CONFIGURATION = null;
	
	private DbProperties() {
		super();
	}


//	public static SessionFactory getDbConnection() {	
////		if(SESSION_FACTORY==null) {
////			Configuration configuration = new Configuration();
////			configuration.addProperties(getDbProperties());
////			SESSION_FACTORY = configuration.buildSessionFactory();
////		}
////		return SESSION_FACTORY;
//	}
	
	public static Configuration dbConfig() {
		if(DATABASE_CONFIGURATION==null) {
			DATABASE_CONFIGURATION = new Configuration();
			DATABASE_CONFIGURATION.setProperties(getDbProperties());
		}
		return DATABASE_CONFIGURATION;
	}
	
	private static Properties getDbProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/java_project_exp_practice");
		properties.setProperty("hibernate.connection.username", "root");
		properties.setProperty("hibernate.connection.password", "root");
//		properties.setProperty("hibernate.show_sql", "true");
		return properties;
	}

}
