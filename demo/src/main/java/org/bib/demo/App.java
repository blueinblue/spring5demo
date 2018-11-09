package org.bib.demo;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bib.demo.model.Singer;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;

public class App implements Serializable {
// Constructors

// Config
	@Configuration
	@ImportResource(locations={"classpath:/app-context.xml"})
	public static class AppConfig {
		@Lazy
		@Bean(initMethod="afterPropertiesSet")
		public Singer singerOne() {
			Singer singerOne = new Singer();
			singerOne.setName("John Mayer");
			singerOne.setAge(39);
			
			return singerOne;
		}
		
		@Lazy
		@Bean(initMethod="afterPropertiesSet")
		public Singer singerTwo() {
			Singer singerTwo = new Singer();
			singerTwo.setAge(29);
			
			return singerTwo;
		}
		
		@Lazy
		@Bean(initMethod="afterPropertiesSet")
		public Singer singerThree() {
			Singer singerThree = new Singer();
			
			singerThree.setName("P Diddy");
			
			return singerThree;
		}
	}
// Public Methods
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		getBean("singerOne", ctx);
		getBean("singerTwo", ctx);
		getBean("singerThree", ctx);
	}
	
	public static Singer getBean(String beanName, ApplicationContext ctx) {
		try {
			Singer bean = (Singer) ctx.getBean(beanName);
			
			logger.debug(bean);
			
			return bean;
		}
		catch(BeanCreationException e) {
			logger.error("An error occured in bean configuration.", e);
			
			return null;
		}
	}

// Getters & Setters

// Attributes
	/**
	 * Serialization
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Logger
	 */
	private static final Logger logger = LogManager.getLogger(App.class);
}
