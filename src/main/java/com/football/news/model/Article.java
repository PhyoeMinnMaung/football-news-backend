package com.football.news.model;

import lombok.Data;

@Data
public class Article {
    private String title;
    private String description;
    private String url;
    private String publishedAt;
    private String urlToImage; 
}
