package java11;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.*;

public class Ex03Main extends JFrame {

    private static final String TITLE = "사용자 등록 예제";
    private static int studentNumber = 20200001;

    private JTextArea outputTextArea;
    private JTextField nameTextField;
    private JTextField studentNumberTextField;

    private final List<String> types = List.of("=선택=", "교수", "직원", "학생");
    private JComboBox typeCombo;
    private String selectedType;

    public Ex03Main() {
        initializeFrame();
        initializeInputPanel();
        initializeControlPanel();
        initializeOutputArea();
        setVisible(true);
    }

    private void initializeFrame() {
        setTitle(TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 320);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void initializeInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(1, 2));

        JPanel labelPanel = createLabelPanel();
        inputPanel.add(labelPanel);

        JPanel inputFieldsPanel = createInputFieldsPanel();
        inputPanel.add(inputFieldsPanel);

        add(inputPanel, BorderLayout.NORTH);
    }

    private JPanel createLabelPanel() {
        JPanel labelPanel = new JPanel(new GridLayout(3, 1));
        labelPanel.add(new JLabel("학번"));
        labelPanel.add(new JLabel("타입"));
        labelPanel.add(new JLabel("이름"));
        return labelPanel;
    }

    private JPanel createInputFieldsPanel() {
        JPanel inputFieldsPanel = new JPanel(new GridLayout(3, 1));

        studentNumberTextField = new JTextField(String.valueOf(studentNumber));
        studentNumberTextField.setEditable(false);
        inputFieldsPanel.add(studentNumberTextField);

        JPanel comboBoxPanel = createComboBoxPanel();
        inputFieldsPanel.add(comboBoxPanel);

        nameTextField = new JTextField();
        inputFieldsPanel.add(nameTextField);

        return inputFieldsPanel;
    }

    private JPanel createComboBoxPanel() {
        JPanel comboBoxPanel = new JPanel(new FlowLayout());
        typeCombo = new JComboBox();

        for (String type : types) {
            typeCombo.addItem(type);
        }

        typeCombo.addActionListener(e -> {
            JComboBox selected = (JComboBox) e.getSource();
            selectedType = types.get(selected.getSelectedIndex());
        });
        comboBoxPanel.add(typeCombo);
        return comboBoxPanel;
    }

    private void initializeControlPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton addButton = new JButton(new ImageIcon("out/images/더하기.png"));
        addButton.setBorder(BorderFactory.createEmptyBorder());
        addButton.setContentAreaFilled(false);
        addButton.addActionListener(e -> buttonClick());
        buttonPanel.add(addButton);

        add(buttonPanel, BorderLayout.CENTER);
    }

    private void initializeOutputArea() {
        outputTextArea = new JTextArea(7, 20);
        outputTextArea.setEditable(false);
        add(new JScrollPane(outputTextArea), BorderLayout.SOUTH);
    }

    private void buttonClick() {
        if (validateButtonClick()) {
            return;
        }
        saveUserInfo();
        resetInputFields();
    }

    private boolean validateButtonClick() {
        if (selectedType == null || selectedType.equals(types.getFirst())) {
            announceError("콤보박스를 선택하세요");
            return true;
        }
        if (nameTextField.getText().isEmpty()) {
            announceError("이름을 입력하세요");
            return true;
        }
        return false;
    }

    private static void announceError(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    private void saveUserInfo() {
        String formatUserInfo = String.format("id:%d, type:%s, name:%s\n",
                studentNumber,
                selectedType,
                nameTextField.getText());
        outputTextArea.append(formatUserInfo);
    }

    private void resetInputFields() {
        nameTextField.setText("");
        studentNumberTextField.setText(String.valueOf(++studentNumber));
        typeCombo.setSelectedIndex(0);
        selectedType = null;
    }

    public static void main(String[] args) {
        new Ex03Main();
    }
}
