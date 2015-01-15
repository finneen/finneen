package cn.yaofeng.finneen.shiro;

import cn.yaofeng.finneen.system.user.entity.User;
import cn.yaofeng.finneen.system.user.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 认证授权
 *
 * Created by Finneen on 2015/1/13.
 */
@Component(value = "shiroDbRealm")
public class ShiroDbRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);

    private static final String HASH_ALGORITHM = "MD5";
    private static final int HASH_INTERATIONS = 1;

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        logger.info("授权");
        logger.info("user: {}", principals.getPrimaryPrincipal());

        SimpleAuthorizationInfo sazi = new SimpleAuthorizationInfo();
        sazi.addStringPermission("/hi");
        sazi.addStringPermission("/hi/**");
        sazi.addRole("role-1");
        return sazi;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String account = (String) token.getPrincipal();
        User user = userService.findByAccount(account);

        logger.info("account: {} | password: {}", account, token.getCredentials());

        SimpleAuthenticationInfo info = null;

        if(user != null) {

            info = new SimpleAuthenticationInfo(user.getAccount(), user.getPassword(), getName());

        }
        return info;
    }

    /**
     * 设定Password校验的Hash算法与迭代次数.
     */
    @PostConstruct
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(HASH_ALGORITHM);
        matcher.setHashIterations(HASH_INTERATIONS);
        setCredentialsMatcher(matcher);
    }

}
