package java05;

import java.util.Scanner;

public class Ex03Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("요일을 입력하세요 : ");
            String input = sc.nextLine();
            if (input.equals("xxx")) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }

            printDayDescription(input);
            System.out.println();
        }
    }

    private static void printDayDescription(String input) {
        for (Week day : Week.values()) {
            if (input.equals(day.name())) {
                System.out.println(day.getDescription());
                return;
            }
        }

        System.out.println("잘못 입력하셨습니다.");
    }
}

enum Week {

    MON("주간 회의가 있습니다."),
    TUE("프로젝트 기획 회의가 있습니다."),
    WED("진행사항 보고하는 날입니다."),
    THU("사내 축구시합이 있는 날입니다."),
    FRI("프로젝트 마감일입니다."),
    SAT("가족과 함께 즐거운 시간을 보내세요."),
    SUN("오늘은 휴일입니다.");

    private final String description;

    Week(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}