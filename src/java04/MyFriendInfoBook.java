package java04;

import java.util.Scanner;

public class MyFriendInfoBook {

    public static void main(String[] args) {
        FriendInfoHandler handler = new FriendInfoHandler(1);

        while (true) {
            System.out.println("*** 메뉴 선택 ***");
            System.out.println("1. 고교 친구 저장");
            System.out.println("2. 대학 친구 저장");
            System.out.println("3. 전체 정보 출력");
            System.out.println("4. 하는일 정보 출력");
            System.out.println("5. 프로그램 종료");
            System.out.print("선택 >> ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1 :
                case 2 :
                    handler.addFriend(choice);
                    break;
                case 3 :
                    handler.showAllData();
                    break;
                case 4 :
                    handler.showAllWorkData();
                    break;
                case 5 :
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default :
                    System.out.println("올바른 번호를 입력해주세요.\n");
            }
        }
    }
}

class FriendInfoHandler {

    private final HighFriend[] highFriends;
    private final UnivFriend[] univFriends;
    private int numOfHighFriend;
    private int numOfUnivFriend;

    public FriendInfoHandler(int maxFriend) {
        highFriends = new HighFriend[maxFriend];
        univFriends = new UnivFriend[maxFriend];
        numOfHighFriend = 0;
        numOfUnivFriend = 0;
    }

    private void addHighFriendInfo(HighFriend highFriend) {
        highFriends[numOfHighFriend++] = highFriend;
    }

    private void addUnivFriendInfo(UnivFriend univFriend) {
        univFriends[numOfUnivFriend++] = univFriend;
    }

    public void addFriend(int choice) {
        Scanner sc = new Scanner(System.in);

        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("전화 : ");
        String phoneNumber = sc.nextLine();
        System.out.print("주소 : ");
        String address = sc.nextLine();

        if (choice == 1) {
            System.out.print("직업 : ");
            String job = sc.nextLine();
            addHighFriendInfo(new HighFriend(name, phoneNumber, address, job));
        } else if (choice == 2) {
            System.out.print("학과 : ");
            String major = sc.nextLine();
            addUnivFriendInfo(new UnivFriend(name, phoneNumber, address, major));
        }
        System.out.println("입력 완료!\n");
    }

    public void showAllData() {
        for (int i = 0; i < numOfUnivFriend; i++) {
            univFriends[i].showData();
            System.out.println("---");
        }
        for (int i = 0; i < numOfHighFriend; i++) {
            highFriends[i].showData();
            System.out.println("---");
        }
    }

    public void showAllWorkData() {
        for (int i = 0; i < numOfUnivFriend; i++) {
            univFriends[i].showMajorData();
        }
        for (int i = 0; i < numOfHighFriend; i++) {
            highFriends[i].showWorkData();
        }
        System.out.println();
    }
}

class HighFriend {

    private final String name;
    private final String phoneNumber;
    private final String address;
    private final String job;

    public HighFriend(String name, String phoneNumber, String address, String job) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.job = job;
    }

    public void showData() {
        System.out.println("이름 : " + name);
        System.out.println("전화 : " + phoneNumber);
        System.out.println("주소 : " + address);
        System.out.println("직업 : " + job);
    }

    public void showWorkData() {
        System.out.println(name + " 직업 : " + job);
    }
}

class UnivFriend {

    private final String name;
    private final String phoneNumber;
    private final String address;
    private final String major;

    public UnivFriend(String name, String phoneNumber, String address, String major) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.major = major;
    }

    public void showData() {
        System.out.println("이름 : " + name);
        System.out.println("전화 : " + phoneNumber);
        System.out.println("주소 : " + address);
        System.out.println("학과 : " + major);
    }

    public void showMajorData() {
        System.out.println(name + " 학과 : " + major);
    }
}