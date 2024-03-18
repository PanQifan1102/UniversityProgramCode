import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JFrame implements ActionListener {
    private JTextField usernameField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton registerBtn, cancelBtn;

    public RegistrationForm() {
        setSize(400, 300);
        setTitle("Registration Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        panel.add(new JLabel("Username:"), c);
        c.gridx = 1;
        usernameField = new JTextField(20);
        panel.add(usernameField, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(new JLabel("Email:"), c);
        c.gridx = 1;
        emailField = new JTextField(20);
        panel.add(emailField, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(new JLabel("Password:"), c);
        c.gridx = 1;
        passwordField = new JPasswordField(20);
        panel.add(passwordField, c);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(new JLabel("Confirm Password:"), c);
        c.gridx = 1;
        confirmPasswordField = new JPasswordField(20);
        panel.add(confirmPasswordField, c);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        JPanel btnPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        registerBtn = new JButton("Register");
        btnPanel.add(registerBtn);
        cancelBtn = new JButton("Cancel");
        btnPanel.add(cancelBtn);
        panel.add(btnPanel, c);

        add(panel);
        setVisible(true);

        registerBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerBtn) {
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());
            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match.");
            } else {
                // TODO: Handle registration logic
                JOptionPane.showMessageDialog(this, "Registration successful.");
                dispose();
            }
        } else if (e.getSource() == cancelBtn) {
            dispose();
        }
    }

}
