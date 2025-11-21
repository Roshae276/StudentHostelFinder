import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class SignupFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JRadioButton jeeRadio, neetRadio;
    private JComboBox<String> coachingCombo;
    private JComboBox<String> branchCombo;
    private JButton signupBtn;
    private JButton backBtn;

    public SignupFrame() {
        super("Student Hostel Finder - Signup");
        setupUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 360);
        setLocationRelativeTo(null);
    }

    private void setupUI(){
        DataStore ds = DataStore.getInstance();

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

        form.add(new JLabel("Choose Username:"));
        form.add(usernameField);
        form.add(Box.createVerticalStrut(8));
        form.add(new JLabel("Choose Password:"));
        form.add(passwordField);
        form.add(Box.createVerticalStrut(12));

        JPanel radioPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPane.add(new JLabel("Preparing for:"));
        jeeRadio = new JRadioButton("JEE");
        neetRadio = new JRadioButton("NEET");
        ButtonGroup bg = new ButtonGroup();
        bg.add(jeeRadio); bg.add(neetRadio);
        radioPane.add(jeeRadio);
        radioPane.add(neetRadio);
        form.add(radioPane);

        form.add(Box.createVerticalStrut(8));

        JPanel coachingPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
        coachingPane.add(new JLabel("Coaching:"));
        coachingCombo = new JComboBox<>();
        for(String c: ds.getCoachingList()) coachingCombo.addItem(c);
        coachingPane.add(coachingCombo);

        coachingPane.add(new JLabel("Branch:"));
        branchCombo = new JComboBox<>();
        coachingPane.add(branchCombo);
        form.add(coachingPane);

        updateBranches();

        coachingCombo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                updateBranches();
            }
        });

        form.add(Box.createVerticalStrut(14));

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
        signupBtn = new JButton("Signup");
        backBtn = new JButton("Back");

        signupBtn.addActionListener(e -> doSignup());
        backBtn.addActionListener(e -> goBackToLogin());

        btnPanel.add(signupBtn);
        btnPanel.add(backBtn);
        form.add(btnPanel);

        main.add(form, BorderLayout.CENTER);
        add(main);
    }

    private void updateBranches(){
        DataStore ds = DataStore.getInstance();
        String coaching = (String)coachingCombo.getSelectedItem();
        branchCombo.removeAllItems();
        List<String> branches = ds.getBranchesFor(coaching);
        if(branches.isEmpty()){
            branchCombo.addItem("Default Branch");
        } else {
            for(String b: branches) branchCombo.addItem(b);
        }
    }

    private void doSignup(){
        String user = usernameField.getText().trim();
        String exam = jeeRadio.isSelected() ? "JEE" : (neetRadio.isSelected()? "NEET":"Not specified");
        String coaching = (String)coachingCombo.getSelectedItem();
        String branch = (String)branchCombo.getSelectedItem();

        SwingUtilities.invokeLater(() -> {
            StudentDashboard sd = new StudentDashboard(user, exam, coaching, branch);
            sd.setVisible(true);
            this.dispose();
        });
    }

    private void goBackToLogin(){
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
            this.dispose();
        });
    }
}
