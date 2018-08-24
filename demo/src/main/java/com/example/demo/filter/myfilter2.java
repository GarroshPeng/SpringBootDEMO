package com.example.demo.filter;


import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@Order(2)
@WebFilter(urlPatterns = "/*",filterName = "doFilter2")

public class myfilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("do_init");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("TestFilter2");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
