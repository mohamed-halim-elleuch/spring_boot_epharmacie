package com.epharmacy.epharmacy.Controller;


import com.epharmacy.epharmacy.Repository.ArticleRepository;
import com.epharmacy.epharmacy.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

@CrossOrigin("*")
@RestController
public class CatalogueRestController {
    @Autowired
    private ArticleRepository articleRepository;

    public CatalogueRestController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    @GetMapping(path="/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Article p=articleRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getArticleImage()));
    }
    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception{
        Article p=articleRepository.findById(id).get();
        p.setArticleImage(file.getOriginalFilename());
        Files.write(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getArticleImage()),file.getBytes());
        articleRepository.save(p);
    }
}
