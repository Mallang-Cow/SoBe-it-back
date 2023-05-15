package com.finalproject.mvc.sobeit.controller;

import com.finalproject.mvc.sobeit.entity.Article;
import com.finalproject.mvc.sobeit.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;

    /**
     * 글 작성
     * @param article
     * @return
     */
    @RequestMapping("/article/write")
    public String writeArticle(Article article){
        articleService.writeArticle(article);
        return("write");
    }

}
