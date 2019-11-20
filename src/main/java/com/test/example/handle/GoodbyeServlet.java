package com.test.example.handle;

import com.test.example.server.HandlerUtils;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoodbyeServlet extends AbstractHandler {

    private static final Logger logger = LoggerFactory.getLogger(GoodbyeServlet.class);

    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {

        logger.info("fffffffffffffff-----{}", httpServletRequest.getHeader("re" +
                "" +
                "ferer"));

//        httpServletResponse.sendRedirect("http://baidu.com");

        httpServletResponse.setHeader("referer", null);
        String a2 = System.getenv("WEB_HOST");
        logger.info("2-----{}", a2);

//        httpServletResponse.sendRedirect(String.format("%s",a2));
        httpServletResponse.sendRedirect(String.format("http://%s/lp-2.html",a2));


    }
}
