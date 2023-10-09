package com.example.xplorer_controller_demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class controller {

    @GetMapping("/info")
    public UserInfo getUserInfo() {

        // 在此处实现未传递令牌的用户信息获取逻辑
        // 可以返回用户的基本信息，如用户名、电子邮件等
        return new UserInfo("JohnDoe", "johndoe@example.com");
    }

    @GetMapping("/infoWithToken")
    public UserInfo getUserInfo(@RequestParam("token") String token) {
        // 在此处实现使用传递的令牌来获取用户信息的逻辑
        // 需要检查令牌的有效性，并返回相应的用户信息
        if (isValidToken(token)) {
            return new UserInfo("AuthenticatedUser", "authenticated@example.com");
        } else {
            // 令牌无效的情况下返回错误或适当的响应
            return null;
        }
    }

    private boolean isValidToken(String token) {
        // 在此处编写验证令牌有效性的逻辑
        // 可以与数据库或其他身份验证机制进行比较
        // 如果令牌有效，返回true；否则返回false
        return token.equals("valid_token");
    }
}
