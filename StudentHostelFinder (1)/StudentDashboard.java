import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StudentDashboard extends JFrame {
    private String username;
    private String exam;
    private String coaching;
    private String branch;

    public StudentDashboard(String username, String exam, String coaching, String branch){
        super("Student Hostel Finder - " + username);
        this.username = username;
        this.exam = exam;
        this.coaching = coaching;
        this.branch = branch;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI(){
        // Top header panel with colored background and text
        JPanel top = new JPanel();
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        top.setBackground(new Color(48, 63, 159)); // Indigo 700
        top.setBorder(BorderFactory.createEmptyBorder(16, 0, 16, 0));
        JLabel title = new JLabel("Student Hostel Finder");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 0));
        top.add(title);
        JLabel subtitle = new JLabel("Welcome, " + username + " — Exam: " + exam);
        subtitle.setForeground(Color.WHITE);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        top.add(subtitle);
        JLabel subsub = new JLabel("Coaching: " + coaching + " | Branch: " + branch);
        subsub.setForeground(Color.WHITE);
        subsub.setFont(new Font("Arial", Font.PLAIN, 14));
        top.add(subsub);

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        JScrollPane scroller = new JScrollPane(center);
        scroller.getVerticalScrollBar().setUnitIncrement(16);

        List<Hostel> hostels = DataStore.getInstance().getHostels();
        for(Hostel h : hostels){
            JPanel hp = new JPanel(new BorderLayout(8,8)){
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(new Color(0,0,0,30));
                    g.fillRoundRect(4, getHeight()-8, getWidth()-8, 8, 12, 12);
                }
            };
            hp.setBackground(Color.WHITE);
            hp.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(12,12,12,12),
                BorderFactory.createLineBorder(new Color(120,120,120), 1, true)
            ));

            // Left: blank space placeholder
            JPanel imgPanel = new JPanel();
            imgPanel.setPreferredSize(new Dimension(220,140));
            imgPanel.setOpaque(false);
            hp.add(imgPanel, BorderLayout.WEST);

            // Center info
            JPanel info = new JPanel();
            info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
            JLabel nameLabel = new JLabel("<html><b>" + h.getName() + "</b></html>");
            nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
            info.add(nameLabel);
            JLabel addrLabel = new JLabel("Address: " + h.getAddress());
            addrLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            info.add(addrLabel);
            JLabel contactLabel = new JLabel("Contact: " + h.getContactNumber());
            contactLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            info.add(contactLabel);
            JLabel rentLabel = new JLabel("AC Rent: ₹" + h.getRentAc() + " | Non-AC Rent: ₹" + h.getRentNonAc());
            rentLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            info.add(rentLabel);
            info.add(Box.createVerticalStrut(6));

            // Accommodations
            for(Accommodation a : h.getAccommodations()){
                JLabel accLabel = new JLabel("- " + a.getName() + " : " + a.getRoomType() +
                    (a.isAc()? " (AC)" : " (Non-AC)") + " : ₹" + a.getRent() + " | " + a.getNotes());
                accLabel.setFont(new Font("Arial", Font.PLAIN, 13));
                accLabel.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 2));
                info.add(accLabel);
            }

            hp.add(info, BorderLayout.CENTER);

            // Right action buttons with modern styling
            JPanel right = new JPanel(new GridLayout(2,1,6,6));
            JButton callBtn = new JButton("Call");
            callBtn.setBackground(new Color(33, 150, 243));
            callBtn.setForeground(Color.WHITE);
            callBtn.setFocusPainted(false);
            callBtn.setFont(new Font("Arial", Font.BOLD, 14));
            callBtn.setBorder(BorderFactory.createEmptyBorder(8,16,8,16));
            callBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Contact number: " + h.getContactNumber()));

            JButton moreBtn = new JButton("More / Book");
            moreBtn.setBackground(new Color(76, 175, 80));
            moreBtn.setForeground(Color.WHITE);
            moreBtn.setFocusPainted(false);
            moreBtn.setFont(new Font("Arial", Font.BOLD, 14));
            moreBtn.setBorder(BorderFactory.createEmptyBorder(8,16,8,16));
            moreBtn.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Contact owner at: " + h.getContactNumber() + "\nAddress: " + h.getAddress()));

            right.add(callBtn);
            right.add(moreBtn);
            hp.add(right, BorderLayout.EAST);

            center.add(hp);

            JSeparator sep = new JSeparator();
            sep.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));
            center.add(sep);

            center.add(Box.createVerticalStrut(12));
        }

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(top, BorderLayout.NORTH);
        getContentPane().add(scroller, BorderLayout.CENTER);
    }

    public static void main(String[] args){
        DataStore.getInstance();
        SwingUtilities.invokeLater(() -> {
            new StudentDashboard("Test Student","JEE","Allen","Allen Sangyan").setVisible(true);
        });
    }
}
