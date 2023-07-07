package maiji.neo4jEnglish.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
@WebFilter(urlPatterns = {"/neo4j/*","/login","/register","/EQuestion/*","/admin/*"})
public class CustomCorsFilter implements Filter {

    @Value("${maiji.cors-allowed-port}")
    private String port;

    @Value("${maiji.cors-allowed-domain-name}")
    private String domainName;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.setHeader("Access-Control-Allow-Origin", "http://" + domainName + ":" + port); // 允许访问的来源地址
        res.setHeader("Access-Control-Allow-Methods", "*"); // 允许请求的HTTP Method
        res.setHeader("Access-Control-Allow-Headers", "*"); // 允许的请求头列表
        chain.doFilter(request, response);
    }
}