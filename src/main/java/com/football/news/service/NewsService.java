package com.football.news.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.football.news.model.Article;

@Service
public class NewsService {

    public List<Article> getNewsByTeams(List<String> teams) {
        List<Article> dummyArticles = new ArrayList<>();

        Article article1 = new Article();
        article1.setTitle("Chelsea win big in Champions League");
        article1.setDescription("Chelsea beat Barcelona 3-1 in a thrilling game.");
        article1.setUrl("https://example.com/news1");

        Article article2 = new Article();
        article2.setTitle("Barcelona signs new striker");
        article2.setDescription("Barcelona signs a young talent from Brazil.");
        article2.setUrl("https://example.com/news2");

        Article article3 = new Article();
        article3.setTitle("PSG prepares for new season");
        article3.setDescription("PSG reveals their preseason plans.");
        article3.setUrl("https://example.com/news3");

        dummyArticles.add(article1);
        dummyArticles.add(article2);
        dummyArticles.add(article3);

        // Filter articles based on selected team names
        return dummyArticles.stream()
            .filter(article -> teams.stream()
                .anyMatch(team -> article.getTitle() != null &&
                    article.getTitle().toLowerCase().contains(team.toLowerCase())))
            .collect(Collectors.toList());
    }
}
