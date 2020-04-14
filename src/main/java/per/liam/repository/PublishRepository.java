package per.liam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import per.liam.entity.Article;

/**
 * @author liam
 * @date 2020/4/12 下午7:14
 * @description
 */
@Repository
public interface PublishRepository extends JpaRepository<Article, Integer> {
}
