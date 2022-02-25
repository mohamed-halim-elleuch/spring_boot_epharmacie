package com.epharmacy.epharmacy.Controller;


import com.epharmacy.epharmacy.Repository.ArticleRepository;
import com.epharmacy.epharmacy.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@RestController
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping( "/listarticle")
    private String listProduct()
    {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Article> list = articleRepository.findAll();
        modelMap.put("articleList", list);
        String json=modelMap.toString();
        return json;
    }

    @GetMapping(value = "/sortarticlebyprice")
    private Map<String, Object> sortArticleByPrice() {
        Map<String, Object> modelMap = new HashMap<>();
        List<Article> list = articleRepository.findAll(Sort.by("ArticlePrice").ascending());
        modelMap.put("articleListByPrice", list);

        return modelMap;
    }
    @GetMapping(value = "/sortarticlebypricedesc")
    private Map<String, Object> sortArticleByPriceDesc() {
        Map<String, Object> modelMap = new HashMap<>();
        List<Article> list = articleRepository.findAll(Sort.by("ArticlePrice").descending());
        modelMap.put("articleListByPriceDesc", list);
        return modelMap;
    }
}


