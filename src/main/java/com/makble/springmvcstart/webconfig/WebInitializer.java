package com.makble.springmvcstart.webconfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.makble.springmvcstart.config.BasicConfig;
import com.makble.springmvcstart.config.MvcConfig;

public class WebInitializer implements WebApplicationInitializer{
	@Override
	public void onStartup( ServletContext servletContext ) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		
		ctx.register(BasicConfig.class, MvcConfig.class);
		servletContext.addListener( new ContextLoaderListener( ctx ) );
		
		AnnotationConfigWebApplicationContext dispatchCtx = new AnnotationConfigWebApplicationContext();
		ServletRegistration.Dynamic dispatcher;
		
		dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatchCtx));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
}