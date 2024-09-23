package week3;

public class Test {

    public static void main(String[] args) {
        new Cat();
        new Dog();
        new Duck();
        System.out.println("생성된 객체의 개수 : " + Animal.getCount());
    }
}

class Animal {
    private static int count;

    public Animal() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}

class Cat extends Animal {}

class Dog extends Animal {}

class Duck extends Animal {}
