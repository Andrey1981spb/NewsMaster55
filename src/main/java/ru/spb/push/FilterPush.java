package ru.spb.push;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.LogRecord;

public class FilterPush implements javax.servlet.Filter {
    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        // читаем из конфигурации
        encoding = config.getInitParameter("requestEncoding");

        // если не установлена - устанавливаем UTF8
        if (encoding == null)
            encoding = "UTF8";
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
            throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        next.doFilter(request, response);
    }

    public void destroy() {
    }

    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
