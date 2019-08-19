package com.example.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Article;

@Component
public interface ArticleRepository extends ElasticsearchRepository<Article, Long>{

}
