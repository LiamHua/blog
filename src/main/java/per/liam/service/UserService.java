package per.liam.service;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import per.liam.entity.Result;
import per.liam.entity.User;
import per.liam.entity.enumeration.CodeEnum;
import per.liam.repository.UserRepository;
import per.liam.util.JwtUtil;

import java.util.HashMap;

/**
 * @author liam
 * @date 2020/3/26 下午7:01
 * @description
 */
@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Object loginService(User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        JSONObject jsonObject = new JSONObject();
        try {
            subject.login(token);
            User userInfo = userRepository.findUserByUsername(user.getUsername());
            HashMap<String, Object> userMap = new HashMap<>(8);
            userMap.put("nickname", userInfo.getNickname());
            userMap.put("username", userInfo.getUsername());
            userMap.put("role", userInfo.getRole());
            JSONObject jwtToken = JwtUtil.createToken(userMap);
            Result<JSONObject> result = new Result<JSONObject>(CodeEnum.SUCCESS.code, "登录成功", jwtToken);
            jsonObject.put("status", 1);
            jsonObject.put("msg", "登录成功!");
            jsonObject.put("userInfo", userMap);
            jsonObject.put("token", jwtToken);
            return result;
        } catch (UnknownAccountException e) {
            jsonObject.put("status", "failure");
            jsonObject.put("msg", "该用户不存在!");
            return jsonObject;
        } catch (IncorrectCredentialsException e) {
            jsonObject.put("status", "failure");
            jsonObject.put("msg", "密码错误!");
            return jsonObject;
        }
    }
}
