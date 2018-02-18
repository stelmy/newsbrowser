package com.stelmyit.newsbrowser.factory;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.stelmyit.newsbrowser.dto.Article;
import com.stelmyit.newsbrowser.dto.ArticleFullDTO;

@Component
public class ArticleFactory {

	public List<Article> create(List<ArticleFullDTO> dtos) {
		return dtos.stream().map(dto -> create(dto)).collect(Collectors.toList());
	}

	private Article create(ArticleFullDTO dto) {
		return Article.Builder.getInstance()
				.author(dto.getAuthor())
				.title(dto.getTitle())
				.description(dto.getDescription())
				.date(dto.getDate())
				.sourceName(dto.getSource().getName())
				.articleUrl(dto.getArticleUrl())
				.imageUrl(dto.getImageUrl())
				.build();
	}
}
