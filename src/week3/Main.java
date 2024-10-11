package week3;

public class Main {

    public static void main(String[] args) {
        BusinessMan businessMan = new BusinessMan();
        businessMan.setName("Jack");
        businessMan.setCompany("Hannam");
        businessMan.setPosition("Student");

        businessMan.showInfo();
    }
}

class Man {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showInfo() {
        System.out.println("My name is " + getName());
    }
}

class BusinessMan extends Man {

    private String company;
    private String position;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("My company is " + getCompany());
        System.out.println("My position is " + getPosition());
    }
}
