package com.cash.servlet.filter;

import com.cash.util.singleton.DbController;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@Log4j
@WebFilter({"/"})
public class IndexFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) { }

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        log.info("Filter on:/");

        DbController dbController = DbController.getInstance();
        dbController.removeTemplate();

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
