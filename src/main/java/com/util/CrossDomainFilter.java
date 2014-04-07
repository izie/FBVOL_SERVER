package com.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by changmatthew on 2014. 4. 7..
 */
public class CrossDomainFilter implements Filter {
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse servletResponse,
                         FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        if (!(request instanceof HttpServletRequest)) {
            throw new ServletException("This filter can "
                    + " only process HttpServletRequest requests");
        }
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "origin, x-requested-with, content-type, accept");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }
}