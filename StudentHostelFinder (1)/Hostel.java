// Hostel.java
import java.util.*;

public class Hostel {
    private String id;
    private String name;
    private String address;
    private String contactNumber;
    private int rentAc;
    private int rentNonAc;
    private boolean forBoys;
    private boolean forGirls;
    private List<Accommodation> accommodations;
    private String imageUrl;        // remote URL (used to download)
    private String localImagePath;  // local path under ./images/

    public Hostel(String id, String name, String address, String contactNumber,
                  int rentAc, int rentNonAc, boolean forBoys, boolean forGirls,
                  String imageUrl, String localImagePath) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.rentAc = rentAc;
        this.rentNonAc = rentNonAc;
        this.forBoys = forBoys;
        this.forGirls = forGirls;
        this.accommodations = new ArrayList<>();
        this.imageUrl = imageUrl;
        this.localImagePath = localImagePath;
    }

    // getters / setters
    public String getId(){ return id; }
    public String getName(){ return name; }
    public String getAddress(){ return address; }
    public String getContactNumber(){ return contactNumber; }
    public int getRentAc(){ return rentAc; }
    public int getRentNonAc(){ return rentNonAc; }
    public boolean isForBoys(){ return forBoys; }
    public boolean isForGirls(){ return forGirls; }
    public List<Accommodation> getAccommodations(){ return accommodations; }
    public String getImageUrl(){ return imageUrl; }
    public String getLocalImagePath(){ return localImagePath; }

    public void addAccommodation(Accommodation a){
        if(a != null) accommodations.add(a);
    }
}
