package maiji.neo4jEnglish.interceptor;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import maiji.neo4jEnglish.pojo.Result;
import maiji.neo4jEnglish.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override //目标资源方法运行前运行, 返回true: 放行, 放回false, 不放行
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        //1.获取请求url。
        String url = req.getRequestURL().toString();
        log.info("请求的url: {}",url);

        //2.获取请求头中的令牌（token）。
        String jwt = req.getHeader("token");

        //3.判断令牌是否存在，如果不存在，返回错误结果（未登录）。
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token为空,返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象 --> json
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }

        //4.解析token，如果解析失败，返回错误结果（未登录）。
        Claims claims;
        try {
            claims = JwtUtils.parseJWT(jwt);
            Integer permission = (Integer)claims.get("permission");
            if (url.contains("admin")){
                if (permission == 0) {
                    log.info("解析令牌失败, 返回无权限错误信息");
                    Result error = Result.error("NOT_ALLOWED");
                    //手动转换 对象 --> json
                    String notLogin = JSONObject.toJSONString(error);
                    resp.getWriter().write(notLogin);
                    return false;
                }
            }
            else if (url.contains("videos") && !req.getMethod().equals("GET")) {
                log.info("解析令牌失败, 返回无权限错误信息");
                Result error = Result.error("NOT_ALLOWED");
                //手动转换 对象 --> json
                String notLogin = JSONObject.toJSONString(error);
                resp.getWriter().write(notLogin);
                return false;
            }
        } catch (Exception e) { //jwt解析失败
            e.printStackTrace();
            log.info("解析令牌失败, 返回未登录错误信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象 --> json
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }

        //5.放行。
        log.info("令牌合法, 放行");
        return true;
    }
}
