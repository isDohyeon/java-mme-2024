package java09;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01Main {

    private static final String FILE_PATH = "persons.bin";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> persons = loadPersons();

        while (true) {
            int input = readUserInput(sc);
            if (input == 3) {
                System.out.println("프로그램을 종료합니다.");
                savePersons(persons);
                break;
            }
            switch (input) {
                case 1:
                    inputPerson(sc, persons);
                    break;
                case 2:
                    printPersons(persons);
                    break;
            }
        }
    }

    private static int readUserInput(Scanner sc) {
        System.out.println("\n== 메뉴 == ");
        System.out.println("1. 입력");
        System.out.println("2. 출력");
        System.out.println("3. 종료");
        System.out.print("무엇을 하시겠습니까? ");
        int input = sc.nextInt();
        sc.nextLine();
        return input;
    }

    private static void inputPerson(Scanner sc, List<Person> persons) {
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("나이 : ");
        int age = sc.nextInt();
        persons.add(new Person(name, age));
    }

    private static void printPersons(List<Person> persons) {
        System.out.println("총 " + persons.size() + "명을 출력합니다.");
        for (Person person : persons) {
            person.showInfo();
        }
    }

    private static List<Person> loadPersons() {
        List<Person> persons = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            while (true) {
                try {
                    Person person = (Person) in.readObject();
                    persons.add(person);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.printf("%s 파일을 생성합니다.", FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }

    private static void savePersons(List<Person> persons) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            for (Person person : persons) {
                out.writeObject(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Person implements Serializable {

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void showInfo() {
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
    }
}
