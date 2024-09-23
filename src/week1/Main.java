package week1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 입력 객체 생성
        Scanner sc = new Scanner(System.in);

        // 이름 입력
        String name = sc.nextLine();
        // 나이 입력
        int age = sc.nextInt();
        // 개행문자 제거
        sc.nextLine();
        // 주소 입력
        String address = sc.nextLine();

        // 첫 번째 방법
        int ageGroup1 = age / 10 * 10;
        // 두 번째 방법
        int ageGroup2 = age - age % 10;

        // 결과 출력
        System.out.println(name + "님은 " + ageGroup1 + "대로 " + address + "에 살고 계십니다.");
    }
}
