package com.epharmacy.epharmacy.Repository;

public interface ArticleRepository {
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
