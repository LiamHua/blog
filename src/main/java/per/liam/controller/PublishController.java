package per.liam.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.liam.entity.Article;
import per.liam.service.PublishService;

/**
 * @author liam
 * @date 2020/4/12 下午7:13
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class PublishController {
    private final PublishService publishService;

    public PublishController(PublishService publishService) {
        this.publishService = publishService;
    }

    @RequestMapping("/publish")
    public String publish(@RequestBody Article article) {
        System.out.println(article);
        return "hello";
    }
}
