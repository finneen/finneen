package com.finneen.web.config;

import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;

/**
 * Created by yaofeng on 2014/12/10.
 */
public class SpringWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {AppConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebMVCConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		//字符集拦截器
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
/*		
		ShiroFilter shiroFilter = new ShiroFilter();
		shiroFilter.setName("shiroFilter");*/

		DelegatingFilterProxy shiroFilter = new DelegatingFilterProxy();
		shiroFilter.setTargetFilterLifecycle(true);
		
		return new Filter[] {encodingFilter, shiroFilter};
	}
	
	@Override
	protected void registerContextLoaderListener(ServletContext servletContext) {
	    super.registerContextLoaderListener(servletContext);
	    EnvironmentLoaderListener eLoaderListener = new EnvironmentLoaderListener();
	    servletContext.addListener(eLoaderListener);	    
	}

}
