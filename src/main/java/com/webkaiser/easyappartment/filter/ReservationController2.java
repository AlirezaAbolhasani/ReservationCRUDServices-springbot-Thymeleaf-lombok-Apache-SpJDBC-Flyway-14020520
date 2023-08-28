package com.webkaiser.easyappartment.filter;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * *Developer: ALireza Abolhasani
 * 8/28/2023
 * 9:52 AM
 **/

@Component
@Order(2)
public class ReservationController2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("++++++++++Second Filter2222222222 ++++++++++++++");
        System.out.println(request.getRemoteAddr());
        System.out.println("++++++++++Second Filter2222222222 ++++++++++++++");

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
