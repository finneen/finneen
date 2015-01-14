package com.finneen.web.config;

import com.finneen.web.core.security.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Finneen on 2014/12/11.
 */
@Configuration
public class ShiroConfiguration {


    @Bean
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(this.securityManager());
        shiroFilter.setLoginUrl("/login.jsp");
        //加入过滤器
        Map<String, Filter> filters = new HashMap<String, Filter>();
        filters.put("authc", this.authenticationFilter());
        shiroFilter.setFilters(filters);

        //加入过滤器定义
        Map<String, String> filterChains = new HashMap<String, String>();
        filterChains.put("/home", "authc");
        shiroFilter.setFilterChainDefinitionMap(filterChains);

        SecurityUtils.setSecurityManager(this.securityManager());

        return shiroFilter;
    }


    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(this.userRealm());
        return securityManager;
    }

    @Bean
    public AuthenticationFilter authenticationFilter() {
        FormAuthenticationFilter authenticationFilter = new FormAuthenticationFilter();
        authenticationFilter.setUsernameParam("username");
        authenticationFilter.setPasswordParam("password");
        authenticationFilter.setLoginUrl("/login.jsp");
        return authenticationFilter;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public Realm userRealm(){
        return new UserRealm();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(this.securityManager());
        return advisor;
    }
}
