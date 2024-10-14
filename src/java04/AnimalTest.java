package java04;

public class AnimalTest {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();
        Animal cat = new Cat();
        speak(animal);
        speak(dog);
        speak(cat);
    }

    private static void speak(Animal animal) {
        animal.speak();
    }
}

class Animal {
    public void speak() {
        System.out.println("animal speak");
    }
}

class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("멍멍");
    }
}

class Cat extends Animal {
    @Override
    public void speak() {
        System.out.println("야옹");
    }
}
