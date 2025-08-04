package com.football.news.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.football.news.model.Article;
import com.football.news.service.NewsService;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    // Handle GET /api/news?teams=chelsea&teams=barcelona
    // If 'teams' is missing, return an empty list or default teams
    @GetMapping
    public List<Article> getNews(@RequestParam(required = false) List<String> teams) {
        if (teams == null || teams.isEmpty()) {
            // Optional: return default news or an empty list
            return Collections.emptyList();
        }
        return newsService.getNewsByTeams(teams);
    }
}
