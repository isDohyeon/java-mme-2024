package java04;

public class Test {

    public static void main(String[] args) {
        Person jee = new Student("jee");
        Person kim = new Professor("kim");
        Person lee = new Researcher("lee");

        if (jee instanceof Person) {
            jee.printPersonMessage();
        }
        if (jee instanceof Student) {
            jee.printMessage("Student");
        }
        if (kim instanceof Student) {
            kim.printMessage("Student");
        }
        if (kim instanceof Professor) {
            kim.printMessage("Professor");
        }
        if (kim instanceof Researcher) {
            kim.printMessage("Researcher");
        }
        if (lee instanceof Professor) {
            lee.printMessage("Professor");
        }
    }
}

class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 예제의 main()을 건드리지 않기 위해 존재. 없어도 무방
    public void printPersonMessage() {
        printMessage("Person");
    }

    public void printMessage(String personType) {
        System.out.println(getName() + "은 " + personType + "으로 캐스팅할 수 있다");
    }
}

class Student extends Person {

    public Student(String name) {
        super(name);
    }
}

class Researcher extends Person {

    public Researcher(String name) {
        super(name);
    }
}

class Professor extends Researcher {

    public Professor(String name) {
        super(name);
    }
}