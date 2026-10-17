package onlineExamination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class about extends JFrame {

    private static final long serialVersionUID = 1L;

    public about() {
		setTitle("Online Examination Portal");
    	getContentPane().setPreferredSize(new Dimension(1366, 800));
        setTitle("About Us - Examination Portal");
        setSize(800, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(255, 250, 250));
        getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("About Us", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitle.setForeground(new Color(30, 144, 255));
        lblTitle.setBounds(387, 25, 800, 40);
        getContentPane().add(lblTitle);

        JTextArea textArea = new JTextArea();
        textArea.setText(
                "Welcome to the Online Examination Portal!\n\n" +
                "This platform is created to help students practice and improve their knowledge\n" +
                "through interactive online exams. It is an independent system and is not associated\n" +
                "with any school, college, or university.\n\n" +
                "Our goal is to make learning easier, faster, and more accessible for everyone.\n\n" +
                "Students can take mock tests, review their performance, and prepare for real exams\n" +
                "from anywhere at any time.\n\n" +
                "Key Features:\n" +
                "• Practice exams for various subjects.\n" +
                "• Instant result evaluation.\n" +
                "• Simple and user-friendly interface.\n\n" +
                "Thank you for using our portal!\n\n" +
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
        new about().setVisible(true);
    }
}
