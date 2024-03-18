import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserFunctionalityForm extends JFrame implements ActionListener {
    private JButton enterOrgBtn, enterAcctBtn, logoutBtn;

    public UserFunctionalityForm() {
        setTitle("User Functionality");
        setSize(400, 300);
        setLocationRelativeTo(null);

        enterOrgBtn = new JButton("Enter Organization");
        enterAcctBtn = new JButton("Enter Accounts");
        logoutBtn = new JButton("Logout");

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(enterOrgBtn, gbc);
        gbc.gridy = 1;
        panel.add(enterAcctBtn, gbc);
        gbc.gridy = 2;
        panel.add(logoutBtn, gbc);

        add(panel);
        setVisible(true);

        enterOrgBtn.addActionListener(this);
        enterAcctBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterOrgBtn) {
            // Open organization page
        } else if (e.getSource() == enterAcctBtn) {
            // Open accounts page
        } else if (e.getSource() == logoutBtn) {
            new MainLoginForm();
            dispose();
        }
    }
}