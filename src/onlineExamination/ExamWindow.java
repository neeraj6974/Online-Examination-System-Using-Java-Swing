package onlineExamination;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class ExamWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel questionPanel;
    private JScrollPane scrollPane;
    private String subject;
    private JButton btnNewButton;

   
    private Map<Integer, String> correctAnswers = new HashMap<>();
    private Map<Integer, ButtonGroup> questionGroups = new HashMap<>();

    public ExamWindow(String subject) {
		setTitle("Online Examination Portal");
        this.subject = subject;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setTitle("Exam - " + subject);
        getContentPane().setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblTitle = new JLabel("Subject: " + subject, JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        getContentPane().add(lblTitle, BorderLayout.NORTH);

        questionPanel = new JPanel();
        questionPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        questionPanel.setBackground(Color.WHITE);
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane(questionPanel);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        fetchAndDisplayQuestions();

        
        btnNewButton = new JButton("Finish");
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
        btnNewButton.setBackground(new Color(34, 139, 34));
        btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnNewButton.addActionListener(e -> calculateResult());
        questionPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        questionPanel.add(btnNewButton);
    }

    private void fetchAndDisplayQuestions() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/online-exam", "postgres", "1977");

            String query = "SELECT * FROM questions WHERE subject = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, subject);
            ResultSet rs = pst.executeQuery();

            int qNum = 1;

            while (rs.next()) {
                JLabel qLabel = new JLabel(qNum + ". " + rs.getString("question"));
                qLabel.setFont(new Font("Arial", Font.BOLD, 16));
                qLabel.setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 5));
                questionPanel.add(qLabel);

                ButtonGroup group = new ButtonGroup();
                JRadioButton opt1 = new JRadioButton(rs.getString("choice1"));
                JRadioButton opt2 = new JRadioButton(rs.getString("choice2"));
                JRadioButton opt3 = new JRadioButton(rs.getString("choice3"));
                JRadioButton opt4 = new JRadioButton(rs.getString("choice4"));

                JRadioButton[] options = {opt1, opt2, opt3, opt4};
                for (JRadioButton opt : options) {
                    opt.setFont(new Font("Arial", Font.PLAIN, 15));
                    opt.setBackground(Color.WHITE);
                    group.add(opt);
                    questionPanel.add(opt);
                }

                correctAnswers.put(qNum, rs.getString("correct_ans").trim());
                questionGroups.put(qNum, group);

                questionPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                qNum++;
            }

            rs.close();
            pst.close();
            conn.close();

            questionPanel.revalidate();
            questionPanel.repaint();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading questions: " + ex.getMessage());
        }
    }

    private void calculateResult() {
        int score = 0;

        for (int i = 1; i <= correctAnswers.size(); i++) {
            ButtonGroup group = questionGroups.get(i);
            if (group != null) {
                for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
                    AbstractButton btn = buttons.nextElement();
                    if (btn.isSelected()) {
                        String selected = btn.getText().trim();
                        String correct = correctAnswers.get(i);
                        if (selected.equalsIgnoreCase(correct)) {
                            score++;
                        } else {
                            score--;
                        }
                        break;
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(this,
                "Exam Finished!\nYour Score: " + score + " / " + correctAnswers.size(),
                "Result", JOptionPane.INFORMATION_MESSAGE);
        new studentDashboard().setVisible(true);
        dispose();
    }
}
