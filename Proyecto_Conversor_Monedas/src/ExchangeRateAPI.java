import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;
import org.json.JSONObject;


public class ExchangeRateAPI {
    private final String apiKey = "b721046d90770c6734f67f0d";

    public double getExchangeRate(String fromCurrency, String toCurrency) {
        String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + fromCurrency + "/" + toCurrency;

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Error al conectar con la API: Código " + responseCode);
            }

            Scanner scanner = new Scanner(url.openStream());
            StringBuilder inline = new StringBuilder();
            while (scanner.hasNext()) {
                inline.append(scanner.nextLine());
            }
            scanner.close();

            JSONObject json = new JSONObject(inline.toString());
            return json.getDouble("conversion_rate");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return 0.0;
    }
}



