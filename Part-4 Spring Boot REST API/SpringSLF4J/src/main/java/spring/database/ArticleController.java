package spring.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Created 01 / 04 / 2020 - 4:22 PM
 * @project SpringJPAaudit
 * @Author Hamdamboy
 */

@RestController
public class ArticleController {
    //
    private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);

    @Autowired
    private ArticleService articleService;
    @GetMapping("/articles")
    public List<Article> getArticles(){
        logger.debug("inside ArticleController.getArticles() method");
        return articleService.getArticles();
    }
}
