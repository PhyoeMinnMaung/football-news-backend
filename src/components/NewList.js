import React, { useEffect, useState } from 'react';
import axios from 'axios';

function NewsList() {
  const [articles, setArticles] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/news?teams=barcelona,chelsea')
      .then(response => setArticles(response.data))
      .catch(error => console.error(error));
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      {articles.map((article, index) => (
        <div key={index} style={{
          marginBottom: "20px",
          border: "1px solid #ccc",
          padding: "10px",
          borderRadius: "8px",
          backgroundColor: "#f9f9f9"
        }}>
          <h2>{article.title}</h2>
          <p>{article.description}</p>
          <a href={article.url} target="_blank" rel="noopener noreferrer">Read more</a>
          <p><small>{new Date(article.publishedAt).toLocaleString()}</small></p>
        </div>
      ))}
    </div>
  );
}

export default NewsList;
