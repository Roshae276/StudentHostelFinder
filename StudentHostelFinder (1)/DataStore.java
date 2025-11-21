import java.util.*;
import java.io.*;

public class DataStore {
    private static DataStore instance;

    private List<String> coachingList;
    private Map<String, List<String>> coachingBranches;
    private List<Hostel> hostels;

    public static List<Accommodation> accommodations = new ArrayList<>();
    public static List<Issue> issues = new ArrayList<>();

    private DataStore(){
        coachingList = new ArrayList<>();
        coachingBranches = new LinkedHashMap<>();
        hostels = new ArrayList<>();
        seedCoachingAndBranches();
        seedHostels();
        ensureImagesDirectory();
        downloadHostelImages();
    }

    public static DataStore getInstance(){
        if(instance == null) instance = new DataStore();
        return instance;
    }

    public List<String> getCoachingList(){ return coachingList; }
    public List<String> getBranchesFor(String coaching) {
        List<String> l = coachingBranches.get(coaching);
        return (l == null) ? Collections.emptyList() : l;
    }
    public List<Hostel> getHostels(){ return hostels; }

    private void seedCoachingAndBranches() {
        coachingList.add("Allen");
        coachingList.add("Vibrant Academy");
        coachingList.add("eSaral");
        coachingList.add("eToos");
        coachingList.add("Physics Wallah");
        coachingList.add("Aakash Institute");
        coachingList.add("Motion");

        coachingBranches.put("Allen", Arrays.asList(
            "Allen Sankalp",
            "Allen Sangyan",
            "Allen SatYarth-1",
            "Allen Samanvaya (PNCF campus)",
            "Allen Safalya",
            "Allen Samyak-2",
            "Allen Supath",
            "Allen Saakar",
            "Allen PNCF Division Sumati",
            "Allen Sarokar"
        ));
        coachingBranches.put("Motion", Arrays.asList(
            "Motion Dadabari (NEET)",
            "Motion Drona (JEE)"
        ));
        coachingBranches.put("Vibrant Academy", Arrays.asList("Vibrant Main"));
        coachingBranches.put("eSaral", Arrays.asList("eSaral Main"));
        coachingBranches.put("eToos", Arrays.asList("eToos Main"));
        coachingBranches.put("Physics Wallah", Arrays.asList("PW Kota"));
        coachingBranches.put("Aakash Institute", Arrays.asList("Aakash Kota"));
    }

    private void seedHostels() {
        // Existing 30 hostels from previous
        hostels.add(new Hostel("H001","MOTHER'S HOME (near Allen Sangyan)","Near Allen Sangyan, Kota",
                "7015689412",21000,15000,true,false, "", ""));
        hostels.add(new Hostel("H002","PARSHVA CHHAYA GIRLS HOSTEL","Near Allen Sankalp / Allen Sangyan area, Kota",
                "1234567781",21000,15000,false,true, "", ""));
        hostels.add(new Hostel("H003","Lokhith Hostel Kota","Indraprastha Industrial Area / Coral Park area, Kota",
                "9950350667",20000,14000,true,true, "", ""));
        hostels.add(new Hostel("H004","Mittal Heights","Kota - premium hostel",
                "99829036180",25000,16000,true,true, "", ""));
        hostels.add(new Hostel("H005","JD Residency (Girls)","Coral Park Area, Kota","N/A",22000,15000,false,true, "", ""));
        hostels.add(new Hostel("H006","Sapphire Living (Girls Hostel)","Near Allen Supath, Kota","N/A",23000,15500,false,true, "", ""));
        hostels.add(new Hostel("H007","Vasanti Residency","Kota","N/A",20000,14000,true,true, "", ""));
        hostels.add(new Hostel("H008","Coral Heights Girls Hostel","Kota","N/A",21000,15000,false,true, "", ""));
        hostels.add(new Hostel("H009","Naman Residency","Kota","N/A",19000,13500,true,true, "", ""));
        hostels.add(new Hostel("H010","Achievers Girls Residency","Kota","N/A",19500,14000,false,true, "", ""));
        hostels.add(new Hostel("H011","Navdurga Residency","Plot No 44-46, Near Allen Sangyan, Landmark City, Kunahadi, Kota",
                "N/A",18000,12999,false,true, "", ""));
        hostels.add(new Hostel("H012","Kanha Residency","Kota city, near main coaching campuses",
                "N/A",15000,10000,true,false, "", ""));
        hostels.add(new Hostel("H013","Big Brother Hostel","Rajendra Hotel Road, Dadwara, Kota",
                "N/A",16000,10500,true,false, "", ""));
        hostels.add(new Hostel("H014","Reva Residency","Rajiv Gandhi Nagar, Kota",
                "N/A",15500,9500,true,false, "", ""));
        hostels.add(new Hostel("H015","Vidhya Ashram Boys Hostel","Rajiv Gandhi Nagar, near Allen Suprabh, Kota",
                "N/A",16000,11200,true,false, "", ""));
        hostels.add(new Hostel("H016","Khalsa Boys Residency","Rajeev Gandhi Nagar, Kota",
                "N/A",14500,10000,true,false, "", ""));
        hostels.add(new Hostel("H017","Shree Sanwariya Seth Girls Block","Coral Park, Naya Nohra, Near Allen Supath, Kota",
                "N/A",13500,11000,false,true, "", ""));
        hostels.add(new Hostel("H018","Arnav Girls Residency","B-91(A), Road No. 4, Industrial Area, Kota",
                "N/A",12000,10500,false,true, "", ""));
        hostels.add(new Hostel("H019","Mahakal Residency Boys Hostel","Sector-3, Indraprastha Nagar, Kota",
                "N/A",16500,12000,true,false, "", ""));
        hostels.add(new Hostel("H020","Shree Residency Boys Hostel","Talwandi Circle, Kota",
                "N/A",17500,12500,true,false, "", ""));
        hostels.add(new Hostel("H021","Gurukripa Girls Residency","JawharNagar, Kota (Near Allen Satyarth 1 & 2)",
                "N/A",13200,11000,false,true, "", ""));
        hostels.add(new Hostel("H022","Bhumi Boys PG/Hostel","Talwandi area, Kota",
                "N/A",13800,10000,true,false, "", ""));
        hostels.add(new Hostel("H023","Tutee Homes Aaradhya","Landmark City, Kota",
                "N/A",16000,11000,true,true, "", ""));
        hostels.add(new Hostel("H024","White House Boys Hostel","Rajiv Gandhi Nagar, Kota",
                "N/A",14500,10000,true,false, "", ""));
        hostels.add(new Hostel("H025","Bhavyam Residency Girls Hostel","Baran Road, Kota",
                "N/A",14000,10500,false,true, "", ""));
        hostels.add(new Hostel("H026","Sanskriti Girls Hostel","Indraprastha Industrial Area, Kota",
                "N/A",13500,11000,false,true, "", ""));
        hostels.add(new Hostel("H027","S S Residency Boys Hostel","Baran Road, Kota",
                "N/A",14800,9900,true,false, "", ""));
        hostels.add(new Hostel("H028","Royal PG Girls Hostel","Jawahar Nagar, Kota",
                "N/A",14500,10500,false,true, "", ""));
        hostels.add(new Hostel("H029","Shivam Boys Hostel","Landmark City, Kunhadi, Kota",
                "N/A",15000,10300,true,false, "", ""));
        hostels.add(new Hostel("H030","Shree PG Boys & Girls","Baran Road, Kota (mixed)",
                "N/A",16000,12000,true,true, "", ""));

        // Additional 10 more hostels to lengthen the list
        hostels.add(new Hostel("H031","SRK Boys Hostel","Near Industrial Area, Kota",
                "N/A",15500,11000,true,false, "", ""));
        hostels.add(new Hostel("H032","Nirvana Girls Hostel","Near Rajeev Gandhi Nagar, Kota",
                "N/A",14000,11500,false,true, "", ""));
        hostels.add(new Hostel("H033","Vats PG Boys Hostel","Near Baran Road, Kota",
                "N/A",15000,10800,true,false, "", ""));
        hostels.add(new Hostel("H034","Shakti Girls Residency","Naya Nohra, Kota",
                "N/A",13800,11200,false,true, "", ""));
        hostels.add(new Hostel("H035","Genesis Boys Hostel","Indraprastha Industrial Area, Kota",
                "N/A",16200,11800,true,false, "", ""));
        hostels.add(new Hostel("H036","Elite Girls Hostel","Talwandi, Kota",
                "N/A",14700,11400,false,true, "", ""));
        hostels.add(new Hostel("H037","Raj Residency Boys Hostel","Near Allen Sangyan, Kota",
                "N/A",15800,12000,true,false, "", ""));
        hostels.add(new Hostel("H038","Heavenly Girls Hostel","Jawahar Nagar, Kota",
                "N/A",14200,11000,false,true, "", ""));
        hostels.add(new Hostel("H039","Parth Boys Hostel","Landmark City, Kota",
                "N/A",16000,11800,true,false, "", ""));
        hostels.add(new Hostel("H040","Tranquil Girls Hostel","Near Coral Park, Kota",
                "N/A",14500,11300,false,true, "", ""));

        // Adding accommodations to all hostels
        for (Hostel h : hostels) {
            Accommodation a1 = new Accommodation(h.getId()+"-A1", "AC Single", "Single", true, h.getRentAc(), "AC single room with attached washroom");
            Accommodation a2 = new Accommodation(h.getId()+"-A2", "Non-AC Sharing", "Sharing", false, h.getRentNonAc(), "Non-AC shared room with mess included");
            h.addAccommodation(a1);
            h.addAccommodation(a2);
            accommodations.add(a1);
            accommodations.add(a2);
        }
    }

    private void ensureImagesDirectory(){ }
    private void downloadHostelImages(){ }
}
