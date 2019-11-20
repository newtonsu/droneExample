package com.test.example.server;

import com.test.example.handle.*;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Service {
    public static void main(String[] args) {

        Server server = new Server(8890);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/tracker/");
        context.addServlet(new ServletHolder(new MyServlet()), "/*");
//        context.addFilter(new FilterHolder(new APPFilter()), "/*", EnumSet.of(DispatcherType.INCLUDE,DispatcherType.REQUEST));

//        ServletContextHandler context1 = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context1.setContextPath("/tracker/");
//        context1.addServlet(new ServletHolder(new GoodServlet()), "/*");

//        ContextHandler context2 = new ContextHandler();
//        context2.setContextPath("/click/");
//        context2.setResourceBase(".");
//        context2.setClassLoader(Thread.currentThread().getContextClassLoader());
//        context2.setHandler(new GoodbyeServlet());
//
//        ContextHandler context3 = new ContextHandler();
//        context3.setContextPath("/click1/");
//        context3.setResourceBase(".");
//        context3.setClassLoader(Thread.currentThread().getContextClassLoader());
//        context3.setHandler(new GoodbyeServlet1());
//
//        ContextHandler context4 = new ContextHandler();
//        context4.setContextPath("/click2/");
//        context4.setResourceBase(".");
//        context4.setClassLoader(Thread.currentThread().getContextClassLoader());
//        context4.setHandler(new GoodbyeServlet2());
//
//        ContextHandler context5 = new ContextHandler();
//        context5.setContextPath("/click4/");
//        context5.setResourceBase(".");
//        context5.setClassLoader(Thread.currentThread().getContextClassLoader());
//        context5.setHandler(new GoodbyeServlet4());

//        ServletContextHandler context3 = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context1.setContextPath("/post/");
//        context1.addServlet(new ServletHolder(new GoodServlet()), "/*");

        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[]{context});

        server.setHandler(contexts);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
