// Issue.java
import java.util.HashSet;

public class Issue {
    private String description;
    private Student reportedBy;
    private boolean resolved = false;
    private HashSet<Student> verifiers = new HashSet<>();
    private Accommodation accommodation; // optional link to accommodation

    public Issue(String description, Student reportedBy) {
        this.description = description;
        this.reportedBy = reportedBy;
    }

    public String getDescription() { return description; }
    public boolean isResolved() { return resolved; }
    public void resolve() { resolved = true; }
    public void addVerifier(Student s) { if(s != null) verifiers.add(s); }
    public int getVerifierCount() { return verifiers.size(); }
    public Student getReportedBy() { return reportedBy; }

    public Accommodation getAccommodation(){ return accommodation; }
    public void setAccommodation(Accommodation a){ this.accommodation = a; }
}
