package java07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex02Main {

    public static void main(String[] args) {
        Set<Person> personSet = new HashSet<>();
        personSet.add(new Person("Hong", 29));
        personSet.add(new Person("Lee", 24));
        personSet.add(new Person("Choi", 21));
        personSet.add(new Person("Hong", 28));
        printCollection(personSet.iterator());

        deleteCollection(personSet, "Hong");
        printCollection(personSet.iterator());
    }

    private static void deleteCollection(Set<Person> personSet, String name) {
        personSet.removeIf(person -> person.getName().equals(name));
    }

    private static void printCollection(Iterator<Person> itr) {
        while (itr.hasNext()) {
            itr.next().showData();
        }
        System.out.println();
    }
}

class Person {

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void showData() {
        System.out.println(name + " " + age);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        return ((Person) o).name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getName() {
        return name;
    }
}
