package com.test.example.server;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class APPFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("----------------------->过滤器被创建");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            System.out.println(123);
//            ParameterTrimRequest trimReqeust= new ParameterTrimRequest((HttpServletRequest) servletRequest);
//            filterChain.doFilter(trimReqeust, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("----------------------->过滤器被销毁");
    }

}
