package cn.yaofeng.finneen.secutiry.web.controller;

import cn.yaofeng.finneen.core.controller.BaseController;
import cn.yaofeng.finneen.system.user.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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

        logger.info("host: {}", token.getHost());

        subject.login(token);

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
