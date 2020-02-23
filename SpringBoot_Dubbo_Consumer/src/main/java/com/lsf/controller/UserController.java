package com.lsf.controller;

import com.lsf.bean.User;
import com.lsf.service.UserService;
import com.lsf.utils.NewRedisUtil;
import com.lsf.utils.ServerConf;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2020/2/22.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private NewRedisUtil newRedisUtil;

    @Resource
    private ServerConf serverConf;

    @GetMapping("getUser")
    public User user() {
        return userService.selectByPrimaryKey(1);
    }

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, @RequestParam(value = "name", defaultValue = "springboot-thymeleaf") String name) {

        Cookie[] cookies = request.getCookies();
        String sessionId = "";
        String jsessionId = "";

        if(cookies != null && cookies.length >=1 ){
           for (Cookie cookie : cookies) {
                if(cookie.getName().equals("JSESSIONID")){
                    jsessionId = cookie.getValue();
                    break;
                }
            }
            if(!jsessionId.equals("")){
                if (newRedisUtil.existsKey(jsessionId)){
                    newRedisUtil.expire(jsessionId, 1000);
                    request.setAttribute("sessionId", "port:"+serverConf.getPort()+"登录时间保持延续!---"+jsessionId);
                    return "delay";
                }else{
                    HttpSession session = request.getSession();
                    sessionId = session.getId();
                    newRedisUtil.set(sessionId, 1000, session.toString());
                    request.setAttribute("sessionId", "port:"+serverConf.getPort()+"登录超时!，重新登陆-----"+sessionId);
                    return "erro";
                }
            }
        }
        HttpSession session = request.getSession();
        sessionId = session.getId();
        newRedisUtil.set(sessionId, 1000, session.toString());
        request.setAttribute("sessionId", "port:"+serverConf.getPort()+"登录成功，获取session!---"+jsessionId);
        return "hello";
    }

}
