package org.article;

import java.util.Scanner;

public class ArticleService {
    private final ArticleRepository repository;
    private final Scanner scanner;
    public ArticleService(Scanner scanner){
        this.repository = new ArticleRepository();
        this.scanner = scanner;
    }

    public void createArticle(){
        System.out.println("제복을 입력하세요");
        String title = scanner.nextLine();
        System.out.println("내용 입력");
        String content = scanner.nextLine();
        repository.create(new Article(
                title,
                content
        ));
    }
}
