package per.liam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liam
 * @date 2020/4/4 下午5:21
 * @description 统一返回的JSON结构
 */
@Data
@AllArgsConstructor
public class Result<T> {
    private int code;
    private String msg;
    private T data;
}
