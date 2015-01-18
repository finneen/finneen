package cn.yaofeng.finneen.shiro.filter;

import org.apache.commons.lang3.StringUtils;
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

        Boolean isPermitted = Boolean.FALSE;

        Subject subject = SecurityUtils.getSubject();
        HttpServletRequest req = (HttpServletRequest) request;

        if (subject.isAuthenticated()) {
            String contextPath = req.getContextPath();
            String uri = req.getRequestURI();

            int i = uri.indexOf(contextPath);
            if (i > -1) {
                uri = uri.substring(i + contextPath.length());
            }
            if (StringUtils.isBlank(uri)) {
                uri = "/";
            }

            if ("/".equals(uri)) {
                isPermitted = Boolean.TRUE;
            } else {
                isPermitted = subject.isPermitted(uri);
            }

        } else {
            //未登录

        }


        logger.info("uri: {}, url: {}, host: {}", req.getRequestURI(), req.getRequestURL(), subject.getSession().getHost());

        return isPermitted;
    }
}
