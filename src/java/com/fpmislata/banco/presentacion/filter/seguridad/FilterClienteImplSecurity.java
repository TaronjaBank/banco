package com.fpmislata.banco.presentacion.filter.seguridad;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class FilterClienteImplSecurity implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(filterConfig.getServletContext());
        AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext.getAutowireCapableBeanFactory();
        autowireCapableBeanFactory.autowireBean(this);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String URI = httpServletRequest.getContextPath() + "api/Session/Cliente";

        HttpSession httpSession = httpServletRequest.getSession(true);
        String loginCliente = (String) httpSession.getAttribute("loginCliente");

        Boolean logueado;
        Boolean permitido;

        if (loginCliente == null) {
            logueado = false;
        } else {
            logueado = true;
        }
        
        if (httpServletRequest.getRequestURI().equals(URI)){
            permitido = true;
        } else {
            if (logueado){
                permitido = true;
            } else {
                permitido = false;
            }
        }
        
        if (permitido){
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } else {
            httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    @Override
    public void destroy() {

    }

}
