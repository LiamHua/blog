package per.liam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author liam
 * @date 2020/3/24 下午11:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class User {
    /**
     * uid : 用户id
     * username : 用户账号
     * password : 用户密码
     * role : 用户角色
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String username;
    private String nickname;
    private char[] password;
    private String role;
}
