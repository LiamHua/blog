package per.liam.exception;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liam
 * @date 2020/3/26 下午7:54
 * @description
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public JSONObject unauthorizedExceptionHandler(HttpServletRequest request, Exception e) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "401");
        jsonObject.put("msg", "抱歉，权限不足!!!");
        return jsonObject;
    }
}
