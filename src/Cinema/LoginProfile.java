package Cinema;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginProfile extends JFrame implements ActionListener {

    // Declare components
    JPanel panel;
    JLabel infoLabel, backgroundLabel, adminLabel, userLabel;
    JButton adminButton, userButton;

    public LoginProfile() {

        this.setTitle("Login Profile");
        this.setSize(1000, 800);
        this.setLayout(null);
        this.setLocationRelativeTo(null); // Center window

        // Background image
        ImageIcon bgIcon = new ImageIcon("Image/LoginPanel.jpg"); // <-- Ensure path is correct
        Image bgImg = bgIcon.getImage().getScaledInstance(1000, 800, Image.SCALE_SMOOTH);
        backgroundLabel = new JLabel(new ImageIcon(bgImg));
        backgroundLabel.setBounds(0, 0, 1000, 800);
        backgroundLabel.setLayout(null); // So we can add components directly on top

        // Info label
        infoLabel = new JLabel("Select Login Role");
        infoLabel.setBounds(400, 60, 250, 100);
        infoLabel.setFont(new Font("Helvetica", Font.BOLD, 25));
        infoLabel.setForeground(Color.red);

        // Admin button
        adminButton = new JButton();
        adminButton.setBounds(130, 250, 300, 300);
        adminButton.setFocusPainted(false);
        adminButton.setBorderPainted(false);
        adminButton.setContentAreaFilled(false);
        ImageIcon adminIcon = new ImageIcon("Image/admin.png");
        Image adminImg = adminIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        adminButton.setIcon(new ImageIcon(adminImg));
        adminButton.addActionListener(this); // ✅ FIXED

        // User button
        userButton = new JButton();
        userButton.setBounds(570, 250, 300, 300);
        userButton.setFocusPainted(false);
        userButton.setBorderPainted(false);
        userButton.setContentAreaFilled(false);
        ImageIcon userIcon = new ImageIcon("Image/user.png");
        Image userImg = userIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        userButton.setIcon(new ImageIcon(userImg));
        userButton.addActionListener(this); // Optional: if needed for user login

        // Admin label
        adminLabel = new JLabel("Admin");
        adminLabel.setBounds(250, 550, 250, 100);
        adminLabel.setFont(new Font("Helvetica", Font.BOLD, 25));
        adminLabel.setForeground(Color.red);

        // User label
        userLabel = new JLabel("User");
        userLabel.setBounds(695, 550, 250, 100);
        userLabel.setFont(new Font("Helvetica", Font.BOLD, 25));
        userLabel.setForeground(Color.red);

        // Main panel
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1000, 800);
        panel.setBackground(Color.cyan);

        // Add elements to panel
        panel.add(infoLabel);
        panel.add(adminButton);
        panel.add(userButton);
        panel.add(adminLabel);
        panel.add(userLabel);
        panel.add(backgroundLabel); // Add background last so it's in back

        // Add panel to frame
        this.add(panel);

        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new LoginProfile();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminButton ) {
            dispose();
            new AdminLoginPage(); // ✅ Make sure this class exists
        } else if (e.getSource() == userButton) {
        	dispose();
            new LoginPage();
        }
    }
}
