package com.example.demo.controller;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Article;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.untils.JsonData;


@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {

	
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@PostMapping("save")
	public Object save(long id,String content){
	
		Article article = new Article();
		article.setId(id);
		article.setPv(123);
		article.setContent(content);
		article.setTitle("一心一意");
		article.setSummary("意涵老婆啊啊");
		
		articleRepository.save(article);
	
		return JsonData.buildSuccess();
	}
	
	
	
	
	@GetMapping("search")
	public Object search(String content){

		//QueryBuilder queryBuilder = QueryBuilders.matchAllQuery(); //搜索全部文档
		QueryBuilder queryBuilder = QueryBuilders.matchQuery("content", content); 

		Iterable<Article> list =  articleRepository.search(queryBuilder);
		
		return JsonData.buildSuccess(list);
	}
	
	@PostMapping("delete")
	public void delete(Long id){
		articleRepository.deleteById(id);
	}
	
}
