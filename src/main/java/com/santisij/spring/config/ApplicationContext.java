package com.santisij.spring.config;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = {"com.santisij.spring"})
@EnableWebMvc
@Import({ ThymeleafConfig.class })
@ImportResource({ "/WEB-INF/spring-security.xml"})
public class ApplicationContext extends WebMvcConfigurerAdapter {

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("messages");
		return source;
	}
	@Bean
	public Properties retrieveSystemProperties(){
	return System.getProperties();
	}

	private Properties systemProperties;
	public Properties getSystemProperties() {
	return systemProperties;
	}
	@Resource(name="retrieveSystemProperties")
	public void setSystemProperties(Properties systemProperties) {
	this.systemProperties = systemProperties;
	}

	@Bean
	public MethodInvokingFactoryBean methodInvokingFactoryBean() {
		MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
		methodInvokingFactoryBean.setStaticMethod("java.lang.System.setProperties");
		systemProperties.setProperty("http.keepAlive", "false");
		methodInvokingFactoryBean.setArguments(new Object[]{systemProperties});
	return methodInvokingFactoryBean;
	} 

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
	}

}
