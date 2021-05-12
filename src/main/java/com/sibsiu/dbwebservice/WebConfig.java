package com.sibsiu.dbwebservice;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration

public class WebConfig {
	@Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet ();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

	
	 @Bean(name = "webschema") public DefaultWsdl11Definition
	 defaultWsdl11Definition(XsdSchema webSchema) { DefaultWsdl11Definition
	 wsdl11Definition = new DefaultWsdl11Definition();
	 wsdl11Definition.setPortTypeName("WebPort");
	 wsdl11Definition.setLocationUri("/ws");
	 wsdl11Definition.setTargetNamespace("http://webservice");
	 wsdl11Definition.setSchema(webSchema); return wsdl11Definition; }
	 
	 @Bean
	    public XsdSchema webSchema() {
	        return new SimpleXsdSchema(new ClassPathResource("webschema.xsd"));
	    }
}
