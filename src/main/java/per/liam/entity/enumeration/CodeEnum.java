package per.liam.entity.enumeration;

/**
 * @author liam
 * @date 2020/4/4 下午5:38
 * @description
 */
public enum CodeEnum {
    // 成功
    SUCCESS(200),

    //失败
    FAIL(202),

    //未认证
    UNAUTHORIZED(401),

    //拒绝请求（权限不足）
    DENIED(403),

    //未找到
    NOT_FOUND(404),

    //服务器内部错误
    INTERNAL_SERVER_ERROR(500);

    public int code;

    CodeEnum(int code) {
        this.code = code;
    }
}
