package onlineExamination;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class studentDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentDashboard frame = new studentDashboard();
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
	public studentDashboard() {
		setTitle("Online Examination Portal");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("More\r\n");
		mnNewMenu.setFont(new Font("Arial", Font.PLAIN, 16));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("About Us");
		mntmNewMenuItem.addActionListener(e -> {
		    new about().setVisible(true);
		});
		mntmNewMenuItem.setFont(new Font("Arial", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Logout");
		mntmNewMenuItem_1.addActionListener(e -> {
		    new Main().setVisible(true);
		});
		mntmNewMenuItem_1.setFont(new Font("Arial", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Help");
		mnNewMenu_1.setFont(new Font("Arial", Font.PLAIN, 16));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Need Help ?");
		mntmNewMenuItem_2.addActionListener(e -> {
		    new help().setVisible(true);
		});
		mntmNewMenuItem_2.setFont(new Font("Arial", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(1366, 800));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(126, 123, 1326, 403);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Subject :");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(62, 30, 387, 63);
		panel.add(lblNewLabel);
		
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
		comboBox.setBounds(62, 88, 329, 31);
		panel.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(62, 205, 337, 19);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Start Exam");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String subject = (String) comboBox.getSelectedItem();
				if (subject == null) {
					lblNewLabel_4.setText("Please select a subject first!");
					return;
	            }
				else {
					new ExamWindow(subject).setVisible(true); // open exam window
	                dispose();
				}
			}
		});
		btnNewButton.setBackground(new Color(34, 139, 34));
		btnNewButton.setForeground(new Color(255, 250, 250));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(62, 144, 329, 40);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("<html><body><p>⚠️ Important Notice<p>\r\n<p>Once you click on “Start Exam”, the test will begin immediately.You cannot cancel, go back, or restart the exam after it starts.\r\nPlease make sure you are ready before proceeding.</p></body></html>");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(62, 203, 337, 190);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(496, 30, 4, 344);
		panel.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html><body><h1>Exam Rules : </h1></body></html>");
		lblNewLabel_2.setBounds(521, 30, 175, 31);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("<html><body>\r\n<ol>\r\n<li>The exam will begin immediately after you click Start Exam.</li>\r\n<li>Once started, you cannot pause, cancel, or restart the exam.</li>\r\n<li>Do not refresh, close, or minimize the exam window — this may end your test automatically.</li>\r\n<li>Make sure your internet connection is stable before starting.</li>\r\n<li>Leaving the exam screen repeatedly may lead to disqualification.</li>\r\n<li>Click “Submit” only after reviewing your answers carefully.</li>\r\n</ol>\r\n</body></html>");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(531, 71, 613, 161);
		panel.add(lblNewLabel_3);
		
		

	}
}
