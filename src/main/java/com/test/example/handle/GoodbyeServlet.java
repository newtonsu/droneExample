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

        logger.info("ddddddddddddd");
        logger.debug("eeeeeeeeee");
        logger.error("fffffffffffffff");
        HandlerUtils.markOkJson(httpServletResponse, "{\"msg\":\"ok\", \"goodbye\":" + "}");

    }
}
