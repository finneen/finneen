package cn.yaofeng.finneen.shiro.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by yaofeng on 2015/1/15.
 */
@Component(value = "finneenpers")
public class FinneenPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {

		Boolean isPermitted = Boolean.TRUE;

		Subject subject  = SecurityUtils.getSubject();

		//Subject subject = getSubject(request, response);


		logger.info("{}", mappedValue);


		logger.info("{}, {}", subject.getPrincipals());


		logger.info("{}", subject.isAuthenticated());

		logger.info("{}", subject.isPermitted("/hi"));

		logger.info("{}", subject.hasRole("role"));
		logger.info("{}", subject.hasRole("role-1"));



		logger.info("{}", subject.getPrincipal());

		HttpServletRequest req = (HttpServletRequest) request;

		logger.info("uri: {}, url: {}, host: {}", req.getRequestURI(), req.getRequestURL(), subject.getSession().getHost());

		return isPermitted;
	}
}
