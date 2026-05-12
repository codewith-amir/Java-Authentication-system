import java.awt.*;
import java.lang.reflect.Method;
import javax.swing.*;

public class Auth {

    Auth(UserData userData) {

        JFrame frame = new JFrame("Login");
        frame.setSize(350, 230);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        // Title label
        JLabel titleLabel = new JLabel("User Login");
        titleLabel.setBounds(120, 10, 120, 25);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 50, 80, 25);

        JTextField userField = new JTextField();
        userField.setBounds(120, 50, 150, 25);

        // Password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 90, 80, 25);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(120, 90, 150, 25);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(90, 140, 90, 30);

        // Sign Up Button
        JButton signupButton = new JButton("Sign Up");
        signupButton.setBounds(190, 140, 90, 30);

        // Login action
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (authenticateUser(userData, username, password)) {
                JOptionPane.showMessageDialog(frame, "Welcome, " + username + "!", "Success", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                // new InventoryWindow();  // uncomment if you have next window
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Sign Up action - opens SignUp window
        signupButton.addActionListener(e -> {
            frame.dispose();
            new SignUp(userData);
        });

        frame.add(titleLabel);
        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginButton);
        frame.add(signupButton);

        frame.setVisible(true);
    }

    private boolean authenticateUser(UserData userData, String username, String password) {
        try {
            Method method = userData.getClass().getMethod("authenticate", String.class, String.class);
            Object result = method.invoke(userData, username, password);
            return result instanceof Boolean && (Boolean) result;
        } catch (Exception ignored) {
            return false;
        }
    }
}
