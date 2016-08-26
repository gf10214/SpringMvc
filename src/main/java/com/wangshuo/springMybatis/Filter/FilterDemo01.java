package com.wangshuo.springMybatis.Filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2016/7/11 0011.
 */
public class FilterDemo01 implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----过滤器初始化----");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //对request和response进行一些预处理
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=UTF-8");

        System.out.println("FilterDemo01执行前！！！");
        filterChain.doFilter(servletRequest, servletResponse);  //让目标资源执行，放行
        System.out.println("FilterDemo01执行后！！！");
    }

    public void destroy() {
        System.out.println("----过滤器销毁----");
    }
}
