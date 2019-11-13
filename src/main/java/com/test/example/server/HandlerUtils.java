package com.test.example.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class HandlerUtils {
    private static final Logger logger = LoggerFactory.getLogger(HandlerUtils.class);
    private static final List<String> IP_HEADERS = Arrays.asList("x-real-ip", "x-forwarded-for", "http_x_forwarded_for", "Proxy-Client-IP", "WL-Proxy-Client-IP");

    public static void markBadRequest(HttpServletResponse resp) {
        markBadRequest(resp, "Bad Request");
    }

    public static void markBadRequest(HttpServletResponse resp, String info) {
        makeResp(resp, HttpServletResponse.SC_BAD_REQUEST, info);
    }

    public static void markOkResp(HttpServletResponse resp) {
        markOkResp(resp, "");
    }

    public static void markOkResp(HttpServletResponse resp, String content) {
        makeResp(resp, HttpServletResponse.SC_OK, content);
    }

    public static void markNotFound(HttpServletResponse resp) {
        makeResp(resp, 404, "Not Found");
    }

    public static void markServerInnerError(HttpServletResponse resp, String message) {
        makeResp(resp, 503, message);
    }

    public static void markOkJson(HttpServletResponse resp, String jsonContent) {
        makeJsonResp(resp, HttpServletResponse.SC_OK, jsonContent);
    }

    public static void markRedirect(HttpServletResponse resp, String redirectUrl) {
        String fUrl = resp.encodeRedirectURL(redirectUrl);
        resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        resp.setHeader("Location", fUrl);
    }

    private static void makeJsonResp(HttpServletResponse resp, int code, String content) {
        makeResp(resp, code, "application/json; charset=UTF-8", content);
    }

    private static void makeResp(HttpServletResponse resp, int code, String content) {
        makeResp(resp, code, "text/html; charset=UTF-8", content);
    }

    private static void makeResp(HttpServletResponse resp, int code, String contentType, String content) {
        enableCrosDomain(resp);
        resp.setContentType(contentType);
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(code);
        try {
            resp.getWriter().write(content);
            resp.flushBuffer();
        } catch (IOException e) {
            logger.error("write response failed", e);
        }
    }

    private static void enableCrosDomain(HttpServletResponse resp) {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Credentials", "true");
        resp.addHeader("Access-Control-Allow-Methods", "*");
    }

    public static String dunpIp(HttpServletRequest request) {
        String ip = null;
        for (String ipHeader : IP_HEADERS) {
            ip = request.getHeader(ipHeader);
            if (!Utils.isEmptyStr(ip))
                return ip;
        }
        return request.getRemoteAddr();
    }

    public static HttpServletResponse withCookie1Day(HttpServletResponse response, String key, String val) {
        Cookie cookie = new Cookie(key, val);
        cookie.setMaxAge(86400);
        response.addCookie(cookie);
        return response;
    }

    public static String dumpUa(HttpServletRequest request) {
        return request.getHeader("user-agent");
    }
}
