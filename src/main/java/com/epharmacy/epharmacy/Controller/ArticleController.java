package com.epharmacy.epharmacy.Controller;

public class ArticleController {
}

/*package com.epharmacy.epharmacy.Controller;

import com.epharmacy.epharmacy.Repository.ArticleRepository;
import com.epharmacy.epharmacy.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/Article")
@RestController
public class ArticleController {
    private final ArticleRepository articleRepo;

    public ArticleController(ArticleRepository articleRepo) {
        this.articleRepo = articleRepo;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Article>> getAllArticles(){
        List<Article> Article = articleRepo.findAllArticles();
        return new ResponseEntity<>(Article, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Article> getEmployeeById(@PathVariable("id") Long id){
        Article Article = articleRepo.findArticleById(id);
        return new ResponseEntity<>(Article, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Article> addArticle(@RequestBody Article article){
        Article newArticle = articleRepo.addArticle(article);
        return new ResponseEntity<>(newArticle,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Article> updateEmployee(@RequestBody Article Article){
        Article updateArticle = articleRepo.updateArticle(Article);
        return new ResponseEntity<>(updateArticle,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable("id") Long id){
        articleRepo.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
*/
