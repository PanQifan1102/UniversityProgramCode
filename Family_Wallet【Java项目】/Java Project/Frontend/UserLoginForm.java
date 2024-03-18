import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginForm extends JFrame implements ActionListener {
	
    private JLabel usernameLbl, passwordLbl;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginBtn;

    public UserLoginForm() {
        setTitle("User Login");
        setSize(400, 300);
        setLocationRelativeTo(null);

        usernameLbl = new JLabel("Username:");
        passwordLbl = new JLabel("Password:");
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        loginBtn = new JButton("Login");

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(usernameLbl, gbc);
        gbc.gridx = 1;
        panel.add(usernameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLbl, gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginBtn, gbc);

        add(panel);
        setVisible(true);

        loginBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Perform user authentication
        boolean isValidUser = true; // Replace with actual authentication code

        if (isValidUser) {
            new UserFunctionalityForm();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.");
            usernameField.setText("");
            passwordField.setText("");
        }
    }
}