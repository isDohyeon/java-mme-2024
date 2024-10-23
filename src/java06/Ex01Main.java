package java06;

import java.util.Scanner;

public class Ex01Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("입력하시오(종료:Z) ");
            String input = sc.nextLine();

            if (input.equals("Z")) {
                System.out.println("프로그램을 종료합니다!!");
                return;
            }

            try {
                Integer.parseInt(input);
                System.out.println("숫자입니다!!");
            } catch (NumberFormatException e) {
                System.out.println("문자입니다!!");
            }
        }
    }
}
