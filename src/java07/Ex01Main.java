package java07;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex01Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int longestNameLength = 0;

        ArrayList<String> nameList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            System.out.print("이름을 입력하세요>>");
            String name = sc.nextLine();
            nameList.add(name);

            if (name.length() > longestNameLength) {
                longestNameLength = name.length();
            }
        }

        for (String name : nameList) {
            System.out.print(name + " ");
        }

        System.out.print("\n가장 긴 이름은 : ");
        for (String name : nameList) {
            if (name.length() == longestNameLength) {
                System.out.print(name + " ");
            }
        }
    }
}
