package com.test.example.handle;

import com.test.example.server.HandlerUtils;
import org.apache.kafka.common.utils.CollectionUtils;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class HelloServlet extends AbstractHandler {

    List<String> supList;

    public HelloServlet (List<String> list){
        this.supList =  list;
    }

    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {


        System.out.println(httpServletRequest.getRequestURI());
        if(supList.contains(httpServletRequest.getRequestURI())){
            System.out.println("hello world");
            HandlerUtils.markOkJson(httpServletResponse, "{\"msg\":\"ok\", \"eventId\":" + "}");
            System.out.println("hello world");

        }else{
            System.out.println("not");
            HandlerUtils.markOkJson(httpServletResponse, "{\"msg\":\"not\", \"eventId\":" + "}");
        }

//        HandlerUtils.markRedirect(httpServletResponse, "http://www.baidu.com");
    }
}
