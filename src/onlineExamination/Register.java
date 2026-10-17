package onlineExamination;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Online Examination Portal");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setTitle("Online Examination Portal");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(1366, 800));
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonGroup group = new ButtonGroup();
		
		JList list = new JList();
		list.setBounds(237, 214, 0, 0);
		contentPane.add(list);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(177, 181, 44, 0);
		contentPane.add(lblNewLabel_5);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(512, 64, 616, 672);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Student Registration");
		lblNewLabel_8.setForeground(new Color(65, 105, 225));
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_8.setBounds(212, 22, 215, 25);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel = new JLabel("Full Name:");
		lblNewLabel.setBounds(86, 84, 99, 25);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setBounds(86, 119, 495, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setBounds(86, 161, 51, 25);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 196, 495, 32);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Age:");
		lblNewLabel_2.setBounds(86, 238, 44, 29);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		
		textField_2 = new JTextField();
		textField_2.setBounds(86, 277, 495, 32);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Gender:");
		lblNewLabel_3.setBounds(85, 319, 67, 18);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JCheckBox Male = new JCheckBox("Male");
		Male.setBackground(new Color(240, 248, 255));
		Male.setBounds(86, 343, 66, 20);
		panel.add(Male);
		Male.setFont(new Font("Arial", Font.PLAIN, 12));
		group.add(Male);
		
		JCheckBox Female = new JCheckBox("Female");
		Female.setBackground(new Color(240, 248, 255));
		Female.setBounds(166, 343, 66, 20);
		panel.add(Female);
		Female.setFont(new Font("Arial", Font.PLAIN, 12));
		group.add(Female);
		
		JCheckBox Other = new JCheckBox("Other");
		Other.setBackground(new Color(240, 248, 255));
		Other.setBounds(253, 343, 95, 20);
		panel.add(Other);
		Other.setFont(new Font("Arial", Font.PLAIN, 12));
		group.add(Other);
		
		JLabel lblNewLabel_4 = new JLabel("Address:");
		lblNewLabel_4.setBounds(86, 378, 79, 19);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
		
		textField_3 = new JTextField();
		textField_3.setBounds(86, 407, 495, 32);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Phone:");
		lblNewLabel_6.setBounds(86, 456, 79, 18);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 15));
		
		textField_4 = new JTextField();
		textField_4.setBounds(86, 484, 495, 32);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Password:");
		lblNewLabel_7.setBounds(86, 526, 79, 25);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 15));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(86, 561, 495, 32);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBounds(86, 615, 206, 32);
		panel.add(btnNewButton);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 192));
		
		JButton btnNewButton_2 = new JButton("Have Account ? Login Now");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new Main().setVisible(true);
			     dispose();
			}
		});
		btnNewButton_2.setBounds(369, 615, 212, 32);
		panel.add(btnNewButton_2);
		btnNewButton_2.setBackground(new Color(0, 128, 192));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try{
					String name = textField.getText();
					String email = textField_1.getText();
					int Age = Integer.parseInt(textField_2.getText());
					String gender = "";
					if(Male.isSelected()){
						gender = "Male";
					}
					else if(Female.isSelected()){
						gender = "Female";
					}
					else if(Other.isSelected()){
						gender = "Other";
					}
					else{
						JOptionPane.showMessageDialog(null, "Please Select A Gender !" , "Online Examination Portal" , JOptionPane.WARNING_MESSAGE); 
						return;
					}

					String address = textField_3.getText();
					String phone = textField_4.getText();
					String password = new String(passwordField.getPassword());

					Class.forName("org.postgresql.Driver");
					Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/online-exam",
						"postgres",
						"1977"

					);

					String sql = "INSERT INTO users(name , email , age , gender , phone , address , password)" +
					"VALUES(? , ? , ? , ? , ? , ? , ?)";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, name);
					stmt.setString(2, email);
					stmt.setInt(3, Age);
					stmt.setString(4, gender);
					stmt.setString(5, phone);
					stmt.setString(6, address);
					stmt.setString(7, password);

					int rows = stmt.executeUpdate();

					if(rows > 0){
						JOptionPane.showMessageDialog(null, "Register Successfully" , "Online Examination Portal" , JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null, "Register Unsuccessfull" , "Online Examination Portal" , JOptionPane.INFORMATION_MESSAGE);
					}
				}catch(Exception c){
					JOptionPane.showMessageDialog(null, c.getMessage() ,  "Error :" , JOptionPane.WARNING_MESSAGE);
					c.printStackTrace();
				}

				
			}
		});
		

	}
}