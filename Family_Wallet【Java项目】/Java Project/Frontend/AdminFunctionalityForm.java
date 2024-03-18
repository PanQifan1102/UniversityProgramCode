import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFunctionalityForm extends JFrame implements ActionListener {
    private JButton addUserBtn, updateUserBtn, deleteUserBtn, searchUserBtn, logoutBtn;

    public AdminFunctionalityForm() {
        setTitle("Admin Functionality");
        setSize(600, 400);
        setLocationRelativeTo(null);

        addUserBtn = new JButton("Add User");
        updateUserBtn = new JButton("Update User");
        deleteUserBtn = new JButton("Delete User");
        searchUserBtn = new JButton("Search User");
        logoutBtn = new JButton("Logout");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1));
        buttonPanel.add(addUserBtn);
        buttonPanel.add(updateUserBtn);
        buttonPanel.add(deleteUserBtn);
        buttonPanel.add(searchUserBtn);
        buttonPanel.add(logoutBtn);

        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BorderLayout());
        JLabel userLabel = new JLabel("Users:");
        userPanel.add(userLabel, BorderLayout.NORTH);
        String[] columnNames = {"Username", "Password"};
        Object[][] data = {{"user1", "password1"}, {"user2", "password2"}, {"user3", "password3"}};
        JTable userTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(userTable);
        userPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.WEST);
        mainPanel.add(userPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);

        addUserBtn.addActionListener(this);
        updateUserBtn.addActionListener(this);
        deleteUserBtn.addActionListener(this);
        searchUserBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addUserBtn) {
            // Open add user page
        } else if (e.getSource() == updateUserBtn) {
            // Open update user page
        } else if (e.getSource() == deleteUserBtn) {
            // Open delete user page
        } else if (e.getSource() == searchUserBtn) {
            // Open search user page
        } else if (e.getSource() == logoutBtn) {
            new MainLoginForm();
            dispose();
        }
    }
}