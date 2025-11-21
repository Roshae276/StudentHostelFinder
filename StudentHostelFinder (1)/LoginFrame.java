import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginBtn;
    private JButton signupBtn;

    public LoginFrame() {
        super("Student Hostel Finder - Login");
        setupUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 260);
        setLocationRelativeTo(null);
    }

    private void setupUI(){
        JPanel main = new JPanel(new BorderLayout(8,8));
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setBorder(BorderFactory.createEmptyBorder(12,12,12,12));

        usernameField = new JTextField();
        usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
        usernameField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(120,120,120), 1, true),
            BorderFactory.createEmptyBorder(8,10,8,10)
        ));

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(120,120,120), 1, true),
            BorderFactory.createEmptyBorder(8,10,8,10)
        ));

        form.add(new JLabel("Username:"));
        form.add(usernameField);
        form.add(Box.createVerticalStrut(8));
        form.add(new JLabel("Password:"));
        form.add(passwordField);
        form.add(Box.createVerticalStrut(12));

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
        loginBtn = new JButton("Login");
        signupBtn = new JButton("Signup");

        loginBtn.addActionListener(e -> doLogin());
        signupBtn.addActionListener(e -> openSignup());

        btnPanel.add(loginBtn);
        btnPanel.add(signupBtn);
        form.add(btnPanel);

        main.add(form, BorderLayout.CENTER);
        add(main);
    }

    private void doLogin(){
        String user = usernameField.getText().trim();
        String exam = "Not specified";
        String coaching = "Not specified";
        String branch = "Not specified";

        SwingUtilities.invokeLater(() -> {
            StudentDashboard sd = new StudentDashboard(user, exam, coaching, branch);
            sd.setVisible(true);
            this.dispose();
        });
    }

    private void openSignup(){
        SwingUtilities.invokeLater(() -> {
            new SignupFrame().setVisible(true);
            this.dispose();
        });
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            DataStore.getInstance();
            new LoginFrame().setVisible(true);
        });
    }
}
