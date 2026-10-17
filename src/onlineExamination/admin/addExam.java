package onlineExamination.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import onlineExamination.Main;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class addExam extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addExam frame = new addExam();
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
	public addExam() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Add Exam");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setBounds(526, 10, 184, 35);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(240, 248, 255));
		panel_3.setBounds(597, 203, 648, 189);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Subject  :");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(112, 34, 252, 33);
		panel_3.add(lblNewLabel_2);
		
		JTextField textField = new JTextField();
		textField.setBounds(112, 77, 420, 27);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Add Exam");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String subject = textField.getText();
					if (subject == "") {
						JOptionPane.showMessageDialog(null, "Please Enter Subject" , "Online Examination System" , JOptionPane.INFORMATION_MESSAGE);
						return;
		            }

					Class.forName("org.postgresql.Driver");
					Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/online-exam",
						"postgres",
						"1977"
					);

					String sql = "INSERT INTO exams(Subject)VALUES(?)";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, subject);

					int rows = stmt.executeUpdate();

					if(rows > 0){
						JOptionPane.showMessageDialog(null, "Subject Added Successfully");
					}
					else{
						JOptionPane.showMessageDialog(null, "Invalid Name");
					}
				}catch(Exception c){
					JOptionPane.showMessageDialog(null, c.getMessage());
				}
			}
		});
		btnNewButton_1.setForeground(new Color(255, 250, 250));
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1.setBounds(243, 125, 121, 33);
		panel_3.add(btnNewButton_1);

	}

}
