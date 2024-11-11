package java07;

import java.util.HashMap;
import java.util.Scanner;

public class Ex03Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> numberWordMap = new HashMap<>();

        while (true) {
            System.out.print("번호와 단어를 입력하세요(99=quit): ");
            int number = sc.nextInt();
            String word = sc.next();
            if (number == 99) {
                break;
            }
            numberWordMap.put(number, word);
        }

        System.out.print("찾을 단어의 번호를 입력하시오: ");
        int findNumber = sc.nextInt();
        System.out.println(numberWordMap.get(findNumber) + "입니다.");
    }
}
