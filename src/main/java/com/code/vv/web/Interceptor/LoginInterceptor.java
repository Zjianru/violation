package com.code.vv.web.Interceptor;

import com.code.vv.common.Const;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 2020/8/25.
 * com.code.vv.web.Interceptor
 *
 * @author Zjianru
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Object obj = request.getSession().getAttribute(Const.USER_SESSION_KEY);
        // 如果user不为空则放行
        if (null != obj) {
            return true;
        }
        // 否则拦截并跳转到登录
        response.sendRedirect("/loginPage");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
