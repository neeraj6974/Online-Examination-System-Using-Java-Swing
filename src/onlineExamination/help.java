package onlineExamination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class help extends JFrame {

    private static final long serialVersionUID = 1L;

    public help() {
		setTitle("Online Examination Portal");
        getContentPane().setPreferredSize(new Dimension(1366, 800));
        setTitle("Help - Examination Portal");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(255, 250, 250));
        getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Help & Support", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitle.setForeground(new Color(30, 144, 255));
        lblTitle.setBounds(387, 25, 800, 40);
        getContentPane().add(lblTitle);

        JTextArea textArea = new JTextArea();
        textArea.setText(
                "Welcome to the Help Center!\n\n" +
                "If you are facing any issues or have questions regarding the Online Examination Portal,\n" +
                "please read the information below carefully.\n\n" +
                "General Instructions:\n" +
                "• Ensure you have a stable internet connection before starting the exam.\n" +
                "• Read each question carefully before selecting an answer.\n" +
                "• Once you click on 'Start Exam', it cannot be cancelled or restarted.\n" +
                "• After completing all questions, click on 'Finish Exam' to view your score.\n\n" +
                "Common Issues:\n" +
                "• Unable to Login: Check your username and password. Make sure Caps Lock is off.\n" +
                "• Questions Not Loading: Please refresh or restart the application.\n" +
                "• Result Not Showing: Wait for a few seconds or reopen the dashboard.\n\n" +
                "For any unresolved problems, contact the support team via the 'Contact Us' section\n" +
                "or email us at: support@examportal.com\n\n" +
                "We’re here to ensure your practice experience is smooth and effective!\n\n" +
                "— Team Examination Portal"
        );
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(255, 250, 250));
        textArea.setBounds(501, 98, 640, 589);
        getContentPane().add(textArea);

        JButton btnBack = new JButton("Back");
        btnBack.setBackground(new Color(30, 144, 255));
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Arial", Font.BOLD, 16));
        btnBack.setBounds(714, 724, 120, 35);
        getContentPane().add(btnBack);

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new studentDashboard().setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new help().setVisible(true);
    }
}
