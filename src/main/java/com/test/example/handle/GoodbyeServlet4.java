package com.test.example.handle;

import com.alibaba.fastjson.JSON;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoodbyeServlet4 extends AbstractHandler {

    private static final Logger logger = LoggerFactory.getLogger(GoodbyeServlet4.class);

    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {

        logger.info("1-----{}",httpServletRequest.getHeader("referer"));

        logger.info("2-----{}", JSON.toJSONString(httpServletRequest));
        String a1 = System.getenv("WEB_HOST");
//        logger.info("1-----{}", a1);
//        httpServletResponse.sendRedirect(a1);
//        httpServletResponse.sendRedirect("http://54.93.73.33:30101/lp-1.html");
        httpServletResponse.sendRedirect(String.format("http://%s/lp-1.html",a1));

    }
}
