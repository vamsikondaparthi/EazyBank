package com.org.eazybank.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.security.web.authentication.www.BasicAuthenticationConverter.AUTHENTICATION_SCHEME_BASIC;

public class RequestValidationBeforeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse res=(HttpServletResponse) servletResponse;
        String header=req.getHeader(AUTHORIZATION);
        if(header!=null){
            header=header.trim();

            if(StringUtils.startsWithIgnoreCase(header,AUTHENTICATION_SCHEME_BASIC)){
                byte[] base64Token=header.substring(6).getBytes(StandardCharsets.UTF_8);
                byte[] decoded;

                try{
                    decoded= Base64.getDecoder().decode(base64Token);
                    String token=new String(decoded,StandardCharsets.UTF_8);
                    int delim=token.indexOf(":");

                    if(delim==-1){
                        throw new BadCredentialsException("Invalid Basic Authentication token");
                    }

                    String email=token.substring(0,delim);

                    if(email.toLowerCase().contains("test")){

                        res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                        return;
                    }



                }
                catch (IllegalArgumentException e) {
                    throw new BadCredentialsException("Failed to decode basic authentication token");
                }
            }
        }

        filterChain.doFilter(req,res);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
