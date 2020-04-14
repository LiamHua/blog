package per.liam.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @author liam
 * @date 2020/3/26 下午12:37
 * @description
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建过滤器
     * @param defaultWebSecurityManager 安全管理器
     * @return 过滤器
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        // 添加过滤器
        /*
          anon：无需认证就可以访问
          authc：必须认证了才可以访问
          user：必须拥有 记住我 功能才可以使用
          perms：必须拥有对某个资源的权限才可以访问
          roles：拥有某个角色权限才可以访问
         */
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 创建安全管理器
     * @param userRealm 用户realm对象
     * @return 安全管理器
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建realm对象
     * @return realm对象
     */
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }
}
