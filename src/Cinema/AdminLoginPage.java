package Cinema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminLoginPage extends JFrame implements ActionListener {

    JTextField userNameField;
    JPasswordField passwordField;
    JButton loginButton, registerButton, backButton;

    final String DB_URL = "jdbc:mysql://localhost:3306/cinema_db";
    final String DB_USER = "root";
    final String DB_PASS = "123";

    public AdminLoginPage() {
        setTitle("Login Page");
        setLayout(null);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Left panel
        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 0, 400, 600);
        panel1.setBackground(Color.cyan);
        panel1.setLayout(null);

        JLabel welcomeLabel = new JLabel("<html><center><i>Welcome To<br>Movie Ticket Booking<br> Login Page</center></html>");
        welcomeLabel.setBounds(60, 180, 300, 150);
        welcomeLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        panel1.add(welcomeLabel);

        // Right panel
        JPanel panel2 = new JPanel();
        panel2.setBounds(400, 0, 400, 600);
        panel2.setBackground(Color.white);
        panel2.setLayout(null);

        // Back Button
        backButton = new JButton("Back");
        backButton.setFont(new Font("Helvetica", Font.PLAIN, 20));
        backButton.setForeground(Color.black);
        backButton.setBackground(Color.WHITE);
        backButton.setOpaque(true);
        backButton.setFocusable(false);
        backButton.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        backButton.setBounds(20, 20, 80, 30);
        backButton.addActionListener(this);
        panel1.add(backButton);  // ✅ FIXED: Added to panel2 instead of backgroundLabel

        // Logo
        JLabel logoLabel = new JLabel(new ImageIcon("image/logo.png"));  // Optional
        logoLabel.setBounds(140, 60, 100, 100);
        panel2.add(logoLabel);

        JLabel loginTitle = new JLabel("<html><h1>LOGIN</h1></html>");
        loginTitle.setBounds(150, 120, 100, 100);
        panel2.add(loginTitle);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(60, 220, 100, 30);
        panel2.add(userLabel);

        userNameField = new JTextField(20);
        userNameField.setBounds(150, 220, 180, 30);
        panel2.add(userNameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(60, 280, 100, 30);
        panel2.add(passLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(150, 280, 180, 30);
        panel2.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 350, 100, 30);
        loginButton.setBackground(Color.cyan);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        panel2.add(loginButton);

//        registerButton = new JButton("Register");
//        registerButton.setBounds(150, 400, 100, 30);
//        registerButton.setBackground(Color.cyan);
//        registerButton.setFocusable(false);
//        registerButton.addActionListener(this);
//        panel2.add(registerButton);

        add(panel1);
        add(panel2);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = userNameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (!username.isEmpty() && !password.isEmpty()) {
                try {
                    Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

                    String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "Login successful!");
                        dispose();
                        new DashBoard();  // You can redirect to UserDashboardUI() here
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid username or password.");
                    }

                    rs.close();
                    stmt.close();
                    conn.close();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter username and password.");
            }
        } else if (e.getSource() == registerButton) {
            dispose();
            new RegistationPage(); // Make sure this class exists
        } else if (e.getSource() == backButton) {
            dispose();
            new LoginProfile(); // Returns to role selection
        }
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "MySQL JDBC driver not found.");
            return;
        }

        new AdminLoginPage();
    }
}
