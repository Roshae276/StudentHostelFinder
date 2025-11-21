// OwnerDashboard.java
import javax.swing.*;
import java.awt.*;

public class OwnerDashboard extends JFrame {
    private Owner owner;
    private DefaultListModel<String> issueListModel;
    private JList<String> issueList;

    public OwnerDashboard(Owner owner) {
        this.owner = owner;
        setTitle("Owner Dashboard - " + owner.getName());
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        issueListModel = new DefaultListModel<>();
        issueList = new JList<>(issueListModel);
        JScrollPane scrollPane = new JScrollPane(issueList);

        JButton resolveBtn = new JButton("Resolve Issue");
        resolveBtn.addActionListener(e -> resolveIssue());

        JPanel top = new JPanel();
        top.add(new JLabel("Reported Issues"));

        JPanel bottom = new JPanel();
        bottom.add(resolveBtn);

        add(top, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        populateIssues();
        setVisible(true);
    }

    void populateIssues() {
        issueListModel.clear();
        for (Accommodation acc : owner.getAccommodations()) {
            for (Issue i : acc.getIssues()) {
                if (!i.isResolved()) {
                    issueListModel.addElement(i.getDescription() + " (" + acc.getName() + ")");
                }
            }
        }
    }

    void resolveIssue() {
        String selected = issueList.getSelectedValue();
        if (selected == null) {
            JOptionPane.showMessageDialog(this, "Select an issue to resolve.");
            return;
        }

        for (Accommodation acc : owner.getAccommodations()) {
            for (Issue i : acc.getIssues()) {
                if (!i.isResolved() && selected.startsWith(i.getDescription())) {
                    i.resolve();
                    JOptionPane.showMessageDialog(this, "Issue marked as resolved.");
                    populateIssues();
                    return;
                }
            }
        }
    }
}
