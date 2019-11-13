package com.test.example.handle;

import com.test.example.server.HandlerUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoodServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {

        String ip = null;
        System.out.println(request.getHeader("X-Forwarded-For"));

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            System.out.println( request.getHeader("Proxy-Client-IP"));
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            System.out.println( request.getHeader("WL-Proxy-Client-IP"));
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            System.out.println( request.getHeader("HTTP_X_FORWARDED_FOR"));
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            System.out.println( request.getHeader("HTTP_X_FORWARDED"));
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            System.out.println( request.getHeader("HTTP_X_CLUSTER_CLIENT_IP"));
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            System.out.println( request.getHeader("HTTP_CLIENT_IP"));
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            System.out.println( request.getHeader("HTTP_FORWARDED_FOR"));
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            System.out.println( request.getHeader("HTTP_FORWARDED"));
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            System.out.println( request.getHeader("HTTP_VIA"));
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            System.out.println( request.getHeader("REMOTE_ADDR"));
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            System.out.println( request.getRemoteAddr());
        }
        HandlerUtils.markOkJson(response, "{\"msg\":\"ok\", \"hello\":" + "}");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Hello POST </h1>");
    }
}
