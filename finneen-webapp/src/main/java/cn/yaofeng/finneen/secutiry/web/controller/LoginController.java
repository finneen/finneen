package cn.yaofeng.finneen.secutiry.web.controller;

import cn.yaofeng.finneen.core.controller.BaseController;
import cn.yaofeng.finneen.system.user.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 登录控制器
 *
 * Created by Finneen on 2015/1/14.
 */
@Controller
public class LoginController extends BaseController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        if(SecurityUtils.getSubject().isAuthenticated()) {
            return redirect + "/";
        }

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user) {

        logger.info("account: {}", user.getAccount());
        logger.info("password: {}", user.getPassword());

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), user.getPassword());


        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            logger.error("用户名不存在", uae);
            throw uae;
        } catch (IncorrectCredentialsException ice) {
            logger.error("密码错误", ice);
            throw ice;
        } catch (Exception e) {
            logger.error("未知错误", e);
            throw e;
        }


        return redirect + "/";
    }

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/unauth", method = RequestMethod.GET)
    public String unauth() {
        return "unauth";
    }
}
