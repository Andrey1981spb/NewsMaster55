package ru.spb.login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FilterLogin")
public class FilterLogin implements Filter {

    ServletContext servletContext;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;

        String uri = httpServletRequest.getRequestURI();
        HttpSession session = httpServletRequest.getSession(false);

        if (session == null && !(uri.endsWith("loginPage"))){
            httpServletResponse.sendRedirect("/loginPage.jsp");
        } else {
            chain.doFilter(req,resp);

        }

    }

    public void init(FilterConfig config) throws ServletException {
        this.servletContext = config.getServletContext();
    }

}
