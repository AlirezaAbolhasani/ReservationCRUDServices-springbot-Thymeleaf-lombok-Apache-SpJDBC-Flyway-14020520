package com.webkaiser.easyappartment.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * *Developer: ALireza Abolhasani
 * 8/18/2023
 * 1:37 AM
 **/

@Component
@Order(1)
public class ReservationController implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String remoteAddress= request.getRemoteAddr();
        if (remoteAddress.equals("127.0.0.1")){
            destroy();
        }else{
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
