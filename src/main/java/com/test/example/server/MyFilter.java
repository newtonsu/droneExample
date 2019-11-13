package com.test.example.server;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

public class MyFilter implements Filter {

    public void destroy() {
        System.out.println("Stopping filter");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter called with: " + request);

//        chain.doFilter(request, response);
//        ParameterTrimRequest trimReqeust= new ParameterTrimRequest((HttpServletRequest) request);
//        chain.doFilter(trimReqeust, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        Enumeration<String> enums = filterConfig.getInitParameterNames();

        while (enums.hasMoreElements()) {
            String param = (String) enums.nextElement();
            System.out.println(param + ":" + filterConfig.getInitParameter(param));
        }
    }

}


