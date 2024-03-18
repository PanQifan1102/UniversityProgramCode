import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainLoginForm extends JFrame implements ActionListener {
    private JButton userLoginBtn, adminLoginBtn, registerBtn;

    public MainLoginForm() {
        setSize(400, 300);
        setTitle("Bookkeeping - A Personal Accounting Software For You");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        userLoginBtn = new JButton("User Login");
        adminLoginBtn = new JButton("Administrator Login");
        registerBtn = new JButton("Register");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        panel.add(userLoginBtn, c);
        c.gridy = 1;
        panel.add(adminLoginBtn, c);
        c.gridy = 2;
        c.gridwidth = 2;
        panel.add(registerBtn, c);

        add(panel);
        setVisible(true);

        userLoginBtn.addActionListener(this);
        adminLoginBtn.addActionListener(this);
        registerBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == userLoginBtn) {
            new UserLoginForm();
        } else if (e.getSource() == adminLoginBtn) {
            new AdminLoginForm();
        } else if (e.getSource() == registerBtn) {
            new RegistrationForm();
        }
    }

    public static void main(String[] args) {
        new MainLoginForm();
    }
}