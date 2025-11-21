// Main.java
import javax.swing.*;

public class Main {
    public static void main(String[] args){
        // ensure DataStore seeds hostels and downloads images at startup
        DataStore.getInstance();

        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}
