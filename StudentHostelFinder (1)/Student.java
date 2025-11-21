// Student.java
import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private List<Issue> reportedIssues = new ArrayList<>();

    public Student(String id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public void reportIssue(Issue issue) {
        if(issue == null) return;
        reportedIssues.add(issue);
        DataStore.issues.add(issue);
    }

    public void verifyIssue(Issue issue) {
        if (issue != null && issue.isResolved()) {
            issue.addVerifier(this);
        }
    }
}
