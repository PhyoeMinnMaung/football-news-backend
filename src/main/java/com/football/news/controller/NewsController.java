package com.football.news.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.football.news.model.Article;
import com.football.news.service.NewsService;

@CrossOrigin(origins = "https://footballnews-app.netlify.app") 
@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public List<Article> getNews(@RequestParam(required = false) List<String> teams) {
        if (teams == null || teams.isEmpty()) {
            return Collections.emptyList();
        }
        return newsService.getNewsByTeams(teams);
    }
}
