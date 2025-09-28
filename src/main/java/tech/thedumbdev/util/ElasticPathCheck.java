package tech.thedumbdev.util;
import java.util.regex.*;

public class ElasticPathCheck {
    // This just performs checks on the basics of length and structure, doesn't actually verify that whether the instance could be connected or not
    public static boolean validConnectionString(String connectionString) {

        String regex = "https?://[a-zA-Z0-9.-]+(:[0-9]{1,5})?";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(connectionString);

        return matcher.matches();
    }

    public static boolean validAPIKey(String apiKey) {
        return true; // Will change this after knowing what is the typical length of the apiKey
    }
}
