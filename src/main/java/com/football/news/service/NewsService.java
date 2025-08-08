package com.football.news.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.football.news.model.Article;

@Service
public class NewsService {

    @Value("${newsapi.key}")
    private String apiKey;

    public List<Article> getNewsByTeams(List<String> teams) {
        List<Article> allArticles = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        for (String team : teams) {
            String url = UriComponentsBuilder.fromHttpUrl("https://newsapi.org/v2/everything")
                    .queryParam("q", team)
                    .queryParam("apiKey", apiKey)
                    .queryParam("language", "en")
                    .queryParam("sortBy", "publishedAt")
                    .toUriString();

            try {
                NewsApiResponse response = restTemplate.getForObject(url, NewsApiResponse.class);
                if (response != null && response.getArticles() != null) {
                    allArticles.addAll(response.getArticles());
                }
            } catch (Exception e) {
                System.err.println("Failed to fetch news for team: " + team + " – " + e.getMessage());
            }
        }

        return allArticles;
    }

    // Helper class to parse NewsAPI response
    static class NewsApiResponse {
        private List<Article> articles;

        public List<Article> getArticles() {
            return articles;
        }

        public void setArticles(List<Article> articles) {
            this.articles = articles;
        }
    }
}
