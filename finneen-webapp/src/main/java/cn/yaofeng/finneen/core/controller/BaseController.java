package cn.yaofeng.finneen.core.controller;

import cn.yaofeng.finneen.core.log.BaseLogger;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
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

        logger.error("exception: ", e);

        return redirect + "/login";
    }
}
