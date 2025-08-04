package com.football.news.model;

import java.util.List;

import lombok.Data;

@Data
public class NewsApiResponse {
    private String status;
    private int totalResults;
    private List<Article> articles;
}
