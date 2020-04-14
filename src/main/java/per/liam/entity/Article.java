package per.liam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author liam
 * @date 2020/4/11 下午8:07
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "article")
@SecondaryTables(value = {
@SecondaryTable(name = "class"),
@SecondaryTable(name = "tag")
})
public class Article {

    /**
     * articleId : 文章id
     * title : 文章标题
     * contentMarkdown : 文章内容
     * type : 文章类型
     * classes : [] 分类专栏
     * tags : [] 文章标签
     * lastSaveTime : 上次保存时间
     * createTime : 创建时间
     * publishTime : 发布时间
     */
    @Id
    private int articleId;
    private String title;
    private String contentMarkdown;
    private String type;
    private String lastSaveTime;
    private String createTime;
    private String publishTime;
    private int state;
    @OneToMany
    @JoinColumn(name = "class_class")
    private List<String> classes;
    private List<String> tags;
}
