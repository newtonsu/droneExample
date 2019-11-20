package com.test.example.handle;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoodbyeServlet1 extends AbstractHandler {

    private static final Logger logger = LoggerFactory.getLogger(GoodbyeServlet1.class);

    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {

        logger.info("fffffffffffffff-----{}",httpServletRequest.getHeader("referer"));

        String a3 = System.getenv("WEB_HOST");

        logger.info("3-----{}", a3);
//        httpServletResponse.sendRedirect("http://54.93.73.33:30101/lp-3.html");
        httpServletResponse.sendRedirect(String.format("http://%s/lp-3.html",a3));


    }
}
