package cn.yaofeng.finneen.core.controller;

import cn.yaofeng.finneen.core.log.BaseLogger;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 控制器基类
 *
 * Created by Finneen on 2015/1/14.
 */
public class BaseController extends BaseLogger {

    public String redirect = "redirect:";

    /**
     * 异常处理
     *
     * @param e
     */
    @ExceptionHandler
    public String exception(Exception e) {

        if(e instanceof AuthenticationException) {
            logger.error("账号验证失败", e);
        } else {
            logger.error("exception: ", e);
        }

        return redirect + "/login";
    }
}
