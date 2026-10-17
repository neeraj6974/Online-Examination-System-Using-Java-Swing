package onlineExamination.admin;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import onlineExamination.Main;

import java.sql.*;

public class dashboard extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableStudents, tableExams;
    private JLabel lblStudentCount, lblExamCount;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                dashboard frame = new dashboard();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public dashboard() {
		setTitle("Online Examination Portal - Admin");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1366, 800);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 250, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // ===== Sidebar =====
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
        panel_1.setBackground(Color.WHITE);
        panel_1.setBounds(10, 95, 282, 2);
        panel.add(panel_1);

        String[] buttons = {"Dashboard", "Add Exam", "Add Question", "Manage Students", "Manage Exams", "Logout"};
        int y = 130;
        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.PLAIN, 17));
            btn.setBackground(Color.WHITE);
            btn.setBounds(10, y, 282, 44);
            panel.add(btn);

            // Add action listeners
            btn.addActionListener(e -> {
                switch (text) {
                    case "Dashboard":
                        new dashboard().setVisible(true);
                        dispose();
                        break;

                    case "Add Exam":
                        new addExam().setVisible(true);
                        dispose();
                        break;

                    case "Add Question":
                        new addQuestion().setVisible(true);
                        dispose();
                        break;

                    case "Manage Students":
                        new manageStudent().setVisible(true);
                        dispose();
                        break;

                    case "Manage Exams":
                        new manageExam().setVisible(true);
                        dispose();
                        break;

                    case "Logout":
                        new Main().setVisible(true);
                        dispose();
                        break;
                }
            });

            y += 70;
        }

        // ===== Header Text =====
        JLabel lblNewLabel_1 = new JLabel("Admin Dashboard");
        lblNewLabel_1.setBounds(328, 0, 917, 61);
        contentPane.add(lblNewLabel_1);
        lblNewLabel_1.setForeground(new Color(30, 144, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 32));

        // ===== Count Panels =====
        JPanel studentPanel = new JPanel();
        studentPanel.setBackground(new Color(70, 130, 180)); // Blue
        studentPanel.setBounds(350, 110, 300, 150);
        studentPanel.setLayout(new BorderLayout());
        contentPane.add(studentPanel);

        JLabel lblStuTitle = new JLabel("Total Students", JLabel.CENTER);
        lblStuTitle.setForeground(Color.WHITE);
        lblStuTitle.setFont(new Font("Arial", Font.BOLD, 20));
        studentPanel.add(lblStuTitle, BorderLayout.NORTH);

        lblStudentCount = new JLabel("0", JLabel.CENTER);
        lblStudentCount.setForeground(Color.WHITE);
        lblStudentCount.setFont(new Font("Arial", Font.BOLD, 50));
        studentPanel.add(lblStudentCount, BorderLayout.CENTER);

        JPanel examPanel = new JPanel();
        examPanel.setBackground(new Color(46, 139, 87)); // Green
        examPanel.setBounds(700, 110, 300, 150);
        examPanel.setLayout(new BorderLayout());
        contentPane.add(examPanel);

        JLabel lblExamTitle = new JLabel("Total Exams", JLabel.CENTER);
        lblExamTitle.setForeground(Color.WHITE);
        lblExamTitle.setFont(new Font("Arial", Font.BOLD, 20));
        examPanel.add(lblExamTitle, BorderLayout.NORTH);

        lblExamCount = new JLabel("0", JLabel.CENTER);
        lblExamCount.setForeground(Color.WHITE);
        lblExamCount.setFont(new Font("Arial", Font.BOLD, 50));
        examPanel.add(lblExamCount, BorderLayout.CENTER);

        // ===== Students Table =====
        JLabel lblLatestStudents = new JLabel("Students");
        lblLatestStudents.setFont(new Font("Arial", Font.BOLD, 20));
        lblLatestStudents.setBounds(350, 300, 300, 30);
        contentPane.add(lblLatestStudents);

        JScrollPane scrollStudents = new JScrollPane();
        scrollStudents.setBounds(350, 340, 950, 120);
        contentPane.add(scrollStudents);

        tableStudents = new JTable();
        scrollStudents.setViewportView(tableStudents);

        // ===== Exams Table =====
        JLabel lblLatestExams = new JLabel("Exams");
        lblLatestExams.setFont(new Font("Arial", Font.BOLD, 20));
        lblLatestExams.setBounds(350, 480, 300, 30);
        contentPane.add(lblLatestExams);

        JScrollPane scrollExams = new JScrollPane();
        scrollExams.setBounds(350, 520, 950, 120);
        contentPane.add(scrollExams);

        tableExams = new JTable();
        scrollExams.setViewportView(tableExams);

        // Load counts & data
        loadCounts();
        loadLatestStudents();
        loadLatestExams();
    }

    private void loadCounts() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/online-exam", "postgres", "1977");
            Statement stmt = conn.createStatement();

            ResultSet rs1 = stmt.executeQuery("SELECT COUNT(*) FROM users");
            if (rs1.next()) lblStudentCount.setText(String.valueOf(rs1.getInt(1)));

            ResultSet rs2 = stmt.executeQuery("SELECT COUNT(*) FROM exams");
            if (rs2.next()) lblExamCount.setText(String.valueOf(rs2.getInt(1)));

            rs1.close();
            rs2.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadLatestStudents() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/online-exam", "postgres", "1977");

            String query = "SELECT id, name, email, phone FROM users ORDER BY id DESC LIMIT 2";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Email");
            model.addColumn("Phone");

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone")
                });
            }

            tableStudents.setModel(model);
            tableStudents.setFont(new Font("Arial", Font.PLAIN, 15));
            tableStudents.setRowHeight(25);
            tableStudents.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));

            rs.close();
            pst.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadLatestExams() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/online-exam", "postgres", "1977");

            String query = "SELECT id, subject FROM exams ORDER BY id DESC LIMIT 2";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Exam ID");
            model.addColumn("Subject");

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("subject"),
                });
            }

            tableExams.setModel(model);
            tableExams.setFont(new Font("Arial", Font.PLAIN, 15));
            tableExams.setRowHeight(25);
            tableExams.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));

            rs.close();
            pst.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
