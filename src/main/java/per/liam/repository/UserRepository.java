package per.liam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import per.liam.entity.User;

/**
 * @author liam
 * @date 2020/3/25 上午1:15
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * 根据用户名账号查询用户
     * @param username 用户账号
     * @return 该用户信息
     */
    User findUserByUsername(String username);
}
