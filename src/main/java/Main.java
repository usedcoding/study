import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 프로그램 시작 ==");

        long lastId = 0;
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

                System.out.println(lastId + "번 게시글이 등록되었습니다.");
            }
        }

        sc.close();
        System.out.println("== 프로그램 끝 ==");
    }
}
