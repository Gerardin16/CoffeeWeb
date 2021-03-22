package com.groupthree.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.groupthree.bean.CoffeeAddon;
import com.groupthree.bean.CoffeeBill;
import com.groupthree.bean.CoffeeOrder;
import com.groupthree.bean.CoffeeSize;
import com.groupthree.bean.CoffeeType;
import com.groupthree.bean.CoffeeVoucher;
import com.groupthree.bean.PersonDetails;


@Configuration
@ComponentScan(basePackages = "com.groupthree")
@EnableWebMvc
public class CoffeeWebConfig implements WebMvcConfigurer {


	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	    }
	   
	
	@Bean(name="dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		driverManagerDataSource.setUsername("system");
		driverManagerDataSource.setPassword("wiley123");
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		return driverManagerDataSource;
		}
	@Bean(name="sessionFactory")
	 public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setAnnotatedClasses(CoffeeAddon.class,CoffeeBill.class,CoffeeOrder.class,
	        		CoffeeSize.class,CoffeeType.class,CoffeeVoucher.class,PersonDetails.class);
	        sessionFactory.setHibernateProperties(hibernateProperties());

	        return sessionFactory;
	    }
	
	private final Properties hibernateProperties() {
		 Properties hibernateProperties = new Properties();
	        hibernateProperties.setProperty(
	          "hibernate.hbm2ddl.auto", "update");
	        hibernateProperties.setProperty(
	          "hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
	        hibernateProperties.setProperty(
			          "hibernate.show_sql", "false");
	        return hibernateProperties;

	}
}

