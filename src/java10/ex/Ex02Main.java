package java10.ex;

import javax.swing.*;
import java.awt.*;

public class Ex02Main extends JFrame {

    public Ex02Main() {
        // 프레임 초기화 작업을 수행한다.
        initializeFrame();
        // 중앙 패널을 생성한다.
        JPanel centerPanel = createCenterPanel();
        // 하단 패널을 생성한다.
        JPanel southPanel = createSouthPanel();
        // 패널을 프레임에 추가한다.
        add(centerPanel, BorderLayout.CENTER); // 중앙 패널 추가
        add(southPanel, BorderLayout.SOUTH); // 하단 패널 추가
        // 프레임을 화면에 표시한다.
        setVisible(true);
    }

    // 프레임 초기화를 수행한다.
    private void initializeFrame() {
        setTitle("Multiple Layout Example"); // 프레임의 제목을 설정한다.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 클릭 시 프로그램을 종료한다.
        setSize(400, 200); // 프레임 크기를 설정한다.
        setLayout(new BorderLayout()); // 프레임의 레이아웃 매니저를 BorderLayout으로 설정한다.
    }

    // 중앙 패널을 생성하여 반환한다.
    private JPanel createCenterPanel() {
        // 중앙 패널 생성
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 0, 0)); // 1행 2열로 구성

        // 왼쪽 패널을 생성하여 추가한다.
        JPanel leftPanel = createLeftPanel();
        centerPanel.add(leftPanel);

        // 오른쪽 패널을 생성하여 추가한다.
        JPanel rightPanel = createRightPanel();
        centerPanel.add(rightPanel);

        return centerPanel;
    }

    // 왼쪽 패널을 생성하여 반환한다.
    private JPanel createLeftPanel() {
        JPanel leftPanel = new JPanel(new GridLayout(4, 1, 0, 10)); // 4행 1열로 구성
        leftPanel.setBackground(Color.YELLOW); // 배경색을 노란색으로 설정

        // "Type ID"와 텍스트 필드를 추가한다.
        JLabel typeIdLabel = new JLabel("Type ID", SwingConstants.CENTER); // 레이블 생성
        JTextField typeIdField = new JTextField(); // 텍스트 필드 생성
        leftPanel.add(typeIdLabel); // 레이블 추가
        leftPanel.add(typeIdField); // 텍스트 필드 추가

        // "Type Password"와 텍스트 필드를 추가한다.
        JLabel typePasswordLabel = new JLabel("Type Password", SwingConstants.CENTER); // 레이블 생성
        JTextField typePasswordField = new JTextField(); // 텍스트 필드 생성
        leftPanel.add(typePasswordLabel); // 레이블 추가
        leftPanel.add(typePasswordField); // 텍스트 필드 추가

        return leftPanel; // 생성된 왼쪽 패널 반환
    }

    // 오른쪽 패널을 생성하여 반환한다.
    private JPanel createRightPanel() {
        JPanel rightPanel = new JPanel(new GridLayout(3, 1, 0, 10)); // 3행 1열로 구성
        rightPanel.setBackground(Color.GREEN); // 배경색을 녹색으로 설정

        // "Please Check!!" 레이블을 추가한다.
        JLabel checkLabel = new JLabel("Please Check!!", SwingConstants.CENTER); // 레이블 생성
        rightPanel.add(checkLabel); // 레이블 추가

        // "C# JCheckBox" 레이블을 추가한다.
        JLabel csharpLabel = new JLabel("C# JCheckBox", SwingConstants.CENTER); // 레이블 생성
        rightPanel.add(csharpLabel); // 레이블 추가

        // "C++ JCheckBox" 레이블을 추가한다.
        JLabel cppLabel = new JLabel("C++ JCheckBox", SwingConstants.CENTER); // 레이블 생성
        rightPanel.add(cppLabel); // 레이블 추가

        return rightPanel; // 생성된 오른쪽 패널 반환
    }

    // 하단 패널을 생성하여 반환한다.
    private JPanel createSouthPanel() {
        JPanel southPanel = new JPanel(); // 하단 패널 생성
        JButton okButton = new JButton("OK"); // "OK" 버튼 생성
        southPanel.add(okButton); // 버튼을 패널에 추가
        return southPanel; // 생성된 하단 패널 반환
    }

    // 프로그램의 실행 진입점인 main 메서드
    public static void main(String[] args) {
        new Ex02Main(); // Ex02Main 인스턴스를 생성하여 프로그램을 실행한다.
    }
}
