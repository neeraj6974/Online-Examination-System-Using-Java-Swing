package onlineExamination.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import onlineExamination.Main;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addQuestion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addQuestion frame = new addQuestion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addQuestion() {
		setTitle("Online Examination Portal - Admin");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setPreferredSize(new Dimension(1366, 800));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 302, 853);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin ");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(104, 25, 85, 59);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 95, 282, 2);
		panel.add(panel_1);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new dashboard().setVisible(true);
                dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 17));
		btnNewButton.setBounds(10, 130, 282, 44);
		panel.add(btnNewButton);
		
		JButton btnAddExam = new JButton("Add Exam");
		btnAddExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addExam().setVisible(true);
                dispose();
			}
		});
		btnAddExam.setFont(new Font("Arial", Font.PLAIN, 17));
		btnAddExam.setBackground(Color.WHITE);
		btnAddExam.setBounds(10, 200, 282, 44);
		panel.add(btnAddExam);
		
		JButton btnAddQuestion = new JButton("Add Question");
		btnAddQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addQuestion().setVisible(true);
                dispose();
			}
		});
		btnAddQuestion.setFont(new Font("Arial", Font.PLAIN, 17));
		btnAddQuestion.setBackground(Color.WHITE);
		btnAddQuestion.setBounds(10, 270, 282, 44);
		panel.add(btnAddQuestion);
		
		JButton btnLogout = new JButton("Manage Students");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new manageStudent().setVisible(true);
                dispose();
			}
		});
		btnLogout.setFont(new Font("Arial", Font.PLAIN, 17));
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setBounds(10, 341, 282, 44);
		panel.add(btnLogout);
		
		JButton btnManageExams = new JButton("Manage Exams");
		btnManageExams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new manageExam().setVisible(true);
                dispose();
			}
		});
		btnManageExams.setFont(new Font("Arial", Font.PLAIN, 17));
		btnManageExams.setBackground(Color.WHITE);
		btnManageExams.setBounds(10, 412, 282, 44);
		panel.add(btnManageExams);
		
		JButton btnLogout_1 = new JButton("Logout");
		btnLogout_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main().setVisible(true);
                dispose();
			}
		});
		btnLogout_1.setFont(new Font("Arial", Font.PLAIN, 17));
		btnLogout_1.setBackground(Color.WHITE);
		btnLogout_1.setBounds(10, 481, 282, 44);
		panel.add(btnLogout_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(30, 144, 255));
		panel_2.setBounds(304, 0, 1237, 55);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Add Question");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setBounds(526, 10, 184, 35);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(240, 248, 255));
		panel_3.setBounds(598, 88, 648, 668);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Question :");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(112, 10, 252, 33);
		panel_3.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(112, 45, 420, 27);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Choice 1 :");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(112, 87, 252, 33);
		panel_3.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(112, 125, 420, 27);
		panel_3.add(textField_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Choice 2 :");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(112, 170, 252, 33);
		panel_3.add(lblNewLabel_2_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(112, 208, 420, 27);
		panel_3.add(textField_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Choice 3 :");
		lblNewLabel_2_1_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2_1_2.setBounds(112, 257, 252, 33);
		panel_3.add(lblNewLabel_2_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(112, 291, 420, 27);
		panel_3.add(textField_3);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Choice 4 :");
		lblNewLabel_2_1_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2_1_2_1.setBounds(112, 333, 252, 33);
		panel_3.add(lblNewLabel_2_1_2_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(112, 375, 420, 27);
		panel_3.add(textField_4);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Correct Choice  :");
		lblNewLabel_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(112, 417, 252, 33);
		panel_3.add(lblNewLabel_2_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(112, 456, 420, 27);
		panel_3.add(textField_5);
		
		JComboBox<String> comboBox = new JComboBox<>();
        try {
            String url = "jdbc:postgresql://localhost:5432/online-exam";
            String user = "postgres";
            String password = "1977";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM exams";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                comboBox.addItem(rs.getString("subject"));
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
}
		comboBox.setBackground(new Color(255, 250, 250));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBounds(112, 544, 420, 33);
		panel_3.add(comboBox);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Select Subject :");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1.setBounds(112, 501, 252, 33);
		panel_3.add(lblNewLabel_2_1_1_1_1);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String question = textField.getText();
					String choice1 = textField_1.getText();
					String choice2 = textField_2.getText();
					String choice3 = textField_3.getText();
					String choice4 = textField_4.getText();
					String correct = textField_5.getText();
					String subject = (String) comboBox.getSelectedItem();

					Class.forName("org.postgresql.Driver");
					Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/online-exam",
						"postgres",
						"1977"
					);

					String sql = "INSERT INTO questions(question , choice1 , choice2 , choice3 , choice4 , correct_ans , subject)VALUES(? , ? , ? , ? , ? , ? , ?)";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, question);
					stmt.setString(2, choice1);
					stmt.setString(3, choice2);
					stmt.setString(4, choice3);
					stmt.setString(5, choice4);
					stmt.setString(6, correct);
					stmt.setString(7, subject);

					int rows = stmt.executeUpdate();

					if(rows > 0){
						JOptionPane.showMessageDialog(null, "Question Added Successfully");
					}
					else{
						JOptionPane.showMessageDialog(null, "Invalid Question");
					}
				}catch(Exception c){
					JOptionPane.showMessageDialog(null, c.getMessage());
				}
			}
		});
		btnNewButton_1.setForeground(new Color(255, 250, 250));
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1.setBounds(260, 604, 121, 33);
		panel_3.add(btnNewButton_1);
	}
}
