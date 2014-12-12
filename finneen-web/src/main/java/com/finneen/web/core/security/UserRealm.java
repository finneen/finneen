package com.finneen.web.core.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yaofeng on 2014/12/12.
 */
public class UserRealm extends AuthorizingRealm {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.info("authc:" + token.getPrincipal());
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("admin", "admin", null, getName());
		return authenticationInfo;
	}
}
