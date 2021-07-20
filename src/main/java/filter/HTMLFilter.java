package main.java.filter;

import javax.servlet.*;
import java.io.IOException;
/**
 *
 * HTML·ûºÅ¹ýÂËÀà
 * @author Administrator
 *
 */
public class HTMLFilter implements Filter {
    public void destroy() {
    }
    public static String escapeHTMLTags (String input ){

        if (input == null || input.length() == 0) {
            return input;
        }
        StringBuffer buf = new StringBuffer();
        char ch = ' ';
        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            if (ch == '<') {
                buf.append("&lt;");
            } else if (ch == '>') {
                buf.append("&gt;");
            } else if (ch == '&') {
                buf.append("&amp;");
            } else {
                buf.append(ch);
            }
        }
        return buf.toString();
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
