package com.cheng.controller.interceptor;

import com.cheng.constant.SessionKeyConst;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * session拦截器
 * Created by cheng on 2017/7/22.
 */

public class SessionInterceptor implements HandlerInterceptor {

    /**
     * 在进入Handler执行之前执行本方法
     *
     * @return true：执行下一个拦截器，知道所有拦截器都执行完，在执行被拦截的Controller
     * false：从当前拦截器往回执行之前的所有拦截器的afterCompletion()，再退出拦截器链
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (httpServletRequest.getSession().getAttribute(SessionKeyConst.USER_INFO) != null) {
            return true;
        }
        //针对ajax请求处理
        if (httpServletRequest.getHeader("x-requested-with") != null) {
            String basePath = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName()
                    + ":" + httpServletRequest.getServerPort() + httpServletRequest.getContextPath();
        } else {
            httpServletRequest.getRequestDispatcher("/login/sessionTimeOut").forward(httpServletRequest,httpServletResponse);
        }
        httpServletRequest.getRequestDispatcher("/login/sessionTimeOut").forward(httpServletRequest, httpServletResponse);
        return false;
    }

    /**
     * 在进入Handler执行之后，返回ModelAndView之前执行
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在进入Handler执行之后，返回ModelAndView之后执行
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
