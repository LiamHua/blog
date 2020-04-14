package per.liam.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.liam.entity.User;
import per.liam.service.UserService;
import per.liam.util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liam
 * @date 2020/3/25 上午1:20
 * @description 管理员登录
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public Object login(@RequestBody User user) {
        return userService.loginService(user);
    }

    @RequestMapping("/verify")
    public String verifyToken(@RequestBody HashMap<String, String> tokenMap) {
        Map<String, Object> objectMap = JwtUtil.verifyToken(tokenMap.get("token"));
        return JSONObject.toJSONString(objectMap);
    }
}
