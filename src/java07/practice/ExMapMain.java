package java07.practice;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class ExMapMain {

    public static void main(String[] args) {
        HashMap<String, String> dictionary = new HashMap<>();

        dictionary.put("baby", "아기");
        dictionary.put("love", "사랑");
        dictionary.put("apple", "사과");

        for (Entry<String, String> entry : dictionary.entrySet()) {
            System.out.println("(" + entry.getKey() + "," + entry.getValue() + ")");
        }
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("찾고 싶은 단어는?");
            String word = sc.next();
            System.out.println(dictionary.get(word));
        }
    }
}
