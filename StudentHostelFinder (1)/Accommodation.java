// Accommodation.java
import java.util.ArrayList;
import java.util.List;

public class Accommodation {
    private String id;
    private String name;       // human readable name for this accommodation (e.g., "AC Single")
    private String roomType;   // single / double / sharing
    private boolean ac;
    private int rent;
    private String notes;
    private List<Issue> issues = new ArrayList<>();

    public Accommodation(String id, String name, String roomType, boolean ac, int rent, String notes) {
        this.id = id;
        this.name = name;
        this.roomType = roomType;
        this.ac = ac;
        this.rent = rent;
        this.notes = notes;
    }

    public String getId(){ return id; }
    public String getName(){ return name; }
    public String getRoomType(){ return roomType; }
    public boolean isAc(){ return ac; }
    public int getRent(){ return rent; }
    public String getNotes(){ return notes; }

    // Issue related
    public List<Issue> getIssues(){ return issues; }
    public void addIssue(Issue issue){
        if(issue != null){
            issues.add(issue);
        }
    }
}
