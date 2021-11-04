package com.ding.online_xdclass.exception;

import com.ding.online_xdclass.utils.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @Description 异常处理类
 * @Author 丁帅帅
 * @Date 21/11/04 15:27
 * @Version 1.0
 */
@ControllerAdvice
public class CustomExceptionHandler {


    private final static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handle(Exception e) {

        logger.error("[ 系统异常 ]{}",e);

        if ( e instanceof XDException) {
            XDException xdException = (XDException) e;

            return JsonData.buildError(xdException.getCode(), xdException.getMsg());
        } else {
            return JsonData.buildError("全局异常，未知错误");
        }
    }
}
