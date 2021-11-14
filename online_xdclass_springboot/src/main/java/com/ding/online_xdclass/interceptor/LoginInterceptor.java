package com.ding.online_xdclass.interceptor;

import com.ding.online_xdclass.utils.JWTUtils;
import com.ding.online_xdclass.utils.JsonData;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description 登录拦截器
 * @Author 丁帅帅
 * @Date 21/11/06 15:41
 * @Version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 进入controller之前的方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       try {

           String accesToken = request.getHeader("token");
           if (accesToken == null) {
               accesToken = request.getParameter("token");
           }

           if (StringUtils.isNoneBlank(accesToken)) {
               Claims claims = JWTUtils.checkJWT(accesToken);
               if (claims == null) {
                   //告诉登录过期,重新登录
                   sendJsonMessage(response, JsonData.buildError("登录过期,重新登录"));
                   return false;
               }
               Integer id = (Integer) claims.get("id");
               String name = (String) claims.get("name");

               request.setAttribute("user_id", id);
               request.setAttribute("name",name);

               return true;
           }

       } catch ( Exception e) {

       }

        sendJsonMessage(response, JsonData.buildError("登录过期，重新登录"));

        return false;
    }

    /**
     * 响应json数据给前端
     * @param response
     * @param obj
     */
    private void sendJsonMessage(HttpServletResponse response, Object obj) {
        try {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = null;

        writer = response.getWriter();
        writer.print(objectMapper.writeValueAsBytes(obj));
        writer.close();
        response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
