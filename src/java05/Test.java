package java05;

interface PersonalNumberStorage {

    void addPersonalInfo(String name, int age);

    String searchName(int age);
}

public class Test {

    public static void main(String[] args) {
        PersonalNumberStorage storage = new PersonalNumberStorageImp(100);
        storage.addPersonalInfo("Jack", 22);
        storage.addPersonalInfo("King", 33);

        System.out.println(storage.searchName(22));
        System.out.println(storage.searchName(33));
        System.out.println(storage.searchName(44));
    }
}

class PersonalNumInfo {

    private final String name;
    private final int age;

    public PersonalNumInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class PersonalNumberStorageImp implements PersonalNumberStorage {

    PersonalNumInfo[] perArr;
    int numOfPerInfo;

    public PersonalNumberStorageImp(int size) {
        perArr = new PersonalNumInfo[size];
    }

    @Override
    public void addPersonalInfo(String name, int age) {
        perArr[numOfPerInfo++] = new PersonalNumInfo(name, age);
    }

    @Override
    public String searchName(int age) {
        for (int i = 0; i < numOfPerInfo; i++) {
            if (perArr[i].getAge() == age) {
                return perArr[i].getName();
            }
        }
        return "no one";
    }
}