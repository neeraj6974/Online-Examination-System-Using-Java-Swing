package onlineExamination;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;


import onlineExamination.admin.dashboard;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.Font;
import javax.swing.Timer;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("Online Examination Portal");
		setBackground(new Color(255, 255, 255));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(1366, 768));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(445, 162, 763, 401);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(400, 0, 363, 400);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome To Exam Portal");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(75, 26, 218, 29);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sign In");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(147, 65, 68, 29);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email :");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(42, 162, 84, 21);
		panel_1.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setToolTipText("Email\r\n");
		textField.setBounds(42, 193, 300, 29);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Password :");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(42, 232, 84, 21);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(0, 100, 0));
		panel_2.setBackground(new Color(0, 100, 0));
		panel_2.setBounds(42, 116, 300, 36);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		
		JLabel lblNewLabel_5 = new JLabel("Please fill the following fields");
		lblNewLabel_5.setForeground(new Color(245, 255, 250));
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 10, 280, 16);
		panel_2.add(lblNewLabel_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(42, 269, 300, 29);
		panel_1.add(passwordField);
		
		JButton btnNewButton = new JButton("Sign In As Admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textField.getText();
				String pass = String.valueOf(passwordField.getPassword());
				
				if(user.equals("admin@gmail.com") && pass.equals("admin")) {
					lblNewLabel_5.setText("Sign In Successfully !");
					Timer timer = new Timer(1000 , e2->{
						new dashboard().setVisible(true);
						dispose();
					});
					timer.setRepeats(false);
					timer.start();
				}
				else {
					lblNewLabel_5.setText("Invalid Username Or Password !");
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 250, 250));
		btnNewButton.setBackground(new Color(46, 139, 87));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton.setBounds(42, 322, 137, 29);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign In");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField.getText();
				String password = String.valueOf(passwordField.getPassword());
				
				if (email.isEmpty() || password.isEmpty()) {
					lblNewLabel_5.setText("Please enter username and password");
		            return;
		        }

		        try {
		            
		            Class.forName("org.postgresql.Driver");

		            
		            String url = "jdbc:postgresql://localhost:5432/online-exam";
		            String dbUser = "postgres";
		            String dbPass = "1977";
		            Connection conn = DriverManager.getConnection(url, dbUser, dbPass);

		         
		            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
		            PreparedStatement pst = conn.prepareStatement(query);
		            pst.setString(1, email);
		            pst.setString(2, password);

		            ResultSet rs = pst.executeQuery();

		            if (rs.next()) {
		            	lblNewLabel_5.setText("Sign In Successfull !");
		            	Timer timer = new Timer(1000 , e2->{
							new studentDashboard().setVisible(true);
							dispose();
						});
						timer.setRepeats(false);
						timer.start();
		            }else {
		            	lblNewLabel_5.setText("Invalid Details !");
		            }

		            rs.close();
		            pst.close();
		            conn.close();

		        } catch (Exception ex) {
		            ex.printStackTrace();
		            lblNewLabel_5.setText("Database Error: " + ex.getMessage());
		       }
		    }

			}
);
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setForeground(new Color(255, 250, 250));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton_1.setBounds(189, 322, 137, 29);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sign Up");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Register().setVisible(true);
				Main.this.dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(30, 144, 255));
		btnNewButton_2.setForeground(new Color(255, 250, 250));
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton_2.setBounds(121, 361, 128, 29);
		panel_1.add(btnNewButton_2);
		
	
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 400, 400);
		panel.add(lblNewLabel);

	}
}
