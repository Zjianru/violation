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
    /**
     * 前置处理
     * 判断 session 中是否有指定内容
     * 判断用户登陆状态
     * @param request request
     * @param response response
     * @param handler handler
     * @return boolean
     * @throws Exception Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Object user = request.getSession().getAttribute(Const.USER_SESSION_KEY);
        // 如果 session 中 user 不为空，则放行
        if (null != user) {
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
