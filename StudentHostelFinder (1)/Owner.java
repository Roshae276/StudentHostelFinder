// Owner.java
import java.util.ArrayList;
import java.util.List;

public class Owner extends User {
    private List<Accommodation> accommodations = new ArrayList<>();

    public Owner(String id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public void addAccommodation(Accommodation acc) {
        accommodations.add(acc);
        // register on global DataStore list as original code expected
        DataStore.accommodations.add(acc);
    }

    public List<Accommodation> getAccommodations() {
        return accommodations;
    }
}
