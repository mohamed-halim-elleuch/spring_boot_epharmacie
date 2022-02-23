package com.epharmacy.epharmacy.Repository;

import com.epharmacy.epharmacy.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @RestResource(path = "/selectedProducts")
    List<Article> findBySelectedIsTrue();
    //@RestResource(path = "/productsByKeyword")
    //List<Article> findByArticleNomContains(String mc);
    @RestResource(path = "/promoProducts")
    List<Article> findByPromotionIsTrue();
    @RestResource(path = "/dispoProducts")
    List<Article> findByAvailableIsTrue();
}

/*package com.epharmacy.epharmacy.Repository;

import com.epharmacy.epharmacy.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {

    List<Article> findAllArticles();
    Article findArticleById(Long id);
    void deleteArticle(Long id);
    Article updateArticle(Article article);
    Article addArticle(Article article);
    
}
*/
