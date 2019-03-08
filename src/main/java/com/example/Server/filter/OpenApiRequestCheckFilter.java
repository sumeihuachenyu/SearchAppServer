package com.example.Server.filter;

import com.example.Server.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenovo on 2019-03-08.
 */
@Component
@WebFilter(urlPatterns = "/getVerifyByMobile", filterName = "OpenApiRequestCheckFilter")
public class OpenApiRequestCheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----------------------->过滤器被创建");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("----------------------->过滤器被拦截");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String apiKey = request.getParameter("sign"); //apiKey

        if (apiKey == null) {
            ///API签名验证失败，把请求转发到处理不合法请求的Controller
            UnauthorizedForward(request, response);
            return;
        }

        String apiSecret = "ssssss";

        ///对API接口签名进行验证
        boolean sigCheckResult = Utils.checkSig(request, apiSecret);
        if (sigCheckResult) {
            //API签名验证通过
            filterChain.doFilter(request, response);
        } else {
            ///API签名验证失败，把请求转发到处理不合法请求的Controller
            UnauthorizedForward(request, response);
        }
    }

    private void UnauthorizedForward(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ///查询不到接口配置，把请求转发到处理不合法请求的Controller
        if ("GET".equals(request.getMethod())) {
            //request.getRequestDispatcher("/api/dataCenterRequest/handleUnauthorizedGetRequest").forward(request, response);
            System.out.print("签名不合理");
        } else {
            // request.getRequestDispatcher("/api/dataCenterRequest/handleUnauthorizedPostRequest").forward(request, response);
            System.out.print("签名不合理");
        }
    }


    @Override
    public void destroy() {
        System.out.println("----------------------->过滤器被销毁");
    }


}
