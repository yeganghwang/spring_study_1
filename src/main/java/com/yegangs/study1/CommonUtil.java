package com.yegangs.study1;

import jakarta.servlet.http.HttpServletRequest;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil
{
    public String markdown(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String rawHtml = renderer.render(document);
        return Jsoup.clean(rawHtml, Safelist.relaxed());
    }

    public static String getClientIp(HttpServletRequest request) {
        String clientIp = request.getHeader("X-Forwarded-For");

        if (!isValidIp(clientIp)) clientIp = request.getHeader("Proxy-Client-IP");
        if (!isValidIp(clientIp)) clientIp = request.getHeader("WL-Proxy-Client-IP");
        if (!isValidIp(clientIp)) clientIp = request.getHeader("HTTP_CLIENT_IP");
        if (!isValidIp(clientIp)) clientIp = request.getHeader("HTTP_X_FORWARDED_FOR");
        if (!isValidIp(clientIp)) clientIp = request.getRemoteAddr();

        if (clientIp != null && clientIp.indexOf(",") > 0) {
            clientIp = clientIp.split(",")[0].trim();
        }
        return clientIp;
    }

    public static Boolean isValidIp(String clientIp) {
        return clientIp != null && !clientIp.isEmpty() && !"unknown".equalsIgnoreCase(clientIp);
    }
}
