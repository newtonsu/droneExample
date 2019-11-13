package com.test.example.server;

import com.test.example.handle.GoodbyeServlet;
import com.test.example.handle.MyServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Service {
    public static void main(String[] args) {
//        Server server = new Server(8080);
//        // http://localhost:8080/hello/kongxx
//        ContextHandler context1 = new ContextHandler();
//        context1.setContextPath("*");
//        context1.setResourceBase(".");
//        context1.setClassLoader(Thread.currentThread().getContextClassLoader());
//        List<String> list = new ArrayList<>();
//        list.add("/pb/");
//        list.add("/event/");
//        list.add("/postback/");
//        context1.setHandler(new HelloServlet(list));
        // http://localhost:8080/goodbye/kongxx

        Server server = new Server(8888);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/tracker/");
        context.addServlet(new ServletHolder(new MyServlet()), "/*");
//        context.addFilter(new FilterHolder(new APPFilter()), "/*", EnumSet.of(DispatcherType.INCLUDE,DispatcherType.REQUEST));

//        ServletContextHandler context1 = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context1.setContextPath("/tracker/");
//        context1.addServlet(new ServletHolder(new GoodServlet()), "/*");

        ContextHandler context2 = new ContextHandler();
        context2.setContextPath("/click/");
        context2.setResourceBase(".");
        context2.setClassLoader(Thread.currentThread().getContextClassLoader());
        context2.setHandler(new GoodbyeServlet());

//        ServletContextHandler context3 = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context1.setContextPath("/post/");
//        context1.addServlet(new ServletHolder(new GoodServlet()), "/*");

        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[] {  context,context2 });

        server.setHandler(contexts);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
