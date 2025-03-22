import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import java.io.UnsupportedEncodingException;

public class JavaClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name");
        String name = scanner.nextLine();
        System.out.println("Enter the link:");
        String urlString = scanner.nextLine();

        try {
            String encodedName = URLEncoder.encode(name, "UTF-8");

            String finalUrlString = urlString + "?name=" + encodedName;

            URL url = new URL(finalUrlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();

            if (statusCode == 200) {
                System.out.println("Success!");
            } else {
                System.out.println("Failed; status: " + statusCode);
            }

            connection.disconnect();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("Failed encoding URL.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed following the link.");
        }
    }
}
