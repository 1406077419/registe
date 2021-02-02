package com.registe.brick.userbrick.interceptor;


import com.alibaba.fastjson.JSON;
import com.registe.brick.userbrick.util.AuthUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class AuthInterceptor implements HandlerInterceptor {

    //private Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    /**
     * 忽略拦截的url
     */
    private String urls[] = {
            "/login/.*",
            "/compute/.*"
    };

    /**
     * 进入controller层之前拦截请求
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String url = httpServletRequest.getRequestURI();
        // 白名单无需拦截
        for (String item : this.urls) {
            if (Pattern.matches(item, url)) {
                return true;
            }
        }

        // 获取token参数
        String token = httpServletRequest.getParameter("token");
        boolean verFlag = AuthUtil.verify(token);

        if (verFlag){
            return true;
        }else{
            try{
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setContentType("application/json; charset=utf-8");
                PrintWriter out = null;
                Map<String,String> resMap = new HashMap<>();
                out = httpServletResponse.getWriter();
                resMap.put("status","fail");
                resMap.put("msg","身份登录信息过期，请重新登录");
                String json =  JSON.toJSONString(resMap);
                out.append(json);
                out.flush();

                return false;
            }catch (Exception e){
                e.printStackTrace();
                httpServletResponse.sendError(500);
                return false;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }


}
