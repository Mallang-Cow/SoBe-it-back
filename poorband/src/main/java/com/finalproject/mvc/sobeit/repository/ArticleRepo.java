package com.finalproject.mvc.sobeit.repository;

import com.finalproject.mvc.sobeit.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ArticleRepo extends JpaRepository<Article, Long> {

    @Query("select a from Article a where a.user_seq = ?1 order by a.written_date desc")
    List<Article> findArticlesByUser(String user_id);
}
