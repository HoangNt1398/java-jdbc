package org.article;

import java.util.Scanner;

public class ArticleMain {
    public static void main(String[] args) {
        // 테스트 단계
        Scanner scanner = new Scanner(System.in);
        ArticleService service = new ArticleService(scanner);
        service.createArticle();

        while (true) {
            System.out.println("기능을 선택하세요");
            System.out.println("1. 작성하기");
            System.out.println("2. 조회하기");
            System.out.println("q. 종료");
            String input = scanner.nextLine();
            if (input.equals("q")) break;
            switch (Integer.parseInt(input)) {
                case 1 -> service.createArticle();
            }
        }
    }
}
