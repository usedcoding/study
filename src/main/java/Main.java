import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 프로그램 시작 ==");

        long lastId = 0;
        List<Article> articleList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.printf("명령어) ");
            String command = sc.nextLine().trim();

            if (command.equals("종료")) {
                System.out.println("시스템을 종료합니다.");
                break;
            } else if (command.equals("등록")) {
                lastId++;
                System.out.printf("제목: ");
                String title = sc.nextLine();
                System.out.printf("내용: ");
                String content = sc.nextLine();

                Article article = new Article(lastId, title, content);
                articleList.add(article);
                
                System.out.println(lastId + "번 게시글이 등록되었습니다.");
            } else if (command.equals("목록")) {
                if (articleList.size() == 0) {
                    System.out.println("게시물이 없습니다.");
                } else {
                    System.out.printf("번호 / 제목 / 내용\n");
                    for (int i = 0; i < articleList.size(); i++) {
                        Article article = articleList.get(i);
                        System.out.printf("%d / %s / %s\n", article.getId(), article.getTitle(), article.getContent());
                    }
                }
            } else if (command.equals("삭제")) {
                System.out.printf("삭제 번호) ");
                long id = Long.parseLong(sc.nextLine());

                long foundIndex = -1;

                for (int i = 0; i < articleList.size(); i ++) {
                    Article article = articleList.get(i);
                    if (article.getId() == id) {
                        foundIndex = id;
                        articleList.remove(article);
                        break;
                    }
                }

                if (foundIndex == -1) {
                    System.out.println(id + "번째 게시물은 존재하지 않습니다.");
                } else {
                    System.out.println(id + "번째 게시글이 삭제 되었습니다.");
                }
            } else if (command.equals("수정")) {
                System.out.printf("수정 번호) ");
                long id = Long.parseLong(sc.nextLine());

                long foundIndex = -1;

                for (int i = 0; i < articleList.size(); i ++) {
                    Article article = articleList.get(i);
                    if (article.getId() == id) {
                        foundIndex = id;

                        System.out.printf("기존 제목: %s\n", article.getTitle());
                        String title = sc.nextLine();
                        article.setTitle(title);

                        System.out.printf("기존 내용: %s\n", article.getContent());
                        String content = sc.nextLine();
                        article.setContent(content);
                        
                        break;
                    }
                }

                if (foundIndex == -1) {
                    System.out.println(id + "번째 게시물은 존재하지 않습니다.");
                } else {
                    System.out.println(id + "번째 게시글이 수정 되었습니다.");
                }
            }
        }

        sc.close();
        System.out.println("== 프로그램 끝 ==");
    }
}
