package com.example.buyhouse.interceptor;

import com.example.buyhouse.util.jwttoken;
import com.example.buyhouse.util.StringUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path=request.getRequestURI();
        System.out.println("path="+path);
        if(handler instanceof HandlerMethod){
            // 判断token是否为空
            String token=request.getHeader("token");
            System.out.println("token="+token);
            if(StringUtil.isEmpty(token)){
                System.out.println("token为空！");
                throw new RuntimeException("签名验证不存在！");
            }else {
                // 如果token不为空
                Claims claims = jwttoken.validateJWT(token).getClaims();

                if(claims==null){
                    System.out.println("鉴权失败");
                    throw new RuntimeException("鉴权失败！");
                }else{
                    if (!claims.getId().equals("-1")) {
                        throw new RuntimeException("您不是管理员");
                    } else {
                        System.out.println("鉴权成功");
                        return true;
                    }
                }
            }
        }else{
            return true;
        }
    }
}
